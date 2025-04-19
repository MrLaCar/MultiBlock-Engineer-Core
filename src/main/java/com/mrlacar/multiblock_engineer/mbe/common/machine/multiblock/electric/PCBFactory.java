package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK;

public class PCBFactory extends WorkableElectricMultiblockMachine {

    @Getter
    @Persisted
    private int PCBTier = 1;

    public PCBFactory(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private BlockPos ControllerOffsetPos(BlockPos pos, Level level) {
        BlockPos[] coordinates = new BlockPos[] {
                pos.offset(3, 1, 0),
                pos.offset(-3, 1, 0),
                pos.offset(0, 1, 3),
                pos.offset(0, 1, -3)};
        for (BlockPos blockPos : coordinates) {
            if (Objects.equals(level.kjs$getBlock(blockPos).getId(), "gtceu:pulsating_alloy_frame")) {
                return blockPos;
            }
        }
        return null;
    }

    private int OtherStructureNum() {
        if (getOffsetTimer() % 5 == 0) {
            final Level level = getLevel();
            final BlockPos blockPos = ControllerOffsetPos(getPos(), level);
            if (blockPos != null) {
                BlockPos[] coordinates = new BlockPos[] {
                        blockPos.offset(-5, 1, 4),
                        blockPos.offset(-4, 1, -5)};
                PCBTier = 1;
                for (BlockPos pos : coordinates) {
                    MetaMachine metaMachine = MetaMachine.getMachine(level, pos);
                    if (metaMachine instanceof WorkableElectricMultiblockMachine ppc && ppc.isFormed() && ppc.isWorkingEnabled()) {
                        String machinePos = ppc.getBlockState().getBlock().kjs$getId();
                        if (machinePos.equals("mbe:precision_photolithographic_chamber")) {
                            PCBTier++;
                            if (PCBTier >= 3) {
                                PCBTier = 2;
                            }
                        }
                    }
                }
                return PCBTier;
            }
        }
        return PCBTier;
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        if (recipe != null && PCBTier != recipe.data.getInt("pcb_tier")) {
            getRecipeLogic().interruptRecipe();
            return false;
        }
        return super.beforeWorking(recipe);
    }

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("mbe.multiblock.pcb_tier", OtherStructureNum()));
    }


    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof PCBFactory pcbFactory && pcbFactory.PCBTier >= recipe.data.getInt("pcb_tier")) {
            if (RecipeHelper.getRecipeEUtTier(recipe) > pcbFactory.getTier()) {
                return null;
            }
            var oc = NON_PERFECT_OVERCLOCK_SUBTICK.getModifier(machine, recipe, pcbFactory.getOverclockVoltage());
            return oc;
        }
        return ModifierFunction.NULL;
    }


    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(PCBFactory.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }
}
