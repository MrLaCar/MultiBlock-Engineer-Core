package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.widget.IntInputWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableEnergyContainer;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.mrlacar.multiblock_engineer.mbe.api.machine.multiblock.part.CosmicRadiationSimulationEnergyMachine;
import net.minecraft.util.Mth;

import java.util.concurrent.ThreadLocalRandom;

import static com.gregtechceu.gtceu.api.GTValues.UEV;

public class CosmicRadiationSimulationHatchPartMachine extends CosmicRadiationSimulationEnergyMachine {

    private static final int MIN_CRT = 1;
    private final int MAX_CRT;
    @Persisted
    private int currentCRT;

    public CosmicRadiationSimulationHatchPartMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, 0, IO.IN, 1, args);
        this.MAX_CRT = 2000;
    }

    public void setCurrentCRT(int CRTAmount) {
        this.currentCRT = Mth.clamp(CRTAmount, MIN_CRT, this.MAX_CRT);
        for (IMultiController controller : this.getControllers()) {
            if (controller instanceof IRecipeLogicMachine rlm) {
                rlm.getRecipeLogic().markLastRecipeDirty();
            }
        }
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    protected NotifiableEnergyContainer createEnergyContainer(Object... args) {
        NotifiableEnergyContainer container;
        container = NotifiableEnergyContainer.receiverContainer(this, GTValues.V[UEV] * 4, GTValues.V[UEV], 1);
        container.setSideInputCondition((s) -> s == this.getFrontFacing() && this.isWorkingEnabled());
        container.setCapabilityValidator((s) -> s == null || s == this.getFrontFacing());
        return container;
    }

    public long consumeEnergy() {
        if (this.energyContainer.getEnergyStored() > 0) {
            return Math.abs(this.energyContainer.changeEnergy(-getMaxEUConsume())) * (3 + ThreadLocalRandom.current().nextInt(6));
        } else {
            return 0;
        }
    }

    @Override
    public Widget createUIWidget() {
        WidgetGroup parallelAmountGroup = new WidgetGroup(0, 0, 100, 20);
        parallelAmountGroup.addWidget(new IntInputWidget(this::getCurrentCRT, this::setCurrentCRT).setMin(MIN_CRT).setMax(MAX_CRT));
        return parallelAmountGroup;
    }

    public long getMaxEUConsume() {
        return Math.round(GTValues.V[UEV] * 0.65);
    }

    public int getCurrentCRT() {
        return this.currentCRT;
    }

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            CosmicRadiationSimulationHatchPartMachine.class, CosmicRadiationSimulationEnergyMachine.MANAGED_FIELD_HOLDER);
}
