package com.mrlacar.multiblock_engineer.mbe.data.recipe;

import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.LV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.*;

public class SpaceCircuitAssemblyLineRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {

        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("basic_electronic_circuit_scal")
                .inputItems(BASIC_CIRCUIT_BOARD)
                .inputItems(CustomTags.RESISTORS, 2)
                .inputItems(wireGtSingle, RedAlloy, 2)
                .inputItems(CustomTags.ULV_CIRCUITS, 2)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(ELECTRONIC_CIRCUIT_LV, 2)
                .duration(200)
                .EUt(VA[LV])
                .addData("SAMTier", 1)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("basic_integrated_circuit_scal")
                .inputItems(BASIC_CIRCUIT_BOARD)
                .inputItems(INTEGRATED_LOGIC_CIRCUIT)
                .inputItems(CustomTags.RESISTORS, 2)
                .inputItems(CustomTags.DIODES, 2)
                .inputItems(wireFine, Copper, 2)
                .inputItems(bolt, Tin, 2)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(INTEGRATED_CIRCUIT_LV, 2)
                .duration(200)
                .EUt(VA[LV])
                .addData("SAMTier", 1)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("microchip_processor_scal")
                .inputItems(PLASTIC_CIRCUIT_BOARD)
                .inputItems(SYSTEM_ON_CHIP)
                .inputItems(wireFine, Copper, 2)
                .inputItems(bolt, Tin, 2)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(MICROPROCESSOR_LV, 6)
                .duration(50)
                .EUt(600)
                .addData("SAMTier", 1)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("good_electronic_circuit_scal")
                .inputItems(GOOD_CIRCUIT_BOARD)
                .inputItems(CustomTags.LV_CIRCUITS, 2)
                .inputItems(CustomTags.DIODES, 2)
                .inputItems(wireGtSingle, Copper, 2)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(ELECTRONIC_CIRCUIT_MV)
                .duration(300)
                .EUt(30)
                .addData("SAMTier", 2)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("good_integrated_circuit_scal")
                .inputItems(GOOD_CIRCUIT_BOARD)
                .inputItems(INTEGRATED_CIRCUIT_LV)
                .inputItems(CustomTags.RESISTORS, 2)
                .inputItems(CustomTags.DIODES, 2)
                .inputItems(wireFine, Gold, 4)
                .inputItems(bolt, Silver, 4)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(INTEGRATED_CIRCUIT_MV, 2)
                .duration(400)
                .EUt(24)
                .addData("SAMTier", 2)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("micro_processor_scal")
                .inputItems(PLASTIC_CIRCUIT_BOARD)
                .inputItems(SYSTEM_ON_CHIP)
                .inputItems(wireFine, RedAlloy, 4)
                .inputItems(bolt, AnnealedCopper, 4)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(PROCESSOR_MV, 4)
                .duration(50)
                .EUt(2400)
                .addData("SAMTier", 2)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("advanced_integrated_circuit_scal")
                .inputItems(INTEGRATED_CIRCUIT_MV)
                .inputItems(INTEGRATED_LOGIC_CIRCUIT, 2)
                .inputItems(RANDOM_ACCESS_MEMORY, 2)
                .inputItems(CustomTags.TRANSISTORS, 4)
                .inputItems(wireFine, Electrum, 8)
                .inputItems(bolt, AnnealedCopper, 8)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(INTEGRATED_CIRCUIT_HV)
                .duration(800)
                .EUt(30)
                .addData("SAMTier", 3)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("micro_processor_assembly_scal")
                .inputItems(PLASTIC_CIRCUIT_BOARD)
                .inputItems(PROCESSOR_MV, 2)
                .inputItems(CustomTags.INDUCTORS, 4)
                .inputItems(CustomTags.CAPACITORS, 8)
                .inputItems(RANDOM_ACCESS_MEMORY, 4)
                .inputItems(wireFine, RedAlloy, 8)
                .inputFluids(SolderingAlloy.getFluid(144))
                .outputItems(PROCESSOR_ASSEMBLY_HV)
                .duration(400)
                .EUt(120)
                .addData("SAMTier", 3)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("nano_processor_scal")
                .inputItems(ADVANCED_CIRCUIT_BOARD)
                .inputItems(ADVANCED_SYSTEM_ON_CHIP)
                .inputItems(wireFine, Electrum, 4)
                .inputItems(bolt, Platinum, 4)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(NANO_PROCESSOR_HV, 4)
                .duration(50)
                .EUt(9600)
                .addData("SAMTier", 3)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("micro_processor_computer_scal")
                .inputItems(PLASTIC_CIRCUIT_BOARD)
                .inputItems(PROCESSOR_ASSEMBLY_HV, 2)
                .inputItems(CustomTags.DIODES, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 4)
                .inputItems(wireFine, Electrum, 16)
                .inputItems(bolt, BlueAlloy, 16)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(WORKSTATION_EV, 4)
                .duration(400)
                .EUt(120)
                .addData("SAMTier", 4)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("nano_processor_assembly_scal")
                .inputItems(ADVANCED_CIRCUIT_BOARD)
                .inputItems(NANO_PROCESSOR_HV, 2)
                .inputItems(ADVANCED_SMD_INDUCTOR, 1)
                .inputItems(ADVANCED_SMD_CAPACITOR, 2)
                .inputItems(RANDOM_ACCESS_MEMORY, 8)
                .inputItems(wireFine, Electrum, 16)
                .inputFluids(SolderingAlloy.getFluid(144))
                .outputItems(NANO_PROCESSOR_ASSEMBLY_EV, 4)
                .duration(200)
                .EUt(600)
                .addData("SAMTier", 4)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("quantum_processor_scal")
                .inputItems(EXTREME_CIRCUIT_BOARD)
                .inputItems(ADVANCED_SYSTEM_ON_CHIP)
                .inputItems(wireFine, Platinum, 12)
                .inputItems(bolt, NiobiumTitanium, 8)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(QUANTUM_PROCESSOR_EV, 4)
                .duration(50)
                .EUt(38400)
                .addData("SAMTier", 4)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("micro_processor_mainframe_scal")
                .inputItems(frameGt, Aluminium, 2)
                .inputItems(WORKSTATION_EV, 2)
                .inputItems(ADVANCED_SMD_INDUCTOR, 2)
                .inputItems(ADVANCED_SMD_CAPACITOR, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 16)
                .inputItems(wireGtSingle, AnnealedCopper, 16)
                .inputFluids(SolderingAlloy.getFluid(288))
                .outputItems(MAINFRAME_IV)
                .duration(400)
                .EUt(480)
                .addData("SAMTier", 5)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("nano_processor_computer_scal")
                .inputItems(ADVANCED_CIRCUIT_BOARD)
                .inputItems(NANO_PROCESSOR_ASSEMBLY_EV, 2)
                .inputItems(ADVANCED_SMD_DIODE, 2)
                .inputItems(NOR_MEMORY_CHIP, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 16)
                .inputItems(wireFine, Electrum, 16)
                .inputFluids(SolderingAlloy.getFluid(144))
                .outputItems(NANO_COMPUTER_IV)
                .duration(200)
                .EUt(600)
                .addData("SAMTier", 5)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("quantum_processor_assembly_scal")
                .inputItems(EXTREME_CIRCUIT_BOARD)
                .inputItems(QUANTUM_PROCESSOR_EV, 2)
                .inputItems(ADVANCED_SMD_INDUCTOR, 2)
                .inputItems(ADVANCED_SMD_CAPACITOR, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 16)
                .inputItems(wireFine, Platinum, 16)
                .inputFluids(SolderingAlloy.getFluid(144))
                .outputItems(QUANTUM_ASSEMBLY_IV)
                .duration(200)
                .EUt(2400)
                .addData("SAMTier", 5)
                .save(provider);
        SPACE_CIRCUIT_ASSEMBLY_LINE.recipeBuilder("crystal_processor_scal")
                .inputItems(ELITE_CIRCUIT_BOARD)
                .inputItems(CRYSTAL_SYSTEM_ON_CHIP)
                .inputItems(wireFine, NiobiumTitanium, 8)
                .inputItems(bolt, YttriumBariumCuprate, 8)
                .inputFluids(SolderingAlloy.getFluid(72))
                .outputItems(CRYSTAL_PROCESSOR_IV)
                .duration(100)
                .EUt(8600)
                .addData("SAMTier", 5)
                .save(provider);

    }
}
