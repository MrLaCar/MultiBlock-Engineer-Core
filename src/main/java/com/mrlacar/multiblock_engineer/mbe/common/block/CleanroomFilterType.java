package com.mrlacar.multiblock_engineer.mbe.common.block;

import com.gregtechceu.gtceu.api.block.IFilterType;

import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.mrlacar.multiblock_engineer.mbe.api.machine.multiblock.MBECleanroomType;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;


public enum CleanroomFilterType implements IFilterType {

    FILTER_CASING_SCULK("sculk_filter_casing", MBECleanroomType.SCULK_CLEANROOM);

    private final String name;
    @Getter
    private final CleanroomType cleanroomType;

    CleanroomFilterType(String name, CleanroomType cleanroomType) {
        this.name = name;
        this.cleanroomType = cleanroomType;
    }

    @NotNull
    @Override
    public String getSerializedName() {
        return this.name;
    }

    @NotNull
    @Override
    public String toString() {
        return getSerializedName();
    }
}
