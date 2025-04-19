package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.UIV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEBlocks.HERMETIC_CASING_UIV;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEBlocks.SPS_CASING;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.VOLTAGE_COIL_UIV;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.SPACE_ASSEMBLY_PLANT;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.AlloyMaterials.ComplexDeepSpaceAlloy;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.AlloyMaterials.Indalloy140;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.Calculasium;

public class SpaceAssemblyPlantRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        SPACE_ASSEMBLY_PLANT.recipeBuilder("sps_casing")
                .inputItems(frameGt, Neutronium, 1)
                .inputItems(HERMETIC_CASING_UIV, 1)
                .inputItems(plate, Polonium, 6)
                .inputItems(plateDouble, Plutonium239, 16)
                .inputItems(plateDouble, Americium, 16)
                .inputItems(VOLTAGE_COIL_UIV, 4)
                .inputItems(ROBOT_ARM_UIV, 16)
                .inputItems(SENSOR_UIV, 16)
                .inputItems(ELECTRIC_PISTON_UIV, 16)
                .inputItems(FIELD_GENERATOR_UIV, 16)
                .inputFluids(Indalloy140.getFluid(2880))
                .inputFluids(TungstenCarbide.getFluid(2880))
                .inputFluids(ComplexDeepSpaceAlloy.getFluid(2880))
                .inputFluids(Calculasium.getFluid(2880))
                .inputFluids(UUMatter.getFluid(2880))
                .outputItems(SPS_CASING, 4)
                .duration(6000)
                .EUt(VA[UIV])
                .addData("SAMTier", 11)
                .save(provider);

    }
}
