package com.mrlacar.multiblock_engineer.mbe.api.data;

import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MBECustomTags {

    public static final TagKey<Block> MINEABLE_WITH_WRENCH = TagUtil.createBlockTag("mineable/wrench");

    public static final TagKey<Item> UEV_BATTERIES = TagUtil.createModItemTag("batteries/uev");
    public static final TagKey<Item> UIV_BATTERIES = TagUtil.createModItemTag("batteries/uiv");
    public static final TagKey<Item> UXV_BATTERIES = TagUtil.createModItemTag("batteries/uxv");
    public static final TagKey<Item> OpV_BATTERIES = TagUtil.createModItemTag("batteries/opv");
    public static final TagKey<Item> MAX_BATTERIES = TagUtil.createModItemTag("batteries/max");

    public static final TagKey<Item> ROCKET_DATA_MODULE = TagUtil.createModItemTag("rocket_data_module");

    public static final TagKey<Item> TIER_8_ROCKET_FUEL = TagUtil.createModItemTag("tier_8_rocket_fuel");
}
