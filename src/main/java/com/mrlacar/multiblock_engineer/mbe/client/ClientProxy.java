package com.mrlacar.multiblock_engineer.mbe.client;

import com.mrlacar.multiblock_engineer.mbe.client.renderer.AcceleratorBlocksModelProvider;
import com.mrlacar.multiblock_engineer.mbe.client.renderer.CraftingUnitBlocksModelProvider;
import com.mrlacar.multiblock_engineer.mbe.common.CommonProxy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
        init();
    }

    public static void init() {
        AcceleratorBlocksModelProvider.initCraftingUnitModels();
        CraftingUnitBlocksModelProvider.initCraftingUnitModels();
    }

}
