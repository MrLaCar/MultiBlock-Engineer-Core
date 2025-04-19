package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.generator;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class PhotonStationDeployUnit extends WorkableElectricMultiblockMachine {

    @Persisted
    public int ReceiveEfficiency = 0;
    @Persisted
    public double PhotonCoefficient = 0;

    public PhotonStationDeployUnit(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        this.ReceiveEfficiency = 2;
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        //Randomise the value of receive efficiency every 10s when working
        if (getOffsetTimer() % 200 == 0) {
            Random rand = new Random();
            ReceiveEfficiency = rand.nextInt(1, 15);
        }
        return value;
    }

    public void addDisplayText(@NotNull List<Component> textList) {
        MultiblockDisplayText.builder(textList, isFormed()).setWorkingStatus(true, true)
                .addCustom(tl -> {
                    if (isActive()) {
                        long EUt = RecipeHelper.getOutputEUt(recipeLogic.getLastRecipe());
                        String voltageName = GTValues.VNF[GTUtil.getTierByVoltage(EUt)];
                        tl.add(Component.translatable("mbe.multiblock.energy_out_per_tick", FormattingUtil.formatNumbers(EUt), voltageName));
                    }
                    if (isFormed()) {
                        if (getLevel().dimension() == Level.OVERWORLD) {
                            PhotonCoefficient = 1.461;
                        } else if (getLevel().dimension() == Level.END) {
                            PhotonCoefficient = 2.743;
                        } else if (getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("mbe:flat"))) {
                            PhotonCoefficient = 1.461;
                        } else if (getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:mercury"))) {
                            PhotonCoefficient = 4.172;
                        } else if (getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:venus"))) {
                            PhotonCoefficient = 3.052;
                        } else if (getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:mars"))) {
                            PhotonCoefficient = 1.240;
                        } else if (getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:moon"))) {
                            PhotonCoefficient = 1.898;
                        } else if (getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:glacio"))) {
                            PhotonCoefficient = 3.887;
                        }
                        tl.add(Component.translatable("mbe.photon_station_deploy_unit.photon_coefficient", PhotonCoefficient).setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA)));
                        tl.add(Component.translatable("mbe.photon_station_deploy_unit.receive_efficiency", ReceiveEfficiency).setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA)));

                    }
                }).addWorkingStatusLine();
    }

    public static ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof PhotonStationDeployUnit photonStationDeployUnit)) {
            return RecipeModifier.nullWrongType(PhotonStationDeployUnit.class, machine);
        }
        if (photonStationDeployUnit.getLevel().dimension() == Level.OVERWORLD) {
            photonStationDeployUnit.PhotonCoefficient = 1.461;
        } else if (photonStationDeployUnit.getLevel().dimension() == Level.END) {
            photonStationDeployUnit.PhotonCoefficient = 2.743;
        } else if (photonStationDeployUnit.getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("mbe:flat"))) {
            photonStationDeployUnit.PhotonCoefficient = 1.461;
        } else if (photonStationDeployUnit.getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:mercury"))) {
            photonStationDeployUnit.PhotonCoefficient = 4.172;
        } else if (photonStationDeployUnit.getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:venus"))) {
            photonStationDeployUnit.PhotonCoefficient = 3.052;
        } else if (photonStationDeployUnit.getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:mars"))) {
            photonStationDeployUnit.PhotonCoefficient = 1.240;
        } else if (photonStationDeployUnit.getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:moon"))) {
            photonStationDeployUnit.PhotonCoefficient = 1.898;
        } else if (photonStationDeployUnit.getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("ad_astra:glacio"))) {
            photonStationDeployUnit.PhotonCoefficient = 3.887;
        }
        long EUt = RecipeHelper.getOutputEUt(recipe);
        if (EUt > 0) {
            double eutMultiplier = photonStationDeployUnit.PhotonCoefficient * photonStationDeployUnit.ReceiveEfficiency;
            return ModifierFunction.builder().eutMultiplier(eutMultiplier).build();
        }
        return ModifierFunction.NULL;
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(PhotonStationDeployUnit.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }
}
