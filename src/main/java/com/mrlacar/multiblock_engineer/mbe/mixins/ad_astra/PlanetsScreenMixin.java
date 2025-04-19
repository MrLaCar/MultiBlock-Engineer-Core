package com.mrlacar.multiblock_engineer.mbe.mixins.ad_astra;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import com.mrlacar.multiblock_engineer.mbe.client.util.DimensionRenderingUtils;
import com.mrlacar.multiblock_engineer.mbe.common.constants.MBEPlanetConstants;
import earth.terrarium.adastra.api.client.events.AdAstraClientEvents;
import earth.terrarium.adastra.client.screens.PlanetsScreen;
import earth.terrarium.adastra.common.constants.PlanetConstants;
import net.minecraft.Util;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlanetsScreen.class)
public class PlanetsScreenMixin {
    static {
        AdAstraClientEvents.RenderSolarSystemEvent.register((graphics, solarSystem, width, height) -> {
            if (PlanetConstants.SOLAR_SYSTEM.equals(solarSystem)) {
                Tesselator tessellator = Tesselator.getInstance();
                BufferBuilder bufferBuilder = tessellator.getBuilder();
                RenderSystem.setShader(GameRenderer::getPositionColorShader);
                bufferBuilder.begin(VertexFormat.Mode.DEBUG_LINES, DefaultVertexFormat.POSITION_COLOR);
                int color = 0xff24327b;
                PlanetsScreen.drawCircle(bufferBuilder, ((float)width / 2.0F), ((float)height / 2.0F), (210), 75, color);
                PlanetsScreen.drawCircle(bufferBuilder, ((float)width / 2.0F), ((float)height / 2.0F), (240), 75, color);
                tessellator.end();

                graphics.pose().pushPose();
                graphics.pose().translate(width / 2f, height / 2f, 0);
                graphics.pose().mulPose(Axis.ZP.rotationDegrees((Util.getMillis() / 100f) / 3 / 2));
                graphics.pose().translate(205, 0, 0);
                graphics.blit(DimensionRenderingUtils.URANUS, 0, 0, 0.0F, 0.0F, 12, 12, 12, 12);
                graphics.pose().popPose();

                graphics.pose().pushPose();
                graphics.pose().translate(width / 2f, height / 2f, 0);
                graphics.pose().mulPose(Axis.ZP.rotationDegrees((Util.getMillis() / 100f) / 4 / 2));
                graphics.pose().translate(233, 0, 0);
                graphics.blit(DimensionRenderingUtils.NEPTUNE, 0, 0, 0, 0, 12, 12, 12, 12);
                graphics.pose().popPose();

            }

//            if (MBEPlanetConstants.PROXIMA_CENTAURI.equals(solarSystem)) {
//                Tesselator tessellator = Tesselator.getInstance();
//                BufferBuilder bufferBuilder = tessellator.getBuilder();
//                RenderSystem.setShader(GameRenderer::getPositionColorShader);
//                bufferBuilder.begin(VertexFormat.Mode.DEBUG_LINES, DefaultVertexFormat.POSITION_COLOR);
//                int color = 0xff008080;
//                PlanetsScreen.drawCircle(bufferBuilder, (double)((float)width / 2.0F), (double)((float)height / 2.0F), 30.0D, 75, color);
//                tessellator.end();
//
//                graphics.pose().pushPose();
//                graphics.pose().translate(width / 2f, height / 2f, 0);
//                graphics.pose().mulPose(Axis.ZP.rotationDegrees((Util.getMillis() / 100f) * 20 / 2));
//                graphics.pose().translate(22, 0, 0);
//                graphics.blit(DimensionRenderingUtils.B, 0, 0, 0, 0, 12, 12, 12, 12);
//                graphics.pose().popPose();
//            }

            if (MBEPlanetConstants.EX_940_SYSTEM.equals(solarSystem)) {
                Tesselator tessellator = Tesselator.getInstance();
                BufferBuilder bufferBuilder = tessellator.getBuilder();
                RenderSystem.setShader(GameRenderer::getPositionColorShader);
                bufferBuilder.begin(VertexFormat.Mode.DEBUG_LINES, DefaultVertexFormat.POSITION_COLOR);
                int color = 0xff24327b;
                PlanetsScreen.drawCircle(bufferBuilder, ((float) width / 2.0F), ((float) height / 2.0F), (45), 75, color);
                PlanetsScreen.drawCircle(bufferBuilder, ((float) width / 2.0F), ((float) height / 2.0F), (190), 75, color);

                tessellator.end();

                graphics.blit(DimensionRenderingUtils.DOOM_SUN, width / 2 - 8, height / 2 - 8, 0.0F, 0.0F, 16, 16, 16, 16);

                graphics.pose().pushPose();
                graphics.pose().translate((float)width / 2.0F, (float)height / 2.0F, 0.0F);
                graphics.pose().mulPose(Axis.ZP.rotationDegrees((Util.getMillis() / 100f) / 2));
                graphics.pose().translate(38, 0, 0);
                graphics.blit(DimensionRenderingUtils.CYLIOS, 0, 0, 0.0F, 0.0F, 12, 12, 12, 12);
                graphics.pose().popPose();

                graphics.pose().pushPose();
                graphics.pose().translate((float)width / 2.0F, (float)height / 2.0F, 0.0F);
                graphics.pose().mulPose(Axis.ZP.rotationDegrees((Util.getMillis() / 100f) / 6 / 2));
                graphics.pose().translate(185, 0, 0);
                graphics.blit(DimensionRenderingUtils.EX_68I, 0, 0, 0.0F, 0.0F, 12, 12, 12, 12);
                graphics.pose().popPose();
            }
        });
    }
}
