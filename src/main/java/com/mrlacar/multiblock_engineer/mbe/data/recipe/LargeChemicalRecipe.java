package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.HydrofluoricAcid;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Neutronium;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.LARGE_CHEMICAL_RECIPES;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.EX_68I_BACTERIA;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.*;

public class LargeChemicalRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        LARGE_CHEMICAL_RECIPES.recipeBuilder("activated_ex_68_i_bacteria_solution_from_contaminated_universium_containing_fluid")
                .inputItems(EX_68I_BACTERIA, 10)
                .inputFluids(ContaminatedUniversiumContainingFluid.getFluid(10000))
                .outputItems(dust, Gloomystone, 32)
                .outputFluids(UniversiumWasteFluid.getFluid(2000))
                .outputFluids(ActivatedEX68IBacteriaSolution.getFluid(8000))
                .duration(800)
                .EUt(VA[UV])
                .circuitMeta(3)
                .save(provider);
        LARGE_CHEMICAL_RECIPES.recipeBuilder("acidified_activated_ex_68_i_bacteria_solution_from_activated_ex_68_i_bacteria_solution")
                .notConsumable(dust, Neutronium)
                .inputFluids(ActivatedEX68IBacteriaSolution.getFluid(2000))
                .inputFluids(HydrofluoricAcid.getFluid(4000))
                .outputFluids(AcidifiedActivatedEX68IBacteriaSolution.getFluid(4000))
                .duration(800)
                .EUt(VA[UV])
                .circuitMeta(2)
                .save(provider);

    }
}
