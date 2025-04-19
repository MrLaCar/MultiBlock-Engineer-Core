package com.mrlacar.multiblock_engineer.mbe.integration.jade;

import com.mrlacar.multiblock_engineer.mbe.integration.jade.provider.AdvancedMEPatternBufferProvider;
import com.mrlacar.multiblock_engineer.mbe.integration.jade.provider.AdvancedMEPatternBufferProxyProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class MBEJadePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(new AdvancedMEPatternBufferProvider(), BlockEntity.class);
        registration.registerBlockDataProvider(new AdvancedMEPatternBufferProxyProvider(), BlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(new AdvancedMEPatternBufferProvider(), Block.class);
        registration.registerBlockComponent(new AdvancedMEPatternBufferProxyProvider(), Block.class);
    }
}
