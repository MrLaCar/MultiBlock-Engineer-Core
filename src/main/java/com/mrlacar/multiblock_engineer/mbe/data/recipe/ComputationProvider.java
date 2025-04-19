package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.*;

import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.IMAGINARY_ENGINE_COMPUTER;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.STAR_TOWER;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.Calculasium;

public class ComputationProvider {

    public static void init(Consumer<FinishedRecipe> provider) {

        IMAGINARY_ENGINE_COMPUTER.recipeBuilder("uhv_mainframe_cwu")
                .notConsumable(STELLAR_PROCESSOR_MAINFRAME.asStack(16))
                .outputFluids(Calculasium.getFluid(200))
                .duration(6000)
                .hideDuration(true)
                .EUt(VA[UHV])
                .save(provider);
        IMAGINARY_ENGINE_COMPUTER.recipeBuilder("uev_mainframe_cwu")
                .notConsumable(DIMENSION_MAPPING_PROCESSOR_MAINFRAME.asStack(16))
                .outputFluids(Calculasium.getFluid(400))
                .duration(6000)
                .hideDuration(true)
                .EUt(VA[UEV])
                .save(provider);
        IMAGINARY_ENGINE_COMPUTER.recipeBuilder("uiv_mainframe_cwu")
                .notConsumable(COSMIC_PROCESSOR_MAINFRAME.asStack(16))
                .outputFluids(Calculasium.getFluid(600))
                .duration(6000)
                .hideDuration(true)
                .EUt(VA[UIV])
                .save(provider);
        IMAGINARY_ENGINE_COMPUTER.recipeBuilder("uxv_mainframe_cwu")
                .notConsumable(SURREAL_PROCESSOR_MAINFRAME.asStack(16))
                .outputFluids(Calculasium.getFluid(800))
                .duration(6000)
                .hideDuration(true)
                .EUt(VA[UXV])
                .save(provider);

        STAR_TOWER.recipeBuilder("star_tower_cwu")
                .notConsumable(DIMENSION_MAPPING_PROCESSOR_COMPUTER.asStack(64))
                .outputFluids(Calculasium.getFluid(10000))
                .duration(6000)
                .hideDuration(true)
                .EUt(VA[UIV])
                .save(provider);
    }
}
