package com.mrlacar.multiblock_engineer.mbe.data.recipe.chemical;

import com.gregtechceu.gtceu.GTCEu;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DISTILLERY_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.LARGE_CHEMICAL_RECIPES;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.*;

public class RocketFuelProcess {

    public static void init(Consumer<FinishedRecipe> provider) {

        DISTILLERY_RECIPES.recipeBuilder(GTCEu.id(("kerosene_from_diesel")))
                .inputFluids(Diesel.getFluid(250))
                .outputFluids(Kerosene.getFluid(150))
                .duration(16)
                .EUt(VA[MV])
                .circuitMeta(23)
                .save(provider);

        DISTILLERY_RECIPES.recipeBuilder(GTCEu.id(("kerosene_from_coal_tar")))
                .inputFluids(CoalTar.getFluid(40))
                .outputFluids(Kerosene.getFluid(24))
                .duration(24)
                .EUt(VA[MV])
                .circuitMeta(5)
                .save(provider);

        DISTILLERY_RECIPES.recipeBuilder(GTCEu.id(("rp_1_from_kerosene")))
                .inputFluids(Kerosene.getFluid(100))
                .outputFluids(RP1.getFluid(75))
                .duration(100)
                .EUt(VA[HV])
                .circuitMeta(23)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTCEu.id(("rp_1_rocket_fuel_from_rp_1")))
                .inputFluids(RP1.getFluid(500))
                .inputFluids(Oxygen.getFluid(2000))
                .outputFluids(RP1RocketFuel.getFluid(1500))
                .duration(600)
                .EUt(VA[EV])
                .circuitMeta(1)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTCEu.id(("hydrazine_from_hydrogen_peroxide_and_ammonia")))
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .inputFluids(Ammonia.getFluid(2000))
                .outputFluids(Hydrazine.getFluid(1000))
                .duration(600)
                .EUt(VA[MV])
                .circuitMeta(21)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTCEu.id(("dense_hydrazine_from_hydrazine_and_methanol")))
                .inputFluids(Hydrazine.getFluid(4000))
                .inputFluids(Methanol.getFluid(6000))
                .outputFluids(DenseHydrazineFuelMixture.getFluid(10000))
                .duration(800)
                .EUt(VA[IV])
                .circuitMeta(2)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTCEu.id(("monomethyl_hydrazine_from_carbon_and_hydrogen_and_hydrazine")))
                .inputItems(dust, Carbon)
                .inputFluids(Hydrazine.getFluid(2000))
                .inputFluids(Methanol.getFluid(1000))
                .outputFluids(MonomethylHydrazine.getFluid(1000))
                .duration(900)
                .EUt(VA[HV])
                .circuitMeta(21)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTCEu.id(("cn3h7o3_rocket_fuel_from_monomethyl_hydrazine_and_nitric_acid")))
                .inputFluids(MonomethylHydrazine.getFluid(2000))
                .inputFluids(NitricAcid.getFluid(1000))
                .outputFluids(CN3H7O3RocketFuel.getFluid(1000))
                .duration(1200)
                .EUt(VA[LuV])
                .circuitMeta(3)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTCEu.id(("h8n4c2o4_rocket_fuel_from_dimethyl_hydrazine_and_dinitrogen_tetroxide")))
                .inputFluids(Dimethylhydrazine.getFluid(2000))
                .inputFluids(DinitrogenTetroxide.getFluid(2000))
                .outputFluids(H8N4C2O4RocketFuel.getFluid(5000))
                .duration(1600)
                .EUt(VA[ZPM])
                .circuitMeta(4)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTCEu.id(("hydrogen_peroxide_and_2_ethylanthraquinone_from_oxygen_and_2_ethylanthrahydroquinone_and_anthracene")))
                .inputFluids(Oxygen.getFluid(10000))
                .inputFluids(TwoEthylanthrahydroquinone.getFluid(5000))
                .inputFluids(Anthracene.getFluid(50))
                .outputFluids(TwoEthylanthraquinone.getFluid(5000))
                .outputFluids(HydrogenPeroxide.getFluid(5000))
                .duration(100)
                .EUt(VA[HV])
                .circuitMeta(4)
                .save(provider);

        DISTILLERY_RECIPES.recipeBuilder(GTCEu.id(("anthracene_from_coal_tar")))
                .inputFluids(CoalTar.getFluid(400))
                .outputFluids(Anthracene.getFluid(20))
                .duration(240)
                .EUt(VA[MV])
                .circuitMeta(6)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTCEu.id(("2_ethylanthrahydroquinone_from_2_ethylanthraquinone_and_hydrogen")))
                .inputFluids(TwoEthylanthraquinone.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(2000))
                .outputFluids(TwoEthylanthrahydroquinone.getFluid(1000))
                .duration(800)
                .EUt(VA[MV])
                .circuitMeta(4)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder(GTCEu.id(("2_ethylanthraquinone_from_methylbenzene_and_phthalic_anhybride")))
                .inputItems(dust, PhthalicAnhybride, 15)
                .inputFluids(Ethylbenzene.getFluid(1000))
                .outputFluids(TwoEthylanthraquinone.getFluid(1000))
                .duration(300)
                .EUt(VA[MV])
                .circuitMeta(4)
                .save(provider);
    }
}
