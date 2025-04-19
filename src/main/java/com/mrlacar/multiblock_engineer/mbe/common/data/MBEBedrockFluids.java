package com.mrlacar.multiblock_engineer.mbe.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.worldgen.bedrockfluid.BedrockFluidDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.GelidCryotheum;

public class MBEBedrockFluids {

    public static final Map<ResourceLocation, BedrockFluidDefinition> toReRegister = new HashMap<>();

    public static BedrockFluidDefinition GELID_CRYOTHEUM = create(GTCEu.id("gelid_cryotheum_deposit"),
            builder -> builder
                    .fluid(GelidCryotheum::getFluid)
                    .weight(5)
                    .yield(20, 40)
                    .depletionAmount(1)
                    .depletionChance(100)
                    .depletedYield(10)
                    .dimensions(Dimension("ad_astra", "glacio")));

    public static BedrockFluidDefinition HELIUM_3 = create(GTCEu.id("helium3_deposit"),
            builder -> builder
                    .fluid(Helium3::getFluid)
                    .weight(10)
                    .yield(50, 180)
                    .depletionAmount(1)
                    .depletionChance(100)
                    .depletedYield(40)
                    .dimensions(Dimension("ad_astra", "moon")));

    public static BedrockFluidDefinition HELIUM = create(GTCEu.id("helium_deposit"),
            builder -> builder
                    .fluid(Helium::getFluid)
                    .weight(20)
                    .yield(50, 300)
                    .depletionAmount(1)
                    .depletionChance(100)
                    .depletedYield(40)
                    .dimensions(Dimension("ad_astra", "moon")));

    public static BedrockFluidDefinition SULFURIC_ACID = create(GTCEu.id("sulfuric_acid_deposit"),
            builder -> builder
                    .fluid(SulfuricAcid::getFluid)
                    .weight(20)
                    .yield(100, 250)
                    .depletionAmount(1)
                    .depletionChance(100)
                    .depletedYield(40)
                    .dimensions(Dimension("ad_astra", "venus")));

    public static BedrockFluidDefinition HEAVY_OIL_FLAT = create(GTCEu.id("heavy_oil_flat_deposit"), builder -> builder
            .fluid(GTMaterials.OilHeavy::getFluid)
            .weight(15)
            .yield(100, 200)
            .depletionAmount(1)
            .depletionChance(100)
            .depletedYield(20)
            .dimensions(Dimension("mbe", "flat")));

    public static BedrockFluidDefinition LIGHT_OIL_FLAT = create(GTCEu.id("light_oil_flat_deposit"), builder -> builder
            .fluid(GTMaterials.OilLight::getFluid)
            .weight(25)
            .yield(175, 300)
            .depletionAmount(1)
            .depletionChance(100)
            .depletedYield(25)
            .dimensions(Dimension("mbe", "flat")));

    public static BedrockFluidDefinition NATURAL_GAS_FLAT = create(GTCEu.id("natural_gas_flat_deposit"), builder -> builder
            .fluid(GTMaterials.NaturalGas::getFluid)
            .weight(15)
            .yield(100, 175)
            .depletionAmount(1)
            .depletionChance(100)
            .depletedYield(20)
            .dimensions(Dimension("mbe", "flat")));

    public static BedrockFluidDefinition OIL_FLAT = create(GTCEu.id("oil_flat_deposit"), builder -> builder
            .fluid(GTMaterials.Oil::getFluid)
            .weight(20)
            .yield(175, 300)
            .depletionAmount(1)
            .depletionChance(100)
            .depletedYield(25)
            .dimensions(Dimension("mbe", "flat")));

    public static BedrockFluidDefinition RAW_OIL_FLAT = create(GTCEu.id("raw_oil_flat_deposit"), builder -> builder
            .fluid(GTMaterials.RawOil::getFluid)
            .weight(20)
            .yield(200, 300)
            .depletionAmount(1)
            .depletionChance(100)
            .depletedYield(25)
            .dimensions(Dimension("mbe", "flat")));

    public static BedrockFluidDefinition SALT_WATER_FLAT = create(GTCEu.id("salt_water_flat_deposit"), builder -> builder
            .fluid(GTMaterials.SaltWater::getFluid)
            .weight(20)
            .yield(50, 100)
            .depletionAmount(1)
            .depletionChance(100)
            .depletedYield(15)
            .dimensions(Dimension("mbe", "flat")));

    public static void init() {
        toReRegister.forEach(GTRegistries.BEDROCK_FLUID_DEFINITIONS::registerOrOverride);
    }

    public static BedrockFluidDefinition create(ResourceLocation id, Consumer<BedrockFluidDefinition.Builder> consumer) {
        BedrockFluidDefinition.Builder builder = BedrockFluidDefinition.builder(id);
        consumer.accept(builder);
        BedrockFluidDefinition definition = builder.build();
        toReRegister.put(id, definition);
        return definition;
    }

    public static Set<ResourceKey<Level>> Dimension(String namespace, String path) {
        return Set.of(ResourceKey.create(Registries.DIMENSION,
                new ResourceLocation(namespace, path)));
    }


}
