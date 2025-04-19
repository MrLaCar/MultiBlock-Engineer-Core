package com.mrlacar.multiblock_engineer.mbe;

import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.mrlacar.multiblock_engineer.mbe.client.ClientProxy;
import com.mrlacar.multiblock_engineer.mbe.common.CommonProxy;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod("mbe")
public final class MultiBlock_Engineer {
    public static final String MOD_ID = "mbe";

    public static ResourceLocation id(String name) {
        return new ResourceLocation("mbe", FormattingUtil.toLowerCaseUnder(name));
    }

    public MultiBlock_Engineer() {
        DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
