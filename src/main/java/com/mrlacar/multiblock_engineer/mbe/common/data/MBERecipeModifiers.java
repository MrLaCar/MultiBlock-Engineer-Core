package com.mrlacar.multiblock_engineer.mbe.common.data;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IOverclockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import org.jetbrains.annotations.NotNull;

public class MBERecipeModifiers {

    public static @NotNull ModifierFunction accurateParallels(MetaMachine machine, @NotNull GTRecipe recipe, int parallelLimit) {
        if (machine instanceof IOverclockMachine overclockMachine) {
            if (RecipeHelper.getRecipeEUtTier(recipe) > overclockMachine.getMaxOverclockTier()) {
                return null;
            }
            int maxParallel = parallelLimit;
            int parallels = ParallelLogic.getParallelAmount(machine, recipe, maxParallel);
            return ModifierFunction.builder()
                    .modifyAllContents(ContentModifier.multiplier(parallels))
                    .eutMultiplier(parallels)
                    .parallels(parallels)
                    .build();
        }
        return ModifierFunction.IDENTITY;
    }
}
