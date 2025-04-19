package com.mrlacar.multiblock_engineer.mbe.common.data.materials;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.HazardProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.gregtechceu.gtceu.common.data.GTMedicalConditions;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class MiscMaterials {

    public static Material MoonStone;
    public static Material MercuryStone;
    public static Material MarsStone;
    public static Material VenusStone;
    public static Material GlacioStone;
    public static Material CyliosStone;
    public static Material Gloomystone;
    public static Material EtherPolymer;
    public static Material ContaminatedUniversiumContainingFluid;
    public static Material UniversiumWasteFluid;
    public static Material ActivatedEX68IBacteriaSolution;
    public static Material AcidifiedActivatedEX68IBacteriaSolution;
    public static Material InactivatedEX68IBacteriaSolution;
    public static Material ImpureUniversiumDust;
    public static Material ImpureUniversiumSolution;
    public static Material PurifiedUniversiumSolution;
    public static Material DarkPlasma;
    public static Material StarCatalyst;
    public static Material DepletedUHTDPFlow;
    public static Material ExcitedUHTDPFlow;
    public static Material GelidCryotheum;
    public static Material RadiumRadonMixture;
    public static Material ScandiumTitanium50Mixture;
    public static Material IsomericResin;
    public static Material ActiveSculkBacterialSludge;
    public static Material SuperCoolant;
    public static Material RP1RocketFuel;
    public static Material RP1;
    public static Material DenseHydrazineFuelMixture;
    public static Material Hydrazine;
    public static Material CN3H7O3RocketFuel;
    public static Material MonomethylHydrazine;
    public static Material H8N4C2O4RocketFuel;
    public static Material Kerosene;
    public static Material HydrogenPeroxide;
    public static Material Anthracene;
    public static Material TwoEthylanthraquinone;
    public static Material TwoEthylanthrahydroquinone;
    public static Material PhthalicAnhybride;
    public static Material ElementalExtractant;
    public static Material WasteElementalExtractant;
    public static Material Creageno;
    public static Material SpaceTimeStateDimensionAvulseMatter;
    public static Material CyliosAir;
    public static Material LiquidCrystalKevlar;
    public static Material Hydroquinone;
    public static Material TerephthaloylChloride;
    public static Material FourNitroaniline;
    public static Material Aniline;
    public static Material ThionylChloride;
    public static Material DimethylTerephthalate;
    public static Material SulfurDichloride;
    public static Material TerephthalicAcid;
    public static Material CobaltNaphthenate;
    public static Material NaphthenicAcid;
    public static Material CobaltHydroxide;
    public static Material CobaltNitrite;
    public static Material NMethylpyrolidone;
    public static Material GammaButyrolactone;
    public static Material OneFourButanediol;
    public static Material NickelAluminide;
    public static Material RaneyNickelActivated;
    public static Material AluminiumHydroxide;
    public static Material TwoButin14Diol;
    public static Material BismuthOxide;
    public static Material Acetylene;
    public static Material CalciumCarbide;
    public static Material MethylAmine;
    public static Material AluminiumOxide;
    public static Material SodiumAluminate;
    public static Material Kevlar;
    public static Material PolyurethaneResin;
    public static Material PolyurethaneCatalystA;
    public static Material Pentaerythritol;
    public static Material FourFourDiphenylmethaneDiisocyanate;
    public static Material EthyleneGlycol;
    public static Material SiliconOil;
    public static Material PropionicAcid;
    public static Material NickelTetracarbonyl;
    public static Material Acetaldehyde;
    public static Material DiphenylmethaneDiisocyanateMixture;
    public static Material DiaminodiphenylmethaneMixture;
    public static Material Phosgene;
    public static Material EthyleneOxide;
    public static Material Butanol;
    public static Material StellarAlloyActivatedCoating;
    public static Material Antimatter;
    public static Material ConcentratedStarFuel;

    public static void register() {
        MoonStone = new Material.Builder(GTCEu.id("moon_stone"))
                .dust()
                .color(0x424c4e)
                .iconSet(DULL)
                .buildAndRegister();
        MercuryStone = new Material.Builder(GTCEu.id("mercury_stone"))
                .dust()
                .color(0x4d2a3c)
                .iconSet(DULL)
                .buildAndRegister();
        MarsStone = new Material.Builder(GTCEu.id("mars_stone"))
                .dust()
                .color(0xbf6f50)
                .iconSet(DULL)
                .buildAndRegister();
        VenusStone = new Material.Builder(GTCEu.id("venus_stone"))
                .dust()
                .color(0xb88143)
                .iconSet(DULL)
                .buildAndRegister();
        GlacioStone = new Material.Builder(GTCEu.id("glacio_stone"))
                .dust()
                .color(0x9185b6)
                .iconSet(DULL)
                .buildAndRegister();
        CyliosStone = new Material.Builder(GTCEu.id("cylios_stone"))
                .dust()
                .color(0x251d1c)
                .iconSet(DULL)
                .buildAndRegister();
        Gloomystone = new Material.Builder(GTCEu.id("gloomystone"))
                .dust()
                .color(0x111111)
                .iconSet(DULL)
                .buildAndRegister();
        EtherPolymer = new Material.Builder(GTCEu.id("ether_polymer"))
                .polymer()
                .liquid(new FluidBuilder().temperature(2670))
                .color(0x2f2f2f)
                .iconSet(DULL)
                .flags(GENERATE_FRAME, GENERATE_ROD, GENERATE_PLATE, GENERATE_FOIL, GENERATE_LENS)
                .fluidPipeProperties(5200, 1600, true, true, true, false)
                .buildAndRegister();
        ContaminatedUniversiumContainingFluid = new Material.Builder(GTCEu.id("contaminated_universium_containing_fluid"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill())
                .radioactiveHazard(10)
                .buildAndRegister();
        UniversiumWasteFluid = new Material.Builder(GTCEu.id("universium_waste_fluid"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill())
                .radioactiveHazard(2)
                .buildAndRegister();
        ActivatedEX68IBacteriaSolution = new Material.Builder(GTCEu.id("activated_ex_68_i_bacteria_solution"))
                .liquid()
                .color(0x111111)
                .radioactiveHazard(15)
                .buildAndRegister();
        AcidifiedActivatedEX68IBacteriaSolution = new Material.Builder(GTCEu.id("acidified_activated_ex_68_i_bacteria_solution"))
                .liquid()
                .color(0x1d1b19)
                .radioactiveHazard(15)
                .buildAndRegister();
        InactivatedEX68IBacteriaSolution = new Material.Builder(GTCEu.id("inactivated_ex_68_i_bacteria_solution"))
                .liquid()
                .color(0x111111)
                .radioactiveHazard(15)
                .buildAndRegister();
        ImpureUniversiumDust = new Material.Builder(GTCEu.id("impure_universium"))
                .dust()
                .color(0x282828)
                .iconSet(DULL)
                .buildAndRegister();
        ImpureUniversiumSolution = new Material.Builder(GTCEu.id("impure_universium_solution"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill())
                .radioactiveHazard(15)
                .buildAndRegister();
        PurifiedUniversiumSolution = new Material.Builder(GTCEu.id("purified_universium_solution"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill())
                .radioactiveHazard(17)
                .buildAndRegister();
        DarkPlasma = new Material.Builder(GTCEu.id("dark"))
                .plasma(new FluidBuilder().temperature(21334))
                .color(0x000014)
                .buildAndRegister();
        StarCatalyst = new Material.Builder(GTCEu.id("star_catalyst"))
                .liquid()
                .color(0x57697e)
                .buildAndRegister();
        DepletedUHTDPFlow = new Material.Builder(GTCEu.id("depleted_uhtdp_flow"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill())
                .buildAndRegister();
        ExcitedUHTDPFlow = new Material.Builder(GTCEu.id("excited_uhtdp_flow"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill().temperature(5450000))
                .buildAndRegister();
        GelidCryotheum = new Material.Builder(GTCEu.id("gelid_cryotheum"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill().temperature(40))
                .buildAndRegister();
        RadiumRadonMixture = new Material.Builder(GTCEu.id("radium_radon_mixture"))
                .liquid()
                .color(0xc15eb0)
                .buildAndRegister();
        ScandiumTitanium50Mixture = new Material.Builder(GTCEu.id("scandium_titanium_50_mixture"))
                .liquid()
                .color(0xcfa0cb)
                .buildAndRegister();
        IsomericResin = new Material.Builder(GTCEu.id("isomeric_resin"))
                .liquid()
                .color(0x768796)
                .buildAndRegister();
        ActiveSculkBacterialSludge = new Material.Builder(GTCEu.id("active_sculk_bacterial_sludge"))
                .liquid()
                .color(0x001c1e)
                .buildAndRegister();
        SuperCoolant = new Material.Builder(GTCEu.id("super_coolant"))
                .liquid()
                .color(0x97fff6)
                .buildAndRegister();
        RP1RocketFuel = new Material.Builder(GTCEu.id("rp_1_rocket_fuel"))
                .liquid()
                .color(0xda0000)
                .buildAndRegister();
        RP1 = new Material.Builder(GTCEu.id("rp_1"))
                .liquid()
                .color(0x9f0000)
                .buildAndRegister();
        DenseHydrazineFuelMixture = new Material.Builder(GTCEu.id("dense_hydrazine_fuel_mixture"))
                .liquid()
                .color(0xa83d70)
                .buildAndRegister();
        Hydrazine = new Material.Builder(GTCEu.id("hydrazine"))
                .liquid()
                .color(0xadadad)
                .buildAndRegister();
        CN3H7O3RocketFuel = new Material.Builder(GTCEu.id("cn3h7o3_rocket_fuel"))
                .liquid()
                .color(0x470e9d)
                .buildAndRegister()
                .setFormula("CN3H7O3", true);
        MonomethylHydrazine = new Material.Builder(GTCEu.id("monomethyl_hydrazine"))
                .liquid()
                .color(0x8b8b8b)
                .buildAndRegister();
        H8N4C2O4RocketFuel = new Material.Builder(GTCEu.id("h8n4c2o4_rocket_fuel"))
                .liquid()
                .color(0x03b749)
                .buildAndRegister()
                .setFormula("H8N4C2O4", true);
        Kerosene = new Material.Builder(GTCEu.id("kerosene"))
                .liquid()
                .color(0x872490)
                .buildAndRegister();
        HydrogenPeroxide = new Material.Builder(GTCEu.id("hydrogen_peroxide"))
                .liquid()
                .color(0x8b8b8b)
                .buildAndRegister();
        Anthracene = new Material.Builder(GTCEu.id("anthracene"))
                .liquid()
                .color(0x8b8b8b)
                .buildAndRegister();
        TwoEthylanthraquinone = new Material.Builder(GTCEu.id("2_ethylanthraquinone"))
                .liquid()
                .color(0xb4c992)
                .buildAndRegister();
        TwoEthylanthrahydroquinone = new Material.Builder(GTCEu.id("2_ethylanthrahydroquinone"))
                .liquid()
                .color(0xb4c992)
                .buildAndRegister();
        PhthalicAnhybride = new Material.Builder(GTCEu.id("phthalic_anhybride"))
                .dust()
                .color(0x5d5d5d)
                .iconSet(DULL)
                .components(Carbon, 6, Hydrogen, 4, CarbonMonoxide, 2, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        ElementalExtractant = new Material.Builder(GTCEu.id("elemental_extractant"))
                .liquid()
                .color(0xf5926e)
                .buildAndRegister();
        WasteElementalExtractant = new Material.Builder(GTCEu.id("waste_elemental_extractant"))
                .liquid()
                .color(0xf5bda9)
                .buildAndRegister();
        Creageno = new Material.Builder(GTCEu.id("creageno"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill())
                .buildAndRegister();
        SpaceTimeStateDimensionAvulseMatter = new Material.Builder(GTCEu.id("space_time_state_dimension_avulse_matter"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill())
                .buildAndRegister();
        CyliosAir = new Material.Builder(GTCEu.id("cylios_air"))
                .gas()
                .color(0x3c3433)
                .flags(DISABLE_DECOMPOSITION)
                .hazard(HazardProperty.HazardTrigger.INHALATION, GTMedicalConditions.CHEMICAL_BURNS)
                .buildAndRegister();
        LiquidCrystalKevlar = new Material.Builder(GTCEu.id("liquid_crystal_kevlar"))
                .liquid()
                .color(0xe0c654)
                .buildAndRegister()
                .setFormula("[-CO-C6H4-CO-NH-C6H4-NH-]n", true);
        Hydroquinone = new Material.Builder(GTCEu.id("hydroquinone"))
                .dust()
                .color(0xb6ab76)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("C6H8N2", true);
        TerephthaloylChloride = new Material.Builder(GTCEu.id("terephthaloyl_chloride"))
                .dust()
                .color(0x00b200)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("C8H4Cl2O2", true);
        FourNitroaniline = new Material.Builder(GTCEu.id("4_nitroaniline"))
                .liquid()
                .color(0xdf8518)
                .buildAndRegister()
                .setFormula("C6H6N2O2", true);
        Aniline = new Material.Builder(GTCEu.id("aniline"))
                .liquid()
                .color(0x788916)
                .buildAndRegister()
                .setFormula("C6H7N", true);
        ThionylChloride = new Material.Builder(GTCEu.id("thionyl_chloride"))
                .liquid()
                .color(0xd7d7d7)
                .buildAndRegister()
                .setFormula("SOCl2", true);
        DimethylTerephthalate = new Material.Builder(GTCEu.id("dimethyl_terephthalate"))
                .liquid()
                .color(0xd7d7d7)
                .buildAndRegister()
                .setFormula("C10H10O4", true);
        SulfurDichloride = new Material.Builder(GTCEu.id("sulfur_dichloride"))
                .liquid()
                .color(0x9c1515)
                .buildAndRegister()
                .setFormula("SCl2", true);
        TerephthalicAcid = new Material.Builder(GTCEu.id("terephthalic_acid"))
                .liquid()
                .color(0xd7d7d7)
                .buildAndRegister()
                .setFormula("C8H6O4", true);
        CobaltNaphthenate = new Material.Builder(GTCEu.id("cobalt_naphthenate"))
                .dust()
                .color(0x584120)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("CoC22H14O4", true);
        NaphthenicAcid = new Material.Builder(GTCEu.id("naphthenic_acid"))
                .liquid()
                .color(0xd7d7d7)
                .buildAndRegister();
        CobaltHydroxide = new Material.Builder(GTCEu.id("cobalt_hydroxide"))
                .dust()
                .color(0xd976c2)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("Co(OH)2", true);
        CobaltNitrite = new Material.Builder(GTCEu.id("cobalt_nitrite"))
                .dust()
                .color(0x510a0a)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("Co(NO3)2", true);
        NMethylpyrolidone = new Material.Builder(GTCEu.id("n_methylpyrolidone"))
                .liquid()
                .color(0xd7d7d7)
                .buildAndRegister()
                .setFormula("C5H9NO", true);
        GammaButyrolactone = new Material.Builder(GTCEu.id("gamma_butyrolactone"))
                .liquid()
                .color(0xc9bc84)
                .buildAndRegister()
                .setFormula("C4H6O2", true);
        OneFourButanediol = new Material.Builder(GTCEu.id("1_4_butanediol"))
                .liquid()
                .color(0xd0384c)
                .buildAndRegister()
                .setFormula("HO(CH2)4OH", true);
        NickelAluminide = new Material.Builder(GTCEu.id("nickel_aluminide"))
                .ingot()
                .color(0xffffff)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("NiAl3", true);
        RaneyNickelActivated = new Material.Builder(GTCEu.id("raney_nickel_activated"))
                .dust()
                .color(0xd7d7d7)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("NiAl", true);
        AluminiumHydroxide = new Material.Builder(GTCEu.id("aluminium_hydroxide"))
                .dust()
                .color(0xffffff)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("Al(OH)3", true);
        TwoButin14Diol = new Material.Builder(GTCEu.id("2_butin_1_4_diol"))
                .dust()
                .color(0xe0cb6d)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("C4H6O2", true);
        BismuthOxide = new Material.Builder(GTCEu.id("bismuth_oxide"))
                .dust()
                .color(0x000000)
                .components(Bismuth, 2, Oxygen, 3)
                .iconSet(BRIGHT)
                .buildAndRegister();
        Acetylene = new Material.Builder(GTCEu.id("acetylene"))
                .liquid()
                .color(0xffffff)
                .buildAndRegister()
                .setFormula("C2H2", true);
        CalciumCarbide = new Material.Builder(GTCEu.id("calcium_carbide"))
                .dust()
                .color(0x7f7f7f)
                .components(Calcium, 1, Carbon, 2)
                .iconSet(BRIGHT)
                .buildAndRegister();
        MethylAmine = new Material.Builder(GTCEu.id("methylamine"))
                .gas()
                .color(0x474c7a)
                .buildAndRegister()
                .setFormula("CH5N", true);
        AluminiumOxide = new Material.Builder(GTCEu.id("aluminium_oxide"))
                .dust()
                .color(0xb4d7da)
                .components(Aluminium, 2, Oxygen, 3)
                .iconSet(METALLIC)
                .buildAndRegister();
        SodiumAluminate = new Material.Builder(GTCEu.id("sodium_aluminate"))
                .dust()
                .color(0xe2c3c6)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("NaAlO2", true);
        Kevlar = new Material.Builder(GTCEu.id("kevlar"))
                .polymer()
                .liquid(new FluidBuilder())
                .color(0xf0de8e)
                .iconSet(DULL)
                .flags(GENERATE_ROD, GENERATE_PLATE, GENERATE_FOIL)
                .buildAndRegister();
        PolyurethaneResin = new Material.Builder(GTCEu.id("polyurethane_resin"))
                .liquid()
                .color(0xf0de8e)
                .buildAndRegister();
        PolyurethaneCatalystA = new Material.Builder(GTCEu.id("polyurethane_catalyst_a"))
                .dust()
                .color(0x000000)
                .iconSet(DULL)
                .buildAndRegister();
        Pentaerythritol = new Material.Builder(GTCEu.id("pentaerythritol"))
                .dust()
                .color(0xd7d7d7)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("C5H12O4", true);
        FourFourDiphenylmethaneDiisocyanate = new Material.Builder(GTCEu.id("4_4_diphenylmethane_diisocyanate"))
                .dust()
                .color(0xf0de8e)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("C15H10N2O2", true);
        EthyleneGlycol = new Material.Builder(GTCEu.id("ethylene_glycol"))
                .liquid()
                .color(0xd7d7d7)
                .buildAndRegister()
                .setFormula("C2H6O2", true);
        SiliconOil = new Material.Builder(GTCEu.id("silicon_oil"))
                .liquid()
                .color(0xd7d7d7)
                .buildAndRegister();
        PropionicAcid = new Material.Builder(GTCEu.id("propionic_acid"))
                .liquid()
                .color(0xc3d59f)
                .buildAndRegister();
        NickelTetracarbonyl = new Material.Builder(GTCEu.id("nickel_tetracarbonyl"))
                .liquid()
                .color(0xd7d7d7)
                .buildAndRegister()
                .setFormula("C4NiO4", true);
        Acetaldehyde = new Material.Builder(GTCEu.id("acetaldehyde"))
                .gas()
                .color(0xd7d7d7)
                .buildAndRegister()
                .setFormula("C2H4O", true);
        DiphenylmethaneDiisocyanateMixture = new Material.Builder(GTCEu.id("diphenylmethane_diisocyanate_mixture"))
                .liquid()
                .color(0xe0c346)
                .buildAndRegister()
                .setFormula("C15H10N2O2", true);
        DiaminodiphenylmethaneMixture = new Material.Builder(GTCEu.id("diaminodiphenylmethane_mixture"))
                .liquid()
                .color(0xe0c346)
                .buildAndRegister()
                .setFormula("C13H14N2", true);
        Phosgene = new Material.Builder(GTCEu.id("phosgene"))
                .liquid()
                .color(0x039953)
                .buildAndRegister()
                .setFormula("COCl2", true);
        EthyleneOxide = new Material.Builder(GTCEu.id("ethylene_oxide"))
                .gas()
                .color(0xd7d7d7)
                .buildAndRegister()
                .setFormula("C2H4O", true);
        Butanol = new Material.Builder(GTCEu.id("butanol"))
                .gas()
                .color(0xb22b2b)
                .buildAndRegister();
        StellarAlloyActivatedCoating = new Material.Builder(GTCEu.id("stellar_alloy_activated_coating"))
                .liquid()
                .color(0xff31ef)
                .buildAndRegister();
        Antimatter = new Material.Builder(GTCEu.id("antimatter"))
                .liquid()
                .color(0x201529)
                .buildAndRegister();
        ConcentratedStarFuel = new Material.Builder(GTCEu.id("concentrated_star_fuel"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).customStill())
                .buildAndRegister();
    }
}
