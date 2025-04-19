package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.LASER_ENGRAVER_RECIPES;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.SUPERCRITICAL_PHASE_SHIFT;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.AlloyMaterials.*;

public class MiscRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {
        LASER_ENGRAVER_RECIPES.recipeBuilder("rocket_data_module_t3")
                .inputItems(ROCKET_DATA_MODULE)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .outputItems(ROCKET_DATA_MODULE_T3)
                .duration(400)
                .EUt(VA[LuV])
                .save(provider);
        LASER_ENGRAVER_RECIPES.recipeBuilder("rocket_data_module_t4")
                .inputItems(ROCKET_DATA_MODULE)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .outputItems(ROCKET_DATA_MODULE_T4)
                .duration(400)
                .EUt(VA[ZPM])
                .save(provider);
        LASER_ENGRAVER_RECIPES.recipeBuilder("rocket_data_module_t5")
                .inputItems(ROCKET_DATA_MODULE)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .outputItems(ROCKET_DATA_MODULE_T5)
                .duration(400)
                .EUt(VA[UV])
                .save(provider);
        LASER_ENGRAVER_RECIPES.recipeBuilder("rocket_data_module_t6")
                .inputItems(ROCKET_DATA_MODULE)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .outputItems(ROCKET_DATA_MODULE_T6)
                .duration(400)
                .EUt(VA[UHV])
                .save(provider);
        LASER_ENGRAVER_RECIPES.recipeBuilder("rocket_data_module_t7")
                .inputItems(ROCKET_DATA_MODULE)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .outputItems(ROCKET_DATA_MODULE_T7)
                .duration(400)
                .EUt(VA[UEV])
                .save(provider);
        SUPERCRITICAL_PHASE_SHIFT.recipeBuilder("uev_superconductor")
                .inputFluids(Polonium.getFluid(4000))
                .inputFluids(TranscendentAlloy.getFluid(4000))
                .duration(1200)
                .EUt(VA[UIV])
                .save(provider);
        SUPERCRITICAL_PHASE_SHIFT.recipeBuilder("uiv_superconductor")
                .inputFluids(Polonium.getFluid(4000))
                .inputFluids(ADVCAlloy.getFluid(2000))
                .duration(1200)
                .EUt(VA[UIV])
                .save(provider);
        SUPERCRITICAL_PHASE_SHIFT.recipeBuilder("uxv_superconductor")
                .inputFluids(Polonium.getFluid(4000))
                .inputFluids(SupercriticalDimension.getFluid(1000))
                .duration(1200)
                .EUt(VA[UIV])
                .save(provider);
        SUPERCRITICAL_PHASE_SHIFT.recipeBuilder("opv_superconductor")
                .inputFluids(Polonium.getFluid(4000))
                .inputFluids(TalliMStrangium.getFluid(500))
                .duration(1200)
                .EUt(VA[UIV])
                .save(provider);
    }
}
