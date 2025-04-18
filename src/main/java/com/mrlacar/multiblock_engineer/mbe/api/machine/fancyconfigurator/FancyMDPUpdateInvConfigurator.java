package com.mrlacar.multiblock_engineer.mbe.api.machine.fancyconfigurator;

import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfigurator;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.transfer.item.CustomItemStackHandler;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.jei.IngredientIO;
import com.mrlacar.multiblock_engineer.mbe.api.gui.MBEGuiTextures;
import net.minecraft.network.chat.Component;

import java.util.Collections;
import java.util.List;

public class FancyMDPUpdateInvConfigurator implements IFancyConfigurator {

    private final CustomItemStackHandler inventory;
    private final Component title;
    private List<Component> tooltips = Collections.emptyList();

    public FancyMDPUpdateInvConfigurator(CustomItemStackHandler inventory, Component title) {
        this.inventory = inventory;
        this.title = title;
    }

    @Override
    public IGuiTexture getIcon() {
        return MBEGuiTextures.MDP_UPDATE_SLOT;
    }

    @Override
    public Widget createConfigurator() {
        int rowSize = 4;
        int colSize = rowSize;
        var group = new WidgetGroup(0, 0, 18 * rowSize + 16, 18 * colSize + 16);
        var container = new WidgetGroup(4, 4, 18 * rowSize + 8, 18 * colSize + 8);
        int index = 0;
        for (int y = 0; y < colSize; y++) {
            for (int x = 0; x < rowSize; x++) {
                container.addWidget(new SlotWidget(inventory, index++, 4 + x * 18, 4 + y * 18, true, true).setBackgroundTexture(GuiTextures.SLOT).setIngredientIO(IngredientIO.INPUT));
            }
        }
        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);
        return group;
    }

    public Component getTitle() {
        return this.title;
    }

    public List<Component> getTooltips() {
        return this.tooltips;
    }

    public FancyMDPUpdateInvConfigurator setTooltips(final List<Component> tooltips) {
        this.tooltips = tooltips;
        return this;
    }
}
