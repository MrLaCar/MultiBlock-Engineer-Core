package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.UV;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.FUSION_RECIPES;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.MetastableHassium;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.MetastableOganesson;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.RadiumRadonMixture;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.ScandiumTitanium50Mixture;

public class FusionRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        FUSION_RECIPES.recipeBuilder("enriched_naquadah_and_oganesson_to_metastable_oganesson_plasma")
                .inputFluids(NaquadahEnriched.getFluid(144))
                .inputFluids(Oganesson.getFluid(288))
                .outputFluids(MetastableOganesson.getFluid(36))
                .duration(600)
                .EUt(GTValues.V[UV])
                .fusionStartEU(600_000_000)
                .save(provider);
        FUSION_RECIPES.recipeBuilder("scandium_titanium_50_mixture_and_radium_radon_mixture_to_metastable_hassium_plasma")
                .inputFluids(ScandiumTitanium50Mixture.getFluid(36))
                .inputFluids(RadiumRadonMixture.getFluid(144))
                .outputFluids(MetastableHassium.getFluid(144))
                .duration(400)
                .EUt(GTValues.V[UV])
                .fusionStartEU(550_000_000)
                .save(provider);
        FUSION_RECIPES.recipeBuilder("plutonium_241_and_calcium_to_flerovium_plasma")
                .inputFluids(Plutonium241.getFluid(144))
                .inputFluids(Calcium.getFluid(144))
                .outputFluids(Flerovium.getFluid(144))
                .duration(160)
                .EUt(GTValues.V[UV])
                .fusionStartEU(400_000_000)
                .save(provider);
        FUSION_RECIPES.recipeBuilder("californium_and_calcium_to_oganesson_plasma")
                .inputFluids(Californium.getFluid(32))
                .inputFluids(Calcium.getFluid(720))
                .outputFluids(Oganesson.getFluid(144))
                .duration(400)
                .EUt(GTValues.V[UV])
                .fusionStartEU(600_000_000)
                .save(provider);
        FUSION_RECIPES.recipeBuilder("americium_and_boron_to_fermium_plasma")
                .inputFluids(Americium.getFluid(144))
                .inputFluids(Boron.getFluid(144))
                .outputFluids(Fermium.getFluid(144))
                .duration(600)
                .EUt(GTValues.V[UV])
                .fusionStartEU(320_000_000)
                .save(provider);
        FUSION_RECIPES.recipeBuilder("curium_and_helium_to_californium_plasma")
                .inputFluids(Curium.getFluid(144))
                .inputFluids(Helium.getFluid(144))
                .outputFluids(Californium.getFluid(144))
                .duration(120)
                .EUt(GTValues.V[UV])
                .fusionStartEU(500_000_000)
                .save(provider);
        FUSION_RECIPES.recipeBuilder("plutonium_239_and_beryllium_to_californium_plasma")
                .inputFluids(Plutonium239.getFluid(48))
                .inputFluids(Beryllium.getFluid(48))
                .outputFluids(Californium.getFluid(48))
                .duration(240)
                .EUt(GTValues.V[UV])
                .fusionStartEU(300_000_000)
                .save(provider);
    }
}
