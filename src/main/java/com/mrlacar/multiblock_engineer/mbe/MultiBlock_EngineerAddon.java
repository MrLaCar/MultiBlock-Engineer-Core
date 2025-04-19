package com.mrlacar.multiblock_engineer.mbe;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.mrlacar.multiblock_engineer.mbe.api.MBERegistries;
import com.mrlacar.multiblock_engineer.mbe.common.data.*;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;


@GTAddon
public class MultiBlock_EngineerAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return MBERegistries.REGISTRATE;
    }

    @Override
    public boolean requiresHighTier() {
        return true;
    }

    @Override
    public void initializeAddon() {
    }

    @Override
    public String addonModId() {
        return MultiBlock_Engineer.MOD_ID;
    }

    @Override
    public void registerSounds() {
        MBESoundEntries.init();
    }

    @Override
    public void registerElements() {
        IGTAddon.super.registerElements();
        MBEElements.init();
    }

    @Override
    public void registerTagPrefixes() {
        MBETagPrefix.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        MBERecipes.init(provider);
    }

    @Override
    public void registerFluidVeins() {
        MBEBedrockFluids.init();
    }

    @Override
    public void registerCovers() {
        GTRegistries.COVERS.register(MBECovers.PUMP_MAX.id, MBECovers.PUMP_MAX.definition);
        GTRegistries.COVERS.register(MBECovers.CONVEYOR_MAX.id, MBECovers.CONVEYOR_MAX.definition);
        GTRegistries.COVERS.register(MBECovers.FLUID_REGULATOR_MAX.id, MBECovers.FLUID_REGULATOR_MAX.definition);
        GTRegistries.COVERS.register(MBECovers.ROBOT_ARM_MAX.id, MBECovers.ROBOT_ARM_MAX.definition);
    }
}
