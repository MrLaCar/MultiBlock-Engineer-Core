package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MIXER_RECIPES;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.Titanium50;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.*;

public class MixerRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        MIXER_RECIPES.recipeBuilder("impure_universium_solution_from_impure_universium_dust")
                .inputItems(dust, ImpureUniversiumDust, 10)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(ImpureUniversiumSolution.getFluid(1000))
                .duration(200)
                .EUt(VA[ZPM])
                .circuitMeta(12)
                .save(provider);
        MIXER_RECIPES.recipeBuilder("radium_radon_mixture_from_radium_and_radon")
                .inputFluids(Radium.getFluid(144))
                .inputFluids(Radon.getFluid(1000))
                .outputFluids(RadiumRadonMixture.getFluid(288))
                .duration(140)
                .EUt(VA[UV])
                .save(provider);
        MIXER_RECIPES.recipeBuilder("scandium_titanium_50_mixture_from_scandium_and_titanium_50")
                .inputFluids(Scandium.getFluid(144))
                .inputFluids(Titanium50.getFluid(144))
                .outputFluids(ScandiumTitanium50Mixture.getFluid(288))
                .duration(140)
                .EUt(VA[UV])
                .save(provider);
    }
}
