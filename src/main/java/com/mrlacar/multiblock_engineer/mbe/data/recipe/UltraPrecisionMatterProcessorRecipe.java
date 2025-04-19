package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.STEM_CELLS;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.STAR_CATALYST_UNIT;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.ULTRA_PRECISION_MATTER_PROCESSOR;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.CrystalMatrix;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.Draconium;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.ImpureUniversiumSolution;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.PurifiedUniversiumSolution;

public class UltraPrecisionMatterProcessorRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("purified_universium_solution_from_impure_universium_solution")
                .notConsumable(dust, Draconium)
                .chancedInput(STAR_CATALYST_UNIT.asStack(), 1000, 0)
                .inputFluids(ImpureUniversiumSolution.getFluid(10000))
                .outputFluids(PurifiedUniversiumSolution.getFluid(5000))
                .duration(200)
                .EUt(VA[UEV])
                .circuitMeta(8)
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("bastnasite")
                .inputItems(dust, Copper, 8)
                .inputItems(dust, Sodium, 16)
                .inputItems(dust, Saltpeter, 59)
                .inputItems(dust, Bastnasite, 64)
                .inputItems(dust, Sugar, 128)
                .inputItems(dust, Carbon, 192)
                .inputFluids(Nitrogen.getFluid(210000))
                .inputFluids(Chlorine.getFluid(260000))
                .inputFluids(Hydrogen.getFluid(768000))
                .outputItems(dust,Terbium, 3)
                .outputItems(dust,Gadolinium, 6)
                .outputItems(dust,Zirconium, 11)
                .outputItems(dust,Samarium, 11)
                .outputItems(dust,Holmium, 17)
                .outputItems(dust,Lanthanum, 26)
                .outputItems(dust,Neodymium, 42)
                .outputItems(dust,Cerium, 79)
                .outputItems(dust,Titanium, 163)
                .outputItems(dust,Silicon, 192)
                .outputFluids(Fluorine.getFluid(12000))
                .outputFluids(Oxygen.getFluid(150000))
                .duration(800)
                .EUt(VA[UHV])
                .circuitMeta(3)
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("ilmenite")
                .inputItems(dust, Ilmenite, 640)
                .chancedOutput(dust, Iron, 1280,1667, 0)
                .chancedOutput(dust, Titanium, 1280,1667, 0)
                .chancedOutput(dust, Niobium, 1280,1667, 0)
                .chancedOutput(dust, Tantalum, 1280,1667, 0)
                .chancedOutput(dust, Manganese, 1280,1667, 0)
                .chancedOutput(dust, Magnesium, 1280,1667, 0)
                .duration(800)
                .EUt(VA[UV])
                .circuitMeta(2)
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("rubber")
                .inputItems(dust, Carbon, 640)
                .inputFluids(Oxygen.getFluid(160000))
                .inputFluids(Hydrogen.getFluid(160000))
                .inputFluids(Chlorine.getFluid(160000))
                .outputFluids(SiliconeRubber.getFluid(L * 640))
                .outputFluids(StyreneButadieneRubber.getFluid(L * 640))
                .outputFluids(PolyphenyleneSulfide.getFluid(L * 1280))
                .outputFluids(Rubber.getFluid(L * 2560))
                .duration(4000)
                .EUt(VA[UV])
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("epoxy")
                .inputItems(dust, Carbon, 420)
                .inputFluids(Oxygen.getFluid(80000))
                .inputFluids(Hydrogen.getFluid(480000))
                .outputFluids(Epoxy.getFluid(20000))
                .duration(400)
                .EUt(VA[ZPM])
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("polytetrafluoroethylene")
                .inputItems(dust, Carbon, 360)
                .inputFluids(Fluorine.getFluid(720000))
                .inputFluids(Oxygen.getFluid(2500000))
                .outputFluids(Polytetrafluoroethylene.getFluid(720000))
                .duration(400)
                .EUt(VA[ZPM])
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("polybenzimidazole")
                .notConsumable(dust, PotassiumDichromate)
                .inputItems(dust, Copper, 16)
                .inputItems(dust, Zinc, 144)
                .inputItems(dust, Carbon, 152)
                .inputFluids(SulfuricAcid.getFluid(L * 1000))
                .inputFluids(Chlorobenzene.getFluid(L * 2000))
                .inputFluids(Nitrogen.getFluid(L * 4000))
                .inputFluids(Oxygen.getFluid(L * 14000))
                .inputFluids(Hydrogen.getFluid(L * 22000))
                .outputFluids(Polybenzimidazole.getFluid(L * 1500))
                .outputFluids(HydrochloricAcid.getFluid(L * 2000))
                .duration(400)
                .EUt(VA[UV])
                .circuitMeta(18)
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("phthalic_acid")
                .notConsumable(dust, PotassiumDichromate, 10)
                .inputItems(dust, Carbon, 80)
                .inputFluids(Hydrogen.getFluid(60000))
                .inputFluids(Chlorine.getFluid(60000))
                .outputFluids(PhthalicAcid.getFluid(10000))
                .duration(400)
                .EUt(VA[UV])
                .circuitMeta(6)
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("stemcells")
                .inputItems(dust, Calcium, 320)
                .inputItems(dust, Meat, 320)
                .inputItems(dust, Agar, 320)
                .chancedOutput(STEM_CELLS.asStack(5120),3000, 0)
                .outputFluids(RawGrowthMedium.getFluid(2560000))
                .outputFluids(SterileGrowthMedium.getFluid(1280000))
                .duration(2400)
                .EUt(VA[UIV])
                .addData("IFRTier", 2)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("iridium_metal_residue_dust")
                .inputItems(dust, IridiumMetalResidue, 320)
                .chancedOutput(dust, Iridium, 640,3333, 0)
                .chancedOutput(dust, Platinum, 640,3333, 0)
                .chancedOutput(dust, Osmiridium, 640,3333, 0)
                .duration(4000)
                .EUt(VA[UV])
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("lead_bauxite_tungstensteel")
                .inputItems(dust, Lead, 160)
                .inputItems(dust, Tungstate, 160)
                .inputItems(dust, Bauxite, 320)
                .chancedOutput(dust, Titanium, 640,2500, 0)
                .chancedOutput(dust, TungstenSteel, 640,2500, 0)
                .chancedOutput(dust, TungstenCarbide, 640,2500, 0)
                .chancedOutput(dust, Indium, 640,2500, 0)
                .duration(4000)
                .EUt(VA[UV])
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("scheelite_ilmenite_rutile")
                .inputItems(dust, Scheelite, 160)
                .inputItems(dust, Ilmenite, 160)
                .inputItems(dust, Rutile, 320)
                .chancedOutput(dust, Titanium, 640,2000, 0)
                .chancedOutput(dust, Tungsten, 640,2000, 0)
                .chancedOutput(dust, Tantalum, 640,2000, 0)
                .chancedOutput(dust, Indium, 640,2000, 0)
                .chancedOutput(dust, Niobium, 640,2000, 0)
                .duration(4000)
                .EUt(VA[UV])
                .addData("IFRTier", 1)
                .save(provider);
        ULTRA_PRECISION_MATTER_PROCESSOR.recipeBuilder("crystal_matrix")
                .inputItems(dust, Diamond, 32)
                .inputItems(dust, NetherStar, 16)
                .inputFluids(UUMatter.getFluid(2000))
                .outputFluids(CrystalMatrix.getFluid(864))
                .duration(2000)
                .EUt(GTValues.V[UEV])
                .addData("IFRTier", 1)
                .save(provider);
    }
}
