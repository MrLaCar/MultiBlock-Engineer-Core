package com.mrlacar.multiblock_engineer.mbe.client.renderer;

import appeng.client.render.crafting.AbstractCraftingUnitModelProvider;
import appeng.client.render.crafting.CraftingCubeModel;
import appeng.client.render.crafting.LightBakedModel;
import appeng.core.AppEng;
import appeng.hooks.BuiltInModelHooks;
import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;
import com.mrlacar.multiblock_engineer.mbe.common.block.ae2.AcceleratorBlocks;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public class AcceleratorBlocksModelProvider extends AbstractCraftingUnitModelProvider<AcceleratorBlocks> {

    private static final List<Material> MATERIALS = new ArrayList<>();

    private static final Material RING_CORNER = aeTexture("ring_corner");
    private static final Material RING_SIDE_HOR = aeTexture("ring_side_hor");
    private static final Material RING_SIDE_VER = aeTexture("ring_side_ver");
    private static final Material LIGHT_BASE = aeTexture("light_base");
    protected static final Material ACCELERATOR_4_LIGHT = texture("4_core_accelerator_light");
    protected static final Material ACCELERATOR_16_LIGHT = texture("16_core_accelerator_light");
    protected static final Material ACCELERATOR_64_LIGHT = texture("64_core_accelerator_light");
    protected static final Material ACCELERATOR_256_LIGHT = texture("256_core_accelerator_light");

    public AcceleratorBlocksModelProvider(AcceleratorBlocks type) {
        super(type);
    }

    public TextureAtlasSprite getLightMaterial(Function<Material, TextureAtlasSprite> textureGetter) {
        return switch (this.type) {
            case ACCELERATOR_4 -> textureGetter.apply(ACCELERATOR_4_LIGHT);
            case ACCELERATOR_16 -> textureGetter.apply(ACCELERATOR_16_LIGHT);
            case ACCELERATOR_64 -> textureGetter.apply(ACCELERATOR_64_LIGHT);
            case ACCELERATOR_256 -> textureGetter.apply(ACCELERATOR_256_LIGHT);
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
        for (AcceleratorBlocks type : AcceleratorBlocks.values()) {
            BuiltInModelHooks.addBuiltInModel(
                    MultiBlock_Engineer.id("block/crafting/" + type.getAffix() + "_formed"),
                    new CraftingCubeModel(new AcceleratorBlocksModelProvider(type)));
        }

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(AcceleratorBlocksModelProvider::setRenderLayer);
    }

    private static void setRenderLayer(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(MBEBlocks.ACCELERATOR_4_CORE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MBEBlocks.ACCELERATOR_16_CORE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MBEBlocks.ACCELERATOR_64_CORE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MBEBlocks.ACCELERATOR_256_CORE.get(), RenderType.cutout());
    }
}
