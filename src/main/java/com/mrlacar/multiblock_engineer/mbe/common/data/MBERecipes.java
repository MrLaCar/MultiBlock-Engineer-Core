package com.mrlacar.multiblock_engineer.mbe.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.OreProperty;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.mrlacar.multiblock_engineer.mbe.data.recipe.*;
import com.mrlacar.multiblock_engineer.mbe.data.recipe.chemical.KevlarProcess;
import com.mrlacar.multiblock_engineer.mbe.data.recipe.chemical.RocketFuelProcess;
import com.mrlacar.multiblock_engineer.mbe.data.recipe.generated.ElectricImplosionCompressorRecipeHandler;
import com.mrlacar.multiblock_engineer.mbe.data.recipe.generated.LargeElementReplicatorRecipeHandler;
import com.mrlacar.multiblock_engineer.mbe.data.recipe.generated.OreProcessorRecipeHandler;
import com.mrlacar.multiblock_engineer.mbe.data.recipe.generated.UnstableUltraDenseMetalBallRecipeHandler;
import com.mrlacar.multiblock_engineer.mbe.data.recipe.intergration.AE2Recipe;
import com.mrlacar.multiblock_engineer.mbe.data.recipe.intergration.RocketRecipe;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class MBERecipes {

    public static void init(Consumer<FinishedRecipe> provider) {

        AssemblerRecipe.init(provider);
        AssemblyLineRecipe.init(provider);
        CannerRecipe.init(provider);
        CentrifugeRecipe.init(provider);
        CircuitConverterRecipe.init(provider);
        ComponentFactoryRecipe.init(provider);
        ComputationProvider.init(provider);
        DimensionPenetratorRecipe.init(provider);
        ElementExtractorRecipe.init(provider);
        FusionRecipe.init(provider);
        Generator.init(provider);
        LargeChemicalRecipe.init(provider);
        MinerRecipe.init(provider);
        MiscRecipe.init(provider);
        MixerRecipe.init(provider);
        PackerRecipe.init(provider);
        PCBFactoryRecipe.init(provider);
        PhlogistonFusionForgeRecipe.init(provider);
        SpaceAssemblyPlantRecipe.init(provider);
//        SpaceCircuitAssemblyLineRecipe.init(provider);
        UltraPrecisionMatterProcessorRecipe.init(provider);
        VanillaShapedCraftingRecipe.init(provider);
        WarpingStationRecipe.init(provider);
        //generated
        ElectricImplosionCompressorRecipeHandler.init(provider);
        LargeElementReplicatorRecipeHandler.init(provider);
        OreProcessorRecipeHandler.init(provider);
        UnstableUltraDenseMetalBallRecipeHandler.init(provider);
        //chemical
        KevlarProcess.init(provider);
        RocketFuelProcess.init(provider);
        //integration
        AE2Recipe.init(provider);
        RocketRecipe.init(provider);
    }
}
