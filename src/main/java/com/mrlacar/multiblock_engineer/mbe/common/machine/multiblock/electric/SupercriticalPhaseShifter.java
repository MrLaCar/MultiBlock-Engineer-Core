package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK;
import static com.mrlacar.multiblock_engineer.mbe.api.machine.MBEOverclockingLogic.NONE_OVERCLOCK;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBERecipeTypes.SUPERCRITICAL_PHASE_SYNTHESIS;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.Antimatter;

public class SupercriticalPhaseShifter extends WorkableElectricMultiblockMachine {

    private TickableSubscription hurtSubscription;

    @Persisted
    private int AntimatterMultiplier = 1;
    @Persisted
    private int BaseMultiplier = 1;
    @Persisted
    private int AntimatterOutput;

    public SupercriticalPhaseShifter(IMachineBlockEntity holder) {
        super(holder);
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void onUnload() {
        super.onUnload();
        unsubscribe(hurtSubscription);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        this.hurtSubscription = subscribeServerTick(this::hurtEntities);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        unsubscribe(hurtSubscription);
    }

    public static boolean outputFluid(WorkableMultiblockMachine machine, FluidStack fluid) {
        if (!fluid.isEmpty()) {
            GTRecipe recipe = new GTRecipeBuilder(Objects.requireNonNull(ForgeRegistries.FLUIDS.getKey(fluid.getFluid())), GTRecipeTypes.DUMMY_RECIPES).outputFluids(fluid).buildRawRecipe();
            if (recipe.matchRecipe(machine).isSuccess()) {
                return recipe.handleRecipeIO(IO.OUT, machine, machine.recipeLogic.getChanceCaches());
            }
        }
        return false;
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        if (getOffsetTimer() % 6000 == 0 && AntimatterMultiplier < 13) {
            AntimatterMultiplier ++;
        }
        if (AntimatterMultiplier == 13) {
            BaseMultiplier = (int) 1.5;
        }
        if (getOffsetTimer() % 20 == 0) {
            outputFluid(this, Antimatter.getFluid((int) (BaseMultiplier * Math.pow(2, AntimatterMultiplier))));
        }
        if (getOffsetTimer() % 5 == 0) {
            AntimatterOutput = (int) (BaseMultiplier * Math.pow(2, AntimatterMultiplier));
        }
        return value;
    }

    @Override
    public void addDisplayText (List<Component> textList) {
        super.addDisplayText(textList);
        if (this.isActive()) {
            textList.add(Component.translatable("mbe.antimatter_output", AntimatterOutput));
        }
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof SupercriticalPhaseShifter sps) {
            if (RecipeHelper.getRecipeEUtTier(recipe) > sps.getTier()) {
            }
            var oc = NONE_OVERCLOCK.getModifier(machine, recipe, sps.getOverclockVoltage());
            var oc1 = NON_PERFECT_OVERCLOCK_SUBTICK.getModifier(machine, recipe, sps.getOverclockVoltage());
            if (recipe.recipeType == SUPERCRITICAL_PHASE_SYNTHESIS) {
                return oc1;
            }
            return oc;
        }
        return ModifierFunction.NULL;
    }

    private BlockPos ControllerOffsetPos(BlockPos pos, Level level) {
        BlockPos[] coordinates = new BlockPos[] {
                pos.offset(4, 3, 0),
                pos.offset(-4, 3, 0),
                pos.offset(0, 3, 4),
                pos.offset(0, 3, -4)};
        for (BlockPos blockPos : coordinates) {
            if (Objects.equals(level.kjs$getBlock(blockPos).getId(), "minecraft:air")) {
                return blockPos;
            }
        }
        return null;
    }

    private void hurtEntities() {
        final Level level = getLevel();
        final BlockPos blockPos = ControllerOffsetPos(getPos(), level);
        getLevel().getEntities(null,
                new AABB(
                        blockPos.getX() - 3,
                        blockPos.getY() - 3,
                        blockPos.getZ() - 3,
                        blockPos.getX() + 3,
                        blockPos.getY() + 3,
                        blockPos.getZ() + 3)).
                forEach(e -> e.hurt(e.damageSources().lightningBolt(), 500.0f));
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(SupercriticalPhaseShifter.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }
}
