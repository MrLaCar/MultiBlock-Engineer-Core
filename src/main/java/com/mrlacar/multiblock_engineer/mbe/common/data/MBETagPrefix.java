package com.mrlacar.multiblock_engineer.mbe.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

public class MBETagPrefix {

    public static final TagPrefix unstable_ultra_dense_metal_ball = new TagPrefix("unstable_ultra_dense_metal_ball")
            .idPattern("%s_unstable_ultra_dense_metal_ball")
            .defaultTagPath("unstable_ultra_dense_metal_ball/%s")
            .unformattedTagPath("unstable_ultra_dense_metal_ball")
            .langValue(" %s unstable_ultra_dense_metal_ball")
            .materialAmount(GTValues.M)
            .materialIconType(new MaterialIconType("unstable_ultra_dense_metal_ball"))
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(MBEMaterialFlags.GENERATE_UNSTABLE_ULTRA_DENSE_METAL_BALL));

    public static void init() {}
}
