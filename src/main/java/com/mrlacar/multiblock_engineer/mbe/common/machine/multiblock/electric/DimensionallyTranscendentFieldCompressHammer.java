package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.Size;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;

import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK;
import static com.gregtechceu.gtceu.data.recipe.CustomTags.FIELD_GENERATORS;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DimensionallyTranscendentFieldCompressHammer extends WorkableElectricMultiblockMachine implements IMachineModifyDrops {

    @Getter
    @Persisted
    private final NotifiableItemStackHandler StorageSlot;
    @Persisted
    private int FieldGeneratorTier;

    public DimensionallyTranscendentFieldCompressHammer(IMachineBlockEntity holder) {
        super(holder);
        this.StorageSlot = new NotifiableItemStackHandler(this, 1, IO.NONE, IO.BOTH);
        this.StorageSlot.setFilter(stack -> stack.is(FIELD_GENERATORS));
    }

    @Override
    public Widget createUIWidget() {
        Widget widget = super.createUIWidget();
        if (widget instanceof WidgetGroup group) {
            Size size = group.getSize();
            group.addWidget(new SlotWidget(StorageSlot.storage, 0, size.width - 30, size.height - 30, true, true)
                    .setBackground(GuiTextures.SLOT));
            group.setBackground(GuiTextures.BACKGROUND_INVERSE);
        }
        return widget;
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (this.isFormed()) {
        }
    }


    private void FieldGeneratorTier() {
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:lv_field_generator")) {
            FieldGeneratorTier = 1;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:mv_field_generator")) {
            FieldGeneratorTier = 2;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:hv_field_generator")) {
            FieldGeneratorTier = 3;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:ev_field_generator")) {
            FieldGeneratorTier = 4;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:iv_field_generator")) {
            FieldGeneratorTier = 5;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:luv_field_generator")) {
            FieldGeneratorTier = 6;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:zpm_field_generator")) {
            FieldGeneratorTier = 7;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:uv_field_generator")) {
            FieldGeneratorTier = 8;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:uhv_field_generator")) {
            FieldGeneratorTier = 9;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:uev_field_generator")) {
            FieldGeneratorTier = 10;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:uiv_field_generator")) {
            FieldGeneratorTier = 11;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:uxv_field_generator")) {
            FieldGeneratorTier = 12;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:opv_field_generator")) {
            FieldGeneratorTier = 13;
        }
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "mbe:max_field_generator")) {
            FieldGeneratorTier = 14;
        }
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof DimensionallyTranscendentFieldCompressHammer dtfch)) {
            return RecipeModifier.nullWrongType(WorkableElectricMultiblockMachine.class, machine);
        }
        if (RecipeHelper.getRecipeEUtTier(recipe) > dtfch.getTier()) {
            return null;
        }
        double durationMultiplier = 1 - Math.sin(6.4 + (dtfch.FieldGeneratorTier - 1) / 10);
        var durationModifier = ModifierFunction.builder()
                .durationMultiplier(dtfch.StorageSlot.getStackInSlot(0).getCount() == 64 ? durationMultiplier : 1)
                .build();
        var oc = NON_PERFECT_OVERCLOCK_SUBTICK.getModifier(machine, recipe, dtfch.getOverclockVoltage());
        return oc.andThen(durationModifier);
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(DimensionallyTranscendentFieldCompressHammer.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }

    public void onDrops(List<ItemStack> drops) {
        this.clearInventory(StorageSlot.storage);
    }
}
