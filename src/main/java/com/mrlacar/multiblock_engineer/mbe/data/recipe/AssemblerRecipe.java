package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.HULL;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEBlocks.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.AlloyMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.EtherPolymer;

public class AssemblerRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        ASSEMBLER_RECIPES.recipeBuilder("machine_casing_uev")
                .inputItems(plate, StructuralSteel800, 8)
                .outputItems(MACHINE_CASING_UEV)
                .duration(50)
                .EUt(16)
                .circuitMeta(8)
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("machine_hull_uev")
                .inputItems(MACHINE_CASING_UEV)
                .inputItems(cableGtSingle, Draconium, 2)
                .inputFluids(EtherPolymer.getFluid(L * 2))
                .outputItems(HULL[UEV])
                .duration(50)
                .EUt(16)
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("machine_casing_uiv")
                .inputItems(plate, Adamantium64RAlloy, 8)
                .outputItems(MACHINE_CASING_UIV)
                .duration(50)
                .EUt(16)
                .circuitMeta(8)
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("machine_hull_uiv")
                .inputItems(MACHINE_CASING_UIV)
                .inputItems(cableGtSingle, Vibranium, 2)
                .inputFluids(EtherPolymer.getFluid(L * 2))
                .outputItems(HULL[UIV])
                .duration(50)
                .EUt(16)
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("machine_casing_uxv")
                .inputItems(plate, FragmentedDimension, 8)
                .outputItems(MACHINE_CASING_UXV)
                .duration(50)
                .EUt(16)
                .circuitMeta(8)
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("machine_hull_uxv")
                .inputItems(MACHINE_CASING_UXV)
                .inputItems(cableGtSingle, RedTungsten, 2)
                .inputFluids(EtherPolymer.getFluid(L * 2))
                .outputItems(HULL[UXV])
                .duration(50)
                .EUt(16)
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("machine_casing_opv")
                .inputItems(plate, Strangium, 8)
                .outputItems(MACHINE_CASING_OpV)
                .duration(50)
                .EUt(16)
                .circuitMeta(8)
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("machine_hull_opv")
                .inputItems(MACHINE_CASING_OpV)
                .inputItems(cableGtSingle, Dustosmos, 2)
                .inputFluids(EtherPolymer.getFluid(L * 2))
                .outputItems(HULL[OpV])
                .duration(50)
                .EUt(16)
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("machine_casing_max")
                .inputItems(plate, MultiverseHyperstableCompactMatter, 8)
                .outputItems(MACHINE_CASING_MAX)
                .duration(50)
                .EUt(16)
                .circuitMeta(8)
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("battery_empty_tier_iv_0")
                .inputItems(frameGt, XK3700TAlloy)
                .inputItems(plate, XK3700TAlloy, 6)
                .inputItems(screw, XK3700TAlloy, 24)
                .outputItems(BATTERY_EMPTY_TIER_IV)
                .duration(400)
                .EUt(VA[UHV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("component_factory_heat_vent")
                .inputItems(COMPONENT_FACTORY_CASING)
                .inputItems(FILTER_CASING)
                .inputItems(rotor, Tritanium, 4)
                .inputItems(wireFine, Europium, 4)
                .inputItems(wireFine, Naquadria, 4)
                .inputFluids(Lutetium.getFluid(288))
                .outputItems(COMPONENT_FACTORY_HEAT_VENT)
                .duration(400)
                .EUt(VA[UV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("component_factory_gearbox")
                .inputItems(COMPONENT_FACTORY_CASING)
                .inputItems(frameGt, Tritanium)
                .inputItems(gear, Tritanium, 6)
                .inputItems(plate, Tritanium, 4)
                .inputFluids(Americium.getFluid(288))
                .outputItems(COMPONENT_FACTORY_GEARBOX)
                .duration(600)
                .EUt(VA[UV])
                .save(provider);
    }
}
