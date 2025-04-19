package com.mrlacar.multiblock_engineer.mbe.common.block;

import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.AlloyMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.*;

public class MBECoilBlocks {

    public enum CoilType implements StringRepresentable, ICoilType {

        STELLAR_ALLOY("stellar_alloy", 11580, 8, 16, 8, () -> StellarAlloy, MultiBlock_Engineer.id("block/coils/stellar_alloy_coil")),
        OMTERIUM("omterium", 12930, 9, 32, 8, () -> Omterium, MultiBlock_Engineer.id("block/coils/omterium_coil")),
        STRUCTURAL_STEEL_5297("structural_steel_5297", 14530, 10, 32, 8, () -> StructuralSteel5297, MultiBlock_Engineer.id("block/coils/structural_steel_5297_coil")),
        QUANTUM_ALLOY("quantum_alloy", 16220, 10, 64, 8, () -> QuantumAlloy, MultiBlock_Engineer.id("block/coils/quantum_alloy_coil")),
        PRIMARY_SUBSTANCE("primary_substance", 18020, 10, 64, 8, () -> PrimarySubstance, MultiBlock_Engineer.id("block/coils/primary_substance_coil")),
        INFINITY("infinity", 20046, 10, 128, 8, () -> Infinity, MultiBlock_Engineer.id("block/coils/infinity_coil"));

        @NotNull
        @Getter
        private final String name;
        @Getter
        private final int coilTemperature;
        @Getter
        private final int tier;
        @Getter
        private final int level;
        @Getter
        private final int energyDiscount;
        @NotNull
        private final Supplier<Material> material;
        @NotNull @Getter
        private final ResourceLocation texture;

        CoilType(String name, int coilTemperature, int tier, int level, int energyDiscount, Supplier<Material> material, ResourceLocation texture) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.tier = tier;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.material = material;
            this.texture = texture;
        }


        public Material getMaterial() {
            return material.get();
        }

        @NotNull
        @Override
        public String toString() {
            return getName();
        }

        @Override
        @NotNull
        public String getSerializedName() {
            return name;
        }
        }
}
