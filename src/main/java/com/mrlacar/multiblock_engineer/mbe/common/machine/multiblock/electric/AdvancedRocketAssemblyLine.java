package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.lowdragmc.lowdraglib.gui.texture.GuiTextureGroup;
import com.lowdragmc.lowdraglib.gui.texture.ResourceBorderTexture;
import com.lowdragmc.lowdraglib.gui.texture.TextTexture;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.Size;
import com.mrlacar.multiblock_engineer.mbe.api.gui.MBEGuiTextures;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;

import static com.mrlacar.multiblock_engineer.mbe.api.data.MBECustomTags.ROCKET_DATA_MODULE;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AdvancedRocketAssemblyLine extends WorkableElectricMultiblockMachine implements IMachineModifyDrops {

    private final String ARALTier;
    @Persisted
    private int tier = 1;
    @Getter
    @Persisted
    private final NotifiableItemStackHandler StorageSlot;

    public AdvancedRocketAssemblyLine(IMachineBlockEntity holder, String ARALTier) {
        super(holder);
        this.ARALTier = ARALTier;
        this.StorageSlot = new NotifiableItemStackHandler(this, 1, IO.NONE, IO.BOTH);
        this.StorageSlot.setFilter(stack -> stack.is(ROCKET_DATA_MODULE));
    }

    @Override
    public Widget createUIWidget() {
        Widget widget = super.createUIWidget();
        if (widget instanceof WidgetGroup group) {
            Size size = group.getSize();
            group.addWidget(new SlotWidget(StorageSlot.storage, 0, size.width - 68, size.height - 30, true, true)
                    .setBackground(GuiTextures.SLOT, MBEGuiTextures.ROCKET_DATA_MODULE_OVERLAY));
            group.setBackground(GuiTextures.BACKGROUND_INVERSE);
            group.addWidget(new ButtonWidget(size.width - 45, size.height - 30, 36, 18, new GuiTextureGroup(ResourceBorderTexture.BUTTON_COMMON, new TextTexture("button.mbe.upgrade")),
                    cd -> {
                        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "mbe:rocket_data_module_t3")) {
                            tier = 3;
                            StorageSlot.getStackInSlot(0).setCount(0);
                        } else if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "mbe:rocket_data_module_t4")) {
                            tier = 4;
                            StorageSlot.getStackInSlot(0).setCount(0);
                        } else if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "mbe:rocket_data_module_t5")) {
                            tier = 5;
                            StorageSlot.getStackInSlot(0).setCount(0);
                        } else if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "mbe:rocket_data_module_t6")) {
                            tier = 6;
                            StorageSlot.getStackInSlot(0).setCount(0);
                        } else if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "mbe:rocket_data_module_t7")) {
                            tier = 7;
                            StorageSlot.getStackInSlot(0).setCount(0);
                        }
                    }));
        }
        return widget;
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        if (recipe != null && recipe.data.contains(ARALTier) && recipe.data.getInt(ARALTier) > tier) {
            getRecipeLogic().interruptRecipe();
            return false;
        }
        return super.beforeWorking(recipe);
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (this.isFormed()) {
            textList.add(Component.translatable("mbe.multiblock.tech_tier", tier));
        }
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(AdvancedRocketAssemblyLine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }

    public void onDrops(List<ItemStack> drops) {
        this.clearInventory(StorageSlot.storage);
    }
}
