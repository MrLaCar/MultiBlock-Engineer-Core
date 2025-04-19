package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.Size;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

import static com.mrlacar.multiblock_engineer.mbe.api.machine.MBEOverclockingLogic.NONE_OVERCLOCK;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.MULTIVERSE_MATRIX;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DimensionPenetrator extends WorkableElectricMultiblockMachine implements IMachineModifyDrops {

    @Getter
    @Persisted
    private final NotifiableItemStackHandler StorageSlot;
    @Persisted
    private int ObservableDimensionRangePercentage;

    public DimensionPenetrator(IMachineBlockEntity holder) {
        super(holder);
        this.StorageSlot = new NotifiableItemStackHandler(this, 1, IO.NONE, IO.BOTH);
        this.StorageSlot.setFilter(MULTIVERSE_MATRIX::isIn);
    }

    @Override
    public Widget createUIWidget() {
        Widget widget = super.createUIWidget();
        if (widget instanceof WidgetGroup group) {
            Size size = group.getSize();
            group.addWidget(new SlotWidget(StorageSlot.storage, 0, size.width - 30, size.height - 30, true, true)
                    .setBackground(GuiTextures.SLOT));
            group.setBackground(GuiTextures.BACKGROUND_INVERSE);
        }
        return widget;
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private int ObservableDimensionRangePercentage() {
        return this.ObservableDimensionRangePercentage;
    }

    public boolean onWorking() {
        boolean value = super.onWorking();
        if (getOffsetTimer() % 200 == 0) {
            if (this.ObservableDimensionRangePercentage() < 36) {
                ++this.ObservableDimensionRangePercentage;
            }
        }
        return value;
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (this.isFormed()) {
            if (ObservableDimensionRangePercentage == 36) {
                if (StorageSlot.getStackInSlot(0).getCount() == 0) {
                    textList.add(Component.translatable("gtceu.multiblock.parallel", Component.translatable(FormattingUtil.formatNumbers(1)).setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE))));
                } else {
                    textList.add(Component.translatable("gtceu.multiblock.parallel", Component.translatable(FormattingUtil.formatNumbers(StorageSlot.getStackInSlot(0).getCount())).setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE))));
                }
            }
        }
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof DimensionPenetrator dimensionPenetrator) {
            if (RecipeHelper.getRecipeEUtTier(recipe) > dimensionPenetrator.getTier()) {
                return null;
            }
            if (dimensionPenetrator.ObservableDimensionRangePercentage == 36) {
                int parallels = 8 * dimensionPenetrator.StorageSlot.getStackInSlot(0).getCount();
                var parallelModifier = ModifierFunction.builder()
                        .modifyAllContents(ContentModifier.multiplier(parallels))
                        .parallels(parallels)
                        .build();
                var oc = NONE_OVERCLOCK.getModifier(machine, recipe, dimensionPenetrator.getOverclockVoltage());
                return oc.andThen(parallelModifier);
            } else {
                int parallels = 8;
                var parallelModifier = ModifierFunction.builder()
                        .modifyAllContents(ContentModifier.multiplier(parallels))
                        .parallels(parallels)
                        .build();
                var oc = NONE_OVERCLOCK.getModifier(machine, recipe, dimensionPenetrator.getOverclockVoltage());
                return oc.andThen(parallelModifier);
            }
        }
        return ModifierFunction.NULL;
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(DimensionPenetrator.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }

    public void onDrops(List<ItemStack> drops) {
        this.clearInventory(StorageSlot.storage);
    }
}
