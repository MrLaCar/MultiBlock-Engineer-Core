package com.mrlacar.multiblock_engineer.mbe.common.data.materials;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.mrlacar.multiblock_engineer.mbe.common.data.MBEElements;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.GemMaterials.*;

public class AlloyMaterials {

    public static Material EnergeticAlloy;
    public static Material ConductiveAlloy;
    public static Material PulsatingAlloy;
    public static Material EndSteel;
    public static Material Signalum;
    public static Material Enderium;
    public static Material AtomicAlloy;
    public static Material StellarAlloy;
    public static Material XK3700TAlloy;
    public static Material StructuralSteel800;
    public static Material HastelloyP82;
    public static Material Hastelloy633C;
    public static Material VF9200GSAlloy;
    public static Material CosmicNeutronium;
    public static Material ComplexDeepSpaceAlloy;
    public static Material StructuralSteel5297;
    public static Material TwilightLifeAlloy;
    public static Material XK580RAlloy;
    public static Material VibraniumTitaniumAlloy;
    public static Material QuantumAlloy;
    public static Material TranscendentAlloy;
    public static Material ADVCAlloy;
    public static Material SupercriticalDimension;
    public static Material TalliMStrangium;
    public static Material UltimateAlloy;
    public static Material VF722PBAlloy;
    public static Material AlphaHeavyBedrockiumAlloy;
    public static Material CosmicDarkAlloy;
    public static Material VF3462CYAlloy;
    public static Material HastelloyN90;
    public static Material HSST;
    public static Material HSSZH;
    public static Material Gaphilum;
    public static Material DeltaLightBedrockiumAlloy;
    public static Material MolecularAlloy;
    public static Material CalculasiumMolecularAlloy;
    public static Material AdamantiumX50Alloy;
    public static Material Versyton;
    public static Material NeutroniumMagnetic;
    public static Material Adamantium64RAlloy;
    public static Material RedTungsten;
    public static Material MetastableRadiumRutheniumTitaniumSemiNanoAlloy;
    public static Material EchoAlloy;
    public static Material Indalloy140;
    public static Material AstralAlloy;
    public static Material HeavyElementAlloy;

    public static void register() {
        ConductiveAlloy = new Material.Builder(GTCEu.id("conductive_alloy"))
                .ingot()
                .liquid()
                .components(Silicon, 4, Copper, 6, Iron, 3, Redstone, 5, Magnesium, 4)
                .blastTemp(4320, BlastProperty.GasTier.MID, GTValues.VA[GTValues.LV], 660)
                .color(0xd7a6bd)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE)
                .buildAndRegister();
        EnergeticAlloy = new Material.Builder(GTCEu.id("energetic_alloy"))
                .ingot()
                .liquid()
                .components(Redstone, 3, Gold, 5, Potassium, 4, ConductiveAlloy, 6)
                .blastTemp(3800, BlastProperty.GasTier.LOW, GTValues.VA[GTValues.LV], 600)
                .color(0xd89e19)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE)
                .buildAndRegister();
        PulsatingAlloy = new Material.Builder(GTCEu.id("pulsating_alloy"))
                .ingot()
                .liquid()
                .components(Iron, 5, EnderPearl, 3, Silicon, 5, Manganese, 5, Chromium, 4, EnergeticAlloy, 5)
                .blastTemp(5673, BlastProperty.GasTier.MID, GTValues.VA[GTValues.MV], 830)
                .color(0x57e581)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE)
                .buildAndRegister();
        EndSteel = new Material.Builder(GTCEu.id("end_steel"))
                .ingot()
                .liquid()
                .components(Steel, 7, EnderPearl, 5, Cobalt, 4, Rubidium, 6)
                .blastTemp(4780, BlastProperty.GasTier.MID, GTValues.VA[GTValues.MV], 770)
                .color(0xd4d394)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE)
                .buildAndRegister();
        Signalum = new Material.Builder(GTCEu.id("signalum"))
                .ingot()
                .liquid()
                .components(Redstone, 7, Steel, 5, Silver, 4, Copper, 6, Naquadah, 5)
                .blastTemp(5665, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.MV], 960)
                .color(0xe24200)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE)
                .buildAndRegister();
        Enderium = new Material.Builder(GTCEu.id("enderium"))
                .ingot()
                .liquid()
                .components(EndSteel, 6, Iridium, 7, Cobalt, 5, Trinium, 4)
                .blastTemp(6120, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.HV], 1020)
                .color(0x00586f)
                .secondaryColor(0x241a44)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE)
                .buildAndRegister();
        AtomicAlloy = new Material.Builder(GTCEu.id("atomic_alloy"))
                .ingot()
                .liquid()
                .components(GTMaterials.Carbon, 8, NaquadahAlloy, 4)
                .blastTemp(7283, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.ZPM], 1200)
                .color(0x281832)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_DENSE)
                .radioactiveHazard(10)
                .buildAndRegister();
        StellarAlloy = new Material.Builder(GTCEu.id("stellar_alloy"))
                .ingot()
                .liquid()
                .components(Tephilorium, 6, Plonurium, 4, Olancadium, 7, Racontrimium, 3, B47, 4, Desh, 6, Ostrum, 8, Calorite, 4)
                .blastTemp(10230, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.LuV], 1270)
                .color(0x6a0041)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE, GENERATE_DENSE)
                .cableProperties(GTValues.V[GTValues.UHV], 4, 8, false)
                .radioactiveHazard(15)
                .buildAndRegister();
        XK3700TAlloy = new Material.Builder(GTCEu.id("xk_3700_t_alloy"))
                .ingot()
                .liquid()
                .components(StellarAlloy, 6, Neutronium, 4)
                .blastTemp(11347, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UV], 1340)
                .color(0x8ee3d5)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_BOLT_SCREW)
                .radioactiveHazard(20)
                .buildAndRegister();
        StructuralSteel800 = new Material.Builder(GTCEu.id("structural_steel_800"))
                .ingot()
                .liquid()
                .components(XK3700TAlloy, 6, Plutonium239, 4, Steel, 5)
                .blastTemp(11800, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV], 1500)
                .color(0x338d71)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_BOLT_SCREW)
                .radioactiveHazard(20)
                .buildAndRegister();
        HastelloyP82 = new Material.Builder(GTCEu.id("hastelloy_p_82"))
                .ingot()
                .liquid()
                .components(Rhodium, 8, Indium, 6, Titanium, 5, Chromium, 4, Silicon, 6, Niobium, 6, Osmium, 6)
                .blastTemp(10453, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.LuV], 1380)
                .color(0xb84cd4)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL)
                .buildAndRegister();
        Hastelloy633C = new Material.Builder(GTCEu.id("hastelloy_633_c"))
                .ingot()
                .liquid()
                .components(Uranium238, 5, Trinium, 4, Tritanium, 3, Tephilorium, 8, Tungsten, 6, Tantalum, 4)
                .blastTemp(12455, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UV], 1660)
                .color(0x062d2d)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL, GENERATE_FRAME)
                .buildAndRegister();
        VF9200GSAlloy = new Material.Builder(GTCEu.id("vf_9200_gs_alloy"))
                .ingot()
                .liquid()
                .components(Uranium235, 5, Tritanium, 4, UraniumRhodiumDinaquadide, 3, Thorium, 4, Curium, 3)
                .blastTemp(10444, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.UV], 1440)
                .color(0x3a272c)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_FRAME)
                .buildAndRegister();
        CosmicNeutronium = new Material.Builder(GTCEu.id("cosmic_neutronium"))
                .ingot()
                .liquid()
                .components(Neutronium, 8, Universium, 5)
                .color(0x323232)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FOIL, GENERATE_BOLT_SCREW, DISABLE_DECOMPOSITION)
                .radioactiveHazard(45)
                .buildAndRegister();
        ComplexDeepSpaceAlloy = new Material.Builder(GTCEu.id("complex_deep_space_alloy"))
                .ingot()
                .liquid()
                .components(Vibranium, 4, CosmicNeutronium, 6, HadesSteel, 10)
                .color(0x0b0b0b)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL, GENERATE_FRAME, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UIV], 2, 4, false)
                .buildAndRegister();
        StructuralSteel5297 = new Material.Builder(GTCEu.id("structural_steel_5297"))
                .ingot()
                .liquid()
                .components(Vibranium, 6, HadesSteel, 4, Steel, 24, AwakenedDraconium, 8)
                .color(0x232232)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UIV], 4, 16, false)
                .radioactiveHazard(30)
                .buildAndRegister();
        TwilightLifeAlloy = new Material.Builder(GTCEu.id("twilight_life_alloy"))
                .ingot()
                .liquid()
                .components(WaterCrystal, 4, FireCrystal, 5, EarthCrystal, 3, ThunderCrystal, 6, Cobalt, 8, Tritanium, 12)
                .blastTemp(8972, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.LuV], 1330)
                .color(0x008842)
                .secondaryColor(0x002615)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .buildAndRegister();
        XK580RAlloy = new Material.Builder(GTCEu.id("xk_580_r_alloy"))
                .ingot()
                .liquid()
                .components(Draconium, 12, HastelloyP82, 4, HSSS, 10, Neutronium, 6)
                .color(0x791a95)
                .secondaryColor(0x2e002a)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .radioactiveHazard(14)
                .buildAndRegister();
        VibraniumTitaniumAlloy = new Material.Builder(GTCEu.id("vibranium_titanium_alloy"))
                .ingot()
                .liquid()
                .components(Vibranium, 12, Titanium, 24)
                .color(0xba004f)
                .secondaryColor(0x76053e)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .radioactiveHazard(13)
                .buildAndRegister();
        QuantumAlloy = new Material.Builder(GTCEu.id("quantum_alloy"))
                .ingot()
                .liquid()
                .components(Quantonium, 6, CosmicNeutronium, 6, Tritanium, 12, Darmstadtium, 4, Niobium, 5, Trinium, 6, Einsteinium, 8, Radium, 4)
                .color(0x002448)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UXV], 3, 9, false)
                .radioactiveHazard(38)
                .buildAndRegister();
        TranscendentAlloy = new Material.Builder(GTCEu.id("transcendent_alloy"))
                .ingot()
                .liquid()
                .components(Terbium, 6, Infinity, 3, Steel, 10, UraniumRhodiumDinaquadide, 5, Osmiridium, 4)
                .blastTemp(12383, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 3200)
                .color(0x84265a)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UEV], 32, 0, true)
                .radioactiveHazard(34)
                .buildAndRegister();
        ADVCAlloy = new Material.Builder(GTCEu.id("advc_alloy"))
                .ingot()
                .liquid()
                .components(AwakenedDraconium, 4, Vibranium, 6, CosmicNeutronium, 5)
                .color(0x924300)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UIV], 48, 0, true)
                .radioactiveHazard(28)
                .buildAndRegister();
        SupercriticalDimension = new Material.Builder(GTCEu.id("supercritical_dimension"))
                .ingot()
                .liquid()
                .color(0xd14967)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UXV], 96, 0, true)
                .buildAndRegister();
        TalliMStrangium = new Material.Builder(GTCEu.id("talli_m_strangium"))
                .ingot()
                .liquid()
                .components(TalliM, 7, Strangium, 6)
                .color(0x3c3869)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.OpV], 128, 0, true)
                .radioactiveHazard(107)
                .buildAndRegister();
        UltimateAlloy = new Material.Builder(GTCEu.id("ultimate_alloy"))
                .ingot()
                .liquid()
                .components(StellarAlloy, 3, Seaborgium, 6, Neptunium, 3 , Radon, 1)
                .blastTemp(9887, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UV], 1200)
                .color(0x561b41)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND, GENERATE_RING, GENERATE_ROTOR, GENERATE_BOLT_SCREW, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UHV], 2, 8, false)
                .fluidPipeProperties(9755, 3400, true, true, true, true)
                .radioactiveHazard(45)
                .buildAndRegister();
        VF722PBAlloy = new Material.Builder(GTCEu.id("vf_722_pb_alloy"))
                .ingot()
                .liquid()
                .components(Seaborgium, 3, Fermium, 4, Omterium, 2 , Tungsten, 12, Neutronium, 2)
                .blastTemp(10300, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UV], 1720)
                .color(0x001c89)
                .secondaryColor(0x009f89)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND, GENERATE_RING, GENERATE_ROTOR, GENERATE_BOLT_SCREW, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UEV], 3, 6, false)
                .fluidPipeProperties(10456, 6000, true, true, true, true)
                .radioactiveHazard(52)
                .buildAndRegister();
        AlphaHeavyBedrockiumAlloy = new Material.Builder(GTCEu.id("alpha_heavy_bedrockium_alloy"))
                .ingot()
                .liquid()
                .components(Oganesson, 6, Tennessine, 4, Einsteinium, 2 , Universium, 4, Bedrockium, 8, Flerovium, 3)
                .color(0xe2980e)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND, GENERATE_RING, GENERATE_ROTOR, GENERATE_BOLT_SCREW, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UEV], 3, 6, false)
                .fluidPipeProperties(12220, 7610, true, true, true, true)
                .radioactiveHazard(123)
                .buildAndRegister();
        CosmicDarkAlloy = new Material.Builder(GTCEu.id("cosmic_dark_alloy"))
                .ingot()
                .liquid()
                .components(MetastableOganesson, 7, Meitnerium, 2, CosmicNeutronium, 6 , QuantumAlloy, 3, TalliM, 8)
                .color(0x1e2922)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.OpV], 1, 4, false)
                .radioactiveHazard(90)
                .buildAndRegister();
        VF3462CYAlloy = new Material.Builder(GTCEu.id("vf_3462_cy_alloy"))
                .ingot()
                .liquid()
                .components(VF9200GSAlloy, 5, HSSS, 7, Naquadria, 6 , Infinity, 3)
                .color(0x6d2c00)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_FRAME, DISABLE_DECOMPOSITION)
                .fluidPipeProperties(10800, 7230, true, true, true, true)
                .radioactiveHazard(88)
                .buildAndRegister();
        HastelloyN90 = new Material.Builder(GTCEu.id("hastelloy_n_90"))
                .ingot()
                .liquid()
                .components(Hastelloy633C, 5, CosmicNeutronium, 7, Draconium, 6 , Racontrimium, 3, Ostrum, 5, FragmentedDimension, 2)
                .color(0x548c7f)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .radioactiveHazard(76)
                .buildAndRegister();
        HSST = new Material.Builder(GTCEu.id("hsst"))
                .ingot()
                .liquid()
                .components(HSSS, 12, Neutronium, 4, B47, 6, HadesSteel, 4, Holmium, 6)
                .blastTemp(11898, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV], 570)
                .color(0x280c40)
                .iconSet(SHINY)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .radioactiveHazard(43)
                .buildAndRegister();
        HSSZH = new Material.Builder(GTCEu.id("hsszh"))
                .ingot()
                .liquid()
                .components(HSST, 10, Infinity, 4)
                .color(0x2e333d)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, DISABLE_DECOMPOSITION)
                .radioactiveHazard(60)
                .buildAndRegister();
        Gaphilum = new Material.Builder(GTCEu.id("gaphilum"))
                .ingot()
                .liquid()
                .components(Enderium, 8, Tephilorium, 4, Trinium, 6, Krypton, 2, Niobium, 3, Californium, 5, Berkelium, 4)
                .blastTemp(10020, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.ZPM], 1400)
                .color(0x4b1739)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .radioactiveHazard(38)
                .buildAndRegister();
        DeltaLightBedrockiumAlloy = new Material.Builder(GTCEu.id("delta_light_bedrockium_alloy"))
                .ingot()
                .liquid()
                .components(Mendelevium, 4, Darmstadtium, 5, Yttrium, 6, Radon, 3, Vibranium, 4, Bedrockium, 6, Holmium, 5)
                .color(0xe24a0d)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UXV], 4, 8, false)
                .radioactiveHazard(65)
                .buildAndRegister();
        MolecularAlloy = new Material.Builder(GTCEu.id("molecular_alloy"))
                .ingot()
                .liquid()
                .components(AtomicAlloy, 8, Draconium, 6, Niobium, 6, Olancadium, 5, Actinium, 6)
                .color(0x121f94)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, DISABLE_DECOMPOSITION)
                .radioactiveHazard(40)
                .buildAndRegister();
        CalculasiumMolecularAlloy = new Material.Builder(GTCEu.id("calculasium_molecular_alloy"))
                .ingot()
                .liquid()
                .components(Calculasium, 8, MolecularAlloy, 6)
                .color(0x2c8f8f)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, DISABLE_DECOMPOSITION, GENERATE_FOIL)
                .cableProperties(GTValues.V[GTValues.UIV], 2, 6, false)
                .radioactiveHazard(57)
                .buildAndRegister();
        AdamantiumX50Alloy = new Material.Builder(GTCEu.id("adamantium_x_50_alloy"))
                .ingot()
                .liquid()
                .components(Vibranium, 6, Calorite, 7, Bedrockium, 4, Infinity, 3)
                .color(0x868686)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
                .buildAndRegister();
        Versyton = new Material.Builder(GTCEu.id("versyton"))
                .ingot()
                .liquid()
                .components(AwakenedDraconium, 8, Strangium, 5, Osmiridium, 12, Infinity, 8, Gadolinium, 6, Protactinium, 8)
                .color(0xec556e)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_ROD, GENERATE_FINE_WIRE, GENERATE_FOIL, DISABLE_DECOMPOSITION)
                .buildAndRegister();
        NeutroniumMagnetic = new Material.Builder(GTCEu.id("magnetic_neutronium"))
                .ingot()
                .color(0xFFFFFF)
                .secondaryColor(0x000000)
                .iconSet(MAGNETIC)
                .flags(GENERATE_LONG_ROD, IS_MAGNETIC)
                .components(Neutronium, 1)
                .ingotSmeltInto(Neutronium)
                .arcSmeltInto(Neutronium)
                .macerateInto(Neutronium)
                .buildAndRegister();
        Adamantium64RAlloy = new Material.Builder(GTCEu.id("adamantium_64_r_alloy"))
                .ingot()
                .liquid()
                .components(Neutronium, 4, Einsteinium, 6, Radon, 4, Dysprosium, 8, Universium, 12)
                .color(0xefbe35)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_BOLT_SCREW, DISABLE_DECOMPOSITION)
                .buildAndRegister();
        RedTungsten = new Material.Builder(GTCEu.id("redtungsten"))
                .ingot()
                .liquid()
                .components(Tungsten, 24, Tritanium, 6, Plutonium241, 6, B47, 12, Californium, 5, Calorite, 8, FragmentedDimension, 4)
                .color(0x5a0004)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL, GENERATE_FRAME, DISABLE_DECOMPOSITION)
                .cableProperties(GTValues.V[GTValues.UXV], 2, 4, false)
                .radioactiveHazard(80)
                .buildAndRegister();
        MetastableRadiumRutheniumTitaniumSemiNanoAlloy = new Material.Builder(GTCEu.id("metastable_radium_ruthenium_titanium_semi_nano_alloy"))
                .ingot()
                .liquid()
                .components(Radium, 8, Ruthenium, 5, Titanium50, 6)
                .color(0x57485e)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, DISABLE_DECOMPOSITION)
                .buildAndRegister();
        EchoAlloy = new Material.Builder(GTCEu.id("echo_alloy"))
                .ingot()
                .liquid()
                .components(Tungsten, 3, Concrete, 7, Naquadah, 6, Osmium, 4)
                .color(0x00444e)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, DISABLE_DECOMPOSITION, GENERATE_FOIL)
                .buildAndRegister();
        Indalloy140 = new Material.Builder(GTCEu.id("indalloy_140"))
                .ingot()
                .liquid()
                .components(Bismuth, 47, Lead, 25, Tin, 13, Cadmium, 10, Indium, 5)
                .blastTemp(5400, BlastProperty.GasTier.MID, GTValues.VA[GTValues.IV], 32)
                .color(0x4a465f)
                .iconSet(METALLIC)
                .appendFlags(STD_METAL, DISABLE_DECOMPOSITION)
                .buildAndRegister();
        AstralAlloy = new Material.Builder(GTCEu.id("astral_alloy"))
                .ingot()
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill().temperature(12))
                .element(MBEElements.AstralAlloy)
                .color(0x1d2243)
                .secondaryColor(0x333751)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, DISABLE_DECOMPOSITION)
                .buildAndRegister();
        HeavyElementAlloy = new Material.Builder(GTCEu.id("heavy_element_alloy"))
                .ingot()
                .liquid()
                .components(Francium, 1, Darmstadtium, 1, Mendelevium, 1, Seaborgium, 1, Thorium, 1, Rutherfordium, 1)
                .blastTemp(11898, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UV], 620)
                .color(0x000000)
                .secondaryColor(0x333751)
                .iconSet(BRIGHT)
                .appendFlags(STD_METAL, GENERATE_FRAME, GENERATE_FOIL, DISABLE_DECOMPOSITION)
                .buildAndRegister();
    }
}
