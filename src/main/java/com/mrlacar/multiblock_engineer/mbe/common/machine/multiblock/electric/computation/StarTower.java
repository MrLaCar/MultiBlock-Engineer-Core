package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric.computation;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.IControllable;
import com.gregtechceu.gtceu.api.capability.IOpticalComputationProvider;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
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
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.api.machine.MBEOverclockingLogic.NONE_OVERCLOCK;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.STAR_TOWER_EXTREME_CALCULATION_UNIT;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.GelidCryotheum;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.SuperCoolant;

public class StarTower extends WorkableElectricMultiblockMachine implements
        IOpticalComputationProvider, IControllable, IMachineModifyDrops {

    @Getter
    @Persisted
    private final NotifiableItemStackHandler StorageSlot;
    @Persisted
    private int CoolingFactor;
    @Persisted
    private int Computation;

    private static final FluidStack COOLANT = PCBCoolant.getFluid(400);
    private static final FluidStack COOLANTExtreme = PCBCoolant.getFluid(2000);
    private static final FluidStack COOLANT0 = Helium.getFluid(FluidStorageKeys.LIQUID, 250);
    private static final FluidStack COOLANT1 = SuperCoolant.getFluid(250);
    private static final FluidStack COOLANT2 = GelidCryotheum.getFluid(250);

    public StarTower(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.StorageSlot = new NotifiableItemStackHandler(this, 1, IO.NONE, IO.BOTH);
        this.StorageSlot.setFilter(STAR_TOWER_EXTREME_CALCULATION_UNIT::isIn);
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
        if (isActive()) {
            if (StorageSlot.getStackInSlot(0).getCount() > 0) {
                this.Computation = 262144 * StorageSlot.getStackInSlot(0).getCount();
            } else {
                this.Computation = (int) Math.pow(2, getTier() - 2) * CoolingFactor;
            }

        }
        return Computation;
    }

    @Override
    public int getMaxCWUt(@NotNull Collection<IOpticalComputationProvider> seen) {
        seen.add(this);
        if (isActive()) {
            if (StorageSlot.getStackInSlot(0).getCount() > 0) {
                this.Computation = 262144 * StorageSlot.getStackInSlot(0).getCount();
            } else {
                this.Computation = (int) Math.pow(2, getTier() - 2) * CoolingFactor;
            }
        }
        return Computation;
    }

    @Override
    public boolean canBridge(@NotNull Collection<IOpticalComputationProvider> seen) {
        return true;
    }

    protected GTRecipe getCoolant() {
        return GTRecipeBuilder.ofRaw().inputFluids(StorageSlot.getStackInSlot(0).getCount() > 0 ? COOLANTExtreme : COOLANT).buildRawRecipe();
    }
    protected GTRecipe getCoolant0() {
        return GTRecipeBuilder.ofRaw().inputFluids(COOLANT0).buildRawRecipe();
    }
    protected GTRecipe getCoolant1() {
        return GTRecipeBuilder.ofRaw().inputFluids(COOLANT1).buildRawRecipe();
    }
    protected GTRecipe getCoolant2() {
        return GTRecipeBuilder.ofRaw().inputFluids(COOLANT2).buildRawRecipe();
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        final var totalContinuousRunningTime = recipeLogic.getTotalContinuousRunningTime();
        if ((totalContinuousRunningTime == 1 || totalContinuousRunningTime % 20 == 0)) {
            if (getCoolant().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                this.CoolingFactor = 1;
                if (!getCoolant().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                    this.CoolingFactor = 0;
                    recipeLogic.interruptRecipe();
                    return false;
                }
            }
            if (getCoolant0().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                this.CoolingFactor = 5;
                if (!getCoolant0().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                    this.CoolingFactor = 0;
                    recipeLogic.interruptRecipe();
                    return false;
                }
            }
            if (getCoolant1().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                this.CoolingFactor = 10;
                if (!getCoolant1().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                    this.CoolingFactor = 0;
                    recipeLogic.interruptRecipe();
                    return false;
                }
            }
            if (getCoolant2().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                this.CoolingFactor = 100;
                if (!getCoolant2().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                    this.CoolingFactor = 0;
                    recipeLogic.interruptRecipe();
                    return false;
                }
            }
        }
        return value;
    }

    public void addDisplayText(@NotNull List<Component> textList) {
        MultiblockDisplayText.builder(textList, isFormed()).setWorkingStatus(true, true)
                .setWorkingStatusKeys("gtceu.multiblock.idling", "gtceu.multiblock.idling", "gtceu.multiblock.data_bank.providing")
                .addCustom(tl -> {
                    if (isActive()) {
                        var CWU = StorageSlot.getStackInSlot(0).getCount() > 0 ? 262144 * StorageSlot.getStackInSlot(0).getCount() :
                                (int) Math.pow(2, getTier() - 2) * CoolingFactor;
                        tl.add(Component.translatable("mbe.multiblock.cwut.energy", GTValues.VNF[getTier()]));
                        Component cwutInfo = Component.literal(CWU + " CWU/t").withStyle(ChatFormatting.AQUA);
                        tl.add(Component.translatable("gtceu.multiblock.hpca.computation", cwutInfo).withStyle(ChatFormatting.GRAY));
                    }
        }).addWorkingStatusLine();
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof StarTower starTower && starTower.getCoolant().matchRecipe(starTower).isSuccess()) {
            if (RecipeHelper.getRecipeEUtTier(recipe) > starTower.getTier()) {
            }
            var oc = NONE_OVERCLOCK.getModifier(machine, recipe, starTower.getOverclockVoltage());
            return oc;
        }
        return ModifierFunction.NULL;
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(StarTower.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }

    public void onDrops(List<ItemStack> drops) {
        this.clearInventory(StorageSlot.storage);
    }
}
