package com.mrlacar.multiblock_engineer.mbe.common.item;

import com.gregtechceu.gtceu.api.item.component.IAddInformation;
import com.gregtechceu.gtceu.api.item.component.IInteractionItem;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.mrlacar.multiblock_engineer.mbe.integration.ae2.machine.AdvancedMEPatternBufferPartMachine;
import com.mrlacar.multiblock_engineer.mbe.integration.ae2.machine.AdvancedMEPatternBufferProxyPartMachine;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AdvancedConnectorBehavior implements IInteractionItem, IAddInformation {
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (stack.getOrCreateTag().contains("pos", Tag.TAG_INT_ARRAY) && stack.hasTag()) {
            int[] posArray = stack.getOrCreateTag().getIntArray("pos");
            tooltipComponents.add(Component.translatable(
                    "gtceu.tooltip.proxy_bind",
                    Component.literal("" + posArray[0]).withStyle(ChatFormatting.LIGHT_PURPLE),
                    Component.literal("" + posArray[1]).withStyle(ChatFormatting.LIGHT_PURPLE),
                    Component.literal("" + posArray[2]).withStyle(ChatFormatting.LIGHT_PURPLE)));
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getItemInHand();
        if (!level.isClientSide) {
            MetaMachine machine = MetaMachine.getMachine(level, pos);
            var player = context.getPlayer();
            if (machine instanceof AdvancedMEPatternBufferPartMachine && player != null) {
                stack.getOrCreateTag().putIntArray("pos", new int[] {pos.getX(), pos.getY(), pos.getZ()});
                player.sendSystemMessage(Component.translatable("behavior.advanced_connector"));
            } else if (machine instanceof AdvancedMEPatternBufferProxyPartMachine proxy) {
                if (stack.hasTag()) {
                    if (stack.getOrCreateTag().contains("pos", Tag.TAG_INT_ARRAY)) {
                        int[] posArray = stack.getOrCreateTag().getIntArray("pos");
                        BlockPos bufferPos = new BlockPos(posArray[0], posArray[1], posArray[2]);
                        proxy.setBuffer(bufferPos);
                    }
                }
            } else {
                return InteractionResult.PASS;
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
