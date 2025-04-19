package com.mrlacar.multiblock_engineer.mbe.common.block.ae2;

import appeng.block.crafting.CraftingUnitBlock;
import appeng.block.crafting.ICraftingUnitType;
import com.tterrag.registrate.util.entry.BlockEntry;
import lombok.Getter;
import net.minecraft.world.item.Item;

import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEBlocks.*;

public enum AcceleratorBlocks implements ICraftingUnitType {

    ACCELERATOR_4(4, "4_core_accelerator"),
    ACCELERATOR_16(16, "16_core_accelerator"),
    ACCELERATOR_64(64, "64_core_accelerator"),
    ACCELERATOR_256(256, "256_core_accelerator");

    private final int accelerator;
    @Getter
    private final String affix;

    AcceleratorBlocks(int accelerator, String affix) {
        this.accelerator = accelerator;
        this.affix = affix;
    }

    @Override
    public long getStorageBytes() {
        return 0;
    }

    @Override
    public int getAcceleratorThreads() {
        return accelerator;
    }

    public BlockEntry<CraftingUnitBlock> getDefinition() {
        return switch (this) {
            case ACCELERATOR_4 -> ACCELERATOR_4_CORE;
            case ACCELERATOR_16 -> ACCELERATOR_16_CORE;
            case ACCELERATOR_64 -> ACCELERATOR_64_CORE;
            case ACCELERATOR_256 -> ACCELERATOR_256_CORE;
        };
    }

    @Override
    public Item getItemFromType() {
        return getDefinition().asItem();
    }
}
