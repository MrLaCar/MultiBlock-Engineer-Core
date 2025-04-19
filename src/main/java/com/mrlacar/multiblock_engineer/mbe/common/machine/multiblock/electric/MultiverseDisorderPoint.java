package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.machine.ConditionalSubscriptionHandler;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.fancyconfigurator.ButtonConfigurator;
import com.gregtechceu.gtceu.api.machine.feature.IDataInfoProvider;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.item.PortableScannerBehavior;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.util.ClickData;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.mrlacar.multiblock_engineer.mbe.api.gui.MBEGuiTextures;
import com.mrlacar.multiblock_engineer.mbe.api.machine.fancyconfigurator.FancyMDPUpdateInvConfigurator;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class MultiverseDisorderPoint extends WorkableElectricMultiblockMachine implements IMachineModifyDrops, IExplosionMachine, IDataInfoProvider {

    @Getter
    @Persisted
    private final String MDPTier;
    private final String SSTier;
    private final String DPHeat;
    @Persisted
    private int mdp_tier = 1;
    @Persisted
    private int ss_tier = 0;
    @Persisted
    private int dp_heat = 0;
    @Getter
    @Persisted
    private final NotifiableItemStackHandler MDPUpdateInventory;

    protected ConditionalSubscriptionHandler HeatSubs;

    private static final FluidStack Fuel_Type_1 = PCBCoolant.getFluid(1000);
    private static final FluidStack Fuel_Type_2 = Water.getFluid(1000);
    private static final FluidStack Fuel_Type_3 = Lava.getFluid(1000);

    protected GTRecipe getFuelType1() {return GTRecipeBuilder.ofRaw().inputFluids(Fuel_Type_1).buildRawRecipe();}
    protected GTRecipe getFuelType2() {return GTRecipeBuilder.ofRaw().inputFluids(Fuel_Type_2).buildRawRecipe();}
    protected GTRecipe getFuelType3() {return GTRecipeBuilder.ofRaw().inputFluids(Fuel_Type_3).buildRawRecipe();}

    public MultiverseDisorderPoint(IMachineBlockEntity holder, String MDPTier, String SSTier, String DPHeat) {
        super(holder, IO.IN);
        this.MDPTier = MDPTier;
        this.SSTier = SSTier;
        this.DPHeat = DPHeat;
        this.MDPUpdateInventory = new NotifiableItemStackHandler(this, 16, IO.IN, IO.NONE);
        this.HeatSubs = new ConditionalSubscriptionHandler(this, this::HeatUpdate, this::isFormed);
    }

    @Override
    public IGuiTexture getScreenTexture() {
        return MBEGuiTextures.DISPLAY_MDP;
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    protected void HeatUpdate() {
        if (getOffsetTimer() % 20 == 0) {
            if (getFuelType1().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                dp_heat += 10000;
            }
            if (getFuelType2().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                dp_heat += 60000;
            }
            if (getFuelType3().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                dp_heat += 120000;
            }
        }
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        ss_tier = getMultiblockState().getMatchContext().get(SSTier);
        HeatSubs.initialize(getLevel());
    }

    @Override
    public void onStructureInvalid() {
        if (isWorkingEnabled() && recipeLogic.getStatus() == RecipeLogic.Status.WORKING) {
            doExplosion(30f);
        }
        super.onStructureInvalid();
        ss_tier = 0;
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        if (recipe.data.contains(MDPTier) && recipe.data.getInt("MDPTier") > mdp_tier) {
            getRecipeLogic().interruptRecipe();
            return false;
        }
        if (recipe.data.contains(SSTier) && recipe.data.getInt("SSTier") > ss_tier) {
            getRecipeLogic().interruptRecipe();
            return false;
        }
        if (recipe.data.contains(DPHeat) && recipe.data.getInt("DPHeat") > dp_heat) {
            getRecipeLogic().interruptRecipe();
            return false;
        }
        return super.beforeWorking(recipe);
    }

    private void UpdateBehavior(ClickData clickData) {
        if (!clickData.isRemote) {
            if (mdp_tier == 1 &&
                    Objects.equals(MDPUpdateInventory.getStackInSlot(0).kjs$getId(), "gtceu:singularium_plate") && MDPUpdateInventory.getStackInSlot(0).getCount() == 48 &&
                    Objects.equals(MDPUpdateInventory.getStackInSlot(1).kjs$getId(), "gtceu:spacetime_plate") && MDPUpdateInventory.getStackInSlot(1).getCount() == 48 &&
                    Objects.equals(MDPUpdateInventory.getStackInSlot(2).kjs$getId(), "gtceu:versyton_foil") && MDPUpdateInventory.getStackInSlot(2).getCount() == 48 &&
                    Objects.equals(MDPUpdateInventory.getStackInSlot(3).kjs$getId(), "gtceu:cosmic_neutronium_screw") && MDPUpdateInventory.getStackInSlot(3).getCount() == 48 &&
                    Objects.equals(MDPUpdateInventory.getStackInSlot(4).kjs$getId(), "mbe:surreal_processor_mainframe") && MDPUpdateInventory.getStackInSlot(4).getCount() == 48 &&
                    Objects.equals(MDPUpdateInventory.getStackInSlot(5).kjs$getId(), "gtceu:uxv_robot_arm") && MDPUpdateInventory.getStackInSlot(5).getCount() == 32 &&
                    Objects.equals(MDPUpdateInventory.getStackInSlot(6).kjs$getId(), "gtceu:uxv_field_generator") && MDPUpdateInventory.getStackInSlot(6).getCount() == 32 &&
                    Objects.equals(MDPUpdateInventory.getStackInSlot(7).kjs$getId(), "gtceu:ether_polymer_frame") && MDPUpdateInventory.getStackInSlot(7).getCount() == 24 &&
                    Objects.equals(MDPUpdateInventory.getStackInSlot(8).kjs$getId(), "gtceu:infinity_frame") && MDPUpdateInventory.getStackInSlot(8).getCount() == 24 &&
                    Objects.equals(MDPUpdateInventory.getStackInSlot(9).kjs$getId(), "mbe:astral_emitter") && MDPUpdateInventory.getStackInSlot(9).getCount() == 16) {
                mdp_tier += 1;
                MDPUpdateInventory.getStackInSlot(0).setCount(0);
                MDPUpdateInventory.getStackInSlot(1).setCount(0);
                MDPUpdateInventory.getStackInSlot(2).setCount(0);
                MDPUpdateInventory.getStackInSlot(3).setCount(0);
                MDPUpdateInventory.getStackInSlot(4).setCount(0);
                MDPUpdateInventory.getStackInSlot(5).setCount(0);
                MDPUpdateInventory.getStackInSlot(6).setCount(0);
                MDPUpdateInventory.getStackInSlot(7).setCount(0);
                MDPUpdateInventory.getStackInSlot(8).setCount(0);
                MDPUpdateInventory.getStackInSlot(9).setCount(0);
            }
        }
    }

    @Override
    public void attachConfigurators(ConfiguratorPanel configuratorPanel) {
        configuratorPanel.attachConfigurators(new ButtonConfigurator(MBEGuiTextures.MDP_UPDATE, this::UpdateBehavior));
        configuratorPanel.attachConfigurators(new FancyMDPUpdateInvConfigurator(MDPUpdateInventory.storage, Component.translatable("mbe.gui.mdp_update_inventory.title")));
    }

    public static String getSSTier(int tier) {
        return switch (tier) {
            default -> I18n.get("mbe.ss_tier.1");
            case 2 -> I18n.get("mbe.ss_tier.2");
            case 3 -> I18n.get("mbe.ss_tier.3");
            case 4 -> I18n.get("mbe.ss_tier.4");
        };
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (this.isFormed()) {
            textList.add(Component.translatable("mbe.multiblock.mdp_tier", mdp_tier));
            textList.add(Component.translatable("mbe.multiblock.ss_tier", getSSTier(ss_tier)));
            textList.add(Component.translatable("mbe.multiblock.dp_heat", Component.translatable(FormattingUtil.formatNumbers(dp_heat) + "K").setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
        }
    }

    @NotNull
    @Override
    public List<Component> getDataInfo(PortableScannerBehavior.DisplayMode mode) {
        if (mode == PortableScannerBehavior.DisplayMode.SHOW_ALL || mode == PortableScannerBehavior.DisplayMode.SHOW_MACHINE_INFO) {
            if (mdp_tier == 1) {
                return Collections.singletonList(Component.translatable("mbe.multiblock.mdp_update.indicate.2"));
            }
            if (mdp_tier == 2) {
                return Collections.singletonList(Component.translatable("mbe.multiblock.mdp_update.indicate.3"));
            }
            if (mdp_tier == 3) {
                return Collections.singletonList(Component.translatable("mbe.multiblock.mdp_update.indicate.max"));
            }
        }
        return new ArrayList<>();
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof MultiverseDisorderPoint mdp)) {
            return RecipeModifier.nullWrongType(WorkableElectricMultiblockMachine.class, machine);
        }
        if (RecipeHelper.getRecipeEUtTier(recipe) > mdp.getTier()) {
            return null;
        }
        double durationMultiplier = (10 - mdp.ss_tier) / 10;
        var durationModifier = ModifierFunction.builder()
                .durationMultiplier(durationMultiplier)
                .build();
        var oc = NON_PERFECT_OVERCLOCK_SUBTICK.getModifier(machine, recipe, mdp.getOverclockVoltage());
        return oc.andThen(durationModifier);
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(MultiverseDisorderPoint.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }

    public void onDrops(List<ItemStack> drops) {
        this.clearInventory(MDPUpdateInventory.storage);
    }
}
