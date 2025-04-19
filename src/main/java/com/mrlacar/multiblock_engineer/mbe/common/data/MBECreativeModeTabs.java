package com.mrlacar.multiblock_engineer.mbe.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;
import com.mrlacar.multiblock_engineer.mbe.common.data.machines.MBEMachines;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static com.mrlacar.multiblock_engineer.mbe.api.MBERegistries.REGISTRATE;

public class MBECreativeModeTabs {

    public static RegistryEntry<CreativeModeTab> ITEM = REGISTRATE.defaultCreativeTab("item",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("item", REGISTRATE))
                            .icon(MBEItems.ASTRAL_EMITTER::asStack)
                            .title(REGISTRATE.addLang("itemGroup", MultiBlock_Engineer.id("item_tab"), "MultiBlock Engineer Item"))
                            .build())
            .register();
    public static RegistryEntry<CreativeModeTab> BLOCK = REGISTRATE.defaultCreativeTab("block",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("block", REGISTRATE))
                            .icon(MBEBlocks.HIGH_PRECISE_INERT_CASING::asStack)
                            .title(REGISTRATE.addLang("itemGroup", MultiBlock_Engineer.id("block_tab"), "MultiBlock Engineer Block"))
                            .build())
            .register();
    public static RegistryEntry<CreativeModeTab> MACHINE = REGISTRATE.defaultCreativeTab("machine",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("machine", REGISTRATE))
                            .icon(MBEMachines.SPACE_ASSEMBLY_PLANT::asStack)
                            .title(REGISTRATE.addLang("itemGroup", MultiBlock_Engineer.id("machine_tab"), "MultiBlock Engineer Machine"))
                            .build())
            .register();

    public static void init() {}
}
