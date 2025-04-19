package com.mrlacar.multiblock_engineer.mbe.common.block.ae2;

import appeng.block.crafting.CraftingUnitBlock;
import appeng.block.crafting.ICraftingUnitType;
import com.tterrag.registrate.util.entry.BlockEntry;
import lombok.Getter;
import net.minecraft.world.item.Item;

import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEBlocks.*;

public enum CraftingUnitBlocks implements ICraftingUnitType {

    STORAGE_1024K(1024, "1024k_storage"),
    STORAGE_4096K(4096, "4096k_storage"),
    STORAGE_16384K(16384, "16384k_storage"),
    STORAGE_65536K(65536, "65536k_storage"),
    STORAGE_262144K(262144, "262144k_storage");

    private final int storageKb;
    @Getter
    private final String affix;

    CraftingUnitBlocks(int storageKb, String affix) {
        this.storageKb = storageKb;
        this.affix = affix;
    }

    @Override
    public long getStorageBytes() {
        return 1024L * storageKb;
    }

    @Override
    public int getAcceleratorThreads() {
        return 0;
    }

    public BlockEntry<CraftingUnitBlock> getDefinition() {
        return switch (this) {
            case STORAGE_1024K -> CRAFTING_STORAGE_1024K;
            case STORAGE_4096K -> CRAFTING_STORAGE_4096K;
            case STORAGE_16384K -> CRAFTING_STORAGE_16384K;
            case STORAGE_65536K -> CRAFTING_STORAGE_65536K;
            case STORAGE_262144K -> CRAFTING_STORAGE_262144K;
        };
    }

    @Override
    public Item getItemFromType() {
        return getDefinition().asItem();
    }
}
