package com.mrlacar.multiblock_engineer.mbe.common.data;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import appeng.block.crafting.CraftingUnitBlock;
import appeng.blockentity.AEBaseBlockEntity;
import appeng.blockentity.crafting.CraftingBlockEntity;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.machine.multiblock.IBatteryData;
import com.gregtechceu.gtceu.common.block.BatteryBlock;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.data.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.mrlacar.multiblock_engineer.mbe.api.data.MBECustomTags;
import com.mrlacar.multiblock_engineer.mbe.common.block.*;
import com.mrlacar.multiblock_engineer.mbe.common.block.ae2.AcceleratorBlocks;
import com.mrlacar.multiblock_engineer.mbe.common.block.ae2.CraftingUnitBlocks;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.client.model.generators.ConfiguredModel;

import java.util.*;
import java.util.function.Supplier;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.mrlacar.multiblock_engineer.mbe.api.MBERegistries.REGISTRATE;

public class MBEBlocks {

    public static Map<Integer, Supplier<ActiveBlock>> IFRMap = new HashMap<>();
    public static Map<Integer, Supplier<Block>> SAMMap = new HashMap<>();
    public static Map<Integer, Supplier<Block>> SSMAP = new HashMap<>();
    public static Map<Integer, Supplier<Block>> ReactionCoilMAP = new HashMap<>();

    static {
        REGISTRATE.creativeModeTab(() -> MBECreativeModeTabs.BLOCK);
    }

    public static final BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_1024K = createCraftingUnitBlock(1024, CraftingUnitBlocks.STORAGE_1024K);
    public static final BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_4096K = createCraftingUnitBlock(4096, CraftingUnitBlocks.STORAGE_4096K);
    public static final BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_16384K = createCraftingUnitBlock(16384, CraftingUnitBlocks.STORAGE_16384K);
    public static final BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_65536K = createCraftingUnitBlock(65536, CraftingUnitBlocks.STORAGE_65536K);
    public static final BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_262144K = createCraftingUnitBlock(262144, CraftingUnitBlocks.STORAGE_262144K);

    public static final BlockEntry<CraftingUnitBlock> ACCELERATOR_4_CORE = createAcceleratorBlock(4, AcceleratorBlocks.ACCELERATOR_4);
    public static final BlockEntry<CraftingUnitBlock> ACCELERATOR_16_CORE = createAcceleratorBlock(16, AcceleratorBlocks.ACCELERATOR_16);
    public static final BlockEntry<CraftingUnitBlock> ACCELERATOR_64_CORE = createAcceleratorBlock(64, AcceleratorBlocks.ACCELERATOR_64);
    public static final BlockEntry<CraftingUnitBlock> ACCELERATOR_256_CORE = createAcceleratorBlock(256, AcceleratorBlocks.ACCELERATOR_256);

    public static BlockEntityEntry<CraftingBlockEntity> CRAFTING_STORAGE = REGISTRATE
            .blockEntity("crafting_storage", CraftingBlockEntity::new)
            .validBlocks(CRAFTING_STORAGE_1024K, CRAFTING_STORAGE_4096K, CRAFTING_STORAGE_16384K, CRAFTING_STORAGE_65536K, CRAFTING_STORAGE_262144K)
            .onRegister(type -> {for (CraftingUnitBlocks craftingUnitType : CraftingUnitBlocks.values()) {AEBaseBlockEntity.registerBlockEntityItem(type, craftingUnitType.getItemFromType());craftingUnitType.getDefinition().get().setBlockEntity(CraftingBlockEntity.class, type, null, null);}})
            .register();

    public static BlockEntityEntry<CraftingBlockEntity> ACCELERATOR = REGISTRATE
            .blockEntity("accelerator", CraftingBlockEntity::new)
            .validBlocks(ACCELERATOR_4_CORE, ACCELERATOR_16_CORE, ACCELERATOR_64_CORE, ACCELERATOR_256_CORE)
            .onRegister(type -> {for (AcceleratorBlocks acceleratorType : AcceleratorBlocks.values()) {AEBaseBlockEntity.registerBlockEntityItem(type, acceleratorType.getItemFromType());acceleratorType.getDefinition().get().setBlockEntity(CraftingBlockEntity.class, type, null, null);}})
            .register();

    public static final BlockEntry<Block> BRONZE_REINFORCED_WOODEN_CASING = createCasingBlock("bronze_reinforced_wooden_casing",
            MultiBlock_Engineer.id("block/bronze_reinforced_wooden_casing"));
    public static final BlockEntry<Block> ENERGY_RESTRAINT_CASING = createCasingBlock("energy_restraint_casing",
            MultiBlock_Engineer.id("block/energy_restraint_casing"));
    public static final BlockEntry<Block> COMPONENT_FACTORY_CASING = createCasingBlock("component_factory_casing",
            MultiBlock_Engineer.id("block/component_factory_casing"));
    public static final BlockEntry<Block> HIGH_PRECISE_INERT_CASING = createCasingBlock("high_precise_inert_casing",
            MultiBlock_Engineer.id("block/high_precise_inert_casing"));
    public static final BlockEntry<Block> EXTREME_STRENGTH_COMPRESSED_EXPLOSIONPROOF_CASING = createCasingBlock("extreme_strength_compressed_explosionproof_casing",
            MultiBlock_Engineer.id("block/extreme_strength_compressed_explosionproof_casing"));
    public static final BlockEntry<Block> NAQUADAH_ALLOY_CASING = createCasingBlock("naquadah_alloy_casing",
            MultiBlock_Engineer.id("block/naquadah_alloy_casing"));
    public static final BlockEntry<Block> NEUTRONIUM_CASING = createCasingBlock("neutronium_casing",
            MultiBlock_Engineer.id("block/neutronium_casing"));
    public static final BlockEntry<Block> HASTELLOY_633_C_CASING = createCasingBlock("hastelloy_633_c_casing",
            MultiBlock_Engineer.id("block/hastelloy_633_c_casing"));
    public static final BlockEntry<Block> COMPLEX_DEEP_SPACE_ALLOY_CASING = createCasingBlock("complex_deep_space_alloy_casing",
            MultiBlock_Engineer.id("block/complex_deep_space_alloy_casing"));
    public static final BlockEntry<Block> ASTRITANIUM_CASING = createCasingBlock("astritanium_casing",
            MultiBlock_Engineer.id("block/astritanium_casing"));
    public static final BlockEntry<Block> VF_9200_GS_ALLOY_CASING = createCasingBlock("vf_9200_gs_alloy_casing",
            MultiBlock_Engineer.id("block/vf_9200_gs_alloy_casing"));
    public static final BlockEntry<Block> MASS_EXPANSION_SUPPRESSION_CASING = createCasingBlock("mass_expansion_suppression_casing",
            MultiBlock_Engineer.id("block/mass_expansion_suppression_casing"));
    public static final BlockEntry<Block> IMAGINARY_ENGINE_COMPUTER_CASING = createCasingBlock("imaginary_engine_computer_casing",
            MultiBlock_Engineer.id("block/imaginary_engine_computer_casing"));
    public static final BlockEntry<Block> CAPTURE_CASING = createCasingBlock("capture_casing",
            MultiBlock_Engineer.id("block/capture_casing"));
    public static final BlockEntry<Block> SEALED_RADIATION_PROOF_CASING = createCasingBlock("sealed_radiation_proof_casing",
            MultiBlock_Engineer.id("block/sealed_radiation_proof_casing"));
    public static final BlockEntry<Block> SUPER_STABLE_CONCRETE = createCasingBlock("super_stable_concrete",
            MultiBlock_Engineer.id("block/super_stable_concrete"));
    public static final BlockEntry<Block> STELLAR_THERMAL_ENERGY_SHIELDING_CASING = createCasingBlock("stellar_thermal_energy_shielding_casing",
            MultiBlock_Engineer.id("block/stellar_thermal_energy_shielding_casing"));
    public static final BlockEntry<Block> WARPING_STATION_CASING = createCasingBlock("warping_station_casing",
            MultiBlock_Engineer.id("block/warping_station_casing"));
    public static final BlockEntry<Block> ELEMENT_CONSTRAINT_CASING = createCasingBlock("element_constraint_casing",
            MultiBlock_Engineer.id("block/element_constraint_casing"));
    public static final BlockEntry<Block> SPACE_ASSEMBLY_CASING = createCasingBlock("space_assembly_casing",
            MultiBlock_Engineer.id("block/space_assembly_casing"));
    public static final BlockEntry<Block> PHOTOLITHOGRAPHIC_FRAMEWORK_CASING = createCasingBlock("photolithographic_framework_casing",
            MultiBlock_Engineer.id("block/photolithographic_framework_casing"));
    public static final BlockEntry<Block> PRECISION_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING = createCasingBlock("precision_photolithographic_framework_casing",
            MultiBlock_Engineer.id("block/precision_photolithographic_framework_casing"));
    public static final BlockEntry<Block> COSMIC_BOUNDARY_STRUCTURE_CASING = createCasingBlock("cosmic_boundary_structure_casing",
            MultiBlock_Engineer.id("block/cosmic_boundary_structure_casing"));
    public static final BlockEntry<ActiveBlock> PARALLEL_UNIVERSE_BRIDGE_CASING = createActiveCasing("parallel_universe_bridge_casing",
            "block/variant/parallel_universe_bridge_casing");
    public static final BlockEntry<Block> CONVECTIVE_SPACETIME_TRACTION_CASING = createCasingBlock("convective_spacetime_traction_casing",
            MultiBlock_Engineer.id("block/convective_spacetime_traction_casing"));
    public static final BlockEntry<Block> CLOSED_TIME_LIKE_CURVE_CASING = createCasingBlock("closed_time_like_curve_casing",
            MultiBlock_Engineer.id("block/closed_time_like_curve_casing"));
    public static final BlockEntry<Block> SPS_CASING = createCasingBlock("sps_casing",
            MultiBlock_Engineer.id("block/sps_casing"));
    public static final BlockEntry<Block> MOLECULAR_CASING = createCasingBlock("molecular_casing",
            MultiBlock_Engineer.id("block/molecular_casing"));
    public static final BlockEntry<Block> DYSON_SPHERE_BASE_STATION_CASING = createCasingBlock("dyson_sphere_base_station_casing",
            MultiBlock_Engineer.id("block/dyson_sphere_base_station_casing"));
    public static final BlockEntry<Block> DYSON_SPHERE_SIDE_CASING = createCasingBlock("dyson_sphere_side_casing",
            MultiBlock_Engineer.id("block/dyson_sphere_side_casing"));

    public static final BlockEntry<Block> MINER_ACCELERATE_SLIDEWAY = REGISTRATE
            .block("miner_accelerate_slideway", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Miner Accelerate Slideway")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> LASER_PASSTHROUGH_PIPE = REGISTRATE
            .block("laser_passthrough_pipe", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Laser Passthrough Pipe")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> STRUCTURAL_REINFORCED_PIPE_CASING = REGISTRATE
            .block("structural_reinforced_pipe_casing", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Structural Reinforced Pipe Casing")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> DIMENSION_PROJECTOR_MK1 = REGISTRATE
            .block("dimension_projector_mk1", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Dimension Projector MK I")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> DIMENSION_PROJECTOR_MK2 = REGISTRATE
            .block("dimension_projector_mk2", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Dimension Projector MK II")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> COMPONENT_FACTORY_LOGIC_UNIT = REGISTRATE
            .block("component_factory_logic_unit", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Component Factory Logical Unit")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> COMPONENT_FACTORY_HEAT_VENT = createCasingBlock("component_factory_heat_vent",
            MultiBlock_Engineer.id("block/component_factory_heat_vent"));
    public static final BlockEntry<Block> COMPONENT_FACTORY_GEARBOX = REGISTRATE
            .block("component_factory_gearbox", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Component Factory Gearbox Casing")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> ADVANCED_FUSION_COIL = REGISTRATE
            .block("advanced_fusion_coil", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Advanced Fusion Coil")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> ULTRA_ENERGY_COIL = REGISTRATE
            .block("ultra_energy_coil", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Ultra Energy Coil")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> ABSOLUTELY_CLEAN_ISOLATION_INTERLAYER = REGISTRATE
            .block("absolutely_clean_isolation_interlayer", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Absolutely Clean Isolation Interlayer")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> PARTICLE_MOVEMENT_OBSERVATION_CHAMBER = REGISTRATE
            .block("particle_movement_observation_chamber", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Particle Movement Observation Chamber")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> RAPID_COOLING_COMPONENT = REGISTRATE
            .block("rapid_cooling_component", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Rapid Cooling Component")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> IMAGINARY_ENGINE_COMPUTER_HEAT_VENT = REGISTRATE
            .block("imaginary_engine_computer_heat_vent", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Imaginary Engine Computer Heat Vent")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> HPCA_ULTIMATE_COMPUTATION_COMPONENT = REGISTRATE
            .block("hpca_ultimate_computation_component", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("HPCA Ultimate Computation Component")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> PHOTON_RECEIVING_PLATE = REGISTRATE
            .block("photon_receiving_plate", Block::new)
            .initialProperties(() -> Blocks.GLASS)
            .lang("Photon Receiving Plate")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> RAY_RECEIVER_BLOCK = REGISTRATE
            .block("ray_receiver_block", Block::new)
            .initialProperties(() -> Blocks.GLASS)
            .lang("Ray Receiver Block")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> DYSON_SPHERE_STRUCTURAL_SUPPORT_FRAME = REGISTRATE
            .block("dyson_sphere_structural_support_frame", Block::new)
            .initialProperties(() -> Blocks.GLASS)
            .lang("Dyson Sphere Structural Support Frame")
            .defaultBlockstate()
            .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();

    public static final BlockEntry<ActiveBlock> INSTABILITY_FIELD_REGULATOR_MK1 = createActiveTierCasing("instability_field_regulator_mk1",
            "block/variant/instability_field_regulator_mk1", IFRMap, 1);
    public static final BlockEntry<ActiveBlock> INSTABILITY_FIELD_REGULATOR_MK2 = createActiveTierCasing("instability_field_regulator_mk2",
            "block/variant/instability_field_regulator_mk2", IFRMap, 2);
    public static final BlockEntry<ActiveBlock> INSTABILITY_FIELD_REGULATOR_MK3 = createActiveTierCasing("instability_field_regulator_mk3",
            "block/variant/instability_field_regulator_mk3", IFRMap, 3);

    public static final BlockEntry<ActiveBlock> MATTER_DECOMPOSE_HEAT_VENT = createActiveCasing("matter_decompose_heat_vent", "block/variant/matter_decompose_heat_vent");
    public static final BlockEntry<ActiveBlock> PRESSURE_STABILIZER = createActiveCasing("pressure_stabilizer", "block/variant/pressure_stabilizer");
    public static final BlockEntry<ActiveBlock> POWER_ACCELERATION_RAIL = createActiveCasing("power_acceleration_rail", "block/variant/power_acceleration_rail");

    public static void init() {
        for (int i = 1; i < 9; i++) {
            createTierCasings("reaction_coil_mk" + i, MultiBlock_Engineer.id("block/reaction_coil_mk" + i), ReactionCoilMAP, i);
        }
        for (int i = 1; i < 15; i++) {
            createTierCasings("space_assembly_module_" + GTValues.VN[i].toLowerCase(), MultiBlock_Engineer.id("block/space_assembly_module_" + GTValues.VN[i].toLowerCase()), SAMMap, i);
        }
        for (int i = 1; i < 5; i++) {
            createTierCasings("subuniverse_stabilizer_" + i, MultiBlock_Engineer.id("block/subuniverse_stabilizer_" + i), SSMAP, i);
        }
    }



    public static final BlockEntry<Block> ENERGY_FOCUS_LENS = createGlassCasingBlock("energy_focus_lens",
            MultiBlock_Engineer.id("block/energy_focus_lens"), () -> RenderType::translucent);
    public static final BlockEntry<Block> MASS_EXPANSION_SUPPRESSION_GLASS = createGlassCasingBlock("mass_expansion_suppression_glass",
            MultiBlock_Engineer.id("block/mass_expansion_suppression_glass"), () -> RenderType::translucent);
    public static final BlockEntry<Block> STELLAR_THERMAL_ENERGY_SHIELDING_GLASS = createGlassCasingBlock("stellar_thermal_energy_shielding_glass",
            MultiBlock_Engineer.id("block/stellar_thermal_energy_shielding_glass"), () -> RenderType::translucent);
    public static final BlockEntry<Block> NEUTRONIUM_REINFORCED_BOROSILICATE_GLASS = createGlassCasingBlock("neutronium_reinforced_borosilicate_glass",
            MultiBlock_Engineer.id("block/neutronium_reinforced_borosilicate_glass"), () -> RenderType::translucent);
    public static final BlockEntry<Block> INFINITY_REINFORCED_BOROSILICATE_GLASS = createGlassCasingBlock("infinity_reinforced_borosilicate_glass",
            MultiBlock_Engineer.id("block/infinity_reinforced_borosilicate_glass"), () -> RenderType::translucent);
    public static final BlockEntry<Block> PRIMARY_SUBSTANCE_REINFORCED_BOROSILICATE_GLASS = createGlassCasingBlock("primary_substance_reinforced_borosilicate_glass",
            MultiBlock_Engineer.id("block/primary_substance_reinforced_borosilicate_glass"), () -> RenderType::translucent);

    public static final BlockEntry<Block> HERMETIC_CASING_UEV = createHermeticCasing(UEV);
    public static final BlockEntry<Block> HERMETIC_CASING_UIV = createHermeticCasing(UIV);
    public static final BlockEntry<Block> HERMETIC_CASING_UXV = createHermeticCasing(UXV);
    public static final BlockEntry<Block> HERMETIC_CASING_OpV = createHermeticCasing(OpV);
    public static final BlockEntry<Block> HERMETIC_CASING_MAX = createHermeticCasing(MAX);

    public static final BlockEntry<CoilBlock> COIL_STELLAR_ALLOY = createCoilBlock(MBECoilBlocks.CoilType.STELLAR_ALLOY);
    public static final BlockEntry<CoilBlock> COIL_OMTERIUM = createCoilBlock(MBECoilBlocks.CoilType.OMTERIUM);
    public static final BlockEntry<CoilBlock> COIL_STRUCTURAL_STEEL_5297 = createCoilBlock(MBECoilBlocks.CoilType.STRUCTURAL_STEEL_5297);
    public static final BlockEntry<CoilBlock> COIL_QUANTUM_ALLOY = createCoilBlock(MBECoilBlocks.CoilType.QUANTUM_ALLOY);
    public static final BlockEntry<CoilBlock> COIL_PRIMARY_SUBSTANCE = createCoilBlock(MBECoilBlocks.CoilType.PRIMARY_SUBSTANCE);
    public static final BlockEntry<CoilBlock> COIL_INFINITY = createCoilBlock(MBECoilBlocks.CoilType.INFINITY);

    public static final BlockEntry<BatteryBlock> BATTERY_EMPTY_TIER_IV = createBatteryBlock(
            MBEBatteryBlocks.BatteryPartType.EMPTY_TIER_IV);
    public static final BlockEntry<BatteryBlock> BATTERY_ASCENDANT_UEV = createBatteryBlock(
            MBEBatteryBlocks.BatteryPartType.UEV_ASCENDANT);
    public static final BlockEntry<BatteryBlock> BATTERY_SUPREME_UIV = createBatteryBlock(
            MBEBatteryBlocks.BatteryPartType.UIV_SUPREME);
    public static final BlockEntry<BatteryBlock> BATTERY_MYTHICAL_UXV = createBatteryBlock(
            MBEBatteryBlocks.BatteryPartType.UXV_MYTHICAL);
    public static final BlockEntry<BatteryBlock> BATTERY_EMPTY_TIER_V = createBatteryBlock(
            MBEBatteryBlocks.BatteryPartType.EMPTY_TIER_V);
    public static final BlockEntry<BatteryBlock> BATTERY_ILLUSORY_OpV = createBatteryBlock(
            MBEBatteryBlocks.BatteryPartType.OpV_ILLUSORY);
    public static final BlockEntry<BatteryBlock> BATTERY_CREATIVE_MAX = createBatteryBlock(
            MBEBatteryBlocks.BatteryPartType.MAX_CREATIVE);

    public static final BlockEntry<Block> FILTER_CASING_SCULK = createCleanroomFilter(
            CleanroomFilterType.FILTER_CASING_SCULK);

    public static final BlockEntry<PrivateAnchorBlock> PRIVATE_ANCHOR = REGISTRATE
            .block("private_anchor", PrivateAnchorBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Private Anchor")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<OverworldAnchorBlock> OVERWORLD_ANCHOR = REGISTRATE
            .block("overworld_anchor", OverworldAnchorBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Overworld Anchor")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> ENCHANTED_OBSIDIAN = REGISTRATE
            .block("enchanted_obsidian", Block::new)
            .initialProperties(() -> Blocks.OBSIDIAN)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_GRAY).lightLevel(p -> 8))
            .lang("Enchanted Obsidian")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> URANUS_STONE = REGISTRATE
            .block("uranus_stone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_GRAY))
            .lang("Uranus Stone")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> URANUS_COBBLESTONE = REGISTRATE
            .block("uranus_cobblestone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_GRAY))
            .lang("Uranus Cobblestone")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> NEPTUNE_STONE = REGISTRATE
            .block("neptune_stone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_GRAY))
            .lang("Neptune Stone")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> NEPTUNE_COBBLESTONE = REGISTRATE
            .block("neptune_cobblestone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_GRAY))
            .lang("Neptune Cobblestone")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<FallingBlock> CYLIOS_SAND = REGISTRATE
            .block("cylios_sand", FallingBlock::new)
            .initialProperties(() -> Blocks.SAND)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Cylios Sand")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> CYLIOS_STONE = REGISTRATE
            .block("cylios_stone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_GRAY))
            .lang("Cylios Stone")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> CYLIOS_COBBLESTONE = REGISTRATE
            .block("cylios_cobblestone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_GRAY))
            .lang("Cylios Cobblestone")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> CYLIOS_DEEPSLATE = REGISTRATE
            .block("cylios_deepslate", Block::new)
            .initialProperties(() -> Blocks.DEEPSLATE)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_BLACK))
            .lang("Cylios Deepslate")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> DARK_SOIL = REGISTRATE
            .block("dark_soil", Block::new)
            .initialProperties(() -> Blocks.DIRT)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Dark Soil")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> GLOOMYSTONE = REGISTRATE
            .block("gloomystone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_GRAY))
            .lang("Gloomystone")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> GLOOMY_COBBLESTONE = REGISTRATE
            .block("gloomy_cobblestone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_GRAY))
            .lang("Gloomy Cobblestone")
            .defaultBlockstate()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();

    private static BlockEntry<Block> createGlassCasingBlock(String name, ResourceLocation texture, Supplier<Supplier<RenderType>> type) {
        return createCasingBlock(name, GlassBlock::new, texture, () -> Blocks.GLASS, type);
    }

    public static BlockEntry<Block> createCasingBlock(String name, ResourceLocation texture) {
        return createCasingBlock(name, Block::new, texture, () -> Blocks.IRON_BLOCK,
                () -> RenderType::cutoutMipped);
    }

    public static BlockEntry<Block> createCasingBlock(String name, NonNullFunction<BlockBehaviour.Properties, Block> blockSupplier, ResourceLocation texture, NonNullSupplier<? extends Block> properties, Supplier<Supplier<RenderType>> type) {
        return REGISTRATE.block(name, blockSupplier)
                .initialProperties(properties)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(type)
                .blockstate(GTModels.cubeAllModel(name, texture))
                .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(BlockItem::new)
                .build()
                .register();
    }

    private static BlockEntry<CoilBlock> createCoilBlock(ICoilType coilType) {
        BlockEntry<CoilBlock> coilBlock = REGISTRATE
                .block("%s_coil_block".formatted(coilType.getName()), p -> new CoilBlock(p, coilType))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(GTModels.createCoilModel("%s_coil_block".formatted(coilType.getName()), coilType))
                .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(BlockItem::new)
                .build()
                .register();
        GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
        return coilBlock;
    }

    private static BlockEntry<BatteryBlock> createBatteryBlock(IBatteryData batteryData) {
        BlockEntry<BatteryBlock> batteryBlock = REGISTRATE.block("%s_battery".formatted(batteryData.getBatteryName()),
                        p -> new BatteryBlock(p, batteryData))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, entityType) -> false))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(GTModels.createBatteryBlockModel("%s_battery".formatted(batteryData.getBatteryName()),
                        batteryData))
                .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(BlockItem::new)
                .build()
                .register();
        GTCEuAPI.PSS_BATTERIES.put(batteryData, batteryBlock);
        return batteryBlock;
    }

    private static BlockEntry<Block> createHermeticCasing(int tier) {
        String tierName = GTValues.VN[tier].toLowerCase(Locale.ROOT);
        BlockEntry<Block> entry = REGISTRATE
                .block("%s_hermetic_casing".formatted(tierName), Block::new)
                .lang("Hermetic Casing %s".formatted(GTValues.LVT[tier]))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(GTModels.createHermeticCasingModel(tierName))
                .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(BlockItem::new)
                .build()
                .register();
        if (!GTCEuAPI.isHighTier() && tier > GTValues.UHV) {
            REGISTRATE.setCreativeTab(entry, null);
        }
        return entry;
    }

    protected static BlockEntry<ActiveBlock> createActiveCasing(String name, String baseModelPath) {
        return REGISTRATE.block(name, ActiveBlock::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(GTModels.createActiveModel(GTCEu.id(baseModelPath)))
                .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(BlockItem::new)
                .model((ctx, prov) -> prov.withExistingParent(prov.name(ctx), GTCEu.id(baseModelPath)))
                .build()
                .register();
    }

    public static BlockEntry<ActiveBlock> createActiveTierCasing(String name, String baseModelPath, Map<Integer, Supplier<ActiveBlock>> map, int tier) {
        BlockEntry<ActiveBlock> Block = REGISTRATE.block(name, ActiveBlock::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(GTModels.createActiveModel(GTCEu.id(baseModelPath)))
                .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(BlockItem::new)
                .model((ctx, prov) -> prov.withExistingParent(prov.name(ctx), GTCEu.id(baseModelPath)))
                .build()
                .register();
        map.put(tier, Block);
        return Block;
    }

    public static BlockEntry<Block> createTierCasings(String name, ResourceLocation texture, Map<Integer, Supplier<Block>> map, int tier) {
        BlockEntry<Block> Block = REGISTRATE.block(name, Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(GTModels.cubeAllModel(name, texture))
                .tag(MBECustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(BlockItem::new)
                .build()
                .register();
        map.put(tier, Block);
        return Block;
    }

    private static BlockEntry<Block> createCleanroomFilter(IFilterType filterType) {
        var filterBlock = REGISTRATE.block(filterType.getSerializedName(), Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(properties -> properties.strength(2.0f, 8.0f).sound(SoundType.METAL)
                        .isValidSpawn((blockState, blockGetter, blockPos, entityType) -> false))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(MBECustomTags.MINEABLE_WITH_WRENCH, CustomTags.TOOL_TIERS[1])
                .item(BlockItem::new)
                .build()
                .register();
        GTCEuAPI.CLEANROOM_FILTERS.put(filterType, filterBlock);
        return filterBlock;
    }

    private static BlockEntry<CraftingUnitBlock> createCraftingUnitBlock(int tier, CraftingUnitBlocks Type) {
        return REGISTRATE.block(tier + "k_storage", p -> new CraftingUnitBlock(Type))
                .blockstate((ctx, provider) -> {
                    String formed = "block/crafting/" + ctx.getName() + "_formed";
                    String unformed = "block/crafting/" + ctx.getName();
                    provider.models().cubeAll(unformed, provider.modLoc("block/crafting/" + ctx.getName()));
                    provider.models().getBuilder(formed);
                    provider.getVariantBuilder(ctx.get())
                            .forAllStatesExcept(state -> {
                                boolean b = state.getValue(AbstractCraftingUnitBlock.FORMED);
                                return ConfiguredModel.builder()
                                        .modelFile(provider.models()
                                                .getExistingFile(provider.modLoc(b ? formed : unformed)))
                                        .build();
                            }, AbstractCraftingUnitBlock.POWERED);
                })
                .defaultLoot()
                .item(BlockItem::new)
                .model((ctx, provider) -> provider.withExistingParent(ctx.getName(),
                        provider.modLoc("block/crafting/" + ctx.getName())))
                .build()
                .register();
    }

    private static BlockEntry<CraftingUnitBlock> createAcceleratorBlock(int core, AcceleratorBlocks Type) {
        return REGISTRATE.block(core + "_core_accelerator", p -> new CraftingUnitBlock(Type))
                .blockstate((ctx, provider) -> {
                    String formed = "block/crafting/" + ctx.getName() + "_formed";
                    String unformed = "block/crafting/" + ctx.getName();
                    provider.models().cubeAll(unformed, provider.modLoc("block/crafting/" + ctx.getName()));
                    provider.models().getBuilder(formed);
                    provider.getVariantBuilder(ctx.get())
                            .forAllStatesExcept(state -> {
                                boolean b = state.getValue(AbstractCraftingUnitBlock.FORMED);
                                return ConfiguredModel.builder()
                                        .modelFile(provider.models()
                                                .getExistingFile(provider.modLoc(b ? formed : unformed)))
                                        .build();
                            }, AbstractCraftingUnitBlock.POWERED);
                })
                .defaultLoot()
                .item(BlockItem::new)
                .model((ctx, provider) -> provider.withExistingParent(ctx.getName(),
                        provider.modLoc("block/crafting/" + ctx.getName())))
                .build()
                .register();
    }
}
