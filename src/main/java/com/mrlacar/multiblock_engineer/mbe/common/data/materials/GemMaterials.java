package com.mrlacar.multiblock_engineer.mbe.common.data.materials;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Stone;

public class GemMaterials {

    public static Material WaterCrystal;
    public static Material FireCrystal;
    public static Material EarthCrystal;
    public static Material ThunderCrystal;
    public static Material Dilithium;

    public static void register() {
        WaterCrystal = new Material.Builder(GTCEu.id("water_crystal"))
                .gem()
                .color(0x004aff)
                .components(Stone, 1)
                .iconSet(MaterialIconSet.RUBY)
                .buildAndRegister();

        FireCrystal = new Material.Builder(GTCEu.id("fire_crystal"))
                .gem()
                .color(0xb01e00)
                .components(Stone, 1)
                .iconSet(MaterialIconSet.RUBY)
                .buildAndRegister();

        EarthCrystal = new Material.Builder(GTCEu.id("earth_crystal"))
                .gem()
                .color(0x250082)
                .components(Stone, 1)
                .iconSet(MaterialIconSet.RUBY)
                .buildAndRegister();

        ThunderCrystal = new Material.Builder(GTCEu.id("thunder_crystal"))
                .gem()
                .color(0xfff7a6)
                .components(Stone, 1)
                .iconSet(MaterialIconSet.RUBY)
                .buildAndRegister();

        Dilithium = new Material.Builder(GTCEu.id("dilithium"))
                .gem()
                .color(0x97ccd6)
                .components(Stone, 1)
                .iconSet(MaterialIconSet.QUARTZ)
                .buildAndRegister();
    }
}
