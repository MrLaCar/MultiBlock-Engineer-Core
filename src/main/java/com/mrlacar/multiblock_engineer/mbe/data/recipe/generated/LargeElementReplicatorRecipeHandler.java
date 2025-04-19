package com.mrlacar.multiblock_engineer.mbe.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTElements;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.LARGE_ELEMENT_REPLICATOR;

public class LargeElementReplicatorRecipeHandler {

    private final static List<Material> gas = List.of(
            Hydrogen,
            Deuterium,
            Tritium,
            Helium,
            Helium3,
            Nitrogen,
            Oxygen,
            Fluorine,
            Neon,
            Chlorine,
            Argon,
            Krypton,
            Xenon,
            Radon);
    private final static List<Material> metal = List.of(
            Lithium,
            Beryllium,
            Sodium,
            Magnesium,
            Aluminium,
            Potassium,
            Calcium,
            Titanium,
            Vanadium,
            Chromium,
            Manganese,
            Iron,
            Cobalt,
            Nickel,
            Copper,
            Zinc,
            Gallium,
            Yttrium,
            Zirconium,
            Niobium,
            Molybdenum,
            Ruthenium,
            Rhodium,
            Palladium,
            Silver,
            Cadmium,
            Indium,
            Tin,
            Antimony,
            Caesium,
            Barium,
            Lanthanum,
            Cerium,
            Promethium,
            Europium,
            Gadolinium,
            Terbium,
            Dysprosium,
            Holmium,
            Erbium,
            Thulium,
            Lutetium,
            Tantalum,
            Tungsten,
            Osmium,
            Iridium,
            Platinum,
            Gold,
            Lead,
            Francium,
            Actinium,
            Protactinium,
            Uranium235,
            Uranium238,
            Neptunium,
            Plutonium239,
            Plutonium241,
            Americium,
            Curium,
            Berkelium,
            Californium,
            Einsteinium,
            Fermium,
            Mendelevium,
            Nobelium,
            Seaborgium,
            Bohrium,
            Hassium,
            Meitnerium,
            Darmstadtium,
            Roentgenium,
            Copernicium,
            Flerovium,
            Livermorium,
            Tritanium,
            Duranium,
            Trinium,
            Naquadah,
            NaquadahEnriched,
            Naquadria);

    public static void init(Consumer<FinishedRecipe> provider) {

        for (Material type : gas) {
            Element element = Objects.requireNonNullElse(type.getElement(), GTElements.Nt);
            long mass = element.mass();
            LARGE_ELEMENT_REPLICATOR.recipeBuilder(type.getName())
                    .notConsumableFluid(type.getFluid(1000))
                    .inputFluids(UUMatter.getFluid((int) (mass * 2)))
                    .outputFluids(type.getFluid(1000))
                    .duration((int) (mass > 10 ? mass : mass * 5))
                    .EUt(VA[UV])
                    .save(provider);
        }
        for (Material type : metal) {
            Element element = Objects.requireNonNullElse(type.getElement(), GTElements.Nt);
            long mass = element.mass();
            LARGE_ELEMENT_REPLICATOR.recipeBuilder(type.getName())
                    .notConsumable(dust, type)
                    .inputFluids(UUMatter.getFluid((int) (mass * 3)))
                    .outputItems(dust, type)
                    .duration((int) (mass > 10 ? mass : mass * 10))
                    .EUt(VA[UV])
                    .save(provider);
        }
    }
}
