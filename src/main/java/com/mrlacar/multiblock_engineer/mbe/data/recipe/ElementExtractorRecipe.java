package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.ELEMENT_EXTRACTOR;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.Universium;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.*;

public class ElementExtractorRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        ELEMENT_EXTRACTOR.recipeBuilder("universium_from_purified_universium_solution")
                .inputFluids(PurifiedUniversiumSolution.getFluid(4000))
                .inputFluids(ElementalExtractant.getFluid(2000))
                .outputItems(dust, Universium, 2)
                .outputFluids(WasteElementalExtractant.getFluid(2000))
                .duration(200)
                .EUt(VA[UEV])
                .addData("crt", 244)
                .save(provider);

    }
}
