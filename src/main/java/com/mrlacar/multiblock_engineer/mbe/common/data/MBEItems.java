package com.mrlacar.multiblock_engineer.mbe.common.data;

import appeng.api.stacks.AEKeyType;
import appeng.items.materials.StorageComponentItem;
import appeng.items.storage.BasicStorageCell;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ElectricStats;
import com.gregtechceu.gtceu.api.item.component.FoodStats;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.client.util.TooltipHelper;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.mrlacar.multiblock_engineer.mbe.api.MBERegistries;
import com.mrlacar.multiblock_engineer.mbe.api.data.MBECustomTags;
import com.mrlacar.multiblock_engineer.mbe.api.item.appeng.AdvancedStorageCell;
import com.mrlacar.multiblock_engineer.mbe.common.item.AdvancedConnectorBehavior;
import com.mrlacar.multiblock_engineer.mbe.common.item.NewYearLuckyBagBehavior;
import com.mrlacar.multiblock_engineer.mbe.common.item.StructureWandBehavior;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Rarity;

import static com.gregtechceu.gtceu.common.data.GTModels.overrideModel;
import static com.mrlacar.multiblock_engineer.mbe.api.MBERegistries.REGISTRATE;
import static com.mrlacar.multiblock_engineer.mbe.client.util.TooltipHelper.BLINK_PURPLE;

public class MBEItems {

    static {
        MBERegistries.REGISTRATE.creativeModeTab(() -> MBECreativeModeTabs.ITEM);
    }

    //AE Components
    public static final ItemEntry<StorageComponentItem> CELL_COMPONENT_1024K = AEComponent(1024);
    public static final ItemEntry<StorageComponentItem> CELL_COMPONENT_4096K = AEComponent(4096);
    public static final ItemEntry<StorageComponentItem> CELL_COMPONENT_16384K = AEComponent(16384);
    public static final ItemEntry<StorageComponentItem> CELL_COMPONENT_65536K = AEComponent(65536);
    public static final ItemEntry<StorageComponentItem> CELL_COMPONENT_262144K = AEComponent(262144);

    //AE Item Storage Cell
    public static final ItemEntry<BasicStorageCell> ITEM_CELL_1024K = AEItemStorageCell(1024, CELL_COMPONENT_1024K);
    public static final ItemEntry<BasicStorageCell> ITEM_CELL_4096K = AEItemStorageCell(4096, CELL_COMPONENT_4096K);
    public static final ItemEntry<BasicStorageCell> ITEM_CELL_16384K = AEItemStorageCell(16384, CELL_COMPONENT_16384K);
    public static final ItemEntry<BasicStorageCell> ITEM_CELL_65536K = AEItemStorageCell(65536, CELL_COMPONENT_65536K);
    public static final ItemEntry<BasicStorageCell> ITEM_CELL_262144K = AEItemStorageCell(262144, CELL_COMPONENT_262144K);
    public static final ItemEntry<AdvancedStorageCell> ITEM_CELL_QUANTUM = AEAdvancedItemStorageCell(1048576);

    //AE Fluid Storage Cell
    public static final ItemEntry<BasicStorageCell> FLUID_CELL_1024K = AEFluidStorageCell(1024, CELL_COMPONENT_1024K);
    public static final ItemEntry<BasicStorageCell> FLUID_CELL_4096K = AEFluidStorageCell(4096, CELL_COMPONENT_4096K);
    public static final ItemEntry<BasicStorageCell> FLUID_CELL_16384K = AEFluidStorageCell(16384, CELL_COMPONENT_16384K);
    public static final ItemEntry<BasicStorageCell> FLUID_CELL_65536K = AEFluidStorageCell(65536, CELL_COMPONENT_65536K);
    public static final ItemEntry<BasicStorageCell> FLUID_CELL_262144K = AEFluidStorageCell(262144, CELL_COMPONENT_262144K);
    public static final ItemEntry<AdvancedStorageCell> FLUID_CELL_QUANTUM = AEAdvancedFluidStorageCell(1048576);

    //Advanced Cell Housing
    public static ItemEntry<ComponentItem> ADVANCED_ITEM_CELL_HOUSING = REGISTRATE.item("advanced_item_cell_housing", ComponentItem::create)
            .lang("Advanced Item Cell Housing")
            .register();
    public static ItemEntry<ComponentItem> ADVANCED_FLUID_CELL_HOUSING = REGISTRATE.item("advanced_fluid_cell_housing", ComponentItem::create)
            .lang("Advanced Fluid Cell Housing")
            .register();

    //Casting Mold
    public static final ItemEntry<ComponentItem> SINGULARITY_CASTING_MOLD = REGISTRATE.item("singularity_casting_mold", ComponentItem::create)
            .lang("Singularity Casting Mold")
            .register();
    //Connector
    public static ItemEntry<ComponentItem> ADVANCED_CONNECTOR = REGISTRATE.item("advanced_connector", ComponentItem::create)
            .lang("Advanced Connector")
            .onRegister(attach(new AdvancedConnectorBehavior()))
            .register();
    //Battery
    public static ItemEntry<ComponentItem> ASCENDANT_BATTERY = REGISTRATE.item("ascendant_battery", ComponentItem::create)
            .lang("Ascendant Battery")
            .model(overrideModel(GTCEu.id("battery"), 8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UEV)))
            .tag(MBECustomTags.UEV_BATTERIES)
            .register();
    public static ItemEntry<ComponentItem> SUPREME_BATTERY = REGISTRATE.item("supreme_battery", ComponentItem::create)
            .lang("Supreme Battery")
            .model(overrideModel(GTCEu.id("battery"), 8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UIV)))
            .tag(MBECustomTags.UIV_BATTERIES)
            .register();
    public static ItemEntry<ComponentItem> MYTHICAL_BATTERY = REGISTRATE.item("mythical_battery", ComponentItem::create)
            .lang("Mythical Battery")
            .model(overrideModel(GTCEu.id("battery"), 8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE , GTValues.UXV)))
            .tag(MBECustomTags.UXV_BATTERIES)
            .register();
    public static ItemEntry<ComponentItem> ILLUSORY_BATTERY = REGISTRATE.item("illusory_battery", ComponentItem::create)
            .lang("Illusory Battery")
            .model(overrideModel(GTCEu.id("battery"), 8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.OpV)))
            .tag(MBECustomTags.OpV_BATTERIES)
            .register();
    public static ItemEntry<ComponentItem> CREATIVE_BATTERY = REGISTRATE.item("creative_battery", ComponentItem::create)
            .lang("Creative Battery")
            .model(overrideModel(GTCEu.id("battery"), 8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.MAX)))
            .tag(MBECustomTags.MAX_BATTERIES)
            .register();
    //Components
    public static final ItemEntry<ComponentItem> ELECTRIC_MOTOR_MAX = REGISTRATE.item("max_electric_motor", ComponentItem::create)
            .lang("MAX Electric Motor")
            .tag(CustomTags.ELECTRIC_MOTORS)
            .register();
    public static ItemEntry<ComponentItem> ELECTRIC_PUMP_MAX = MBERegistries.REGISTRATE.item("max_electric_pump", ComponentItem::create)
            .lang("MAX Electric Pump")
            .onRegister(attach(new CoverPlaceBehavior(MBECovers.PUMP_MAX.definition)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate", 1280 * 64 * 64 * 4 / 20));
            })))
            .tag(CustomTags.ELECTRIC_PUMPS)
            .register();
    public static ItemEntry<ComponentItem> CONVEYOR_MODULE_MAX = MBERegistries.REGISTRATE.item("max_conveyor_module", ComponentItem::create)
            .lang("ULV Conveyor Module")
            .onRegister(attach(new CoverPlaceBehavior(MBECovers.CONVEYOR_MAX.definition)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
            })))
            .tag(CustomTags.CONVEYOR_MODULES)
            .register();
    public static final ItemEntry<ComponentItem> ELECTRIC_PISTON_MAX = REGISTRATE.item("max_electric_piston", ComponentItem::create)
            .lang("MAX Electric Piston")
            .tag(CustomTags.ELECTRIC_PISTONS)
            .register();
    public static ItemEntry<ComponentItem> FLUID_REGULATOR_MAX = MBERegistries.REGISTRATE.item("max_fluid_regulator", ComponentItem::create)
            .lang("ULV Fluid Regulator")
            .onRegister(attach(new CoverPlaceBehavior(MBECovers.FLUID_REGULATOR_MAX.definition)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.fluid.regulator.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate", 1280 * 64 * 64 * 4 / 20));
            })))
            .tag(CustomTags.FLUID_REGULATORS)
            .register();
    public static ItemEntry<ComponentItem> ROBOT_ARM_MAX = MBERegistries.REGISTRATE.item("max_robot_arm", ComponentItem::create)
            .lang("MAX Robot Arm")
            .onRegister(attach(new CoverPlaceBehavior(MBECovers.ROBOT_ARM_MAX.definition)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.robot.arm.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
            })))
            .tag(CustomTags.ROBOT_ARMS)
            .register();
    public static final ItemEntry<ComponentItem> FIELD_GENERATOR_MAX = REGISTRATE.item("max_field_generator", ComponentItem::create)
            .lang("MAX Field Generator")
            .tag(CustomTags.FIELD_GENERATORS)
            .register();
    public static final ItemEntry<ComponentItem> EMITTER_MAX = REGISTRATE.item("max_emitter", ComponentItem::create)
            .lang("MAX Emitter")
            .tag(CustomTags.EMITTERS)
            .register();
    public static final ItemEntry<ComponentItem> SENSOR_MAX = REGISTRATE.item("max_sensor", ComponentItem::create)
            .lang("MAX Sensor")
            .tag(CustomTags.SENSORS)
            .register();
    //Boule
    public static final ItemEntry<ComponentItem> COPERNICIUM_BOULE = REGISTRATE.item("copernicium_boule", ComponentItem::create)
            .lang("Copernicium Boule")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.boule"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> HASTELLOY_P_82_BOULE = REGISTRATE.item("hastelloy_p_82_boule", ComponentItem::create)
            .lang("Hastelloy P-82 Boule")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.boule"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_NEUTRONIUM_BOULE = REGISTRATE.item("cosmic_neutronium_boule", ComponentItem::create)
            .lang("Cosmic Neutronium Boule")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.boule"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> RINBONIUM_BOULE = REGISTRATE.item("rinbonium_boule", ComponentItem::create)
            .lang("Rainbonium Boule")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.boule"));
            })))
            .register();
    //Wafer
    public static final ItemEntry<ComponentItem> COPERNICIUM_WAFER = REGISTRATE.item("copernicium_wafer", ComponentItem::create)
            .lang("Copernicium Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.boule"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> HASTELLOY_P_82_WAFER = REGISTRATE.item("hastelloy_p_82_wafer", ComponentItem::create)
            .lang("Hastelloy P-82 Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.boule"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_NEUTRONIUM_WAFER = REGISTRATE.item("cosmic_neutronium_wafer", ComponentItem::create)
            .lang("Cosmic Neutronium Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.boule"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> RINBONIUM_WAFER = REGISTRATE.item("rinbonium_wafer", ComponentItem::create)
            .lang("Rainbonium Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.boule"));
            })))
            .register();
    //SoC Wafer
    public static final ItemEntry<ComponentItem> EPIC_SOC_WAFER = REGISTRATE.item("epic_soc_wafer", ComponentItem::create)
            .lang("Epic SoC Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.epic_soc_wafer"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> LEGENDARY_SOC_WAFER = REGISTRATE.item("legendary_soc_wafer", ComponentItem::create)
            .lang("Legendary SoC Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.legendary_soc_wafer"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> IMMORTAL_SOC_WAFER = REGISTRATE.item("immortal_soc_wafer", ComponentItem::create)
            .lang("Immortal SoC Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.immortal_soc_wafer"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> CREATIVE_SOC_WAFER = REGISTRATE.item("creative_soc_wafer", ComponentItem::create)
            .lang("Creative SoC Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.creative_soc_wafer"));
            })))
            .register();
    //SoC
    public static final ItemEntry<ComponentItem> EPIC_SOC = REGISTRATE.item("epic_soc", ComponentItem::create)
            .lang("Epic SoC")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.epic_soc"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> LEGENDARY_SOC = REGISTRATE.item("legendary_soc", ComponentItem::create)
            .lang("Legendary SoC")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.legendary_soc"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> IMMORTAL_SOC = REGISTRATE.item("immortal_soc", ComponentItem::create)
            .lang("Immortal SoC")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.immortal_soc"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> CREATIVE_SOC= REGISTRATE.item("creative_soc", ComponentItem::create)
            .lang("Creative SoC")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.creative_soc"));
            })))
            .register();
    //Circuit Board and Printed Circuit Board
    public static final ItemEntry<ComponentItem> SCULK_CIRCUIT_BOARD = REGISTRATE.item("sculk_circuit_board", ComponentItem::create)
            .lang("Sculk Circuit Board")
            .register();
    public static final ItemEntry<ComponentItem> STELLAR_ALLOY_ACTIVATED_COATING_CIRCUIT_BOARD = REGISTRATE.item("stellar_alloy_activated_coating_circuit_board", ComponentItem::create)
            .lang("Stellar Alloy Activated Coating Circuit Board")
            .register();
    public static final ItemEntry<ComponentItem> DIMENSION_MAPPING_CIRCUIT_BOARD = REGISTRATE.item("dimension_mapping_circuit_board", ComponentItem::create)
            .lang("Dimension Mapping Circuit Board")
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_FABRIC_CIRCUIT_BOARD = REGISTRATE.item("cosmic_fabric_circuit_board", ComponentItem::create)
            .lang("Cosmic Fabric Circuit Board")
            .register();
    public static final ItemEntry<ComponentItem> SURREAL_CIRCUIT_BOARD = REGISTRATE.item("surreal_circuit_board", ComponentItem::create)
            .lang("Surreal Circuit Board")
            .register();
    public static final ItemEntry<ComponentItem> CREATIONAL_CIRCUIT_BOARD = REGISTRATE.item("creational_circuit_board", ComponentItem::create)
            .lang("Creational Circuit Board")
            .register();
    public static final ItemEntry<ComponentItem> SCULK_PRINTED_CIRCUIT_BOARD = REGISTRATE.item("sculk_printed_circuit_board", ComponentItem::create)
            .lang("Sculk Printed Coating Board")
            .register();
    public static final ItemEntry<ComponentItem> STELLAR_ALLOY_ACTIVATED_COATING_PRINTED_CIRCUIT_BOARD = REGISTRATE.item("stellar_alloy_activated_coating_printed_circuit_board", ComponentItem::create)
            .lang("Stellar Alloy Activated Printed Coating Board")
            .register();
    public static final ItemEntry<ComponentItem> DIMENSION_MAPPING_PRINTED_CIRCUIT_BOARD = REGISTRATE.item("dimension_mapping_printed_circuit_board", ComponentItem::create)
            .lang("Dimension Mapping Printed Circuit Board")
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_FABRIC_PRINTED_CIRCUIT_BOARD = REGISTRATE.item("cosmic_fabric_printed_circuit_board", ComponentItem::create)
            .lang("Cosmic Fabric Printed Circuit Board")
            .register();
    public static final ItemEntry<ComponentItem> SURREAL_PRINTED_CIRCUIT_BOARD = REGISTRATE.item("surreal_printed_circuit_board", ComponentItem::create)
            .lang("Surreal Printed Circuit Board")
            .register();
    public static final ItemEntry<ComponentItem> CREATIONAL_PRINTED_CIRCUIT_BOARD = REGISTRATE.item("creational_printed_circuit_board", ComponentItem::create)
            .lang("Creational Printed Circuit Board")
            .register();
    //SMD etc
    public static final ItemEntry<ComponentItem> ELITE_SMD_DIODE = REGISTRATE.item("elite_smd_diode", ComponentItem::create)
            .lang("Elite SMD Diode")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_elite"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> ELITE_SMD_TRANSISTOR = REGISTRATE.item("elite_smd_transistor", ComponentItem::create)
            .lang("Elite SMD Transistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_elite"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> ELITE_SMD_RESISTOR = REGISTRATE.item("elite_smd_resistor", ComponentItem::create)
            .lang("Elite SMD Resistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_elite"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> ELITE_SMD_CAPACITOR = REGISTRATE.item("elite_smd_capacitor", ComponentItem::create)
            .lang("Elite SMD Capacitor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_elite"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> ELITE_SMD_INDUCTOR = REGISTRATE.item("elite_smd_inductor", ComponentItem::create)
            .lang("Elite SMD Inductor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_elite"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> EPIC_SMD_DIODE = REGISTRATE.item("epic_smd_diode", ComponentItem::create)
            .lang("Epic SMD Diode")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_epic"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> EPIC_SMD_TRANSISTOR = REGISTRATE.item("epic_smd_transistor", ComponentItem::create)
            .lang("Epic SMD Transistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_epic"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> EPIC_SMD_RESISTOR = REGISTRATE.item("epic_smd_resistor", ComponentItem::create)
            .lang("Epic SMD Resistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_epic"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> EPIC_SMD_CAPACITOR = REGISTRATE.item("epic_smd_capacitor", ComponentItem::create)
            .lang("Epic SMD Capacitor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_epic"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> EPIC_SMD_INDUCTOR = REGISTRATE.item("epic_smd_inductor", ComponentItem::create)
            .lang("Epic SMD Inductor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_epic"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> LEGENDARY_SMD_DIODE = REGISTRATE.item("legendary_smd_diode", ComponentItem::create)
            .lang("Legendary SMD Diode")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_legendary"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> LEGENDARY_SMD_TRANSISTOR = REGISTRATE.item("legendary_smd_transistor", ComponentItem::create)
            .lang("Legendary SMD Transistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_legendary"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> LEGENDARY_SMD_RESISTOR = REGISTRATE.item("legendary_smd_resistor", ComponentItem::create)
            .lang("Legendary SMD Resistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_legendary"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> LEGENDARY_SMD_CAPACITOR = REGISTRATE.item("legendary_smd_capacitor", ComponentItem::create)
            .lang("Legendary SMD Capacitor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_legendary"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> LEGENDARY_SMD_INDUCTOR = REGISTRATE.item("legendary_smd_inductor", ComponentItem::create)
            .lang("Legendary SMD Inductor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_legendary"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> IMMORTAL_SMD_DIODE = REGISTRATE.item("immortal_smd_diode", ComponentItem::create)
            .lang("Immortal SMD Diode")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_immortal"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> IMMORTAL_SMD_TRANSISTOR = REGISTRATE.item("immortal_smd_transistor", ComponentItem::create)
            .lang("Immortal SMD Transistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_immortal"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> IMMORTAL_SMD_RESISTOR = REGISTRATE.item("immortal_smd_resistor", ComponentItem::create)
            .lang("Immortal SMD Resistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_immortal"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> IMMORTAL_SMD_CAPACITOR = REGISTRATE.item("immortal_smd_capacitor", ComponentItem::create)
            .lang("Immortal SMD Capacitor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_immortal"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> IMMORTAL_SMD_INDUCTOR = REGISTRATE.item("immortal_smd_inductor", ComponentItem::create)
            .lang("Immortal SMD Inductor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.smd_immortal"));
            })))
            .register();
    //ZPM-UEV Circuit
    public static final ItemEntry<ComponentItem> SCULK_PROCESSOR = REGISTRATE.item("sculk_processor", ComponentItem::create)
            .lang("Sculk Processor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.zpm.zpm"));
                lines.add(Component.translatable("tooltips.mbe.sculk_processor"));
            })))
            .tag(CustomTags.ZPM_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SCULK_PROCESSOR_ASSEMBLY = REGISTRATE.item("sculk_processor_assembly", ComponentItem::create)
            .lang("Sculk Processor Assembly")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.zpm.uv"));
                lines.add(Component.translatable("tooltips.mbe.sculk_processor_assembly"));
            })))
            .tag(CustomTags.UV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SCULK_PROCESSOR_COMPUTER = REGISTRATE.item("sculk_processor_computer", ComponentItem::create)
            .lang("Sculk Processor Computer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.zpm.uhv"));
                lines.add(Component.translatable("tooltips.mbe.sculk_processor_computer"));
            })))
            .tag(CustomTags.UHV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SCULK_PROCESSOR_MAINFRAME = REGISTRATE.item("sculk_processor_mainframe", ComponentItem::create)
            .lang("Sculk Processor Mainframe")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.zpm.uev"));
                lines.add(Component.translatable("tooltips.mbe.sculk_processor_mainframe"));
            })))
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    //UV-UIV Circuit
    public static final ItemEntry<ComponentItem> STELLAR_PROCESSOR = REGISTRATE.item("stellar_processor", ComponentItem::create)
            .lang("Stellar Processor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uv.uv"));
                lines.add(Component.translatable("tooltips.mbe.stellar_processor"));
            })))
            .tag(CustomTags.UV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> STELLAR_PROCESSOR_ASSEMBLY = REGISTRATE.item("stellar_processor_assembly", ComponentItem::create)
            .lang("Stellar Processor Assembly")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uv.uhv"));
                lines.add(Component.translatable("tooltips.mbe.stellar_processor_assembly"));
            })))
            .tag(CustomTags.UHV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> STELLAR_PROCESSOR_COMPUTER = REGISTRATE.item("stellar_processor_computer", ComponentItem::create)
            .lang("Stellar Processor Computer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uv.uev"));
                lines.add(Component.translatable("tooltips.mbe.stellar_processor_computer"));
            })))
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> STELLAR_PROCESSOR_MAINFRAME = REGISTRATE.item("stellar_processor_mainframe", ComponentItem::create)
            .lang("Stellar Processor Mainframe")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uv.uiv"));
                lines.add(Component.translatable("tooltips.mbe.stellar_processor_mainframe"));
            })))
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    //UHV-UXV Circuit
    public static final ItemEntry<ComponentItem> DIMENSION_MAPPING_PROCESSOR = REGISTRATE.item("dimension_mapping_processor", ComponentItem::create)
            .lang("Dimension Mapping Processor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uhv.uhv"));
                lines.add(Component.translatable("tooltips.mbe.dimension_mapping_processor"));
            })))
            .tag(CustomTags.UHV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> DIMENSION_MAPPING_PROCESSOR_ASSEMBLY = REGISTRATE.item("dimension_mapping_processor_assembly", ComponentItem::create)
            .lang("Dimension Mapping Processor Assembly")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uhv.uev"));
                lines.add(Component.translatable("tooltips.mbe.dimension_mapping_processor_assembly"));
            })))
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> DIMENSION_MAPPING_PROCESSOR_COMPUTER = REGISTRATE.item("dimension_mapping_processor_computer", ComponentItem::create)
            .lang("Dimension Mapping Processor Computer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uhv.uiv"));
                lines.add(Component.translatable("tooltips.mbe.dimension_mapping_processor_computer"));
            })))
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> DIMENSION_MAPPING_PROCESSOR_MAINFRAME = REGISTRATE.item("dimension_mapping_processor_mainframe", ComponentItem::create)
            .lang("Dimension Mapping Processor Mainframe")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uhv.uxv"));
                lines.add(Component.translatable("tooltips.mbe.dimension_mapping_processor_mainframe"));
            })))
            .tag(CustomTags.UXV_CIRCUITS)
            .register();
    //UEV-OpV Circuit
    public static final ItemEntry<ComponentItem> COSMIC_PROCESSOR = REGISTRATE.item("cosmic_processor", ComponentItem::create)
            .lang("Cosmic Processor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uev.uev"));
                lines.add(Component.translatable("tooltips.mbe.cosmic_processor"));
            })))
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_PROCESSOR_ASSEMBLY = REGISTRATE.item("cosmic_processor_assembly", ComponentItem::create)
            .lang("Cosmic Processor Assembly")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uev.uiv"));
                lines.add(Component.translatable("tooltips.mbe.cosmic_processor_assembly"));
            })))
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_PROCESSOR_COMPUTER = REGISTRATE.item("cosmic_processor_computer", ComponentItem::create)
            .lang("Cosmic Processor Computer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uev.uxv"));
                lines.add(Component.translatable("tooltips.mbe.cosmic_processor_computer"));
            })))
            .tag(CustomTags.UXV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_PROCESSOR_MAINFRAME = REGISTRATE.item("cosmic_processor_mainframe", ComponentItem::create)
            .lang("Cosmic Processor Mainframe")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uev.opv"));
                lines.add(Component.translatable("tooltips.mbe.cosmic_processor_mainframe"));
            })))
            .tag(CustomTags.OpV_CIRCUITS)
            .register();
    //UIV-MAX Circuit
    public static final ItemEntry<ComponentItem> SURREAL_PROCESSOR = REGISTRATE.item("surreal_processor", ComponentItem::create)
            .lang("Surreal Processor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uiv.uiv"));
                lines.add(Component.translatable("tooltips.mbe.surreal_processor"));
            })))
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SURREAL_PROCESSOR_ASSEMBLY = REGISTRATE.item("surreal_processor_assembly", ComponentItem::create)
            .lang("Surreal Processor Assembly")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uiv.uxv"));
                lines.add(Component.translatable("tooltips.mbe.surreal_processor_assembly"));
            })))
            .tag(CustomTags.UXV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SURREAL_PROCESSOR_COMPUTER = REGISTRATE.item("surreal_processor_computer", ComponentItem::create)
            .lang("Surreal Processor Computer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uiv.opv"));
                lines.add(Component.translatable("tooltips.mbe.surreal_processor_computer"));
            })))
            .tag(CustomTags.OpV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SURREAL_PROCESSOR_MAINFRAME = REGISTRATE.item("surreal_processor_mainframe", ComponentItem::create)
            .lang("Surreal Processor Mainframe")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uiv.max"));
                lines.add(Component.translatable("tooltips.mbe.surreal_processor_mainframe"));
            })))
            .tag(CustomTags.MAX_CIRCUITS)
            .register();
    //UXV-MAX+ Circuit
    public static final ItemEntry<ComponentItem> CREATIONAL_PROCESSOR = REGISTRATE.item("creational_processor", ComponentItem::create)
            .lang("Creational Processor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uxv.creative").withStyle(style -> style.withColor(TooltipHelper.rainbowColor(6f))));
                lines.add(Component.translatable("tooltips.mbe.creational_processor"));
            })))
            .tag(CustomTags.UXV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> CREATIONAL_PROCESSOR_ASSEMBLY = REGISTRATE.item("creational_processor_assembly", ComponentItem::create)
            .lang("Creational Processor Assembly")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uxv.creative").withStyle(style -> style.withColor(TooltipHelper.rainbowColor(6f))));
                lines.add(Component.translatable("tooltips.mbe.creational_processor_assembly"));
            })))
            .tag(CustomTags.OpV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> CREATIONAL_PROCESSOR_COMPUTER = REGISTRATE.item("creational_processor_computer", ComponentItem::create)
            .lang("Creational Processor Computer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uxv.creative").withStyle(style -> style.withColor(TooltipHelper.rainbowColor(6f))));
                lines.add(Component.translatable("tooltips.mbe.creational_processor_computer"));
            })))
            .tag(CustomTags.MAX_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> CREATIONAL_PROCESSOR_MAINFRAME = REGISTRATE.item("creational_processor_mainframe", ComponentItem::create)
            .lang("Creational Processor Mainframe")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uxv.creative").withStyle(style -> style.withColor(TooltipHelper.rainbowColor(6f))));
                lines.add(Component.translatable("tooltips.mbe.creational_processor_mainframe"));
            })))
            .tag(CustomTags.MAX_CIRCUITS)
            .register();
    //General Circuit
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_LV = REGISTRATE.item("lv_general_circuit", ComponentItem::create)
            .lang("LV General Circuit")
            .tag(CustomTags.LV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_MV = REGISTRATE.item("mv_general_circuit", ComponentItem::create)
            .lang("MV General Circuit")
            .tag(CustomTags.MV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_HV = REGISTRATE.item("hv_general_circuit", ComponentItem::create)
            .lang("HV General Circuit")
            .tag(CustomTags.HV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_EV = REGISTRATE.item("ev_general_circuit", ComponentItem::create)
            .lang("EV General Circuit")
            .tag(CustomTags.EV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_IV = REGISTRATE.item("iv_general_circuit", ComponentItem::create)
            .lang("IV General Circuit")
            .tag(CustomTags.IV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_LuV = REGISTRATE.item("luv_general_circuit", ComponentItem::create)
            .lang("LuV General Circuit")
            .tag(CustomTags.LuV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_ZPM = REGISTRATE.item("zpm_general_circuit", ComponentItem::create)
            .lang("ZPM General Circuit")
            .tag(CustomTags.ZPM_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_UV = REGISTRATE.item("uv_general_circuit", ComponentItem::create)
            .lang("UV General Circuit")
            .tag(CustomTags.UV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_UHV = REGISTRATE.item("uhv_general_circuit", ComponentItem::create)
            .lang("UHV General Circuit")
            .tag(CustomTags.UHV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_UEV = REGISTRATE.item("uev_general_circuit", ComponentItem::create)
            .lang("UEV General Circuit")
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_UIV = REGISTRATE.item("uiv_general_circuit", ComponentItem::create)
            .lang("UIV General Circuit")
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_UXV = REGISTRATE.item("uxv_general_circuit", ComponentItem::create)
            .lang("UXV General Circuit")
            .tag(CustomTags.UXV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GENERAL_CIRCUIT_OpV = REGISTRATE.item("opv_general_circuit", ComponentItem::create)
            .lang("OpV General Circuit")
            .tag(CustomTags.OpV_CIRCUITS)
            .register();
    //Stars
    public static final ItemEntry<ComponentItem> MANA_STAR = REGISTRATE.item("mana_star", ComponentItem::create)
            .lang("Mana Star")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.mana_star"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> PARADOX_STAR = REGISTRATE.item("paradox_star", ComponentItem::create)
            .lang("Paradox Star")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.paradox_star"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> INFINITY_STAR = REGISTRATE.item("infinity_star", ComponentItem::create)
            .lang("Infinity Star")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.infinity_star"));
            })))
            .register();
    //Solar Panel
    public static ItemEntry<ComponentItem> SOLAR_PANEL_UHV = REGISTRATE.item("uhv_solar_panel", ComponentItem::create)
            .lang("Ultra High Voltage Solar Panel")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.addAll(LangHandler.getMultiLang("metaitem.cover.solar.panel.tooltip"));
                lines.add(Component.translatable("tooltips.mbe.cover_disable"));
            })))
            .register();
    public static ItemEntry<ComponentItem> SOLAR_PANEL_UEV = REGISTRATE.item("uev_solar_panel", ComponentItem::create)
            .lang("Ultra Excessive Voltage Solar Panel")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.addAll(LangHandler.getMultiLang("metaitem.cover.solar.panel.tooltip"));
                lines.add(Component.translatable("tooltips.mbe.cover_disable"));
            })))
            .register();
    public static ItemEntry<ComponentItem> SOLAR_PANEL_UIV = REGISTRATE.item("uiv_solar_panel", ComponentItem::create)
            .lang("Ultra Immense Voltage Solar Panel")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.addAll(LangHandler.getMultiLang("metaitem.cover.solar.panel.tooltip"));
                lines.add(Component.translatable("tooltips.mbe.cover_disable"));
            })))
            .register();
    public static ItemEntry<ComponentItem> SOLAR_PANEL_UXV = REGISTRATE.item("uxv_solar_panel", ComponentItem::create)
            .lang("Ultra Extreme Voltage Solar Panel")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.addAll(LangHandler.getMultiLang("metaitem.cover.solar.panel.tooltip"));
                lines.add(Component.translatable("tooltips.mbe.cover_disable"));
            })))
            .register();
    public static ItemEntry<ComponentItem> SOLAR_PANEL_OpV = REGISTRATE.item("opv_solar_panel", ComponentItem::create)
            .lang("Overpowered Voltage Solar Panel")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.addAll(LangHandler.getMultiLang("metaitem.cover.solar.panel.tooltip"));
                lines.add(Component.translatable("tooltips.mbe.cover_disable"));
            })))
            .register();
    //Misc
    public static final ItemEntry<ComponentItem> SPINNERET = REGISTRATE.item("spinneret", ComponentItem::create)
            .lang("Spinneret")
            .register();
    public static final ItemEntry<ComponentItem> KEVLAR_FIBER = REGISTRATE.item("kevlar_fiber", ComponentItem::create)
            .lang("Kevlar Fiber")
            .register();
    public static final ItemEntry<ComponentItem> WOVEN_KEVLAR = REGISTRATE.item("woven_kevlar", ComponentItem::create)
            .lang("Woven Kevlar")
            .register();
    public static final ItemEntry<ComponentItem> ROCKET_DATA_MODULE = REGISTRATE.item("rocket_data_module", ComponentItem::create)
            .lang("Rocket Data Module")
            .properties(p -> p.stacksTo(1))
            .tag(MBECustomTags.ROCKET_DATA_MODULE)
            .register();
    public static final ItemEntry<ComponentItem> HEAVY_ROCKET_PLATE_T1 = REGISTRATE.item("heavy_rocket_plate_t1", ComponentItem::create)
            .lang("Heavy Rocket Plate T1")
            .register();
    public static final ItemEntry<ComponentItem> HEAVY_ROCKET_PLATE_T2 = REGISTRATE.item("heavy_rocket_plate_t2", ComponentItem::create)
            .lang("Heavy Rocket Plate T2")
            .register();
    public static final ItemEntry<ComponentItem> HEAVY_ROCKET_PLATE_T3 = REGISTRATE.item("heavy_rocket_plate_t3", ComponentItem::create)
            .lang("Heavy Rocket Plate T3")
            .register();
    public static final ItemEntry<ComponentItem> HEAVY_ROCKET_PLATE_T4 = REGISTRATE.item("heavy_rocket_plate_t4", ComponentItem::create)
            .lang("Heavy Rocket Plate T4")
            .register();
    public static final ItemEntry<ComponentItem> HEAVY_ROCKET_PLATE_T5 = REGISTRATE.item("heavy_rocket_plate_t5", ComponentItem::create)
            .lang("Heavy Rocket Plate T5")
            .register();
    public static final ItemEntry<ComponentItem> HEAVY_ROCKET_PLATE_T6 = REGISTRATE.item("heavy_rocket_plate_t6", ComponentItem::create)
            .lang("Heavy Rocket Plate T6")
            .register();
    public static final ItemEntry<ComponentItem> HEAVY_ROCKET_PLATE_T7 = REGISTRATE.item("heavy_rocket_plate_t7", ComponentItem::create)
            .lang("Heavy Rocket Plate T7")
            .register();
    public static final ItemEntry<ComponentItem> STAR_MAP_NAVIGATION = REGISTRATE.item("star_map_navigation", ComponentItem::create)
            .lang("Star Map Navigation")
            .register();
    public static final ItemEntry<ComponentItem> ACTIVE_SCULK_BACTERIAL_SLUDGE = REGISTRATE.item("active_sculk_bacterial_sludge", ComponentItem::create)
            .lang("Active Sculk Bacterial Sludge")
            .register();
    public static final ItemEntry<ComponentItem> MINIATURE_SCULK_CATALYST = REGISTRATE.item("miniature_sculk_catalyst", ComponentItem::create)
            .lang("Miniature Sculk Catalyst")
            .register();
    public static final ItemEntry<ComponentItem> STELLAR_ALLOY_BLENDED_DYE = REGISTRATE.item("stellar_alloy_blended_dye", ComponentItem::create)
            .lang("Stellar Alloy Blended Dye")
            .register();
    public static final ItemEntry<ComponentItem> ACTIVATED_STARLIGHT_ADHESIVE = REGISTRATE.item("activated_starlight_adhesive", ComponentItem::create)
            .lang("Activated Starlight Adhesive")
            .register();
    public static final ItemEntry<ComponentItem> REFRACTING_PRISM_SLICE = REGISTRATE.item("refracting_prism_slice", ComponentItem::create)
            .lang("Refracting Prism Slice")
            .register();
    public static final ItemEntry<ComponentItem> OVERCLOCK_MATRIX = REGISTRATE.item("overclock_matrix", ComponentItem::create)
            .lang("Overclock Matrix")
            .register();
    public static final ItemEntry<ComponentItem> QUANTUM_COOLING_BATTERY_UNIT = REGISTRATE.item("quantum_cooling_battery_unit", ComponentItem::create)
            .lang("Quantum Cooling Battery Unit")
            .register();
    public static final ItemEntry<ComponentItem> PLANE_REFRACTING_PLATE = REGISTRATE.item("plane_refracting_plate", ComponentItem::create)
            .lang("Plane Refracting Plate")
            .register();
    public static final ItemEntry<ComponentItem> UNCONTROLLABLE_LOGIC_DIVERGENCE_UNIT = REGISTRATE.item("uncontrollable_logic_divergence_unit", ComponentItem::create)
            .lang("Uncontrollable Logic Divergence Unit")
            .register();
    public static final ItemEntry<ComponentItem> ULTRAHIGH_FREQUENCY_LASER_DIFFRACTION_CRYSTAL = REGISTRATE.item("ultrahigh_frequency_laser_diffraction_crystal", ComponentItem::create)
            .lang("Ultrahigh Frequency Laser Diffraction Crystal")
            .register();
    public static final ItemEntry<ComponentItem> PARTING_CORE = REGISTRATE.item("parting_core", ComponentItem::create)
            .lang("Parting Core")
            .register();
    public static final ItemEntry<ComponentItem> METASTABLE_HASSIUM_COVER_NEUTRON_REFLECTOR = REGISTRATE.item("metastable_hassium_cover_neutron_reflector", ComponentItem::create)
            .lang("Metastable Hassium Cover Neutron Reflector")
            .register();
    public static final ItemEntry<ComponentItem> ASTRAL_EMITTER = REGISTRATE.item("astral_emitter", ComponentItem::create)
            .lang("Astral Emitter")
            .register();
    public static final ItemEntry<ComponentItem> UNLIMITED_PARTICLE_MOTION_OBSERVER = REGISTRATE.item("unlimited_particle_motion_observer", ComponentItem::create)
            .lang("Unlimited Particle Motion Observer")
            .register();
    public static final ItemEntry<ComponentItem> NEUTRONIUM_FOLD_ELECTRON_SPIN_FIELD = REGISTRATE.item("neutronium_fold_electron_spin_field", ComponentItem::create)
            .lang("Neutronium Fold Electron Spin Field")
            .register();
    public static final ItemEntry<ComponentItem> ENERGY_RESTRAINT_PLATE = REGISTRATE.item("energy_restraint_plate", ComponentItem::create)
            .lang("Energy Restraint Plate")
            .register();
    public static final ItemEntry<ComponentItem> INFINITY_ARMOR_PLATE = REGISTRATE.item("infinity_armor_plate", ComponentItem::create)
            .lang("Infinity Armor Plate")
            .register();
    public static final ItemEntry<ComponentItem> UU_MATTER_AMPLIFY_ESSENTIAL = REGISTRATE.item("uu_matter_amplify_essential", ComponentItem::create)
            .lang("UU Matter Amplify Essential")
            .register();
    public static final ItemEntry<ComponentItem> SOLAR_SAIL = REGISTRATE.item("solar_sail", ComponentItem::create)
            .lang("Solar Sail")
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_FABRIC = REGISTRATE.item("cosmic_fabric", ComponentItem::create)
            .lang("Cosmic Fabric")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.cosmic_fabric"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> DYNAMICAL_QUARK_MATTER_FOIL = REGISTRATE.item("dynamical_quark_matter_foil", ComponentItem::create)
            .lang("Dynamical Quark Matter Foil")
            .register();
    public static final ItemEntry<ComponentItem> HYPERQUADRANT_OVERLAY_CONTRACT_AREA_INTRINSIC_MATTER_FOIL = REGISTRATE.item("hyperquadrant_overlay_contract_area_intrinsic_matter_foil", ComponentItem::create)
            .lang("Hyperquadrant Overlay Contract Area Intrinsic Matter Foil")
            .register();
    public static final ItemEntry<ComponentItem> MULTIVERSE_MATRIX = REGISTRATE.item("multiverse_matrix", ComponentItem::create)
            .lang("Multiverse Matrix")
            .properties(p -> p.stacksTo(4).fireResistant().rarity(Rarity.RARE))
            .register();
    public static final ItemEntry<ComponentItem> T1_ANNIHILATION_PIVOT_FUEL_CLUSTER = REGISTRATE.item("t1_annihilation_pivot_fuel_cluster", ComponentItem::create)
            .lang("T1 Annihilation Pivot Fuel Cluster")
            .register();
    public static final ItemEntry<ComponentItem> T2_ANNIHILATION_PIVOT_FUEL_CLUSTER = REGISTRATE.item("t2_annihilation_pivot_fuel_cluster", ComponentItem::create)
            .lang("T2 Annihilation Pivot Fuel Cluster")
            .register();
    public static final ItemEntry<ComponentItem> T3_ANNIHILATION_PIVOT_FUEL_CLUSTER = REGISTRATE.item("t3_annihilation_pivot_fuel_cluster", ComponentItem::create)
            .lang("T3 Annihilation Pivot Fuel Cluster MK")
            .register();
    public static final ItemEntry<ComponentItem> STAR_TOWER_EXTREME_CALCULATION_UNIT = REGISTRATE.item("star_tower_extreme_calculation_unit", ComponentItem::create)
            .lang("Star Tower Extreme Calculation Unit")
            .properties(p -> p.stacksTo(4))
            .register();
    public static final ItemEntry<ComponentItem> EMPTY_CATALYST_UNIT = REGISTRATE.item("empty_catalyst_unit", ComponentItem::create)
            .lang("Empty Catalyst Unit")
            .register();
    public static final ItemEntry<ComponentItem> STAR_CATALYST_UNIT = REGISTRATE.item("star_catalyst_unit", ComponentItem::create)
            .lang("Star Catalyst Unit")
            .register();
    public static final ItemEntry<ComponentItem> DATA_TEMPLATE = REGISTRATE.item("data_template", ComponentItem::create)
            .lang("Data Template")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.data_template"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> LASER_FOCUS_LENS_GROUP = REGISTRATE.item("laser_focus_lens_group", ComponentItem::create)
            .lang("Laser Focus Lens Group")
            .properties(p -> p.stacksTo(1))
            .register();
    public static final ItemEntry<ComponentItem> NEW_YEAR_LUCKY_BAG = REGISTRATE.item("new_year_lucky_bag", ComponentItem::create)
            .lang("New Yea Lucky Bag")
            .properties(p -> p.rarity(Rarity.EPIC))
            .onRegister(attach(new NewYearLuckyBagBehavior()))
            .register();
    public static final ItemEntry<ComponentItem> LUCKY_APPLE = REGISTRATE.item("lucky_apple", ComponentItem::create)
            .lang("Lucky Apple")
            .onRegister(attach(new FoodStats(MBEFoods.LUCKY_APPLE)))
            .register();
    public static final ItemEntry<ComponentItem> LIFE_SINGULARITY = REGISTRATE.item("life_singularity", ComponentItem::create)
            .lang("Life Singularity")
            .register();
    public static final ItemEntry<ComponentItem> SPACE_SINGULARITY = REGISTRATE.item("space_singularity", ComponentItem::create)
            .lang("Space Singularity")
            .register();
    public static final ItemEntry<ComponentItem> ENERGY_SINGULARITY = REGISTRATE.item("energy_singularity", ComponentItem::create)
            .lang("Energy Singularity")
            .register();
    public static final ItemEntry<ComponentItem> SATURATION_SINGULARITY = REGISTRATE.item("saturation_singularity", ComponentItem::create)
            .lang("Saturation Singularity")
            .register();
    public static final ItemEntry<ComponentItem> CHAOS_SINGULARITY = REGISTRATE.item("chaos_singularity", ComponentItem::create)
            .lang("Chaos Singularity")
            .register();
    //Logic Detector
    public static final ItemEntry<ComponentItem> LOGIC_DETECTOR_UV = REGISTRATE.item("uv_logic_detector", ComponentItem::create)
            .lang("UV Logic Detector")
            .properties(p -> p.stacksTo(16))
            .register();
    public static final ItemEntry<ComponentItem> LOGIC_DETECTOR_UHV = REGISTRATE.item("uhv_logic_detector", ComponentItem::create)
            .lang("UHV Logic Detector")
            .properties(p -> p.stacksTo(16))
            .register();
    public static final ItemEntry<ComponentItem> LOGIC_DETECTOR_UEV = REGISTRATE.item("uev_logic_detector", ComponentItem::create)
            .lang("UEV Logic Detector")
            .properties(p -> p.stacksTo(16))
            .register();
    public static final ItemEntry<ComponentItem> LOGIC_DETECTOR_UIV = REGISTRATE.item("uiv_logic_detector", ComponentItem::create)
            .lang("UIV Logic Detector")
            .properties(p -> p.stacksTo(16))
            .register();
    public static final ItemEntry<ComponentItem> LOGIC_DETECTOR_UXV = REGISTRATE.item("uxv_logic_detector", ComponentItem::create)
            .lang("UXV Logic Detector")
            .properties(p -> p.stacksTo(16))
            .register();
    public static final ItemEntry<ComponentItem> LOGIC_DETECTOR_OpV = REGISTRATE.item("opv_logic_detector", ComponentItem::create)
            .lang("OpV Logic Detector")
            .properties(p -> p.stacksTo(16))
            .register();
    //Bacteria
    public static final ItemEntry<ComponentItem> EX_68I_BACTERIA = REGISTRATE.item("ex_68_i_bacteria", ComponentItem::create)
            .lang("EX-68I Bacteria")
            .register();
    //Coils
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_UHV = REGISTRATE.item("uhv_voltage_coil", ComponentItem::create)
            .lang("Ultra High Voltage Coil")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uhv_voltage_coil"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_UEV = REGISTRATE.item("uev_voltage_coil", ComponentItem::create)
            .lang("Ultra Excessive Voltage Coil")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uev_voltage_coil"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_UIV = REGISTRATE.item("uiv_voltage_coil", ComponentItem::create)
            .lang("Ultra Immense Voltage Coil")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uiv_voltage_coil"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_UXV = REGISTRATE.item("uxv_voltage_coil", ComponentItem::create)
            .lang("Ultra Extreme Voltage Coil")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.uxv_voltage_coil"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_OpV = REGISTRATE.item("opv_voltage_coil", ComponentItem::create)
            .lang("Overpowered Voltage Coil")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.opv_voltage_coil"));
            })))
            .register();
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_MAX = REGISTRATE.item("max_voltage_coil", ComponentItem::create)
            .lang("Maximum Voltage Coil")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.max_voltage_coil"));
            })))
            .register();
    //Micro Eternal Universe
    public static final ItemEntry<ComponentItem> MICRO_ETERNAL_UNIVERSE = REGISTRATE.item("micro_eternal_universe", ComponentItem::create)
            .lang("Micro-Eternal Universe")
            .properties(p -> p.stacksTo(1).fireResistant().rarity(Rarity.EPIC))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("tooltips.mbe.micro_eternal_universe").withStyle(style -> style.withColor(BLINK_PURPLE.getCurrent())));
            })))
            .register();
    //Structure Wand
    public static final ItemEntry<ComponentItem> STRUCTURE_WAND = REGISTRATE.item("structure_wand", ComponentItem::create)
            .lang("Chaos Singularity")
            .onRegister(attach(StructureWandBehavior.INSTANCE))
            .register();

    static {
        REGISTRATE.creativeModeTab(() -> null);
    }

    public static final ItemEntry<ComponentItem> DATA_TEMPLATE_01 = REGISTRATE.item("data_template_01", ComponentItem::create)
            .lang("Data Template 01")
            .register();
    public static final ItemEntry<ComponentItem> ROCKET_DATA_MODULE_T3 = REGISTRATE.item("rocket_data_module_t3", ComponentItem::create)
            .lang("Rocket Data Module T3")
            .properties(p -> p.stacksTo(1))
            .tag(MBECustomTags.ROCKET_DATA_MODULE)
            .register();
    public static final ItemEntry<ComponentItem> ROCKET_DATA_MODULE_T4 = REGISTRATE.item("rocket_data_module_t4", ComponentItem::create)
            .lang("Rocket Data Module T4")
            .properties(p -> p.stacksTo(1))
            .tag(MBECustomTags.ROCKET_DATA_MODULE)
            .register();
    public static final ItemEntry<ComponentItem> ROCKET_DATA_MODULE_T5 = REGISTRATE.item("rocket_data_module_t5", ComponentItem::create)
            .lang("Rocket Data Module T5")
            .properties(p -> p.stacksTo(1))
            .tag(MBECustomTags.ROCKET_DATA_MODULE)
            .register();
    public static final ItemEntry<ComponentItem> ROCKET_DATA_MODULE_T6 = REGISTRATE.item("rocket_data_module_t6", ComponentItem::create)
            .lang("Rocket Data Module T6")
            .properties(p -> p.stacksTo(1))
            .tag(MBECustomTags.ROCKET_DATA_MODULE)
            .register();
    public static final ItemEntry<ComponentItem> ROCKET_DATA_MODULE_T7 = REGISTRATE.item("rocket_data_module_t7", ComponentItem::create)
            .lang("Rocket Data Module T7")
            .properties(p -> p.stacksTo(1))
            .tag(MBECustomTags.ROCKET_DATA_MODULE)
            .register();

    private static ItemEntry<StorageComponentItem> AEComponent(int kb) {
        return REGISTRATE.item("cell_component_" + kb + "k", p -> new StorageComponentItem(p, kb * 1024)).register();
    }

    private static ItemEntry<BasicStorageCell> AEItemStorageCell(int tier, ItemEntry<StorageComponentItem> StorageComponent) {
        return REGISTRATE.item("item_storage_cell_" + tier + "k", p -> new BasicStorageCell(p.stacksTo(1), StorageComponent, ADVANCED_ITEM_CELL_HOUSING, 3 + 0.5 * Math.log(tier) / Math.log(4), tier, 1, 63, AEKeyType.items())).register();
    }

    private static ItemEntry<BasicStorageCell> AEFluidStorageCell(int tier, ItemEntry<StorageComponentItem> StorageComponent) {
        return REGISTRATE.item("fluid_storage_cell_" + tier + "k", p -> new BasicStorageCell(p.stacksTo(1), StorageComponent, ADVANCED_FLUID_CELL_HOUSING, 3 + 0.5 * Math.log(tier) / Math.log(4), tier, 1, 18, AEKeyType.fluids())).register();
    }

    private static ItemEntry<AdvancedStorageCell> AEAdvancedItemStorageCell(int tier) {
        return REGISTRATE.item("item_storage_cell_" + tier + "k", p -> new AdvancedStorageCell(p.stacksTo(1), ADVANCED_ITEM_CELL_HOUSING, 3 + 0.5 * Math.log(tier) / Math.log(4), tier, 1, 32, AEKeyType.items())).register();
    }

    private static ItemEntry<AdvancedStorageCell> AEAdvancedFluidStorageCell(int tier) {
        return REGISTRATE.item("fluid_storage_cell_" + tier + "k", p -> new AdvancedStorageCell(p.stacksTo(1), ADVANCED_FLUID_CELL_HOUSING, 3 + 0.5 * Math.log(tier) / Math.log(4), tier, 1, 9, AEKeyType.fluids())).register();
    }

    public static <T extends ComponentItem> NonNullConsumer<T> attach(IItemComponent... components) {
        return item -> item.attachComponents(components);
    }

    public static void init() {}
}
