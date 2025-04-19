package com.mrlacar.multiblock_engineer.mbe.api.machine;

import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;

import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.standardOC;
import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.subTickParallelOC;

public interface MBEOverclockingLogic {

    static OverclockingLogic create(double durationFactor, double voltageFactor, boolean subtick) {
        if (subtick) return (params, maxV) -> subTickParallelOC(params, maxV, durationFactor, voltageFactor);
        else return (params, maxV) -> standardOC(params, maxV, durationFactor, voltageFactor);
    }

    OverclockingLogic NONE_OVERCLOCK = create(1, 1, true);
}
