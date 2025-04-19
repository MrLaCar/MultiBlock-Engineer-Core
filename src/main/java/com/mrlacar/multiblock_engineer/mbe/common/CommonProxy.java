package com.mrlacar.multiblock_engineer.mbe.common;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.DimensionMarker;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;
import com.mrlacar.multiblock_engineer.mbe.api.MBERegistries;
import com.mrlacar.multiblock_engineer.mbe.common.data.*;
import com.mrlacar.multiblock_engineer.mbe.common.data.machines.GTMMachines;
import com.mrlacar.multiblock_engineer.mbe.common.data.machines.GTMTMachines;
import com.mrlacar.multiblock_engineer.mbe.common.data.machines.MBEMachines;
import com.mrlacar.multiblock_engineer.mbe.common.data.materials.*;
import com.mrlacar.multiblock_engineer.mbe.config.ConfigHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.mrlacar.multiblock_engineer.mbe.api.MBERegistries.REGISTRATE;

public class CommonProxy {

    public CommonProxy() {
        CommonProxy.init();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(eventBus);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::addMaterialRegistries);
        eventBus.addListener(this::registerMaterials);
        eventBus.addListener(this::modifyMaterials);
        eventBus.addGenericListener(DimensionMarker.class, this::registerDimensionMarkers);
        eventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        eventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
    }

    public static void init() {
        MBEItems.init();
        MBEBlocks.init();
        MBECreativeModeTabs.init();
        MBEFoods.init();
        ConfigHolder.init();
        MBERegistries.REGISTRATE.registerRegistrate();
    }

    private void clientSetup(final FMLClientSetupEvent event) {}

    private void addMaterialRegistries(MaterialRegistryEvent event) {
        GTCEuAPI.materialManager.createRegistry(MultiBlock_Engineer.MOD_ID);
    }

    public void registerMaterials(MaterialEvent event) {
        ElementMaterials.register();
        GemMaterials.register();
        AlloyMaterials.register();
        MiscMaterials.register();
    }

    public void modifyMaterials(PostMaterialEvent event) {
        MaterialsModify.modifyMaterials();
    }

    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        MBERecipeTypes.init();
    }

    public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        GTMMachines.init();
        GTMTMachines.init();
        MBEMachines.init();
    }

    public void registerDimensionMarkers(GTCEuAPI.RegisterEvent<ResourceLocation, DimensionMarker> event) {
        MBEDimensionMarkers.init();
    }
}
