package com.mrlacar.multiblock_engineer.mbe.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Quaternionf;

public class RotationEffectRenderer extends WrappedItemRenderer {

    public static final RotationEffectRenderer INSTANCE = new RotationEffectRenderer();

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderItem(ItemStack stack, ItemDisplayContext transformType, boolean leftHand, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay, BakedModel model) {
        model = getVanillaModel(stack, null, null);
        poseStack.pushPose();
        if (transformType == ItemDisplayContext.GUI) {poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(-0.3f, -0.5f, -0.8f, (System.currentTimeMillis() / 8) % 360));
        } else if (transformType == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
        {poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(-0.3f, -0.4f, 0.2f, (System.currentTimeMillis() / 8) % 360));
        } else if (transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
        {poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(-0.3f, -0.4f, 0.2f, (System.currentTimeMillis() / 8) % 360));
        } else if (transformType == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
        {poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(-0.3f, -0.4f, 0.2f, (System.currentTimeMillis() / 8) % 360));
        } else if (transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
        {poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(-0.3f, -0.4f, 0.2f, (System.currentTimeMillis() / 8) % 360));
        } else if (transformType == ItemDisplayContext.GROUND)
        {poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(-0.3f, -0.4f, 0.2f, (System.currentTimeMillis() / 8) % 360));
        } else if (transformType == ItemDisplayContext.FIXED)
        {poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(-0.3f, -0.4f, 0.2f, (System.currentTimeMillis() / 8) % 360));
        }
        vanillaRender(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, model);
        poseStack.popPose();
    }
}
