package com.mrlacar.multiblock_engineer.mbe.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.client.renderer.cover.*;
import com.gregtechceu.gtceu.common.cover.ConveyorCover;
import com.gregtechceu.gtceu.common.cover.FluidRegulatorCover;
import com.gregtechceu.gtceu.common.cover.PumpCover;
import com.gregtechceu.gtceu.common.cover.RobotArmCover;
import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;
import net.minecraft.resources.ResourceLocation;

public class MBECovers {
    public static class CoverInfo {
        public ResourceLocation id;
        public CoverDefinition definition;

        CoverInfo(String id, CoverDefinition.TieredCoverBehaviourProvider behavior, ICoverRenderer renderer) {
            this.id = MultiBlock_Engineer.id(id);
            this.definition = register(id, behavior, renderer);
        }
    };

    public static CoverInfo PUMP_MAX = new CoverInfo(
            "pump", PumpCover::new, PumpCoverRenderer.INSTANCE
    );
    public static CoverInfo FLUID_REGULATOR_MAX = new CoverInfo(
            "fluid_regulator", FluidRegulatorCover::new, FluidRegulatorCoverRenderer.INSTANCE
    );
    public static CoverInfo CONVEYOR_MAX = new CoverInfo(
            "conveyor", ConveyorCover::new, ConveyorCoverRenderer.INSTANCE
    );
    public static CoverInfo ROBOT_ARM_MAX = new CoverInfo(
            "robot_arm", RobotArmCover::new, RobotArmCoverRenderer.INSTANCE
    );

    public static CoverDefinition register(
            String id,
            CoverDefinition.TieredCoverBehaviourProvider behavior,
            ICoverRenderer renderer
    ) {
        var definition = new CoverDefinition(MultiBlock_Engineer.id(id),
                (def, coverable, side) -> behavior.create(def, coverable, side, GTValues.MAX),
                renderer);

        return definition;
    }
}
