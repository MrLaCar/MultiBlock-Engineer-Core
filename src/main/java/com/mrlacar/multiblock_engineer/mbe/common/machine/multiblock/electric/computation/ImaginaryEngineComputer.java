package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric.computation;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.IControllable;
import com.gregtechceu.gtceu.api.capability.IOpticalComputationProvider;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.Size;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

import static com.gregtechceu.gtceu.common.data.GTMaterials.PCBCoolant;
import static com.mrlacar.multiblock_engineer.mbe.api.machine.MBEOverclockingLogic.NONE_OVERCLOCK;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.DIMENSION_MAPPING_PROCESSOR_MAINFRAME;

public class ImaginaryEngineComputer extends WorkableElectricMultiblockMachine implements
        IOpticalComputationProvider, IControllable, IMachineModifyDrops {

    @Getter
    @Persisted
    private final NotifiableItemStackHandler StorageSlot;

    private static final FluidStack COOLANT = PCBCoolant.getFluid(200);


    public ImaginaryEngineComputer(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.StorageSlot = new NotifiableItemStackHandler(this, 1, IO.NONE, IO.BOTH);
        this.StorageSlot.setFilter(DIMENSION_MAPPING_PROCESSOR_MAINFRAME::isIn);
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

    @Override
    public int requestCWUt(int cwut, boolean simulate, @NotNull Collection<IOpticalComputationProvider> seen) {
        seen.add(this);
        return isActive() ? (int) MaxCWUt() : 0;
    }

    @Override
    public int getMaxCWUt(@NotNull Collection<IOpticalComputationProvider> seen) {
        seen.add(this);
        return isActive() ? (int) MaxCWUt() : 0;
    }

    public long MaxCWUt() {
        long maxCWUt = (long) Math.pow(2, getTier());
        return maxCWUt;
    }

    @Override
    public boolean canBridge(@NotNull Collection<IOpticalComputationProvider> seen) {
        return true;
    }

    protected GTRecipe getCoolant() {
        return GTRecipeBuilder.ofRaw().inputFluids(COOLANT).buildRawRecipe();
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        final var totalContinuousRunningTime = recipeLogic.getTotalContinuousRunningTime();
        if ((totalContinuousRunningTime == 1 || totalContinuousRunningTime % 20 == 0)) {
            if (!getCoolant().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                recipeLogic.interruptRecipe();
                return false;
            }
            if (StorageSlot.getStackInSlot(0).getCount() != 64) {
                recipeLogic.interruptRecipe();
                return false;
            }
        }
        return value;
    }

    public void addDisplayText(@NotNull List<Component> textList) {
        MultiblockDisplayText.builder(textList, isFormed()).setWorkingStatus(true, true)
                .setWorkingStatusKeys("gtceu.multiblock.idling", "gtceu.multiblock.idling", "gtceu.multiblock.data_bank.providing")
                .addCustom(tl -> {
                    if (isActive()) {
                        var CWUt = (long) Math.pow(2, getTier());
                        tl.add(Component.translatable("mbe.multiblock.cwut.energy", GTValues.VNF[getTier()]));
                        Component cwutInfo = Component.literal(CWUt + " CWU/t").withStyle(ChatFormatting.AQUA);
                        tl.add(Component.translatable("gtceu.multiblock.hpca.computation", cwutInfo).withStyle(ChatFormatting.GRAY));
                    }
                    if (isFormed()) {
                        if (StorageSlot.getStackInSlot(0).getCount() == 64) {
                            textList.add(Component.translatable("mbe.imaginary_engine_computer.ready.0").setStyle(Style.EMPTY.withColor(ChatFormatting.GREEN)));
                        } else {
                            textList.add(Component.translatable("mbe.imaginary_engine_computer.ready.1").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
                        }
                    }
        }).addWorkingStatusLine();
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof ImaginaryEngineComputer imaginaryEngineComputer && imaginaryEngineComputer.StorageSlot.getStackInSlot(0).getCount() == 64 && imaginaryEngineComputer.getCoolant().matchRecipe(imaginaryEngineComputer).isSuccess()) {
            if (RecipeHelper.getRecipeEUtTier(recipe) > imaginaryEngineComputer.getTier()) {
            }
            var oc = NONE_OVERCLOCK.getModifier(machine, recipe, imaginaryEngineComputer.getOverclockVoltage());
            return oc;
        }
        return ModifierFunction.NULL;
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ImaginaryEngineComputer.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }

    public void onDrops(List<ItemStack> drops) {
        this.clearInventory(StorageSlot.storage);
    }
}
