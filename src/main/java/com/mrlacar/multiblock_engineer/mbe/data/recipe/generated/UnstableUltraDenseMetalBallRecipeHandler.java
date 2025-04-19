package com.mrlacar.multiblock_engineer.mbe.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTElements;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.block;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.DIMENSIONALLY_TRANSCENDENT_FIELD_COMPRESS_HAMMER;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBETagPrefix.unstable_ultra_dense_metal_ball;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.*;

public class UnstableUltraDenseMetalBallRecipeHandler {

    private final static List<Material> metal0 = List.of(
            Titanium,
            Tungsten,
            Naquadah,
            Europium,
            Steel);

    private final static List<Material> metal1 = List.of(
            Oganesson,
            Hassium,
            Universium,
            FragmentedDimension,
            Singularium);

    public static void init(Consumer<FinishedRecipe> provider) {

        for (Material type : metal0) {
            Element element = Objects.requireNonNullElse(type.getElement(), GTElements.Nt);
            long mass = element.mass();
            DIMENSIONALLY_TRANSCENDENT_FIELD_COMPRESS_HAMMER.recipeBuilder(type.getName())
                    .inputItems(block, type, 48)
                    .outputItems(unstable_ultra_dense_metal_ball, type, 1)
                    .duration(10000)
                    .EUt(VA[UEV])
                    .CWUt((int) mass)
                    .save(provider);
        }

        for (Material type : metal1) {
            DIMENSIONALLY_TRANSCENDENT_FIELD_COMPRESS_HAMMER.recipeBuilder(type.getName())
                    .inputItems(block, type, 48)
                    .outputItems(unstable_ultra_dense_metal_ball, type, 1)
                    .duration(10000)
                    .EUt(VA[UIV])
                    .CWUt(1024)
                    .save(provider);
        }
    }
}
