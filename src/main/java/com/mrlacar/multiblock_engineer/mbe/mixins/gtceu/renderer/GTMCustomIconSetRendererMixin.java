package com.mrlacar.multiblock_engineer.mbe.mixins.gtceu.renderer;

import com.mrlacar.multiblock_engineer.mbe.common.data.MBEMaterialIconSets;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.TagPrefixItem;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;

import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.renderer.IItemRendererProvider;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = TagPrefixItem.class, remap = false)
public class GTMCustomIconSetRendererMixin extends Item implements IItemRendererProvider {

    @Unique
    private ICustomRenderer mbe$gtmcustomiconrenderer;

    private GTMCustomIconSetRendererMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "<init>(Lnet/minecraft/world/item/Item$Properties;Lcom/gregtechceu/gtceu/api/data/tag/TagPrefix;Lcom/gregtechceu/gtceu/api/data/chemical/material/Material;)V", at = @At(value = "RETURN"))
    private void TagPrefixItem(Properties properties, TagPrefix tagPrefix, Material material, CallbackInfo ci) {
        if (Platform.isClient()) {
            if (material.getMaterialIconSet() instanceof MBEMaterialIconSets iconSet) {
                this.mbe$gtmcustomiconrenderer = iconSet.getCustomRenderer();
            }
        }
    }

    @Nullable
    @Override
    public IRenderer getRenderer(ItemStack stack) {
        if (mbe$gtmcustomiconrenderer != null) {
            return mbe$gtmcustomiconrenderer.getRenderer();
        }
        return null;
    }
}
