package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.cableGtSingle;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.plate;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.AlloyMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.EtherPolymer;

public class VanillaShapedCraftingRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("machine_casing_uev"), GTBlocks.MACHINE_CASING_UEV.asStack(),
                "AAA", "AwA", "AAA",
                'A', new UnificationEntry(plate, StructuralSteel800)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("machine_hull_uev"), GTMachines.HULL[UEV].asStack(),
                "   ", "ABA", "CDC",
                'A', new UnificationEntry(plate, EtherPolymer),
                'B', new UnificationEntry(plate, StructuralSteel800),
                'C', new UnificationEntry(cableGtSingle, Draconium),
                'D', GTBlocks.MACHINE_CASING_UEV
        );
        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("machine_casing_uiv"), GTBlocks.MACHINE_CASING_UIV.asStack(),
                "AAA", "AwA", "AAA",
                'A', new UnificationEntry(plate, Adamantium64RAlloy)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("machine_hull_uiv"), GTMachines.HULL[UIV].asStack(),
                "   ", "ABA", "CDC",
                'A', new UnificationEntry(plate, EtherPolymer),
                'B', new UnificationEntry(plate, Adamantium64RAlloy),
                'C', new UnificationEntry(cableGtSingle, Vibranium),
                'D', GTBlocks.MACHINE_CASING_UIV
        );
        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("machine_casing_uxv"), GTBlocks.MACHINE_CASING_UXV.asStack(),
                "AAA", "AwA", "AAA",
                'A', new UnificationEntry(plate, FragmentedDimension)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("machine_hull_uxv"), GTMachines.HULL[UXV].asStack(),
                "   ", "ABA", "CDC",
                'A', new UnificationEntry(plate, EtherPolymer),
                'B', new UnificationEntry(plate, FragmentedDimension),
                'C', new UnificationEntry(cableGtSingle, RedTungsten),
                'D', GTBlocks.MACHINE_CASING_UXV
        );
        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("machine_casing_opv"), GTBlocks.MACHINE_CASING_OpV.asStack(),
                "AAA", "AwA", "AAA",
                'A', new UnificationEntry(plate, Strangium)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("machine_hull_opv"), GTMachines.HULL[OpV].asStack(),
                "   ", "ABA", "CDC",
                'A', new UnificationEntry(plate, EtherPolymer),
                'B', new UnificationEntry(plate, Strangium),
                'C', new UnificationEntry(cableGtSingle, Dustosmos),
                'D', GTBlocks.MACHINE_CASING_OpV
        );
        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("machine_casing_max"), GTBlocks.MACHINE_CASING_MAX.asStack(),
                "AAA", "AwA", "AAA",
                'A', new UnificationEntry(plate, MultiverseHyperstableCompactMatter)
        );
    }
}
