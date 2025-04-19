package com.mrlacar.multiblock_engineer.mbe.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.OreProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.utils.GTUtil;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.LV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey.GEM;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.DistilledWater;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Stone;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.ORE_PROCESSOR;

public class OreProcessorRecipeHandler {

    public static void init(Consumer<FinishedRecipe> provider) {
        ore.executeHandler(provider, PropertyKey.ORE, OreProcessorRecipeHandler::Ore);
        rawOre.executeHandler(provider, PropertyKey.ORE, OreProcessorRecipeHandler::RawOre);
    }

    public static void Ore(TagPrefix orePrefix, Material material, OreProperty property, Consumer<FinishedRecipe> provider) {
        TagKey<Item> oreTypes = orePrefix.getItemTags(material) [0];
        Material BPMType0 = GTUtil.selectItemInList(0, material, property.getOreByProducts(), Material.class);
        Material BPMType1 = GTUtil.selectItemInList(1, material, property.getOreByProducts(), Material.class);
        Material WBPMType3 = GTUtil.selectItemInList(3, material, property.getOreByProducts(), Material.class);
        ItemStack BPSType1 = ChemicalHelper.get(dust, BPMType0);
        ItemStack BPSType2 = ChemicalHelper.get(dust, GTUtil.selectItemInList(2, material, property.getOreByProducts(), Material.class), property.getOreMultiplier() * 2);
        int NumCrushedOre = property.getOreMultiplier();
        int NumOutput = NumCrushedOre * 3;

        if (property.getWashedIn().getFirst() != null) {
            ORE_PROCESSOR.recipeBuilder(material.getName() + "_ore_process")
                    .inputItems(oreTypes)
                    .inputFluids(DistilledWater.getFluid(1000))
                    .outputItems(ChemicalHelper.get(dust, material, NumOutput))
                    .outputItems(dust, Stone, NumOutput)
                    .outputItems(ChemicalHelper.get(dust, WBPMType3, property.getByProductMultiplier() * NumOutput))
                    .outputItems(dust, BPMType1, NumOutput)
                    .outputItems(BPSType1)
                    .outputItems(BPSType2)
                    .duration((int) (material.getMass() * 3 * NumOutput))
                    .EUt(VA[LV])
                    .circuitMeta(1)
                    .save(provider);
        } else {
            ORE_PROCESSOR.recipeBuilder(material.getName() + "_ore_process")
                    .inputItems(oreTypes)
                    .inputFluids(DistilledWater.getFluid(1000))
                    .outputItems(dust, material, NumOutput)
                    .outputItems(dust, Stone, NumOutput)
                    .outputItems(BPSType1)
                    .outputItems(ChemicalHelper.get(dust, BPMType0, property.getByProductMultiplier() * NumOutput))
                    .duration((int) (material.getMass() * 3 * NumOutput))
                    .EUt(VA[LV])
                    .circuitMeta(1)
                    .save(provider);
        }

        if (BPMType0.hasProperty(PropertyKey.DUST)) {
            ORE_PROCESSOR.recipeBuilder("raw_" + material.getName() + "_ore_process")
                    .inputItems(orePrefix, material)
                    .inputFluids(DistilledWater.getFluid(1000))
                    .outputItems(dust, material, NumOutput)
                    .outputItems(BPSType1)
                    .outputItems(ChemicalHelper.get(dust, BPMType0, property.getByProductMultiplier() * NumOutput))
                    .outputItems(dust, BPMType0, NumCrushedOre)
                    .duration((int) (material.getMass() * 3 * NumOutput))
                    .EUt(VA[LV])
                    .circuitMeta(2)
                    .save(provider);
        } else {
            ORE_PROCESSOR.recipeBuilder("raw_" + material.getName() + "_ore_process")
                    .inputItems(orePrefix, material)
                    .inputFluids(DistilledWater.getFluid(1000))
                    .outputItems(dust, material, NumOutput)
                    .outputItems(BPSType1)
                    .outputItems(ChemicalHelper.get(dust, BPMType0, property.getByProductMultiplier() * NumOutput))
                    .duration((int) (material.getMass() * 3 * NumOutput))
                    .EUt(VA[LV])
                    .circuitMeta(2)
                    .save(provider);
        }

        if (material.hasProperty(GEM)) {
            ORE_PROCESSOR.recipeBuilder(material.getName() + "_gem_ore_process")
                    .inputItems(oreTypes)
                    .inputFluids(DistilledWater.getFluid(1000))
                    .outputItems(ChemicalHelper.get(dust, material, NumOutput))
                    .outputItems(dust, Stone, NumOutput)
                    .outputItems(BPSType1)
                    .outputItems(dust, BPMType0, NumOutput)
                    .outputItems(BPSType1)
                    .outputItems(BPSType1)
                    .outputItems(dust, BPMType1, NumOutput)
                    .outputItems(BPSType1)
                    .duration(16 * NumOutput)
                    .EUt(VA[LV])
                    .circuitMeta(3)
                    .save(provider);
        }
    }

    public static void RawOre(TagPrefix orePrefix, Material material, OreProperty property, Consumer<FinishedRecipe> provider) {
        TagKey<Item> oreTypes = orePrefix.getItemTags(material) [0];
        Material BPMType0 = GTUtil.selectItemInList(0, material, property.getOreByProducts(), Material.class);
        Material BPMType1 = GTUtil.selectItemInList(1, material, property.getOreByProducts(), Material.class);
        Material WBPMType3 = GTUtil.selectItemInList(3, material, property.getOreByProducts(), Material.class);
        ItemStack BPSType1 = ChemicalHelper.get(dust, BPMType0);
        ItemStack BPSType2 = ChemicalHelper.get(dust, GTUtil.selectItemInList(2, material, property.getOreByProducts(), Material.class), property.getOreMultiplier() * 2);
        int NumCrushedOre = property.getOreMultiplier();
        int NumOutput = NumCrushedOre * 3;

        if (BPMType0.hasProperty(PropertyKey.DUST)) {
            ORE_PROCESSOR.recipeBuilder("raw_" + material.getName() + "_ore_process")
                    .inputItems(orePrefix, material)
                    .inputFluids(DistilledWater.getFluid(1000))
                    .outputItems(dust, material, NumOutput)
                    .outputItems(BPSType1)
                    .outputItems(BPSType2)
                    .outputItems(ChemicalHelper.get(dust, BPMType0, property.getByProductMultiplier() * NumOutput))
                    .outputItems(dust, BPMType0, NumCrushedOre)
                    .duration((int) (material.getMass() * 3 * NumOutput))
                    .EUt(VA[LV])
                    .circuitMeta(4)
                    .save(provider);
        } else {
            ORE_PROCESSOR.recipeBuilder("raw_" + material.getName() + "_ore_process")
                    .inputItems(orePrefix, material)
                    .inputFluids(DistilledWater.getFluid(1000))
                    .outputItems(dust, material, NumOutput)
                    .outputItems(BPSType1)
                    .outputItems(BPSType2)
                    .outputItems(ChemicalHelper.get(dust, BPMType0, property.getByProductMultiplier() * NumOutput))
                    .duration((int) (material.getMass() * 3 * NumOutput))
                    .EUt(VA[LV])
                    .circuitMeta(4)
                    .save(provider);
        }

        if (property.getWashedIn().getFirst() != null) {
            ORE_PROCESSOR.recipeBuilder("raw_" + material.getName() + "_ore_process")
                    .inputItems(oreTypes)
                    .inputFluids(DistilledWater.getFluid(1000))
                    .outputItems(ChemicalHelper.get(dust, material, NumOutput))
                    .outputItems(ChemicalHelper.get(dust, WBPMType3, property.getByProductMultiplier() * NumOutput))
                    .outputItems(ChemicalHelper.get(dust, Stone, NumOutput))
                    .outputItems(TagPrefix.dust, BPMType1, NumOutput)
                    .outputItems(BPSType2)
                    .outputItems(BPSType1)
                    .duration((int) (material.getMass() * 3 * NumOutput))
                    .EUt(VA[LV])
                    .circuitMeta(4)
                    .save(provider);
        }
    }
}
