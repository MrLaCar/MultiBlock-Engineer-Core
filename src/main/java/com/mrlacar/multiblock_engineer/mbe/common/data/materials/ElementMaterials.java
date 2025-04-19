package com.mrlacar.multiblock_engineer.mbe.common.data.materials;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.mrlacar.multiblock_engineer.mbe.common.data.MBEElements;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.STD_METAL;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEMaterialIconSets.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEMaterialFlags.GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL;

public class ElementMaterials {

    public static Material Tephilorium;
    public static Material Plonurium;
    public static Material Olancadium;
    public static Material Racontrimium;
    public static Material B47;
    public static Material Universium;
    public static Material Draconium;
    public static Material AwakenedDraconium;
    public static Material Desh;
    public static Material Ostrum;
    public static Material Calorite;
    public static Material Omterium;
    public static Material HadesSteel;
    public static Material Vibranium;
    public static Material Astritanium;
    public static Material Quantonium;
    public static Material FragmentedDimension;
    public static Material TalliM;
    public static Material Infinity;
    public static Material PrimitiveInfinity;
    public static Material Strangium;
    public static Material QuasarMatter;
    public static Material PrimarySubstance;
    public static Material Calculasium;
    public static Material Bedrockium;
    public static Material Kobosium;
    public static Material StarlightIridium;
    public static Material Singularium;
    public static Material Dustosmos;
    public static Material MetastableOganesson;
    public static Material MetastableHassium;
    public static Material Titanium50;
    public static Material CrystalMatrix;
    public static Material MultiverseHyperstableCompactMatter;
    public static Material SpaceTime;
    public static Material PolyhedralSteel;

    public static void register() {
        Tephilorium = new Material.Builder(GTCEu.id("tephilorium"))
                .ingot()
                .ore()
                .color(0x335344)
                .blastTemp(8670, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.ZPM], 400)
                .element(MBEElements.Tephilorium)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL)
                .buildAndRegister();
        Plonurium = new Material.Builder(GTCEu.id("plonurium"))
                .ingot()
                .ore()
                .color(0x81870c)
                .blastTemp(8900, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.ZPM], 500)
                .element(MBEElements.Plonurium)
                .iconSet(SHINY)
                .appendFlags(STD_METAL)
                .buildAndRegister();
        Olancadium = new Material.Builder(GTCEu.id("olancadium"))
                .ingot()
                .ore()
                .color(0x604e95)
                .blastTemp(9400, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.UV], 600)
                .element(MBEElements.Olancadium)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL)
                .buildAndRegister();
        Racontrimium = new Material.Builder(GTCEu.id("racontrimium"))
                .ingot()
                .ore()
                .color(0x555555)
                .blastTemp(9600, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.ZPM], 640)
                .element(MBEElements.Racontrimium)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL)
                .buildAndRegister();
        B47 = new Material.Builder(GTCEu.id("b_47"))
                .ingot()
                .ore()
                .color(0x770b11)
                .blastTemp(10500, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.ZPM], 800)
                .element(MBEElements.B47)
                .iconSet(SHINY)
                .appendFlags(STD_METAL)
                .buildAndRegister();
        Universium = new Material.Builder(GTCEu.id("universium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(35450))
                .color(0x2a2c2b)
                .blastTemp(13500, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UIV], 840)
                .element(MBEElements.Universium)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FOIL, GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL)
                .radioactiveHazard(20)
                .buildAndRegister();
        Draconium = new Material.Builder(GTCEu.id("draconium"))
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(2372))
                .color(0x4c0e80)
                .blastTemp(11432, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 750)
                .element(MBEElements.Draconium)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_DENSE, GENERATE_FOIL)
                .cableProperties(GTValues.V[GTValues.UEV], 4, 16, false)
                .buildAndRegister();
        AwakenedDraconium = new Material.Builder(GTCEu.id("awakened_draconium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(26674))
                .color(0xff7200)
                .element(MBEElements.Awakened_Draconium)
                .iconSet(SHINY)
                .appendFlags(STD_METAL,GENERATE_FRAME, GENERATE_FOIL)
                .radioactiveHazard(32)
                .buildAndRegister();
        Desh = new Material.Builder(GTCEu.id("desh"))
                .ingot()
                .ore()
                .color(0xe87a40)
                .element(MBEElements.Desh)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_DENSE)
                .buildAndRegister();
        Ostrum = new Material.Builder(GTCEu.id("ostrum"))
                .ingot()
                .color(0xa86c73)
                .element(MBEElements.Ostrum)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_DENSE)
                .buildAndRegister();
        Calorite = new Material.Builder(GTCEu.id("calorite"))
                .ingot()
                .color(0xb83145)
                .element(MBEElements.Calorite)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_DENSE)
                .buildAndRegister();
        Omterium = new Material.Builder(GTCEu.id("omterium"))
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(18988))
                .color(0x22483e)
                .blastTemp(9986, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 600)
                .element(MBEElements.Omterium)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_DENSE)
                .cableProperties(GTValues.V[GTValues.UEV], 2, 4, false)
                .buildAndRegister();
        HadesSteel = new Material.Builder(GTCEu.id("hades_steel"))
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(1744))
                .color(0x141414)
                .element(MBEElements.Hades_Steel)
                .iconSet(SHINY)
                .appendFlags(STD_METAL)
                .cableProperties(GTValues.V[GTValues.UEV], 6, 2, false)
                .buildAndRegister();
        Vibranium = new Material.Builder(GTCEu.id("vibranium"))
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(30025))
                .color(0xba004f)
                .element(MBEElements.Vibranium)
                .iconSet(BRIGHT)
                .flags(GENERATE_FINE_WIRE, GENERATE_FOIL)
                .cableProperties(GTValues.V[GTValues.UIV], 4, 12, false)
                .radioactiveHazard(13)
                .buildAndRegister();
        Astritanium = new Material.Builder(GTCEu.id("astritanium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(33447))
                .color(0x5b0617)
                .element(MBEElements.Astritanium)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FOIL)
                .radioactiveHazard(28)
                .buildAndRegister();
        Quantonium = new Material.Builder(GTCEu.id("quantonium"))
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(27722))
                .color(0x004676)
                .blastTemp(14210, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UXV], 600)
                .element(MBEElements.Quantonium)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME)
                .buildAndRegister();
        FragmentedDimension = new Material.Builder(GTCEu.id("fragmented_dimension"))
                .ingot()
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill().temperature(875600000))
                .color(0x752331)
                .element(MBEElements.Fragmented_Dimension)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FOIL, GENERATE_BOLT_SCREW, GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL)
                .buildAndRegister();
        TalliM = new Material.Builder(GTCEu.id("talli_m"))
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(57763))
                .color(0x19145f)
                .element(MBEElements.Talli_M)
                .iconSet(METALLIC)
                .radioactiveHazard(30)
                .buildAndRegister();
        Infinity = new Material.Builder(GTCEu.id("infinity"))
                .ingot()
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill().temperature(3879023))
                .element(MBEElements.Infinity)
                .iconSet(INFINITY)
                .appendFlags(STD_METAL, GENERATE_FRAME)
                .cableProperties(GTValues.V[GTValues.MAX], 32768, 0, true)
                .radioactiveHazard(24)
                .buildAndRegister();
        PrimitiveInfinity = new Material.Builder(GTCEu.id("primitive_infinity"))
                .ore()
                .color(0xbdbdbd)
                .element(MBEElements.PrimitiveInfinity)
                .iconSet(BRIGHT)
                .buildAndRegister();
        Strangium = new Material.Builder(GTCEu.id("strangium"))
                .ingot()
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill().temperature(5764800))
                .element(MBEElements.Strangium)
                .iconSet(STRANGIUM)
                .appendFlags(STD_METAL, GENERATE_FRAME)
                .radioactiveHazard(70)
                .buildAndRegister();
        QuasarMatter = new Material.Builder(GTCEu.id("quasar_matter"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill().temperature(962374298))
                .element(MBEElements.Quasar_Matter)
                .radioactiveHazard(700)
                .buildAndRegister();
        PrimarySubstance = new Material.Builder(GTCEu.id("primary_substance"))
                .ingot()
                .element(MBEElements.Primary_Substance)
                .iconSet(PRIMARY_SUBSTANCE)
                .flags(GENERATE_FRAME)
                .cableProperties(GTValues.V[GTValues.MAX], 983040, 0, true)
                .radioactiveHazard(1200)
                .buildAndRegister();
        Calculasium = new Material.Builder(GTCEu.id("calculasium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(548976))
                .color(0x319d65)
                .element(MBEElements.Calculasium)
                .iconSet(BRIGHT)
                .buildAndRegister();
        Bedrockium = new Material.Builder(GTCEu.id("bedrockium"))
                .ingot()
                .color(0x333333)
                .element(MBEElements.Bedrockium)
                .iconSet(BRIGHT)
                .buildAndRegister();
        Kobosium = new Material.Builder(GTCEu.id("kobosium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(6343000))
                .color(0x589351)
                .element(MBEElements.Kobosium)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND, GENERATE_RING, GENERATE_ROTOR, GENERATE_BOLT_SCREW)
                .fluidPipeProperties(13740, 8200, true, true, true, true)
                .buildAndRegister();
        StarlightIridium = new Material.Builder(GTCEu.id("starlight_iridium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(7845748))
                .color(0x941e84)
                .secondaryColor(0xff7fed)
                .element(MBEElements.Starlight_Iridium)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND, GENERATE_RING, GENERATE_ROTOR, GENERATE_BOLT_SCREW)
                .fluidPipeProperties(14440, 8660, true, true, true, true)
                .buildAndRegister();
        Singularium = new Material.Builder(GTCEu.id("singularium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(14))
                .secondaryColor(0x8b8b8b)
                .element(MBEElements.Singularium)
                .iconSet(SINGULARIUM)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND, GENERATE_RING, GENERATE_ROTOR, GENERATE_BOLT_SCREW, GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL)
                .fluidPipeProperties(16780, 10340, true, true, true, true)
                .buildAndRegister();
        Dustosmos = new Material.Builder(GTCEu.id("dustosmos"))
                .ingot()
                .liquid()
                .color(0x5a00bc)
                .element(MBEElements.Dustosmos)
                .iconSet(RADIOACTIVE)
                .cableProperties(GTValues.V[GTValues.OpV], 3, 6, false)
                .buildAndRegister();
        MetastableOganesson = new Material.Builder(GTCEu.id("metastable_oganesson"))
                .ingot()
                .liquid()
                .color(0x211583)
                .element(MBEElements.Metastable_Oganesson)
                .iconSet(RADIOACTIVE)
                .appendFlags(STD_METAL, GENERATE_FOIL, GENERATE_BOLT_SCREW)
                .buildAndRegister();
        MetastableHassium = new Material.Builder(GTCEu.id("metastable_hassium"))
                .ingot()
                .liquid()
                .color(0x424d4d)
                .secondaryColor(0x51e0b6)
                .element(MBEElements.Metastable_Hassium)
                .iconSet(RADIOACTIVE)
                .buildAndRegister();
        Titanium50 = new Material.Builder(GTCEu.id("titanium_50"))
                .ingot()
                .liquid()
                .color(0xeda4de)
                .secondaryColor(0xdea7cc)
                .element(MBEElements.Titanium50)
                .iconSet(BRIGHT)
                .buildAndRegister();
        CrystalMatrix = new Material.Builder(GTCEu.id("crystal_matrix"))
                .ingot()
                .liquid()
                .color(0x7ef1e9)
                .element(MBEElements.CrystalMatrix)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD)
                .buildAndRegister();
        MultiverseHyperstableCompactMatter = new Material.Builder(GTCEu.id("multiverse_hyperstable_compact_matter"))
                .ingot()
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill())
                .color(0x40374f)
                .element(MBEElements.MultiverseHyperstableCompactMatter)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD)
                .buildAndRegister();
        SpaceTime = new Material.Builder(GTCEu.id("spacetime"))
                .ingot()
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill().temperature(0))
                .iconSet(SPACETIME)
                .appendFlags(STD_METAL, GENERATE_FOIL, GENERATE_FRAME)
                .buildAndRegister();
        TagPrefix.plateDouble.setIgnored(SpaceTime);
        PolyhedralSteel = new Material.Builder(GTCEu.id("polyhedral_steel"))
                .ingot()
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill())
                .color(0x555555)
                .element(MBEElements.MultiverseHyperstableCompactMatter)
                .iconSet(POLYHEDRAL_STEEL)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FRAME)
                .buildAndRegister();
    }
}
