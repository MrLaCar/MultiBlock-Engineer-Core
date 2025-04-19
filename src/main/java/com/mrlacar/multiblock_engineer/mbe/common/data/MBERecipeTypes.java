package com.mrlacar.multiblock_engineer.mbe.common.data;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.sound.ExistingSoundEntry;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.integration.xei.handlers.item.CycleItemStackHandler;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class MBERecipeTypes {

    public static final GTRecipeType CIRCUIT_RECIPE = GTRecipeTypes.register("circuit_recipe", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1, 0, 0, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType CIRCUIT_RECIPE_GENERATOR = GTRecipeTypes.register("circuit_recipe_generator", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1, 0, 0, 0)
            .setEUIO(IO.OUT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType MASS_FABRICATOR = GTRecipeTypes.register("mass_fabricator", GTRecipeTypes.ELECTRIC)
            .setMaxIOSize(1, 0, 0, 1)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.COOLING)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType SUBSTANCE_COMPRESSOR = GTRecipeTypes.register("substance_compressor", GTRecipeTypes.ELECTRIC)
            .setMaxIOSize(0, 1, 1, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.COOLING)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType MATRIX_WORKBENCH = GTRecipeTypes.register("matrix_workbench", GTRecipeTypes.ELECTRIC)
            .setMaxIOSize(25, 1, 0, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType GREENHOUSE = GTRecipeTypes.register("greenhouse", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1, 9, 1, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.BOILER)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType ELECTRIC_IMPLOSION_COMPRESSOR = GTRecipeTypes.register("electric_implosion_compressor", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(3, 2, 0, 0).setEUIO(IO.IN)
            .prepareBuilder(recipeBuilder -> recipeBuilder.duration(20).EUt(GTValues.VA[GTValues.LV]))
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(new ExistingSoundEntry(SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS));

    public static final GTRecipeType GENERAL_CIRCUIT_CONVERTER = GTRecipeTypes.register("general_circuit_converter", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1, 1, 0, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType COMPONENT_FACTORY = GTRecipeTypes.register("component_factory", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(17, 1, 4, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ASSEMBLY_LINE, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType ELEMENT_EXTRACTOR = GTRecipeTypes.register("element_extractor", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(2, 2, 2, 2)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.COOLING)
            .addDataInfo(data -> LocalizationUtils.format("mbe.recipe.crt", data.getInt("crt")))
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType PHLOGISTON_FUSION_FORGE = GTRecipeTypes.register("phlogiston_fusion_forge", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(12, 0, 4, 4)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ARC)
            .addDataInfo(data -> {
                int temp = data.getInt("ebf_temp");
                return LocalizationUtils.format("gtceu.recipe.temperature", temp);
            })
            .addDataInfo(data -> {
                int temp = data.getInt("ebf_temp");
                ICoilType requiredCoil = ICoilType.getMinRequiredType(temp);

                if (requiredCoil != null && requiredCoil.getMaterial() != null) {
                    return LocalizationUtils.format("gtceu.recipe.coil.tier",
                            I18n.get(requiredCoil.getMaterial().getUnlocalizedName()));
                }
                return "";
            })
            .setUiBuilder((recipe, widgetGroup) -> {
                int temp = recipe.data.getInt("ebf_temp");
                List<List<ItemStack>> items = new ArrayList<>();
                items.add(GTCEuAPI.HEATING_COILS.entrySet().stream()
                        .filter(coil -> coil.getKey().getCoilTemperature() >= temp)
                        .map(coil -> new ItemStack(coil.getValue().get())).toList());
                widgetGroup.addWidget(new SlotWidget(new CycleItemStackHandler(items), 0,
                        widgetGroup.getSize().width - 25, widgetGroup.getSize().height - 32, false, false));
            })
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType LARGE_MASS_FABRICATOR = GTRecipeTypes.register("large_mass_fabricator", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(2, 0, 1, 1)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.COOLING)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType ULTRA_PRECISION_MATTER_PROCESSOR = GTRecipeTypes.register("ultra_precision_matter_processor", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(16, 16, 16, 16)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.CHEMICAL)
            .addDataInfo(data -> LocalizationUtils.format("mbe.recipe.ifr_tier", data.getInt("IFRTier")))
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType IMAGINARY_ENGINE_COMPUTER = GTRecipeTypes.register("imaginary_engine_computer", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(2, 0, 1, 1)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.COMPUTATION);

    public static final GTRecipeType MICRO_STAR_COLLAPSE_SIMULATOR = GTRecipeTypes.register("micro_star_collapse_simulator", GTRecipeTypes.GENERATOR)
            .setMaxIOSize(1, 0, 2, 2)
            .setEUIO(IO.OUT)
            .setSound(GTSoundEntries.ARC);

    public static final GTRecipeType DIMENSION_PENETRATOR = GTRecipeTypes.register("dimension_penetrator", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(2, 72, 1, 18)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ARC);

    public static final GTRecipeType STAR_TOWER = GTRecipeTypes.register("star_tower", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1, 0, 0, 1)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.COMPUTATION);

    public static final GTRecipeType WARPING_STATION = GTRecipeTypes.register("warping_station", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1, 1, 0, 0)
            .setEUIO(IO.IN);

    public static final GTRecipeType LARGE_ELEMENT_REPLICATOR = GTRecipeTypes.register("large_element_replicator", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1, 1, 2, 1)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.REPLICATOR)
            .setProgressBar(GuiTextures.PROGRESS_BAR_REPLICATOR, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType SPACE_CIRCUIT_ASSEMBLY_LINE = GTRecipeTypes.register("space_circuit_assembly_line", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(16, 1, 4, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER)
            .addDataInfo(data -> LocalizationUtils.format("mbe.recipe.space_assembly_module_tier", data.getInt("SAMTier")))
            .setProgressBar(GuiTextures.PROGRESS_BAR_ASSEMBLY_LINE, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType SPACE_ASSEMBLY_PLANT = GTRecipeTypes.register("space_assembly_plant", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(18, 4, 6, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER)
            .addDataInfo(data -> LocalizationUtils.format("mbe.recipe.space_assembly_module_tier", data.getInt("SAMTier")))
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType RADIOACTIVE_INCUBATOR = GTRecipeTypes.register("radioactive_incubator", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(7, 0, 3, 1)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.CHEMICAL)
            .addDataInfo(data -> LocalizationUtils.format("mbe.recipe.sv", data.getInt("Sv")))
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType ADVANCED_ROCKET_ASSEMBLY_LINE = GTRecipeTypes.register("advanced_rocket_assembly_line", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(30, 1, 4, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType ORE_PROCESSOR = GTRecipeTypes.register("ore_processor", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(3, 9, 3, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.MACERATOR)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType STAR_VEIN_DIGGER = GTRecipeTypes.register("star_vein_digger", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1, 1, 0, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.MINER)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType DIMENSIONALLY_TRANSCENDENT_FIELD_COMPRESS_HAMMER = GTRecipeTypes.register("dimensionally_transcendent_field_compress_hammer", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1, 1, 0, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ARC)
            .setProgressBar(GuiTextures.PROGRESS_BAR_HAMMER, ProgressTexture.FillDirection.UP_TO_DOWN);

    public static final GTRecipeType PCB_FACTORY = GTRecipeTypes.register("pcb_factory", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(6, 9, 3, 0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .addDataInfo(data -> LocalizationUtils.format("mbe.recipe.pcb_tier", data.getInt("pcb_tier")))
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType SUPERCRITICAL_PHASE_SHIFT = GTRecipeTypes.register("supercritical_phase_shift", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(0, 0, 2, 0)
            .setEUIO(IO.IN)
            .setSound(MBESoundEntries.SPS)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType SUPERCRITICAL_PHASE_SYNTHESIS = GTRecipeTypes.register("supercritical_phase_synthesis", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(0, 0, 1, 1)
            .setEUIO(IO.IN)
            .setSound(new ExistingSoundEntry(SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS))
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType DYSON_SPHERE_DEPLOYMENT_BASE_STATION = GTRecipeTypes.register("dyson_sphere_deployment_base_station", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1, 0, 0, 0)
            .setEUIO(IO.OUT)
            .setSound(MBESoundEntries.SPS)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType MULTIVERSE_DISORDER_POINT = GTRecipeTypes.register("multiverse_disorder_point", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(9, 8, 8, 8)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.CHEMICAL)
            .addDataInfo(data -> LocalizationUtils.format("mbe.recipe.mdp_tier", data.getInt("MDPTier")))
            .addDataInfo(data -> LocalizationUtils.format("mbe.recipe.ss_tier", getSSTier(data.getInt("SSTier"))))
            .addDataInfo(data -> LocalizationUtils.format("mbe.recipe.dp_heat", data.getInt("DPHeat")))
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static String getSSTier(int tier) {
        return switch (tier) {
            default -> I18n.get("mbe.ss_tier.1");
            case 2 -> I18n.get("mbe.ss_tier.2");
            case 3 -> I18n.get("mbe.ss_tier.3");
            case 4 -> I18n.get("mbe.ss_tier.4");
        };
    }

    public static void init() {}
}
