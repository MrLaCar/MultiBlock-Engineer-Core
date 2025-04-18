package com.mrlacar.multiblock_engineer.mbe.data.recipe.intergration;

import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLY_LINE_RECIPES;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.ADVANCED_ROCKET_ASSEMBLY_LINE;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.AlloyMaterials.Indalloy140;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.AlloyMaterials.XK3700TAlloy;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.*;
import static earth.terrarium.adastra.common.registry.ModItems.*;
import static net.celsiusqc.ad_astra_rocketed.common.registry.ModItems.*;

public class RocketRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        ASSEMBLER_RECIPES.recipeBuilder("heavy_rocket_plate_t1")
                .inputItems(plateDouble, StainlessSteel, 4)
                .inputItems(plateDouble, Titanium, 4)
                .inputItems(plateDouble, Aluminium, 4)
                .inputItems(plateDouble, Chromium, 4)
                .inputItems(screw, StainlessSteel, 12)
                .inputFluids(SolderingAlloy.getFluid(L * 10))
                .outputItems(HEAVY_ROCKET_PLATE_T1)
                .duration(400)
                .EUt(VA[EV])
                .save(provider);
        ASSEMBLER_RECIPES.recipeBuilder("heavy_rocket_plate_t2")
                .inputItems(plateDouble, TungstenSteel, 4)
                .inputItems(plateDouble, Desh, 4)
                .inputItems(plateDouble, Platinum, 4)
                .inputItems(plateDouble, Cobalt, 4)
                .inputItems(screw, TungstenSteel, 12)
                .inputFluids(Indalloy140.getFluid(L * 10))
                .outputItems(HEAVY_ROCKET_PLATE_T2)
                .duration(400)
                .EUt(VA[IV])
                .save(provider);
        ASSEMBLY_LINE_RECIPES.recipeBuilder("heavy_rocket_plate_t3")
                .inputItems(plateDouble, NaquadahAlloy, 4)
                .inputItems(plateDouble, Ostrum, 4)
                .inputItems(plateDouble, Osmiridium, 4)
                .inputItems(plateDouble, HSSE, 4)
                .inputItems(screw, NaquadahAlloy, 12)
                .inputFluids(Indalloy140.getFluid(L * 10))
                .outputItems(HEAVY_ROCKET_PLATE_T3)
                .scannerResearch(b -> b
                        .researchStack(HEAVY_ROCKET_PLATE_T2.asStack())
                        .duration(200)
                        .EUt(VA[LuV]))
                .duration(400).EUt(VA[LuV]).save(provider);
        ASSEMBLY_LINE_RECIPES.recipeBuilder("heavy_rocket_plate_t4")
                .inputItems(plateDouble, Trinium, 4)
                .inputItems(plateDouble, Calorite, 4)
                .inputItems(plateDouble, Naquadria, 4)
                .inputItems(plateDouble, Niobium, 4)
                .inputItems(screw, Trinium, 12)
                .inputFluids(Indalloy140.getFluid(L * 10))
                .outputItems(HEAVY_ROCKET_PLATE_T4)
                .scannerResearch(b -> b
                        .researchStack(HEAVY_ROCKET_PLATE_T3.asStack())
                        .duration(400)
                        .EUt(VA[ZPM]))
                .duration(400).EUt(VA[ZPM]).save(provider);
        ASSEMBLY_LINE_RECIPES.recipeBuilder("heavy_rocket_plate_t5")
                .inputItems(plateDouble, Europium, 4)
                .inputItems(plateDouble, Olancadium, 4)
                .inputItems(plateDouble, Tritanium, 4)
                .inputItems(plateDouble, Iridium, 4)
                .inputItems(screw, Europium, 12)
                .inputFluids(Indalloy140.getFluid(L * 10))
                .outputItems(HEAVY_ROCKET_PLATE_T5)
                .stationResearch(b -> b
                        .researchStack(HEAVY_ROCKET_PLATE_T4.asStack())
                        .CWUt(24)
                        .EUt(VA[UV]))
                .duration(400).EUt(VA[UV]).save(provider);
        ASSEMBLY_LINE_RECIPES.recipeBuilder("heavy_rocket_plate_t6")
                .inputItems(plateDouble, Neutronium, 4)
                .inputItems(plateDouble, B47, 4)
                .inputItems(plateDouble, Rhodium, 4)
                .inputItems(plateDouble, Darmstadtium, 4)
                .inputItems(screw, Neutronium, 12)
                .inputFluids(Indalloy140.getFluid(L * 10))
                .outputItems(HEAVY_ROCKET_PLATE_T6)
                .stationResearch(b -> b
                        .researchStack(HEAVY_ROCKET_PLATE_T5.asStack())
                        .CWUt(48)
                        .EUt(VA[UHV]))
                .duration(400).EUt(VA[UHV]).save(provider);
        ASSEMBLY_LINE_RECIPES.recipeBuilder("heavy_rocket_plate_t7")
                .inputItems(plateDouble, XK3700TAlloy, 4)
                .inputItems(plateDouble, Oganesson, 4)
                .inputItems(plateDouble, Draconium, 4)
                .inputItems(plateDouble, Indium, 4)
                .inputItems(screw, XK3700TAlloy, 12)
                .inputFluids(Indalloy140.getFluid(L * 10))
                .outputItems(HEAVY_ROCKET_PLATE_T7)
                .stationResearch(b -> b
                        .researchStack(HEAVY_ROCKET_PLATE_T6.asStack())
                        .CWUt(96)
                        .EUt(VA[UEV]))
                .duration(400).EUt(VA[UEV]).save(provider);
        //Rocket
        ADVANCED_ROCKET_ASSEMBLY_LINE.recipeBuilder("rocket_t3")
                .inputItems(ROCKET_NOSE_CONE)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(frameGt, TungstenSteel)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(frameGt, TungstenSteel)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(frameGt, TungstenSteel)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(HEAVY_ROCKET_PLATE_T3)
                .inputItems(ROCKET_FIN)
                .inputItems(OSTRUM_TANK)
                .inputItems(OSTRUM_TANK)
                .inputItems(ROCKET_FIN)
                .inputItems(ROCKET_FIN)
                .inputItems(OSTRUM_ENGINE)
                .inputItems(OSTRUM_ENGINE)
                .inputItems(ROCKET_FIN)
                .inputItems(STAR_MAP_NAVIGATION)
                .inputItems(GRAVITATION_ENGINE)
                .inputItems(CustomTags.LuV_CIRCUITS, 8)
                .inputItems(FIELD_GENERATOR_LuV)
                .inputFluids(Lubricant.getFluid(L * 30))
                .inputFluids(Indalloy140.getFluid(L * 30))
                .inputFluids(Polybenzimidazole.getFluid(L * 30))
                .inputFluids(StyreneButadieneRubber.getFluid(L * 30))
                .outputItems(TIER_3_ROCKET)
                .duration(1200)
                .EUt(VA[LuV])
                .addData("ARALTier", 3)
                .save(provider);
        ADVANCED_ROCKET_ASSEMBLY_LINE.recipeBuilder("rocket_t4")
                .inputItems(ROCKET_NOSE_CONE)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(frameGt, Trinium)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(frameGt, Trinium)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(frameGt, Trinium)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(HEAVY_ROCKET_PLATE_T4)
                .inputItems(ROCKET_FIN)
                .inputItems(CALORITE_TANK)
                .inputItems(CALORITE_TANK)
                .inputItems(ROCKET_FIN)
                .inputItems(ROCKET_FIN)
                .inputItems(CALORITE_ENGINE)
                .inputItems(CALORITE_ENGINE)
                .inputItems(ROCKET_FIN)
                .inputItems(STAR_MAP_NAVIGATION)
                .inputItems(GRAVITATION_ENGINE)
                .inputItems(CustomTags.ZPM_CIRCUITS, 8)
                .inputItems(FIELD_GENERATOR_ZPM)
                .inputFluids(Lubricant.getFluid(L * 30))
                .inputFluids(Indalloy140.getFluid(L * 30))
                .inputFluids(Polybenzimidazole.getFluid(L * 30))
                .inputFluids(StyreneButadieneRubber.getFluid(L * 30))
                .outputItems(TIER_4_ROCKET)
                .duration(1200)
                .EUt(VA[ZPM])
                .addData("ARALTier", 4)
                .save(provider);
        ADVANCED_ROCKET_ASSEMBLY_LINE.recipeBuilder("rocket_t5")
                .inputItems(ROCKET_NOSE_CONE)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(frameGt, Europium)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(frameGt, Europium)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(frameGt, Europium)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(HEAVY_ROCKET_PLATE_T5)
                .inputItems(ROCKET_FIN)
                .inputItems(CALORITE_TANK)
                .inputItems(CALORITE_TANK)
                .inputItems(ROCKET_FIN)
                .inputItems(ROCKET_FIN)
                .inputItems(CALORITE_ENGINE)
                .inputItems(CALORITE_ENGINE)
                .inputItems(ROCKET_FIN)
                .inputItems(STAR_MAP_NAVIGATION)
                .inputItems(GRAVITATION_ENGINE, 2)
                .inputItems(CustomTags.UV_CIRCUITS, 8)
                .inputItems(FIELD_GENERATOR_UV)
                .inputFluids(Lubricant.getFluid(L * 30))
                .inputFluids(Indalloy140.getFluid(L * 30))
                .inputFluids(Osmiridium.getFluid(L * 30))
                .inputFluids(StyreneButadieneRubber.getFluid(L * 30))
                .outputItems(TIER_5_ROCKET)
                .duration(1200)
                .EUt(VA[UV])
                .addData("ARALTier", 5)
                .save(provider);
        ADVANCED_ROCKET_ASSEMBLY_LINE.recipeBuilder("rocket_t6")
                .inputItems(ROCKET_NOSE_CONE)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(frameGt, Neutronium)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(frameGt, Neutronium)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(frameGt, Neutronium)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(HEAVY_ROCKET_PLATE_T6)
                .inputItems(ROCKET_FIN)
                .inputItems(CALORITE_TANK)
                .inputItems(CALORITE_TANK)
                .inputItems(ROCKET_FIN)
                .inputItems(ROCKET_FIN)
                .inputItems(CALORITE_ENGINE)
                .inputItems(CALORITE_ENGINE)
                .inputItems(ROCKET_FIN)
                .inputItems(STAR_MAP_NAVIGATION)
                .inputItems(GRAVITATION_ENGINE, 3)
                .inputItems(CustomTags.UHV_CIRCUITS, 8)
                .inputItems(FIELD_GENERATOR_UHV)
                .inputFluids(Lubricant.getFluid(L * 30))
                .inputFluids(Indalloy140.getFluid(L * 30))
                .inputFluids(Tritanium.getFluid(L * 30))
                .inputFluids(StyreneButadieneRubber.getFluid(L * 30))
                .outputItems(TIER_6_ROCKET)
                .duration(1200)
                .EUt(VA[UHV])
                .addData("ARALTier", 6)
                .save(provider);
        ADVANCED_ROCKET_ASSEMBLY_LINE.recipeBuilder("rocket_t7")
                .inputItems(ROCKET_NOSE_CONE)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(frameGt, XK3700TAlloy)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(frameGt, XK3700TAlloy)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(frameGt, XK3700TAlloy)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(HEAVY_ROCKET_PLATE_T7)
                .inputItems(ROCKET_FIN)
                .inputItems(CALORITE_TANK)
                .inputItems(CALORITE_TANK)
                .inputItems(ROCKET_FIN)
                .inputItems(ROCKET_FIN)
                .inputItems(CALORITE_ENGINE)
                .inputItems(CALORITE_ENGINE)
                .inputItems(ROCKET_FIN)
                .inputItems(STAR_MAP_NAVIGATION)
                .inputItems(GRAVITATION_ENGINE, 4)
                .inputItems(CustomTags.UEV_CIRCUITS, 8)
                .inputItems(FIELD_GENERATOR_UEV)
                .inputFluids(Lubricant.getFluid(L * 30))
                .inputFluids(Indalloy140.getFluid(L * 30))
                .inputFluids(Draconium.getFluid(L * 30))
                .inputFluids(StyreneButadieneRubber.getFluid(L * 30))
                .outputItems(TIER_7_ROCKET)
                .duration(1200)
                .EUt(VA[UEV])
                .addData("ARALTier", 7)
                .save(provider);
    }
}
