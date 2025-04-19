package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.CANNER_RECIPES;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEBlocks.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.StarCatalyst;

public class CannerRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        CANNER_RECIPES.recipeBuilder("star_catalyst")
                .inputItems(EMPTY_CATALYST_UNIT, 4)
                .inputFluids(StarCatalyst.getFluid(1000))
                .outputItems(STAR_CATALYST_UNIT, 4)
                .duration(400)
                .EUt(VA[ZPM])
                .save(provider);
        CANNER_RECIPES.recipeBuilder("uev_ascendant_battery")
                .inputItems(BATTERY_EMPTY_TIER_IV.asStack())
                .inputItems(ASCENDANT_BATTERY)
                .outputItems(BATTERY_ASCENDANT_UEV.asStack())
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);
        CANNER_RECIPES.recipeBuilder("uiv_supreme_battery")
                .inputItems(BATTERY_EMPTY_TIER_IV.asStack())
                .inputItems(SUPREME_BATTERY)
                .outputItems(BATTERY_SUPREME_UIV.asStack())
                .duration(400)
                .EUt(VA[LuV])
                .save(provider);
        CANNER_RECIPES.recipeBuilder("uxv_mythical_battery")
                .inputItems(BATTERY_EMPTY_TIER_IV.asStack())
                .inputItems(MYTHICAL_BATTERY)
                .outputItems(BATTERY_MYTHICAL_UXV.asStack())
                .duration(600)
                .EUt(VA[LuV])
                .save(provider);
        CANNER_RECIPES.recipeBuilder("opv_illusory_battery")
                .inputItems(BATTERY_EMPTY_TIER_V.asStack())
                .inputItems(ILLUSORY_BATTERY)
                .outputItems(BATTERY_ILLUSORY_OpV.asStack())
                .duration(200)
                .EUt(VA[ZPM])
                .save(provider);
        CANNER_RECIPES.recipeBuilder("max_creative_battery")
                .inputItems(BATTERY_EMPTY_TIER_V.asStack())
                .inputItems(CREATIVE_BATTERY)
                .outputItems(BATTERY_CREATIVE_MAX.asStack())
                .duration(400)
                .EUt(VA[ZPM])
                .save(provider);
    }
}
