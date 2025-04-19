package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;


@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class UltraPrecisionMatterProcessor extends WorkableElectricMultiblockMachine {

    private final String IFRTier;
    @Persisted
    private int tier = 0;

    public UltraPrecisionMatterProcessor(IMachineBlockEntity holder, String IFRTier) {
        super(holder);
        this.IFRTier = IFRTier;
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        tier = getMultiblockState().getMatchContext().get(IFRTier);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        tier = 0;
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        if (recipe.data.contains(IFRTier) && recipe.data.getInt(IFRTier) > tier) {
            getRecipeLogic().interruptRecipe();
            return false;
        }
        return super.beforeWorking(recipe);
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (this.isFormed()) {
            textList.add(Component.translatable("mbe.multiblock.ifr_tier", tier));
        }
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(UltraPrecisionMatterProcessor.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }
}
