package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.capability.IEnergyContainer;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.ConditionalSubscriptionHandler;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.part.CosmicRadiationSimulationHatchPartMachine;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.NON_PERFECT_OVERCLOCK;

public class ElementExtractor extends WorkableElectricMultiblockMachine{

    @Getter
    @Persisted
    private int CRT;
    @Persisted
    private boolean isWorking;

    protected ConditionalSubscriptionHandler CosmicRadiationSimulationSubs;

    private Set<CosmicRadiationSimulationHatchPartMachine> CosmicRadiationSimulationHatch;


    public ElementExtractor(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.CosmicRadiationSimulationSubs = new ConditionalSubscriptionHandler(this, this::CRTValueUpdate, this::isFormed);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        Map<Long, IO> ioMap = getMultiblockState().getMatchContext().getOrCreate("ioMap", Long2ObjectMaps::emptyMap);
        for (IMultiPart part : getParts()) {
            if (part instanceof CosmicRadiationSimulationHatchPartMachine cosmicRadiationSimulationHatchPartMachine) {
                CosmicRadiationSimulationHatch = Objects.requireNonNullElseGet(CosmicRadiationSimulationHatch, HashSet::new);
                CosmicRadiationSimulationHatch.add(cosmicRadiationSimulationHatchPartMachine);
            }
            IO io = ioMap.getOrDefault(part.self().getPos().asLong(), IO.BOTH);
            if (io == IO.NONE) continue;
            for (var handler : part.getRecipeHandlers()) {
                var handlerIO = handler.getHandlerIO();
                if (io != IO.BOTH && handlerIO != IO.BOTH && io != handlerIO) continue;
                if (handler.getCapability() == EURecipeCapability.CAP && handler instanceof IEnergyContainer) {
                    traitSubscriptions.add(handler.addChangedListener(CosmicRadiationSimulationSubs::updateSubscription));
                }
            }
        }
        CosmicRadiationSimulationSubs.initialize(getLevel());
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        CosmicRadiationSimulationHatch = null;
    }

    protected void CRTValueUpdate() {
        if (CosmicRadiationSimulationHatch == null) return;
        boolean anyWorking = false;
        for (var machine : CosmicRadiationSimulationHatch) {
            long energy = machine.consumeEnergy();
            if (energy > 0) {
                anyWorking = true;
                this.CRT = machine.getCurrentCRT();
            }
        }
        this.isWorking = anyWorking;
        if (!isWorking) CosmicRadiationSimulationSubs.unsubscribe();
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof ElementExtractor elementExtractor && elementExtractor.CRT >= recipe.data.getInt("crt")) {
            if (RecipeHelper.getRecipeEUtTier(recipe) > elementExtractor.getTier()) {
                return null;
            }
            var oc = NON_PERFECT_OVERCLOCK.getModifier(machine, recipe, elementExtractor.getOverclockVoltage());
            return oc;
        }
        return ModifierFunction.NULL;
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (isFormed()) {
            textList.add(Component.translatable("mbe.machine.element_extractor.crt", CRT));
        }
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ElementExtractor.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
}
