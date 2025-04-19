package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SpaceAssemblyMachine extends WorkableElectricMultiblockMachine {

    private final String SAMTier;
    @Persisted
    private int tier = 0;

    public SpaceAssemblyMachine(IMachineBlockEntity holder, String SAMTier) {
        super(holder);
        this.SAMTier = SAMTier;
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        tier = getMultiblockState().getMatchContext().get(SAMTier);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        tier = 0;
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        if (recipe.data.contains(SAMTier) && recipe.data.getInt(SAMTier) > tier) {
            getRecipeLogic().interruptRecipe();
            return false;
        }
        return super.beforeWorking(recipe);
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (this.isFormed()) {
            textList.add(Component.translatable("mbe.multiblock.module_tier", tier));
        }
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof SpaceAssemblyMachine spaceAssemblyMachine)) {
            return RecipeModifier.nullWrongType(WorkableElectricMultiblockMachine.class, machine);
        }
        if (RecipeHelper.getRecipeEUtTier(recipe) > spaceAssemblyMachine.getTier()) {
            return null;
        }
        double durationMultiplier = 1 - (spaceAssemblyMachine.tier - 1) * 0.05;
        var durationModifier = ModifierFunction.builder()
                .durationMultiplier(spaceAssemblyMachine.tier <= 12 ? durationMultiplier : 0.5)
                .build();
        var oc = NON_PERFECT_OVERCLOCK_SUBTICK.getModifier(machine, recipe, spaceAssemblyMachine.getOverclockVoltage());
        return oc.andThen(durationModifier);
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(SpaceAssemblyMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }
}
