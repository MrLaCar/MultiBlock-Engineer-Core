package com.mrlacar.multiblock_engineer.mbe.integration.ae2.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineLife;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.*;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;

import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import com.mrlacar.multiblock_engineer.mbe.integration.ae2.machine.trait.AdvancedMEPatternBufferProxyRecipeHandler;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.phys.BlockHitResult;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@Getter
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class AdvancedMEPatternBufferProxyPartMachine extends TieredIOPartMachine implements IMachineLife {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            AdvancedMEPatternBufferProxyPartMachine.class, TieredIOPartMachine.MANAGED_FIELD_HOLDER);

    protected AdvancedMEPatternBufferProxyRecipeHandler<Ingredient> itemProxyHandler;

    protected AdvancedMEPatternBufferProxyRecipeHandler<FluidIngredient> fluidProxyHandler;

    @Persisted
    @DescSynced
    private BlockPos bufferPos;

    public AdvancedMEPatternBufferProxyPartMachine(IMachineBlockEntity holder) {
        super(holder, GTValues.UHV, IO.BOTH);
        this.itemProxyHandler = new AdvancedMEPatternBufferProxyRecipeHandler<>(this, IO.IN, ItemRecipeCapability.CAP);
        this.fluidProxyHandler = new AdvancedMEPatternBufferProxyRecipeHandler<>(this, IO.IN, FluidRecipeCapability.CAP);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (getLevel() instanceof ServerLevel level) {
            level.getServer().tell(new TickTask(0, () -> this.setBuffer(bufferPos)));
        }
    }

    public boolean setBuffer(@Nullable BlockPos pos) {
        var level = getLevel();
        if (pos == null || level == null) return false;
        if (MetaMachine.getMachine(getLevel(), pos) instanceof AdvancedMEPatternBufferPartMachine machine) {
            this.bufferPos = pos;

            List<NotifiableRecipeHandlerTrait<Ingredient>> itemHandlers = new ArrayList<>();
            List<NotifiableRecipeHandlerTrait<FluidIngredient>> fluidHandlers = new ArrayList<>();
            for (var handler : machine.getRecipeHandlers()) {
                if (handler.isProxy()) continue;

                if (handler.getCapability() == ItemRecipeCapability.CAP) {
                    itemHandlers.add((NotifiableRecipeHandlerTrait<Ingredient>) handler);
                } else {
                    fluidHandlers.add((NotifiableRecipeHandlerTrait<FluidIngredient>) handler);
                }
            }
            itemProxyHandler.setHandlers(itemHandlers);
            fluidProxyHandler.setHandlers(fluidHandlers);

            machine.addProxy(this);

            return true;
        } else {
            return false;
        }
    }

    @Nullable
    private AdvancedMEPatternBufferPartMachine getBuffer() {
        var level = getLevel();
        if (level == null || bufferPos == null) return null;
        if (MetaMachine.getMachine(level, bufferPos) instanceof AdvancedMEPatternBufferPartMachine buffer) {
            return buffer;
        } else {
            this.bufferPos = null;
            return null;
        }
    }

    @Override
    public MetaMachine self() {
        var buffer = getBuffer();
        return buffer != null ? buffer.self() : super.self();
    }

    @Override
    public boolean shouldOpenUI(Player player, InteractionHand hand, BlockHitResult hit) {
        var buffer = getBuffer();
        return buffer != null;
    }

    @Override
    public @Nullable ModularUI createUI(Player entityPlayer) {
        GTCEu.LOGGER.warn("'createUI' of the Crafting Buffer Proxy was incorrectly called!");
        return null;
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void onMachineRemoved() {
        var level = getLevel();
        if (level == null || bufferPos == null) return;
        if (MetaMachine.getMachine(getLevel(), this.bufferPos) instanceof AdvancedMEPatternBufferPartMachine machine) {
            machine.removeProxy(this);
        }
    }
}
