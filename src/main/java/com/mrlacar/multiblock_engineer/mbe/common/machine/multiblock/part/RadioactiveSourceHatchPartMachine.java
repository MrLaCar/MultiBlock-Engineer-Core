package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.IMachineLife;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDistinctPart;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.utils.GTTransferUtils;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.jei.IngredientIO;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.mrlacar.multiblock_engineer.mbe.api.gui.MBEGuiTextures;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.rodLong;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RadioactiveSourceHatchPartMachine extends TieredIOPartMachine implements IDistinctPart, IMachineLife {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(RadioactiveSourceHatchPartMachine.class,
            TieredIOPartMachine.MANAGED_FIELD_HOLDER);
    @Getter
    @Persisted
    private final NotifiableItemStackHandler inventory;
    @Nullable
    protected TickableSubscription autoIOSubs;
    @Nullable
    protected ISubscription inventorySubs;

    public RadioactiveSourceHatchPartMachine(IMachineBlockEntity holder, Object...args) {
        super(holder, GTValues.LuV, IO.IN);
        this.inventory = createInventory(args);
        this.inventory.setFilter(stack -> ChemicalHelper.getPrefix(stack.getItem()) == rodLong);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    protected int getInventorySize() {
        return 1;
    }

    protected NotifiableItemStackHandler createInventory(Object... args) {
        return new NotifiableItemStackHandler(this, getInventorySize(), io);
    }

    @Override
    public void onMachineRemoved() {
        clearInventory(getInventory().storage);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, this::updateInventorySubscription));
        }
        inventorySubs = getInventory().addChangedListener(this::updateInventorySubscription);
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (inventorySubs != null) {
            inventorySubs.unsubscribe();
            inventorySubs = null;
        }
    }

    @Override
    public boolean isDistinct() {
        return io != IO.OUT && getInventory().isDistinct();
    }

    @Override
    public void setDistinct(boolean isDistinct) {
        getInventory().setDistinct(isDistinct);
    }

    @Override
    public void onNeighborChanged(Block block, BlockPos fromPos, boolean isMoving) {
        super.onNeighborChanged(block, fromPos, isMoving);
        updateInventorySubscription();
    }

    @Override
    public void onRotated(Direction oldFacing, Direction newFacing) {
        super.onRotated(oldFacing, newFacing);
        updateInventorySubscription();
    }

    protected void updateInventorySubscription() {
        if (isWorkingEnabled() && ((io == IO.OUT && !getInventory().isEmpty()) || io == IO.IN) &&
                GTTransferUtils.hasAdjacentItemHandler(getLevel(), getPos(), getFrontFacing())) {
            autoIOSubs = subscribeServerTick(autoIOSubs, this::autoIO);
        } else if (autoIOSubs != null) {
            autoIOSubs.unsubscribe();
            autoIOSubs = null;
        }
    }

    protected void autoIO() {
        if (getOffsetTimer() % 5 == 0) {
            if (isWorkingEnabled()) {
                if (io == IO.OUT) {
                    getInventory().exportToNearby(getFrontFacing());
                } else if (io == IO.IN) {
                    getInventory().importFromNearby(getFrontFacing());
                }
            }
            updateInventorySubscription();
        }
    }

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        super.setWorkingEnabled(workingEnabled);
        updateInventorySubscription();
    }

    @Override
    public Widget createUIWidget() {
        int rowSize = (int) Math.sqrt(getInventorySize());
        int colSize = rowSize;
        var group = new WidgetGroup(0, 0, 18 * rowSize + 16, 18 * colSize + 16);
        var container = new WidgetGroup(4, 4, 18 * rowSize + 8, 18 * colSize + 8);
        int index = 0;
        for (int y = 0; y < colSize; y++) {
            for (int x = 0; x < rowSize; x++) {
                container.addWidget(
                        new SlotWidget(getInventory().storage, index++, 4 + x * 18, 4 + y * 18, true, io.support(IO.IN))
                                .setBackgroundTexture(MBEGuiTextures.ROD_LONG_OVERLAY)
                                .setIngredientIO(this.io == IO.IN ? IngredientIO.INPUT : IngredientIO.OUTPUT));
            }
        }
        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);

        return group;
    }
}
