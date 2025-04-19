package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.gem;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Ash;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.WARPING_STATION;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.GemMaterials.Dilithium;

public class WarpingStationRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        WARPING_STATION.recipeBuilder("warp")
                .inputItems(gem, Dilithium, 10)
                .outputItems(dust, Ash)
                .duration(60)
                .EUt(VA[UIV])
                .circuitMeta(1)
                .save(provider);
    }
}
