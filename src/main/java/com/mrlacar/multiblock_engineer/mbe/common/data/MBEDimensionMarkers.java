package com.mrlacar.multiblock_engineer.mbe.common.data;

import com.gregtechceu.gtceu.api.data.DimensionMarker;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

import static com.mrlacar.multiblock_engineer.mbe.api.MBERegistries.REGISTRATE;

public class MBEDimensionMarkers {

    static {
        REGISTRATE.creativeModeTab(() -> MBECreativeModeTabs.BLOCK);
    }

    //Orbit
    public static final BlockEntry<Block> EARTH_ORBIT_MARKER = createMarker("earth_orbit");
    public static final BlockEntry<Block> MOON_ORBIT_MARKER = createMarker("moon_orbit");
    public static final BlockEntry<Block> MERCURY_ORBIT_MARKER = createMarker("mercury_orbit");
    public static final BlockEntry<Block> MARS_ORBIT_MARKER = createMarker("mars_orbit");
    public static final BlockEntry<Block> VENUS_ORBIT_MARKER = createMarker("venus_orbit");
    public static final BlockEntry<Block> URANUS_ORBIT_MARKER = createMarker("uranus_orbit");
    public static final BlockEntry<Block> NEPTUNE_ORBIT_MARKER = createMarker("neptune_orbit");
    public static final BlockEntry<Block> GLACIO_ORBIT_MARKER = createMarker("glacio_orbit");

    //Planet
    public static final BlockEntry<Block> MOON_MARKER = createMarker("moon");
    public static final BlockEntry<Block> MERCURY_MARKER = createMarker("mercury");
    public static final BlockEntry<Block> MARS_MARKER = createMarker("mars");
    public static final BlockEntry<Block> VENUS_MARKER = createMarker("venus");
    public static final BlockEntry<Block> URANUS_MARKER = createMarker("uranus");
    public static final BlockEntry<Block> NEPTUNE_MARKER = createMarker("neptune");
    public static final BlockEntry<Block> GLACIO_MARKER = createMarker("glacio");


    public static final DimensionMarker EARTH_ORBIT = createAndRegister(new ResourceLocation("ad_astra:earth_orbit"), 1,
            () -> EARTH_ORBIT_MARKER, null);
    public static final DimensionMarker MOON_ORBIT = createAndRegister(new ResourceLocation("ad_astra:moon_orbit"), 1,
            () -> MOON_ORBIT_MARKER, null);
    public static final DimensionMarker MERCURY_ORBIT = createAndRegister(new ResourceLocation("ad_astra:mercury_orbit"), 2,
            () -> MERCURY_ORBIT_MARKER, null);
    public static final DimensionMarker MARS_ORBIT = createAndRegister(new ResourceLocation("ad_astra:mars_orbit"), 2,
            () -> MARS_ORBIT_MARKER, null);
    public static final DimensionMarker VENUS_ORBIT = createAndRegister(new ResourceLocation("ad_astra:venus_orbit"), 3,
            () -> VENUS_ORBIT_MARKER, null);
    public static final DimensionMarker GLACIO_ORBIT = createAndRegister(new ResourceLocation("ad_astra:glacio_orbit"), 4,
            () -> GLACIO_ORBIT_MARKER, null);

    public static final DimensionMarker MOON = createAndRegister(new ResourceLocation("ad_astra:moon"), 1,
            () -> MOON_MARKER, null);
    public static final DimensionMarker MERCURY = createAndRegister(new ResourceLocation("ad_astra:mercury"), 2,
            () -> MERCURY_MARKER, null);
    public static final DimensionMarker MARS = createAndRegister(new ResourceLocation("ad_astra:mars"), 2,
            () -> MARS_MARKER, null);
    public static final DimensionMarker VENUS = createAndRegister(new ResourceLocation("ad_astra:venus"), 3,
            () -> VENUS_MARKER, null);
    public static final DimensionMarker GLACIO = createAndRegister(new ResourceLocation("ad_astra:glacio"), 4,
            () -> GLACIO_MARKER, null);

    public static DimensionMarker createAndRegister(ResourceLocation dim, int tier, Supplier<ItemLike> supplier,
                                                    @Nullable String overrideName) {
        DimensionMarker marker = new DimensionMarker(tier, supplier, overrideName);
        marker.register(dim);
        return marker;
    }

    private static BlockEntry<Block> createMarker(String name) {
        return REGISTRATE.block("%s_marker".formatted(name), Block::new)
                .lang(FormattingUtil.toEnglishName(name))
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cube(ctx.getName(),
                                prov.modLoc("block/dim_markers/%s/down".formatted(name)),
                                prov.modLoc("block/dim_markers/%s/up".formatted(name)),
                                prov.modLoc("block/dim_markers/%s/north".formatted(name)),
                                prov.modLoc("block/dim_markers/%s/south".formatted(name)),
                                prov.modLoc("block/dim_markers/%s/east".formatted(name)),
                                prov.modLoc("block/dim_markers/%s/west".formatted(name)))
                        .texture("particle", "#north")
                        .guiLight(BlockModel.GuiLight.FRONT)))
                .simpleItem()
                .register();
    }

    public static void init() {}
}
