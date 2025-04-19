package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.*;

public class Generator {

    public static void init(Consumer<FinishedRecipe> provider) {

        DYSON_SPHERE_DEPLOYMENT_BASE_STATION.recipeBuilder("dyson_sphere")
                .circuitMeta(1)
                .duration(200)
                .EUt(-GTValues.V[MAX])
                .save(provider);

        MICRO_STAR_COLLAPSE_SIMULATOR.recipeBuilder("micro_star_collapse_simulator0")
                .notConsumable(DATA_TEMPLATE_01)
                .duration(200)
                .EUt(-GTValues.V[MAX] * 256)
                .CWUt(131072)
                .save(provider);

        CIRCUIT_RECIPE_GENERATOR.recipeBuilder("photon_station_deploy_unit_generator")
                .circuitMeta(1)
                .duration(200)
                .EUt(-V[HV])
                .save(provider);

    }

}
