package com.mrlacar.multiblock_engineer.mbe.common.data;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class MBEFoods {

    public final static FoodProperties LUCKY_APPLE = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 6000, 1), 1F)
            .alwaysEat().nutrition(4).saturationMod(9.6F).build();

    public static void init() {}
}
