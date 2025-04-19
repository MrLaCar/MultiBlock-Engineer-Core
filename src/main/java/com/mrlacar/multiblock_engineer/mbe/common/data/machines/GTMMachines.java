package com.mrlacar.multiblock_engineer.mbe.common.data.machines;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes;

import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerLaserHatch;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerSimpleMachines;

public class GTMMachines {

    public static final MachineDefinition[] LASER_INPUT_HATCH_16384 = registerLaserHatch(IO.IN, 16384, PartAbility.INPUT_LASER);
    public static final MachineDefinition[] LASER_OUTPUT_HATCH_16384 = registerLaserHatch(IO.OUT, 16384, PartAbility.OUTPUT_LASER);
    public static final MachineDefinition[] LASER_INPUT_HATCH_65536 = registerLaserHatch(IO.IN, 65536, PartAbility.INPUT_LASER);
    public static final MachineDefinition[] LASER_OUTPUT_HATCH_65536 = registerLaserHatch(IO.OUT, 65536, PartAbility.OUTPUT_LASER);
    public static final MachineDefinition[] LASER_INPUT_HATCH_262144 = registerLaserHatch(IO.IN, 262144, PartAbility.INPUT_LASER);
    public static final MachineDefinition[] LASER_OUTPUT_HATCH_262144 = registerLaserHatch(IO.OUT, 262144, PartAbility.OUTPUT_LASER);
    public static final MachineDefinition[] LASER_INPUT_HATCH_1048576 = registerLaserHatch(IO.IN, 1048576, PartAbility.INPUT_LASER);
    public static final MachineDefinition[] LASER_OUTPUT_HATCH_1048576 = registerLaserHatch(IO.OUT, 1048576, PartAbility.OUTPUT_LASER);

    public final static MachineDefinition[] MASS_FABRICATOR = registerSimpleMachines("mass_fabricator",
            MBERecipeTypes.MASS_FABRICATOR, tier -> (int) (tier * 2000L), false, 7, 8, 9);

    public static void init() {}

}
