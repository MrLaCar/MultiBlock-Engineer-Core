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

public class PrivateAnchorBehavior {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if ((entity.level().dimension()) == Level.OVERWORLD) {
            if (entity instanceof ServerPlayer player && !player.level().isClientSide()) {
                ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("mbe:flat"));
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
                ent.teleportTo(0, 128, 0);
                if (ent instanceof ServerPlayer _serverPlayer)
                    _serverPlayer.connection.teleport(0, 32, 0, ent.getYRot(), ent.getXRot());
            }
        }
    }
}
