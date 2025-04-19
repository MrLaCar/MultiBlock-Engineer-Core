package com.mrlacar.multiblock_engineer.mbe.client.renderer;

import appeng.client.render.crafting.AbstractCraftingUnitModelProvider;
import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;
import com.mrlacar.multiblock_engineer.mbe.common.block.ae2.CraftingUnitBlocks;
import com.mrlacar.multiblock_engineer.mbe.common.data.MBEBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import appeng.client.render.crafting.CraftingCubeModel;
import appeng.client.render.crafting.LightBakedModel;
import appeng.core.AppEng;
import appeng.hooks.BuiltInModelHooks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public class CraftingUnitBlocksModelProvider extends AbstractCraftingUnitModelProvider<CraftingUnitBlocks> {

    private static final List<Material> MATERIALS = new ArrayList<>();

    private static final Material RING_CORNER = aeTexture("ring_corner");
    private static final Material RING_SIDE_HOR = aeTexture("ring_side_hor");
    private static final Material RING_SIDE_VER = aeTexture("ring_side_ver");
    private static final Material LIGHT_BASE = aeTexture("light_base");
    protected static final Material STORAGE_1024K_LIGHT = texture("1024k_storage_light");
    protected static final Material STORAGE_4096K_LIGHT = texture("4096k_storage_light");
    protected static final Material STORAGE_16384K_LIGHT = texture("16384k_storage_light");
    protected static final Material STORAGE_65536K_LIGHT = texture("65536k_storage_light");
    protected static final Material STORAGE_262144K_LIGHT = texture("262144k_storage_light");

    public CraftingUnitBlocksModelProvider(CraftingUnitBlocks type) {
        super(type);
    }

    public TextureAtlasSprite getLightMaterial(Function<Material, TextureAtlasSprite> textureGetter) {
        return switch (this.type) {
            case STORAGE_1024K -> textureGetter.apply(STORAGE_1024K_LIGHT);
            case STORAGE_4096K -> textureGetter.apply(STORAGE_4096K_LIGHT);
            case STORAGE_16384K -> textureGetter.apply(STORAGE_16384K_LIGHT);
            case STORAGE_65536K -> textureGetter.apply(STORAGE_65536K_LIGHT);
            case STORAGE_262144K -> textureGetter.apply(STORAGE_262144K_LIGHT);
        };
    }

    @Override
    public List<Material> getMaterials() {
        return Collections.unmodifiableList(MATERIALS);
    }

    @Override
    public BakedModel getBakedModel(Function<Material, TextureAtlasSprite> spriteGetter) {
        TextureAtlasSprite ringCorner = spriteGetter.apply(RING_CORNER);
        TextureAtlasSprite ringSideHor = spriteGetter.apply(RING_SIDE_HOR);
        TextureAtlasSprite ringSideVer = spriteGetter.apply(RING_SIDE_VER);
        TextureAtlasSprite lightBase = spriteGetter.apply(LIGHT_BASE);
        return new LightBakedModel(
                ringCorner,
                ringSideHor,
                ringSideVer,
                lightBase,
                getLightMaterial(spriteGetter));
    }

    private static Material texture(String name) {
        var material = new Material(InventoryMenu.BLOCK_ATLAS, MultiBlock_Engineer.id("block/crafting/" + name));
        MATERIALS.add(material);
        return material;
    }

    private static Material aeTexture(String name) {
        var material = new Material(InventoryMenu.BLOCK_ATLAS, AppEng.makeId("block/crafting/" + name));
        MATERIALS.add(material);
        return material;
    }

    public static void initCraftingUnitModels() {
        for (CraftingUnitBlocks type : CraftingUnitBlocks.values()) {
            BuiltInModelHooks.addBuiltInModel(
                    MultiBlock_Engineer.id("block/crafting/" + type.getAffix() + "_formed"),
                    new CraftingCubeModel(new CraftingUnitBlocksModelProvider(type)));
        }

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(CraftingUnitBlocksModelProvider::setRenderLayer);
    }

    private static void setRenderLayer(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(MBEBlocks.CRAFTING_STORAGE_1024K.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MBEBlocks.CRAFTING_STORAGE_4096K.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MBEBlocks.CRAFTING_STORAGE_16384K.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MBEBlocks.CRAFTING_STORAGE_65536K.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MBEBlocks.CRAFTING_STORAGE_262144K.get(), RenderType.cutout());
    }
}
