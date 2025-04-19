package com.mrlacar.multiblock_engineer.mbe.client.renderer.machine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.client.renderer.machine.IControllerRenderer;
import com.gregtechceu.gtceu.client.renderer.machine.WorkableCasingMachineRenderer;
import com.lowdragmc.lowdraglib.client.bakedpipeline.FaceQuad;
import com.lowdragmc.lowdraglib.client.model.ModelFactory;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;
import com.mrlacar.multiblock_engineer.mbe.client.util.ClientUtil;
import com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric.MultiverseDisorderPoint;
import com.mrlacar.multiblock_engineer.mbe.config.ConfigHolder;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.ModelData;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

import java.util.List;
import java.util.function.Consumer;

public class MDPRender extends WorkableCasingMachineRenderer implements IControllerRenderer {

    private static final ResourceLocation UNIVERSE_MODEL = MultiBlock_Engineer.id("renderer/universe");
    public static final ResourceLocation DISORDER_POINT_MODEL = MultiBlock_Engineer.id("renderer/disorder_point");
    public static final ResourceLocation CHAOTIC_ENERGY_MODEL = MultiBlock_Engineer.id("renderer/chaotic_energy");

    public MDPRender() {
        super(MultiBlock_Engineer.id("block/cosmic_boundary_structure_casing"), MultiBlock_Engineer.id("block/multiblock/multiverse_disorder_point"));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderPartModel(List<BakedQuad> list, IMultiController iMultiController, IMultiPart iMultiPart, Direction direction, @Nullable Direction d1, RandomSource randomSource, Direction d2, ModelState modelState) {
        if (d1 != null && d2 != null) {
            list.add(FaceQuad.bakeFace(d2, ModelFactory.getBlockSprite(MultiBlock_Engineer.id("block/convective_spacetime_traction_casing")), modelState));
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void render(BlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        if (blockEntity instanceof IMachineBlockEntity machineBlockEntity && machineBlockEntity.getMetaMachine() instanceof MultiverseDisorderPoint multiverseDisorderPoint && multiverseDisorderPoint.isActive()) {
            float tick = multiverseDisorderPoint.getOffsetTimer() + partialTicks;
            double x = 0.5, y = 0.5, z = 0.5;
            switch (multiverseDisorderPoint.getFrontFacing()) {
                case NORTH -> z = 20.5;
                case SOUTH -> z = -19.5;
                case WEST -> x = 20.5;
                case EAST -> x = -19.5;
            }
            poseStack.pushPose();
            poseStack.translate(x, y, z);
            DisorderPointRender(tick, poseStack, buffer);
            ChaoticEnergyRender(tick, poseStack, buffer);
            UniverseRender(tick, poseStack, buffer);
            poseStack.popPose();
        }
    }

    private static void DisorderPointRender(float tick, PoseStack poseStack, MultiBufferSource buffer) {
        poseStack.pushPose();
        poseStack.scale(0.03F, 0.03F, 0.03F);
        poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0F, -7.7F, -4F, (float) ((tick / 0.4) % 360F)));
        ClientUtil.modelRenderer().renderModel(poseStack.last(), buffer.getBuffer(RenderType.translucent()), null, ClientUtil.getBakedModel(DISORDER_POINT_MODEL), 1.0F, 1.0F, 1.0F, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.translucent());
        poseStack.popPose();
    }

    private void ChaoticEnergyRender(float tick, PoseStack poseStack, MultiBufferSource buffer) {
        poseStack.pushPose();
        poseStack.scale(0.06F, 0.06F, 0.06F);
        poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0F, 3.5F, 6.2F, (float) ((tick / 0.2) % 360F)));
        ClientUtil.modelRenderer().renderModel(poseStack.last(), buffer.getBuffer(RenderType.solid()), null, ClientUtil.getBakedModel(CHAOTIC_ENERGY_MODEL), 1.0F, 1.0F, 1.0F, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.solid());
        poseStack.popPose();
    }

    private void UniverseRender(float tick, PoseStack poseStack, MultiBufferSource buffer) {
        float scale = 0.01F * 13.5F;
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0F, 1F, 1F, (tick / 2) % 360F));
        ClientUtil.modelRenderer().renderModel(poseStack.last(), buffer.getBuffer(RenderType.solid()), null, ClientUtil.getBakedModel(UNIVERSE_MODEL), 1.0F, 1.0F, 1.0F, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.solid());
        poseStack.popPose();
    }

    @Override
    public void onAdditionalModel(Consumer<ResourceLocation> registry) {
        super.onAdditionalModel(registry);
        if (ConfigHolder.INSTANCE.machineRenderer.renderAnimation) {
            registry.accept(UNIVERSE_MODEL);
            registry.accept(DISORDER_POINT_MODEL);
            registry.accept(CHAOTIC_ENERGY_MODEL);
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
