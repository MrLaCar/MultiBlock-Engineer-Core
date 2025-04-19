package com.mrlacar.multiblock_engineer.mbe.common.block;

import com.gregtechceu.gtceu.api.block.IFusionCasingType;
import com.gregtechceu.gtceu.common.block.FusionCasingBlock;
import net.minecraft.world.level.block.Block;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMaterialBlocks.MATERIAL_BLOCKS;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class MBECompressedFusionReactorCasingBlocks {

    public static Block FrameBlock(int tier) {

        return switch (tier) {
            case LuV -> MATERIAL_BLOCKS.get(frameGt, Osmiridium).get();
            case ZPM -> MATERIAL_BLOCKS.get(frameGt, NaquadahAlloy).get();
            case UV -> MATERIAL_BLOCKS.get(frameGt, Trinium).get();
            default -> MATERIAL_BLOCKS.get(frameGt, Osmiridium).get();
        };
    }

    public static Block CasingBlock(int tier) {
        return switch (tier) {
            case LuV -> FUSION_CASING.get();
            case ZPM -> FUSION_CASING_MK2.get();
            case UV -> FUSION_CASING_MK3.get();
            default -> FUSION_CASING.get();
        };
    }

    public static IFusionCasingType CasingType(int tier) {
        return switch (tier) {
            case LuV -> FusionCasingBlock.CasingType.FUSION_CASING;
            case ZPM -> FusionCasingBlock.CasingType.FUSION_CASING_MK2;
            case UV -> FusionCasingBlock.CasingType.FUSION_CASING_MK3;
            default -> FusionCasingBlock.CasingType.FUSION_CASING;
        };
    }
}
