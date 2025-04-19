package com.mrlacar.multiblock_engineer.mbe.client.renderer.machine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.client.renderer.machine.WorkableCasingMachineRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;
import com.mrlacar.multiblock_engineer.mbe.client.util.ClientUtil;
import com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric.SupercriticalPhaseShifter;
import com.mrlacar.multiblock_engineer.mbe.config.ConfigHolder;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.ModelData;
import org.joml.Quaternionf;

import java.util.function.Consumer;

public class SPSRender extends WorkableCasingMachineRenderer {

    private static final ResourceLocation SPS_MODEL = MultiBlock_Engineer.id("renderer/sps");

    public SPSRender() {
        super(MultiBlock_Engineer.id("block/sps_casing"), MultiBlock_Engineer.id("block/multiblock/sps"));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void render(BlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        if (blockEntity instanceof IMachineBlockEntity machineBlockEntity && machineBlockEntity.getMetaMachine() instanceof SupercriticalPhaseShifter sps && sps.isActive()) {
            double x = 0.5, y = 3.5, z = 0.5;
            switch (sps.getFrontFacing()) {
                case NORTH -> z = 4.5;
                case SOUTH -> z = -1.5;
                case WEST -> x = 4.5;
                case EAST -> x = -1.5;
            }
            poseStack.pushPose();
            poseStack.translate(x, y, z);
            SPSLayerRender(poseStack, buffer);
            poseStack.popPose();
        }
    }

    private static void SPSLayerRender( PoseStack poseStack, MultiBufferSource buffer) {
        poseStack.pushPose();
        poseStack.scale(0.016F, 0.016F, 0.016F);
        poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0.768f, 0.233f, 0.463f, (System.currentTimeMillis() / 6) % 360));
        ClientUtil.modelRenderer().renderModel(poseStack.last(), buffer.getBuffer(RenderType.translucent()), null, ClientUtil.getBakedModel(SPS_MODEL), 1.0F, 1.0F, 1.0F, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.solid());
        poseStack.popPose();
    }

    @Override
    public void onAdditionalModel(Consumer<ResourceLocation> registry) {
        super.onAdditionalModel(registry);
        if (ConfigHolder.INSTANCE.machineRenderer.renderAnimation) {
            registry.accept(SPS_MODEL);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasTESR(BlockEntity blockEntity) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isGlobalRenderer(BlockEntity blockEntity) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getViewDistance() {
        return ConfigHolder.INSTANCE.machineRenderer.viewDistance;
    }
}
