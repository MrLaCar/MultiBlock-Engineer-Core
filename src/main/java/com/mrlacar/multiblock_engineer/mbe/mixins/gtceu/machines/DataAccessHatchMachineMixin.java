package com.mrlacar.multiblock_engineer.mbe.mixins.gtceu.machines;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DataAccessHatchMachine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DataAccessHatchMachine.class)
public abstract class DataAccessHatchMachineMixin extends TieredPartMachine {

    public DataAccessHatchMachineMixin(IMachineBlockEntity holder, int tier) {
        super(holder, tier);
    }

    @Overwrite(remap = false)
    protected int getInventorySize() {
        if (getTier() == GTValues.EV) {
            return 9;
        } else if (getTier() == GTValues.LuV) {
            return 16;
        } else {
            return 25;
        }
    }
}
