package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeHandler;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.config.ConfigHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.NON_PERFECT_OVERCLOCK;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AdvancedAssemblyLine extends WorkableElectricMultiblockMachine {

    public AdvancedAssemblyLine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        if (ConfigHolder.INSTANCE.machines.orderedAssemblyLineItems) {

            var recipeInputs = recipe.inputs.get(ItemRecipeCapability.CAP);
            var itemInputInventory = Objects
                    .requireNonNullElseGet(getCapabilitiesProxy().get(IO.IN, ItemRecipeCapability.CAP),
                            Collections::<IRecipeHandler<?>>emptyList)
                    .stream()
                    .filter(handler -> !handler.isProxy())
                    .map(container -> container.getContents().stream().filter(ItemStack.class::isInstance)
                            .map(ItemStack.class::cast).toList())
                    .filter(container -> !container.isEmpty())
                    .toList();

            if (itemInputInventory.size() < recipeInputs.size()) return false;

            for (int i = 0; i < recipeInputs.size(); i++) {
                var itemStack = itemInputInventory.get(i).get(0);
                Ingredient recipeStack = ItemRecipeCapability.CAP.of(recipeInputs.get(i).content);
                if (!recipeStack.test(itemStack)) {
                    return false;
                }
            }
        }
        return super.beforeWorking(recipe);
    }

    @Override
    public void onStructureFormed() {
        getDefinition().setPartSorter(Comparator.comparing(it -> multiblockPartSorter().apply(it.self().getPos())));
        super.onStructureFormed();
    }

    private Function<BlockPos, Integer> multiblockPartSorter() {
        return RelativeDirection.RIGHT.getSorter(getFrontFacing(), getUpwardsFacing(), isFlipped());
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof AdvancedAssemblyLine advancedAssemblyLine) {
            if (RecipeHelper.getRecipeEUtTier(recipe) > advancedAssemblyLine.getTier()) {
                return null;
            }
            double durationMultiplier = 0.8;
            var durationModifier = ModifierFunction.builder()
                    .durationMultiplier(durationMultiplier)
                    .build();
            var oc = NON_PERFECT_OVERCLOCK.getModifier(machine, recipe, advancedAssemblyLine.getOverclockVoltage());
            return oc.andThen(durationModifier);
        }
        return ModifierFunction.IDENTITY;
    }
}
