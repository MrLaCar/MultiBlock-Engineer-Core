package com.mrlacar.multiblock_engineer.mbe.api.machine.multiblock;

import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;

import java.util.HashSet;
import java.util.Set;

public class MBEPartAbility {

    public static final PartAbility RADIOACTIVE_SOURCE_HATCH = new PartAbility("radioactive_source_hatch");
    public static final PartAbility INCUBATOR_INGREDIENT_HATCH = new PartAbility("incubator_ingredient_hatch");
    public static final PartAbility COSMIC_RADIATION_SIMULATION_HATCH = new PartAbility("cosmic_radiation_simulation_hatch");

    private final Int2ObjectMap<Set<Block>> registry = new Int2ObjectOpenHashMap<>();
    private final String name;

    public MBEPartAbility(String name) {
        this.name = name;
    }

    public void register(int tier, Block block) {
        registry.computeIfAbsent(tier, T -> new HashSet<>()).add(block);
    }

    public String getName() {
        return this.name;
    }
}
