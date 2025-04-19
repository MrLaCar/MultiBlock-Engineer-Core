package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.generator;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.network.chat.Component;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.gregtechceu.gtceu.api.GTValues.MAX;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Helium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Hydrogen;

public class MicroStarCollapseSimulator extends WorkableElectricMultiblockMachine {

    private static final FluidStack HYDROGEN = Hydrogen.getFluid(100000);
    private static final FluidStack HELIUM = Helium.getFluid(100000);


    public MicroStarCollapseSimulator(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    protected GTRecipe getHydrogen() {
        return GTRecipeBuilder.ofRaw().inputFluids(HYDROGEN).buildRawRecipe();
    }
    protected GTRecipe getHelium() {
        return GTRecipeBuilder.ofRaw().inputFluids(HELIUM).buildRawRecipe();
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        final var totalContinuousRunningTime = recipeLogic.getTotalContinuousRunningTime();
        if ((totalContinuousRunningTime == 1 || totalContinuousRunningTime % 20 == 0)) {
            if (!getHydrogen().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                recipeLogic.interruptRecipe();
                return false;
            }
        }
        if ((totalContinuousRunningTime == 1 || totalContinuousRunningTime % 20 == 0)) {
            if (!getHelium().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                recipeLogic.interruptRecipe();
                return false;
            }
        }
        return value;
    }

    public void addDisplayText(@NotNull List<Component> textList) {
        MultiblockDisplayText.builder(textList, isFormed()).setWorkingStatus(true, true)
                .addCustom(tl -> {
                    if (isActive()) {
                        long EUt = RecipeHelper.getOutputEUt(recipeLogic.getLastRecipe());
                        int Multiples = (int) (EUt / GTValues.V[MAX]);
                        tl.add(Component.translatable("mbe.multiblock.energy_out_per_tick_max", FormattingUtil.formatNumbers(EUt), Multiples));
                    }
                }).addWorkingStatusLine();
    }

    public static ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof MicroStarCollapseSimulator microStarCollapseSimulator)) {
            return RecipeModifier.nullWrongType(MicroStarCollapseSimulator.class, machine);
        }
        long EUt = RecipeHelper.getOutputEUt(recipe);
        if (EUt > 0) {
            return ModifierFunction.builder().build();
        }
        return ModifierFunction.NULL;
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(MicroStarCollapseSimulator.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }
}
