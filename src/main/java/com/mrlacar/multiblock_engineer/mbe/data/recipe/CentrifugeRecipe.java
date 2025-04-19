package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dustSmall;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.CENTRIFUGE_RECIPES;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.*;

public class CentrifugeRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        CENTRIFUGE_RECIPES.recipeBuilder("impure_universium_dust_from_acidified_activated_ex_68_i_bacteria_solution")
                .inputFluids(AcidifiedActivatedEX68IBacteriaSolution.getFluid(1000))
                .outputItems(dust, ImpureUniversiumDust, 10)
                .chancedOutput(dust, ImpureUniversiumDust, 5,3000, 0)
                .chancedOutput(dust, ImpureUniversiumDust, 5,2000, 0)
                .chancedOutput(dustSmall, Rhodium, 5,1667, 0)
                .chancedOutput(dustSmall, Yttrium, 5,1667, 0)
                .chancedOutput(dustSmall, Iridium, 4,1667, 0)
                .outputFluids(InactivatedEX68IBacteriaSolution.getFluid(800))
                .duration(1000)
                .EUt(VA[UHV])
                .save(provider);

    }
}
