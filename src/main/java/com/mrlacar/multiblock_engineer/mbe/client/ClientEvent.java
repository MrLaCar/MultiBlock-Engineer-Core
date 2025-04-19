package com.mrlacar.multiblock_engineer.mbe.client;

import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;

import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.NEW_YEAR_LUCKY_BAG;

@Mod.EventBusSubscriber
public class ClientEvent {
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        execute(event, event.getEntity().level(), event.getEntity());
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (Calendar.getInstance().get(Calendar.MONTH) == Calendar.JANUARY && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 1) {
            if (entity instanceof Player player) {
                ItemStack itemStack = new ItemStack(NEW_YEAR_LUCKY_BAG).copy();
                itemStack.setCount((int) Mth.nextDouble(RandomSource.create(), 1, 6));
                ItemHandlerHelper.giveItemToPlayer(player, itemStack);
            }
            if (!world.isClientSide() && world.getServer() != null)
                world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("mbe.message.new_year").getString())), false);
        }
        if (!world.isClientSide() && world.getServer() != null)
            world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("================================================================================"), false);
        if (!world.isClientSide() && world.getServer() != null)
            world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("mbe.message.0").getString())), false);
        if (!world.isClientSide() && world.getServer() != null)
            world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("mbe.message.1").getString())), false);
        if (!world.isClientSide() && world.getServer() != null)
            world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("mbe.message.2").getString())), false);
        if (!world.isClientSide() && world.getServer() != null)
            world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("mbe.message.3").getString())), false);
        if (!world.isClientSide() && world.getServer() != null)
            world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("================================================================================"), false);
    }
}
