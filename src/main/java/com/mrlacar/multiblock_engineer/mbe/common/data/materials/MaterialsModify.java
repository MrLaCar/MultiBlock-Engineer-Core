package com.mrlacar.multiblock_engineer.mbe.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.mrlacar.multiblock_engineer.mbe.common.data.MBEMaterialFlags;

public class MaterialsModify {

    public static void modifyMaterials() {
        //GENERATE FLAG
        GTMaterials.UraniumTriplatinum.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.Lead.addFlags(MaterialFlags.GENERATE_DENSE);
        GTMaterials.Polonium.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        GTMaterials.Polonium.addFlags(MaterialFlags.GENERATE_PLATE);
        GTMaterials.Polonium.addFlags(MaterialFlags.GENERATE_PLATE);
        GTMaterials.Plutonium239.addFlags(MaterialFlags.GENERATE_PLATE);
        GTMaterials.Uranium235.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        GTMaterials.Thorium.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        GTMaterials.Plutonium241.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        GTMaterials.NaquadahEnriched.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        GTMaterials.Naquadria.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        GTMaterials.Osmiridium.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.Trinium.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.RutheniumTriniumAmericiumNeutronate.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        GTMaterials.Tritanium.addFlags(MaterialFlags.GENERATE_ROTOR);
        GTMaterials.Neutronium.addFlags(MaterialFlags.GENERATE_FOIL);
        GTMaterials.Mendelevium.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.Mendelevium.addFlags(MaterialFlags.GENERATE_PLATE);
        GTMaterials.Tennessine.addFlags(MaterialFlags.GENERATE_ROTOR);
        GTMaterials.Promethium.addFlags(MaterialFlags.GENERATE_ROTOR);
        GTMaterials.Promethium.addFlags(MaterialFlags.GENERATE_GEAR);
        GTMaterials.Promethium.addFlags(MaterialFlags.GENERATE_SMALL_GEAR);
        GTMaterials.Holmium.addFlags(MaterialFlags.GENERATE_FOIL);
        GTMaterials.Oganesson.addFlags(MaterialFlags.GENERATE_GEAR);
        GTMaterials.Oganesson.addFlags(MaterialFlags.GENERATE_SMALL_GEAR);
        GTMaterials.Francium.addFlags(MaterialFlags.GENERATE_GEAR);
        GTMaterials.Francium.addFlags(MaterialFlags.GENERATE_SMALL_GEAR);
        GTMaterials.Protactinium.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        GTMaterials.Europium.addFlags(MaterialFlags.GENERATE_BOLT_SCREW);
        GTMaterials.Niobium.addFlags(MaterialFlags.GENERATE_PLATE);
        GTMaterials.Indium.addFlags(MaterialFlags.GENERATE_PLATE);
        GTMaterials.Titanium.addFlags(MBEMaterialFlags.GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL);
        GTMaterials.Tungsten.addFlags(MBEMaterialFlags.GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL);
        GTMaterials.Naquadah.addFlags(MBEMaterialFlags.GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL);
        GTMaterials.Oganesson.addFlags(MBEMaterialFlags.GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL);
        GTMaterials.Hassium.addFlags(MBEMaterialFlags.GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL);
        GTMaterials.Europium.addFlags(MBEMaterialFlags.GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL);
        //Ore
        GTMaterials.Titanium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Osmium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Duranium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Darmstadtium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Americium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Tritanium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Neutronium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Radium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Scandium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Holmium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Thulium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Neptunium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Livermorium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Einsteinium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Zirconium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.Mendelevium.setProperty(PropertyKey.ORE, new OreProperty());
        GTMaterials.NetherStar.setProperty(PropertyKey.ORE, new OreProperty());

        //Ingot
        GTMaterials.Seaborgium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Californium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Promethium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Fermium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Roentgenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Thulium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Francium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Nobelium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Terbium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Copernicium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Mendelevium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Bohrium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Hassium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Meitnerium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Flerovium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Livermorium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Gadolinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Dysprosium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Holmium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Erbium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Einsteinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Berkelium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Neptunium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Oganesson.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Tennessine.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Protactinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Actinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Zirconium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Curium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Radium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Scandium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Rutherfordium.setProperty(PropertyKey.INGOT, new IngotProperty());

        //Fluid
        GTMaterials.Promethium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Californium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Fermium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Seaborgium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Meitnerium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Roentgenium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Thulium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Francium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Nobelium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Terbium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Sulfur.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Sodium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Rubidium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Copernicium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Mendelevium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Oganesson.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Bohrium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Hassium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Flerovium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Livermorium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Gadolinium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Dysprosium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Holmium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Erbium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Einsteinium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Berkelium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Neptunium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Tennessine.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Protactinium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Actinium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Zirconium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Curium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Radium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Scandium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Calcium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Boron.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Rutherfordium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));
        GTMaterials.Polonium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));

        //Pipe
        GTMaterials.Trinium.setProperty(PropertyKey.FLUID_PIPE, new FluidPipeProperties(6430, 320, true,false,false,false));
    }
}
