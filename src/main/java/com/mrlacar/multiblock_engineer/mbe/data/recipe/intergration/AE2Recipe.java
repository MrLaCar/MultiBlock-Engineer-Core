package com.mrlacar.multiblock_engineer.mbe.data.recipe.intergration;

import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static appeng.core.definitions.AEBlocks.CRAFTING_UNIT;
import static appeng.core.definitions.AEBlocks.QUARTZ_GLASS;
import static appeng.core.definitions.AEItems.CELL_COMPONENT_256K;
import static appeng.core.definitions.AEItems.ENGINEERING_PROCESSOR;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_LAMINATED_GLASS;
import static com.gregtechceu.gtceu.common.data.GTBlocks.FUSION_GLASS;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.QUANTUM_CHEST;
import static com.gregtechceu.gtceu.common.data.GTMachines.QUANTUM_TANK;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLY_LINE_RECIPES;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEBlocks.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.FLUID_CELL_4096K;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.AlloyMaterials.TranscendentAlloy;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.EtherPolymer;

public class AE2Recipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        ASSEMBLER_RECIPES.recipeBuilder("advanced_item_cell_housing")
                .inputItems(plate, TungstenSteel, 4)
                .inputItems(plate, HSSS, 4)
                .inputItems(plate, CertusQuartz, 4)
                .inputItems(screw, NaquadahAlloy, 12)
                .inputFluids(SolderingAlloy.getFluid(L * 2))
                .outputItems(ADVANCED_ITEM_CELL_HOUSING)
                .duration(400)
                .EUt(VA[LuV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("advanced_fluid_cell_housing")
                .inputItems(plate, TungstenSteel, 4)
                .inputItems(plate, Tritanium, 4)
                .inputItems(plate, CertusQuartz, 4)
                .inputItems(screw, NaquadahAlloy, 12)
                .inputFluids(SolderingAlloy.getFluid(L * 2))
                .outputItems(ADVANCED_FLUID_CELL_HOUSING)
                .duration(400)
                .EUt(VA[LuV])
                .save(provider);


        ASSEMBLY_LINE_RECIPES.recipeBuilder("cell_component_1024k")
                .inputItems(CELL_COMPONENT_256K.asItem(), 4)
                .inputItems(CustomTags.LuV_CIRCUITS, 8)
                .inputItems(QUARTZ_GLASS.asItem(), 2)
                .inputItems(CONVEYOR_MODULE_LuV, 4)
                .inputItems(ROBOT_ARM_LuV, 4)
                .inputFluids(IndiumTinBariumTitaniumCuprate.getFluid(L * 6))
                .inputFluids(SodiumPotassium.getFluid(L * 4))
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .inputFluids(Polybenzimidazole.getFluid(L * 2))
                .outputItems(CELL_COMPONENT_1024K)
                .scannerResearch(b -> b
                        .researchStack(CELL_COMPONENT_256K.stack())
                        .EUt(VA[IV]))
                .duration(300).EUt(VA[LuV]).save(provider);
        ASSEMBLY_LINE_RECIPES.recipeBuilder("cell_component_4096k")
                .inputItems(CELL_COMPONENT_1024K, 4)
                .inputItems(CustomTags.ZPM_CIRCUITS, 8)
                .inputItems(CASING_LAMINATED_GLASS.asItem(), 2)
                .inputItems(CONVEYOR_MODULE_ZPM, 4)
                .inputItems(ROBOT_ARM_ZPM, 4)
                .inputFluids(UraniumRhodiumDinaquadide.getFluid(L * 6))
                .inputFluids(SodiumPotassium.getFluid(L * 4))
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .inputFluids(Polybenzimidazole.getFluid(L * 2))
                .outputItems(CELL_COMPONENT_4096K)
                .stationResearch(b -> b
                        .researchStack(CELL_COMPONENT_1024K.asStack())
                        .CWUt(32)
                        .EUt(VA[LuV]))
                .duration(300).EUt(VA[ZPM]).save(provider);
        ASSEMBLY_LINE_RECIPES.recipeBuilder("cell_component_16384k")
                .inputItems(CELL_COMPONENT_4096K, 4)
                .inputItems(CustomTags.UV_CIRCUITS, 8)
                .inputItems(CASING_LAMINATED_GLASS.asItem(), 2)
                .inputItems(CONVEYOR_MODULE_UV, 4)
                .inputItems(ROBOT_ARM_UV, 4)
                .inputFluids(EnrichedNaquadahTriniumEuropiumDuranide.getFluid(L * 6))
                .inputFluids(SodiumPotassium.getFluid(L * 4))
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .inputFluids(Polybenzimidazole.getFluid(L * 2))
                .outputItems(CELL_COMPONENT_16384K)
                .stationResearch(b -> b
                        .researchStack(CELL_COMPONENT_4096K.asStack())
                        .CWUt(64)
                        .EUt(VA[ZPM]))
                .duration(300).EUt(VA[UV]).save(provider);
        ASSEMBLY_LINE_RECIPES.recipeBuilder("cell_component_65536k")
                .inputItems(CELL_COMPONENT_16384K, 4)
                .inputItems(CustomTags.UHV_CIRCUITS, 8)
                .inputItems(FUSION_GLASS.asItem(), 2)
                .inputItems(CONVEYOR_MODULE_UHV, 4)
                .inputItems(ROBOT_ARM_UHV, 4)
                .inputFluids(RutheniumTriniumAmericiumNeutronate.getFluid(L * 6))
                .inputFluids(SodiumPotassium.getFluid(L * 4))
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .inputFluids(Polybenzimidazole.getFluid(L * 2))
                .outputItems(CELL_COMPONENT_65536K)
                .stationResearch(b -> b
                        .researchStack(CELL_COMPONENT_16384K.asStack())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .duration(300).EUt(VA[UHV]).save(provider);
        ASSEMBLY_LINE_RECIPES.recipeBuilder("cell_component_262144k")
                .inputItems(CELL_COMPONENT_65536K, 4)
                .inputItems(CustomTags.UEV_CIRCUITS, 8)
                .inputItems(FUSION_GLASS.asItem(), 2)
                .inputItems(CONVEYOR_MODULE_UEV, 4)
                .inputItems(ROBOT_ARM_UEV, 4)
                .inputFluids(TranscendentAlloy.getFluid(L * 6))
                .inputFluids(SodiumPotassium.getFluid(L * 4))
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .inputFluids(EtherPolymer.getFluid(L * 2))
                .outputItems(CELL_COMPONENT_262144K)
                .stationResearch(b -> b
                        .researchStack(CELL_COMPONENT_65536K.asStack())
                        .CWUt(256)
                        .EUt(VA[UHV]))
                .duration(300).EUt(VA[UEV]).save(provider);


        ASSEMBLER_RECIPES.recipeBuilder("item_storage_cell_1024k")
                .inputItems(ADVANCED_ITEM_CELL_HOUSING)
                .inputItems(CELL_COMPONENT_1024K)
                .inputItems(QUANTUM_CHEST[LuV])
                .inputItems(EXTREME_CIRCUIT_BOARD, 2)
                .inputItems(screw, NaquadahAlloy, 6)
                .inputFluids(StyreneButadieneRubber.getFluid(L * 5))
                .outputItems(ITEM_CELL_1024K)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("item_storage_cell_4096k")
                .inputItems(ADVANCED_ITEM_CELL_HOUSING)
                .inputItems(CELL_COMPONENT_4096K)
                .inputItems(QUANTUM_CHEST[ZPM])
                .inputItems(ELITE_CIRCUIT_BOARD, 2)
                .inputItems(screw, NaquadahAlloy, 6)
                .inputFluids(StyreneButadieneRubber.getFluid(L * 5))
                .outputItems(ITEM_CELL_4096K)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("item_storage_cell_16384k")
                .inputItems(ADVANCED_ITEM_CELL_HOUSING)
                .inputItems(CELL_COMPONENT_16384K)
                .inputItems(QUANTUM_CHEST[UV])
                .inputItems(WETWARE_CIRCUIT_BOARD, 2)
                .inputItems(screw, NaquadahAlloy, 6)
                .inputFluids(StyreneButadieneRubber.getFluid(L * 5))
                .outputItems(ITEM_CELL_16384K)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("item_storage_cell_65536k")
                .inputItems(ADVANCED_ITEM_CELL_HOUSING)
                .inputItems(CELL_COMPONENT_65536K)
                .inputItems(QUANTUM_CHEST[UHV])
                .inputItems(SCULK_PRINTED_CIRCUIT_BOARD, 2)
                .inputItems(screw, NaquadahAlloy, 6)
                .inputFluids(StyreneButadieneRubber.getFluid(L * 5))
                .outputItems(ITEM_CELL_65536K)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("item_storage_cell_262144k")
                .inputItems(ADVANCED_ITEM_CELL_HOUSING)
                .inputItems(CELL_COMPONENT_262144K)
                .inputItems(QUANTUM_CHEST[UEV])
                .inputItems(STELLAR_ALLOY_ACTIVATED_COATING_PRINTED_CIRCUIT_BOARD, 2)
                .inputItems(screw, NaquadahAlloy, 6)
                .inputFluids(StyreneButadieneRubber.getFluid(L * 5))
                .outputItems(ITEM_CELL_262144K)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);


        ASSEMBLER_RECIPES.recipeBuilder("fluid_storage_cell_1024k")
                .inputItems(ADVANCED_FLUID_CELL_HOUSING)
                .inputItems(CELL_COMPONENT_1024K)
                .inputItems(QUANTUM_TANK[LuV])
                .inputItems(ELECTRIC_PUMP_LuV)
                .inputItems(EXTREME_CIRCUIT_BOARD, 2)
                .inputItems(screw, NaquadahAlloy, 6)
                .inputFluids(StyreneButadieneRubber.getFluid(L * 5))
                .outputItems(FLUID_CELL_1024K)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("fluid_storage_cell_4096k")
                .inputItems(ADVANCED_FLUID_CELL_HOUSING)
                .inputItems(CELL_COMPONENT_4096K)
                .inputItems(QUANTUM_TANK[ZPM])
                .inputItems(ELECTRIC_PUMP_ZPM)
                .inputItems(ELITE_CIRCUIT_BOARD, 2)
                .inputItems(screw, NaquadahAlloy, 6)
                .inputFluids(StyreneButadieneRubber.getFluid(L * 5))
                .outputItems(FLUID_CELL_4096K)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("fluid_storage_cell_16384k")
                .inputItems(ADVANCED_FLUID_CELL_HOUSING)
                .inputItems(CELL_COMPONENT_16384K)
                .inputItems(QUANTUM_TANK[UV])
                .inputItems(ELECTRIC_PUMP_UV)
                .inputItems(WETWARE_CIRCUIT_BOARD, 2)
                .inputItems(screw, NaquadahAlloy, 6)
                .inputFluids(StyreneButadieneRubber.getFluid(L * 5))
                .outputItems(FLUID_CELL_16384K)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("fluid_storage_cell_65536k")
                .inputItems(ADVANCED_FLUID_CELL_HOUSING)
                .inputItems(CELL_COMPONENT_65536K)
                .inputItems(QUANTUM_TANK[UHV])
                .inputItems(ELECTRIC_PUMP_UHV)
                .inputItems(SCULK_PRINTED_CIRCUIT_BOARD, 2)
                .inputItems(screw, NaquadahAlloy, 6)
                .inputFluids(StyreneButadieneRubber.getFluid(L * 5))
                .outputItems(FLUID_CELL_65536K)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("fluid_storage_cell_262144k")
                .inputItems(ADVANCED_FLUID_CELL_HOUSING)
                .inputItems(CELL_COMPONENT_262144K)
                .inputItems(QUANTUM_TANK[UEV])
                .inputItems(ELECTRIC_PUMP_UEV)
                .inputItems(STELLAR_ALLOY_ACTIVATED_COATING_PRINTED_CIRCUIT_BOARD, 2)
                .inputItems(screw, NaquadahAlloy, 6)
                .inputFluids(StyreneButadieneRubber.getFluid(L * 5))
                .outputItems(FLUID_CELL_262144K)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);


        ASSEMBLER_RECIPES.recipeBuilder("4_core_accelerator")
                .inputItems(CRAFTING_UNIT.asItem())
                .inputItems(ENGINEERING_PROCESSOR.asItem(), 4)
                .inputItems(CustomTags.IV_CIRCUITS, 4)
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .outputItems(ACCELERATOR_4_CORE)
                .duration(200)
                .EUt(VA[IV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("16_core_accelerator")
                .inputItems(CRAFTING_UNIT.asItem())
                .inputItems(ENGINEERING_PROCESSOR.asItem(), 8)
                .inputItems(CustomTags.LuV_CIRCUITS, 4)
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .outputItems(ACCELERATOR_16_CORE)
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("64_core_accelerator")
                .inputItems(CRAFTING_UNIT.asItem())
                .inputItems(ENGINEERING_PROCESSOR.asItem(), 12)
                .inputItems(CustomTags.ZPM_CIRCUITS, 4)
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .outputItems(ACCELERATOR_64_CORE)
                .duration(200)
                .EUt(VA[ZPM])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("256_core_accelerator")
                .inputItems(CRAFTING_UNIT.asItem())
                .inputItems(ENGINEERING_PROCESSOR.asItem(), 16)
                .inputItems(CustomTags.UV_CIRCUITS, 4)
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .outputItems(ACCELERATOR_256_CORE)
                .duration(200)
                .EUt(VA[UV])
                .save(provider);
    }
}
