package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDisplayUIMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.lowdragmc.lowdraglib.gui.util.ClickData;
import com.lowdragmc.lowdraglib.gui.widget.ComponentPanelWidget;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import earth.terrarium.adastra.common.menus.base.PlanetsMenuProvider;
import earth.terrarium.botarium.common.menu.MenuHooks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import static com.mrlacar.multiblock_engineer.mbe.api.machine.MBEOverclockingLogic.NONE_OVERCLOCK;

public class WarpingStation extends WorkableElectricMultiblockMachine implements IDisplayUIMachine{

    @Persisted
    private int ChargingProgress;

    public WarpingStation(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    private int ChargingProgress() {
        return this.ChargingProgress;
    }

    public boolean onWorking() {
        boolean value = super.onWorking();
        if (getOffsetTimer() % 20 == 0) {
            if (this.ChargingProgress() < 100) {
                ++this.ChargingProgress;
            }
        }
        return value;
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        MultiblockDisplayText.builder(textList, isFormed()).setWorkingStatus(true, true)
                .addCustom(tl -> {
                    if (isFormed()) {
                        Component cargingProgress = Component.literal(ChargingProgress + "%");
                        textList.add(Component.translatable("mbe.multiblock.warping_station.charging_progress", cargingProgress).withStyle(ChatFormatting.GREEN));
                    }
                    if (ChargingProgress != 100) return;
                    textList.add(ComponentPanelWidget.withButton(Component.translatable("mbe.multiblock.warping_station.warping"), "warping"));
                });
    }

    @Override
    public void handleDisplayClick(String componentData, ClickData clickData) {
        if (componentData.equals("warping") && recipeLogic.isWorking()) {
            final BlockPos pos = getPos();
            List<ServerPlayer> entities = Objects.requireNonNull(getLevel()).getEntitiesOfClass(ServerPlayer.class, new AABB(
                    pos.getX() - 5,
                    pos.getY() - 5,
                    pos.getZ() - 5,
                    pos.getX() + 5,
                    pos.getY() + 5,
                    pos.getZ() + 5));
            for (ServerPlayer player : entities) {
                if (player != null) {
                    player.addTag("workable");
                    MenuHooks.openMenu(player, new PlanetsMenuProvider());
                }
            }
        }
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof WarpingStation warpingStation && warpingStation.getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:earth_orbit"))) {
            if (RecipeHelper.getRecipeEUtTier(recipe) > warpingStation.getTier()) {
            }
            var oc = NONE_OVERCLOCK.getModifier(machine, recipe, warpingStation.getOverclockVoltage());
            return oc;
        }
        return ModifierFunction.NULL;
    }
}
