package com.mrlacar.multiblock_engineer.mbe.api.pattern.util;

import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.error.PatternStringError;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.function.Supplier;

public class MBEPredicates {

    public static TraceabilityPredicate ActiveTierPartBlock(Map<Integer, Supplier<ActiveBlock>> map, String partTier) {
        return new TraceabilityPredicate(blockWorldState -> {
            var blockState = blockWorldState.getBlockState();
            for (var entry : map.entrySet()) {
                if (blockState.is(entry.getValue().get())) {
                    var stats = entry.getKey();
                    Object currentPart = blockWorldState.getMatchContext().getOrPut(partTier, stats);
                    if (!currentPart.equals(stats)) {
                        blockWorldState.setError(new PatternStringError("mbe.multiblock.part_tier"));
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }, () -> map.values().stream()
                .map(blockSupplier -> BlockInfo.fromBlockState(blockSupplier.get().defaultBlockState()))
                .toArray(BlockInfo[]::new))
                .addTooltips(Component.translatable("mbe.multiblock.part_tier"));
    }

    public static TraceabilityPredicate CasingTierBlock(Map<Integer, Supplier<Block>> map, String casingTier) {
        return new TraceabilityPredicate(blockWorldState -> {
            var blockState = blockWorldState.getBlockState();
            for (var entry : map.entrySet()) {
                if (blockState.is(entry.getValue().get())) {
                    var stats = entry.getKey();
                    Object currentPart = blockWorldState.getMatchContext().getOrPut(casingTier, stats);
                    if (!currentPart.equals(stats)) {
                        blockWorldState.setError(new PatternStringError("mbe.multiblock.casing_tier"));
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }, () -> map.values().stream()
                .map(blockSupplier -> BlockInfo.fromBlockState(blockSupplier.get().defaultBlockState()))
                .toArray(BlockInfo[]::new))
                .addTooltips(Component.translatable("mbe.multiblock.casing_tier"));
    }
}
