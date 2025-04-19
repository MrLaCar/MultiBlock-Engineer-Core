package com.mrlacar.multiblock_engineer.mbe.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.DustProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import java.util.Locale;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.EXPLOSIVE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.FLAMMABLE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.ELECTRIC_IMPLOSION_COMPRESSOR;

public class ElectricImplosionCompressorRecipeHandler {

    public static void init(Consumer<FinishedRecipe> provider) {
        dust.executeHandler(provider, PropertyKey.DUST, ElectricImplosionCompressorRecipeHandler::processDust);
    }


    public static void processDust(TagPrefix dustPrefix, Material mat, DustProperty property, Consumer<FinishedRecipe> provider) {
        String id = "%s_%s".formatted(FormattingUtil.toLowerCaseUnder(dustPrefix.name),
                mat.getName().toLowerCase(Locale.ROOT));
        ItemStack dustStack = ChemicalHelper.get(dustPrefix, mat);
        if (mat.hasProperty(PropertyKey.GEM)) {
            ItemStack gemStack = ChemicalHelper.get(gem, mat);

            if (!mat.hasFlag(EXPLOSIVE) && !mat.hasFlag(FLAMMABLE)) {
                ELECTRIC_IMPLOSION_COMPRESSOR.recipeBuilder("electric_implode_" + id)
                        .inputItems(GTUtil.copyAmount(4, dustStack))
                        .outputItems(GTUtil.copyAmount(3, gemStack))
                        .chancedOutput(dust, GTMaterials.DarkAsh, 2500, 0)
                        .save(provider);
            }
        }
    }
}
