package com.mrlacar.multiblock_engineer.mbe.data.tags;

import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.providers.RegistrateItemTagsProvider;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.*;

public class ItemTagLoader {
    public static void init(RegistrateItemTagsProvider provider) {

        provider.addTag(CustomTags.ELECTRIC_MOTORS)
                .addOptional(ELECTRIC_MOTOR_MAX.getId());

        provider.addTag(CustomTags.ELECTRIC_PUMPS)
                .addOptional(ELECTRIC_PUMP_MAX.getId());

        provider.addTag(CustomTags.FLUID_REGULATORS)
                .addOptional(FLUID_REGULATOR_MAX.getId());

        provider.addTag(CustomTags.CONVEYOR_MODULES)
                .addOptional(CONVEYOR_MODULE_MAX.getId());

        provider.addTag(CustomTags.ELECTRIC_PISTONS)
                .addOptional(ELECTRIC_PISTON_MAX.getId());

        provider.addTag(CustomTags.ROBOT_ARMS)
                .addOptional(ROBOT_ARM_MAX.getId());

        provider.addTag(CustomTags.FIELD_GENERATORS)
                .addOptional(FIELD_GENERATOR_MAX.getId());

        provider.addTag(CustomTags.EMITTERS)
                .addOptional(EMITTER_MAX.getId());

        provider.addTag(CustomTags.SENSORS)
                .addOptional(SENSOR_MAX.getId());
    }

    public static void create(RegistrateTagsProvider<Item> provider, TagKey<Item> tagKey, ResourceLocation... rls) {
        var builder = provider.addTag(tagKey);
        for (ResourceLocation rl : rls) {
            builder.addOptional(rl);
        }
    }

    public static void create(RegistrateTagsProvider<Item> provider, TagKey<Item> tagKey, Item... rls) {
        var builder = provider.addTag(tagKey);
        for (Item item : rls) {
            builder.add(BuiltInRegistries.ITEM.getResourceKey(item).get());
        }
    }
}
