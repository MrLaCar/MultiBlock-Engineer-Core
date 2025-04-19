package com.mrlacar.multiblock_engineer.mbe.config;

import com.mrlacar.multiblock_engineer.mbe.MultiBlock_Engineer;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = MultiBlock_Engineer.MOD_ID)
public class ConfigHolder {

    public static ConfigHolder INSTANCE;
    private static final Object LOCK = new Object();

    public static void init() {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = Configuration.registerConfig(ConfigHolder.class, ConfigFormats.yaml()).getConfigInstance();
            }
        }
    }

    @Configurable
    public MachineRenderConfigs machineRenderer = new MachineRenderConfigs();

    public static class MachineRenderConfigs {

        @Configurable
        @Configurable.Comment({"Machine enable render animation.", "Default: true"})
        public boolean renderAnimation = true;

        @Configurable
        @Configurable.Comment({"Machine renderer farthest visible distance.", "Default: 64" })
        @Configurable.Range(min = 1, max = 512)
        public int viewDistance = 64;
    }
}
