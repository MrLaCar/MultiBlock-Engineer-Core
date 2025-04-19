package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.ConditionalSubscriptionHandler;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.gui.util.ClickData;
import com.lowdragmc.lowdraglib.gui.widget.ComponentPanelWidget;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK;
import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.PERFECT_OVERCLOCK_SUBTICK;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.PHLOGISTON_FUSION_FORGE;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.ConcentratedStarFuel;

public class StellarHeatSmelter extends CoilWorkableElectricMultiblockMachine {

    @Getter
    @Persisted
    private int StarFuel;
    @Persisted
    public int Mode = 0;

    protected ConditionalSubscriptionHandler HeatSubs;

    private static final FluidStack Star_Fuel = ConcentratedStarFuel.getFluid(1000);

    protected GTRecipe getFuel() {return GTRecipeBuilder.ofRaw().inputFluids(Star_Fuel).buildRawRecipe();}

    public StellarHeatSmelter(IMachineBlockEntity holder) {
        super(holder);
        this.HeatSubs = new ConditionalSubscriptionHandler(this, this::HeatUpdate, this::isFormed);
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    protected void HeatUpdate() {
        if (getOffsetTimer() % 20 == 0) {
            if (getFuel().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                StarFuel += 1000;
            }
        }
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        HeatSubs.initialize(getLevel());
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        if (Mode == 1) {
            if (getOffsetTimer() % 20 == 0) {
                StarFuel -= 100;
            }
        }
        if (StarFuel == 0) {
            this.Mode = 0;
        }
        return value;
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (this.isFormed()) {
            if (Mode == 1) {
                textList.add(Component.translatable("mbe.multiblock.shs_mode_on"));
            } else {
                textList.add(Component.translatable("mbe.multiblock.shs_mode_off"));
            }
            textList.add(Component.translatable("mbe.multiblock.star_fuel", StarFuel));
            textList.add(Component.translatable("gtceu.multiblock.blast_furnace.max_temperature", Component.translatable(FormattingUtil.formatNumbers(getCoilType().getCoilTemperature() + 500L * Math.max(0, getTier() - GTValues.UV) + (Mode == 1 ? 20000L : 0L)) + "K").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_RED))));
            textList.add(ComponentPanelWidget.withButton(Component.translatable("mbe.multiblock.shs_mode_switch"), "mode_switch"));

        }
    }

    @Override
    public void handleDisplayClick(String componentData, ClickData clickData) {
        if (componentData.equals("mode_switch")) {
            if (Mode == 0 && StarFuel >= 1000) {
                this.Mode = 1;
            } else if (Mode == 1) {
                this.Mode = 0;
            }
        }
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof StellarHeatSmelter stellarHeatSmelter)) {
            return RecipeModifier.nullWrongType(CoilWorkableElectricMultiblockMachine.class, machine);
        }
        int FusionTemperature = (int) (stellarHeatSmelter.getCoilType().getCoilTemperature() + (500 * Math.max(0, stellarHeatSmelter.getTier() - GTValues.UV) + (stellarHeatSmelter.Mode == 1 ? 20000L : 0L)));
        int recipeTemp = recipe.data.getInt("ebf_temp");
        if (!recipe.data.contains("ebf_temp") || recipeTemp > FusionTemperature) {
            return ModifierFunction.NULL;
        }
        if (RecipeHelper.getRecipeEUtTier(recipe) > stellarHeatSmelter.getTier()) {
            return ModifierFunction.NULL;
        }
        var durationModifier = ModifierFunction.builder()
                .durationMultiplier(0.4)
                .build();
        var oc = PERFECT_OVERCLOCK_SUBTICK.getModifier(machine, recipe, stellarHeatSmelter.getOverclockVoltage());
        var oc1 = NON_PERFECT_OVERCLOCK_SUBTICK.getModifier(machine, recipe, stellarHeatSmelter.getOverclockVoltage());
        if (recipe.recipeType == PHLOGISTON_FUSION_FORGE) {
            return oc1;
        }
        return oc.andThen(durationModifier);
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(StellarHeatSmelter.class, CoilWorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }
}
