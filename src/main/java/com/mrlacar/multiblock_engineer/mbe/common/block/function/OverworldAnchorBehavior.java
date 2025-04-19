package com.mrlacar.multiblock_engineer.mbe.common.block.function;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class OverworldAnchorBehavior {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("mbe:flat"))) {
            if (entity instanceof ServerPlayer player && !player.level().isClientSide()) {
                ResourceKey<Level> destinationType = Level.OVERWORLD;
                if (player.level().dimension() == destinationType)
                    return;
                ServerLevel nextLevel = player.server.getLevel(destinationType);
                if (nextLevel != null) {
                    player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                    player.teleportTo(nextLevel, player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
                    player.connection.send(new ClientboundPlayerAbilitiesPacket(player.getAbilities()));
                    for (MobEffectInstance effectinstance : player.getActiveEffects())
                        player.connection.send(new ClientboundUpdateMobEffectPacket(player.getId(), effectinstance));
                    player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                }
            }
            {
                Entity ent = entity;
                ent.teleportTo(
                        ((entity instanceof ServerPlayer player && !player.level().isClientSide())
                                ? ((player.getRespawnDimension().equals(player.level().dimension()) && player.getRespawnPosition() != null) ? player.getRespawnPosition().getX() : player.level().getLevelData().getXSpawn())
                                : 0),
                        ((entity instanceof ServerPlayer player && !player.level().isClientSide())
                                ? ((player.getRespawnDimension().equals(player.level().dimension()) && player.getRespawnPosition() != null) ? player.getRespawnPosition().getY() : player.level().getLevelData().getYSpawn())
                                : 0),
                        ((entity instanceof ServerPlayer player && !player.level().isClientSide())
                                ? ((player.getRespawnDimension().equals(player.level().dimension()) && player.getRespawnPosition() != null) ? player.getRespawnPosition().getZ() : player.level().getLevelData().getZSpawn())
                                : 0));
                if (ent instanceof ServerPlayer serverPlayer)
                    serverPlayer.connection.teleport(
                            ((entity instanceof ServerPlayer player && !player.level().isClientSide())
                                    ? ((player.getRespawnDimension().equals(player.level().dimension()) && player.getRespawnPosition() != null) ? player.getRespawnPosition().getX() : player.level().getLevelData().getXSpawn())
                                    : 0),
                            ((entity instanceof ServerPlayer player && !player.level().isClientSide())
                                    ? ((player.getRespawnDimension().equals(player.level().dimension()) && player.getRespawnPosition() != null) ? player.getRespawnPosition().getY() : player.level().getLevelData().getYSpawn())
                                    : 0),
                            ((entity instanceof ServerPlayer player && !player.level().isClientSide())
                                    ? ((player.getRespawnDimension().equals(player.level().dimension()) && player.getRespawnPosition() != null) ? player.getRespawnPosition().getZ() : player.level().getLevelData().getZSpawn())
                                    : 0),
                            ent.getYRot(), ent.getXRot());
            }
        }
    }
}
