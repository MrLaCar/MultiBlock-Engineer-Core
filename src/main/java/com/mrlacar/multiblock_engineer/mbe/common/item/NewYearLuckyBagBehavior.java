package com.mrlacar.multiblock_engineer.mbe.common.item;

import com.gregtechceu.gtceu.api.item.component.IInteractionItem;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.gregtechceu.gtceu.common.data.GTItems.CREDIT_NEUTRONIUM;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.LUCKY_APPLE;

public class NewYearLuckyBagBehavior implements IInteractionItem {

    @Override
    public InteractionResultHolder<ItemStack> use(Item item, Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);

        var credit = CREDIT_NEUTRONIUM.asStack((int) Mth.nextDouble(RandomSource.create(), 1, 8));
        var apple = LUCKY_APPLE.asStack((int) Mth.nextDouble(RandomSource.create(), 1, 8));

        if (!player.isCreative()) {
            itemstack.shrink(1);
        }

        if (player != null) {
            if (!player.getInventory().add(credit)) {
                player.drop(credit, true);
            }
            if (!player.getInventory().add(apple)) {
                player.drop(apple, true);
            }
        }
        return InteractionResultHolder.success(itemstack);
    }
}
