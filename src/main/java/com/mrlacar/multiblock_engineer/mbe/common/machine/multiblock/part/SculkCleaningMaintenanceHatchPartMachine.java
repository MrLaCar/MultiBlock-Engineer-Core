package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.part;

import com.google.common.collect.ImmutableSet;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.ICleanroomReceiver;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.ICleanroomProvider;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.machine.multiblock.DummyCleanroom;
import com.gregtechceu.gtceu.common.machine.multiblock.part.AutoMaintenanceHatchPartMachine;
import com.mrlacar.multiblock_engineer.mbe.api.machine.multiblock.MBECleanroomType;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;

import java.util.Set;

public class SculkCleaningMaintenanceHatchPartMachine extends AutoMaintenanceHatchPartMachine {

    private static final Set<CleanroomType> SCULK_CLEANROOM = new ObjectOpenHashSet<>();

    static {
        SCULK_CLEANROOM.add(MBECleanroomType.SCULK_CLEANROOM);
    }

    public static final ICleanroomProvider SCULK_DUMMY_CLEANROOM = DummyCleanroom.createForTypes(SCULK_CLEANROOM);

    public SculkCleaningMaintenanceHatchPartMachine(IMachineBlockEntity metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    public void addedToController(IMultiController controller) {
        super.addedToController(controller);
        if (controller instanceof ICleanroomReceiver receiver) {
            receiver.setCleanroom(SCULK_DUMMY_CLEANROOM);
        }
    }

    @Override
    public void removedFromController(IMultiController controller) {
        super.removedFromController(controller);
        if (controller instanceof ICleanroomReceiver receiver && receiver.getCleanroom() == SCULK_DUMMY_CLEANROOM) {
            receiver.setCleanroom(null);
        }
    }

    public static ImmutableSet<CleanroomType> getCleanroomTypes(ICleanroomProvider p) {
        return ImmutableSet.copyOf(p.getTypes());
    }

    @Override
    public int getTier() {
        return GTValues.UV;
    }
}
