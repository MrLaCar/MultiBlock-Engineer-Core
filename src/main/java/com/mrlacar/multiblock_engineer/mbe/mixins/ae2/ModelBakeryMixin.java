package com.mrlacar.multiblock_engineer.mbe.mixins.ae2;

import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;

import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBakery.class)
public abstract class ModelBakeryMixin {

    @Inject(at = @At("HEAD"), method = "loadModel", cancellable = true)
    private void loadModelHook(ResourceLocation id, CallbackInfo ci) {

        UnbakedModel model = mbe$getUnbakedModel(id);
        if (model != null) {
            cacheAndQueueDependencies(id, model);
            ci.cancel();
        }
    }

    @Unique
    private UnbakedModel mbe$getUnbakedModel(ResourceLocation variantId) {
        if (!variantId.getNamespace().equals(MultiBlock_Engineer.MOD_ID)) {
            return null;
        }
        if (variantId instanceof ModelResourceLocation modelId) {
            if ("inventory".equals(modelId.getVariant())) {
                var itemModelId = new ResourceLocation(modelId.getNamespace(), "item/" + modelId.getPath());
                return BuiltInModelHooks.getBuiltInModels().get(itemModelId);
            }

            return null;
        } else {
            return BuiltInModelHooks.getBuiltInModels().get(variantId);
        }
    }

    @Shadow
    protected abstract void cacheAndQueueDependencies(ResourceLocation id, UnbakedModel unbakedModel);
}
