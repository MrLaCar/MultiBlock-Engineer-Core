package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.GENERAL_CIRCUIT_CONVERTER;

public class CircuitConverterRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("lv_convert")
                .inputItems(CustomTags.LV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_LV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("mv_convert")
                .inputItems(CustomTags.MV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_MV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("hv_convert")
                .inputItems(CustomTags.HV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_HV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("ev_convert")
                .inputItems(CustomTags.EV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_EV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("iv_convert")
                .inputItems(CustomTags.IV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_IV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("luv_convert")
                .inputItems(CustomTags.LuV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_LuV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("zpm_convert")
                .inputItems(CustomTags.ZPM_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_ZPM)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("uv_convert")
                .inputItems(CustomTags.UV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_UV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("uhv_convert")
                .inputItems(CustomTags.UHV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_UHV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("uev_convert")
                .inputItems(CustomTags.UEV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_UEV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("uiv_convert")
                .inputItems(CustomTags.UIV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_UIV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("uxv_convert")
                .inputItems(CustomTags.UXV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_UXV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
        GENERAL_CIRCUIT_CONVERTER.recipeBuilder("opv_convert")
                .inputItems(CustomTags.OpV_CIRCUITS)
                .outputItems(GENERAL_CIRCUIT_OpV)
                .duration(20)
                .EUt(VA[EV])
                .save(provider);
    }
}
