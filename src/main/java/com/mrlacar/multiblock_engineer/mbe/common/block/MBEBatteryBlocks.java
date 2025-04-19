package com.mrlacar.multiblock_engineer.mbe.common.block;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.multiblock.IBatteryData;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;
public class MBEBatteryBlocks {


    public enum BatteryPartType implements StringRepresentable, IBatteryData {

        EMPTY_TIER_IV,
        UEV_ASCENDANT(GTValues.UEV, Long.MAX_VALUE),
        UIV_SUPREME(GTValues.UIV, Long.MAX_VALUE),
        UXV_MYTHICAL(GTValues.UXV, Long.MAX_VALUE),

        EMPTY_TIER_V,
        OpV_ILLUSORY(GTValues.OpV, Long.MAX_VALUE ),
        MAX_CREATIVE(GTValues.MAX, Long.MAX_VALUE),
        ;

        private final int tier;
        private final long capacity;

        BatteryPartType() {
            this.tier = -1;
            this.capacity = 0;
        }

        BatteryPartType(int tier, long capacity) {
            this.tier = tier;
            this.capacity = capacity;
        }

        @Override
        public int getTier() {
            return tier;
        }

        @Override
        public long getCapacity() {
            return capacity;
        }

        @NotNull
        @Override
        public String getBatteryName() {
            return name().toLowerCase();
        }

        @NotNull
        @Override
        public String getSerializedName() {
            return getBatteryName();
        }
    }
}
