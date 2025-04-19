package com.mrlacar.multiblock_engineer.mbe.common.data.machines;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;

import static com.hepdd.gtmthings.data.WirelessMachines.WIRELL_ENERGY_HIGH_TIERS;
import static com.hepdd.gtmthings.data.WirelessMachines.registerWirelessLaserHatch;

public class GTMTMachines {

    public static final MachineDefinition[] WIRELESS_ENERGY_INPUT_HATCH_262144A = registerWirelessLaserHatch(IO.IN,262144,PartAbility.INPUT_LASER,WIRELL_ENERGY_HIGH_TIERS);
    public static final MachineDefinition[] WIRELESS_ENERGY_OUTPUT_HATCH_262144A = registerWirelessLaserHatch(IO.OUT,262144,PartAbility.OUTPUT_LASER, WIRELL_ENERGY_HIGH_TIERS);
    public static final MachineDefinition[] WIRELESS_ENERGY_INPUT_HATCH_1048576A = registerWirelessLaserHatch(IO.IN,1048576,PartAbility.INPUT_LASER,WIRELL_ENERGY_HIGH_TIERS);
    public static final MachineDefinition[] WIRELESS_ENERGY_OUTPUT_HATCH_1048576A = registerWirelessLaserHatch(IO.OUT,1048576,PartAbility.OUTPUT_LASER, WIRELL_ENERGY_HIGH_TIERS);

    public static void init() {}
}
