package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEBlocks.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.*;

public class PackerRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        PACKER_RECIPES.recipeBuilder("battery_empty_tier_iv_1")
                .inputItems(BATTERY_ASCENDANT_UEV)
                .outputItems(BATTERY_EMPTY_TIER_IV)
                .outputItems(ASCENDANT_BATTERY)
                .duration(200)
                .EUt(VA[LV])
                .circuitMeta(2)
                .save(provider);
        PACKER_RECIPES.recipeBuilder("battery_empty_tier_iv_2")
                .inputItems(BATTERY_SUPREME_UIV)
                .outputItems(BATTERY_EMPTY_TIER_IV)
                .outputItems(SUPREME_BATTERY)
                .duration(200)
                .EUt(VA[LV])
                .circuitMeta(2)
                .save(provider);
        PACKER_RECIPES.recipeBuilder("battery_empty_tier_iv_3")
                .inputItems(BATTERY_MYTHICAL_UXV)
                .outputItems(BATTERY_EMPTY_TIER_IV)
                .outputItems(MYTHICAL_BATTERY)
                .duration(200)
                .EUt(VA[LV])
                .circuitMeta(2)
                .save(provider);
    }
}
