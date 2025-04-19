package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Ash;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.STAR_VEIN_DIGGER;

public class MinerRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {
        STAR_VEIN_DIGGER.recipeBuilder("star_vein_digger")
                .outputItems(dust, Ash, 1024)
                .duration(200)
                .EUt(VA[UHV])
                .circuitMeta(1)
                .hideDuration(true)
                .save(provider);
    }
}
