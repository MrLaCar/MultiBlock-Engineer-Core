package com.mrlacar.multiblock_engineer.mbe.common.data;

import com.mrlacar.multiblock_engineer.mbe.client.renderer.item.RotationEffectRenderer;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public class MBEMaterialIconSets extends MaterialIconSet {

    private final ICustomRenderer customRenderer;

    public MBEMaterialIconSets(@NotNull String name, @Nullable MaterialIconSet parentIconSet, boolean isRootIconSet, ICustomRenderer customRenderer) {
        super(name, parentIconSet, isRootIconSet);
        this.customRenderer = customRenderer;
    }

    public static final MaterialIconSet INFINITY = new MaterialIconSet("infinity");
    public static final MaterialIconSet STRANGIUM = new MaterialIconSet("strangium");
    public static final MaterialIconSet PRIMARY_SUBSTANCE = new MaterialIconSet("primary_substance");
    public static final MaterialIconSet SPACETIME = new MaterialIconSet("spacetime");
    public static final MBEMaterialIconSets SINGULARIUM = new MBEMaterialIconSets("singularium", BRIGHT, false, () -> RotationEffectRenderer.INSTANCE);
    public static final MaterialIconSet POLYHEDRAL_STEEL = new MaterialIconSet("polyhedral_steel");
}


