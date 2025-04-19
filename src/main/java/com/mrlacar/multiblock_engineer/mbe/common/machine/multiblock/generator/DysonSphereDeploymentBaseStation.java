package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.generator;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.ConditionalSubscriptionHandler;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.machine.multiblock.generator.LargeCombustionEngineMachine;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.gui.texture.GuiTextureGroup;
import com.lowdragmc.lowdraglib.gui.widget.ButtonWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.Size;
import com.mrlacar.multiblock_engineer.mbe.api.gui.MBEGuiTextures;
import lombok.Getter;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

import static com.gregtechceu.gtceu.api.GTValues.MAX;
import static com.gregtechceu.gtceu.common.data.GTItems.SENSOR_UIV;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Mendelevium;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.ASCENDANT_BATTERY;
import static com.mrlacar.multiblock_engineer.mbe.common.data.MBEItems.SOLAR_SAIL;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.AlloyMaterials.Hastelloy633C;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.Universium;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.GelidCryotheum;

public class DysonSphereDeploymentBaseStation extends WorkableElectricMultiblockMachine {

    @Getter
    @Persisted
    private int SolarSailAmount;
    @Persisted
    private int SolarSailNodeAmount;
    @Persisted
    private int TotalDamageAmount;
    @Persisted
    private int RandomDamagedAmount;
    @Persisted
    private int AutoRecycle = 1;
    protected ConditionalSubscriptionHandler SolarSailEvent;

    private static final FluidStack COOLANT = GelidCryotheum.getFluid(1000);

    public DysonSphereDeploymentBaseStation(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.SolarSailEvent = new ConditionalSubscriptionHandler(this, this::SolarSailAmountUpdate, this::isFormed);
    }

    @Override
    public Widget createUIWidget() {
        Widget widget = super.createUIWidget();
        if (widget instanceof WidgetGroup group) {
            Size size = group.getSize();
            group.addWidget(new ButtonWidget(size.width - 220, size.height + 10, 24, 24, new GuiTextureGroup(GuiTextures.BACKGROUND, MBEGuiTextures.AUTO_RECYCLE),
                    cd -> {
                        if (AutoRecycle == 0) {
                            this.AutoRecycle = 1;
                        } else if (AutoRecycle == 1) {
                            this.AutoRecycle = 0;
                        }
                    }));
        }
        return widget;
    }

    protected GTRecipe getCoolant() {
        return GTRecipeBuilder.ofRaw().inputFluids(COOLANT).buildRawRecipe();
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    protected void SolarSailAmountUpdate() {
        if (getOffsetTimer() % 20 == 0) {
            if (Input(this, ASCENDANT_BATTERY.asStack())) {
                if (SolarSailNodeAmount < 256) {
                    SolarSailNodeAmount ++;
                }
            }
        }
        if (getOffsetTimer() % 20 == 0) {
            if (Input(this, SOLAR_SAIL.asStack())) {
                if (SolarSailAmount < 100 * SolarSailNodeAmount) {
                    SolarSailAmount ++;
                }
            }
        }
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        SolarSailEvent.initialize(getLevel());
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        if (SolarSailAmount > 5000 && getOffsetTimer() % 200 == 0 && Math.random() < ((double) SolarSailAmount / 200000)) {
            Random rand = new Random();
            RandomDamagedAmount = rand.nextInt(10, 40);
            SolarSailAmount -= RandomDamagedAmount;
            TotalDamageAmount += RandomDamagedAmount;
        }
        if (getOffsetTimer() % 20 == 0) {
            if (!getCoolant().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                recipeLogic.interruptRecipe();
                return false;
            }
        }
        if (AutoRecycle == 0) {
            if (getOffsetTimer() % 6000 == 0) {
                Random rand = new Random();
                Output(this, ChemicalHelper.get(TagPrefix.foil, Universium, rand.nextInt((int) Math.round(TotalDamageAmount * 16 * 0.1), (int) Math.round(TotalDamageAmount * 16 * 0.12))));
                Output(this, ChemicalHelper.get(TagPrefix.plate, Mendelevium, rand.nextInt((int) Math.round(TotalDamageAmount * 8 * 0.07), (int) Math.round(TotalDamageAmount * 8 * 0.09))));
                Output(this, ChemicalHelper.get(TagPrefix.plate, Hastelloy633C, rand.nextInt((int) Math.round(TotalDamageAmount * 8 * 0.1), (int) Math.round(TotalDamageAmount * 8 * 0.14))));
                Output(this, SENSOR_UIV.asStack(rand.nextInt((int) Math.round(TotalDamageAmount * 16 * 0.05), (int) Math.round(TotalDamageAmount * 16 * 0.07))));
                this.TotalDamageAmount = 0;
            }
        }
        return value;
    }

    public static boolean Input(WorkableMultiblockMachine machine, ItemStack item) {
        GTRecipe recipe = new GTRecipeBuilder(item.kjs$getIdLocation(), GTRecipeTypes.DUMMY_RECIPES).inputItems(item).buildRawRecipe();
        if (recipe.matchRecipe(machine).isSuccess()) {
            return recipe.handleRecipeIO(IO.IN, machine, machine.recipeLogic.getChanceCaches());
        }
        return false;
    }

    public static boolean Output(WorkableMultiblockMachine machine, ItemStack item){
        if (!item.isEmpty()) {
            GTRecipe recipe = new GTRecipeBuilder(item.kjs$getIdLocation(), GTRecipeTypes.DUMMY_RECIPES).outputItems(item).buildRawRecipe();
            if (recipe.matchRecipe(machine).isSuccess()) {
                return recipe.handleRecipeIO(IO.OUT, machine, machine.recipeLogic.getChanceCaches());
            }
        }
        return false;
    }

    public void addDisplayText(@NotNull List<Component> textList) {
        MultiblockDisplayText.builder(textList, isFormed()).setWorkingStatus(true, true)
                .addCustom(tl -> {
                    if (isActive()) {
                        long EUt = RecipeHelper.getOutputEUt(recipeLogic.getLastRecipe());
                        int Multiples = (int) (EUt / GTValues.V[MAX]);
                        tl.add(Component.translatable("mbe.multiblock.energy_out_per_tick_max", FormattingUtil.formatNumbers(EUt), Multiples));
                    }
                    if (isFormed) {
                        tl.add(Component.translatable("mbe.multiblock.solar_sail_amount", SolarSailAmount));
                        tl.add(Component.translatable("mbe.multiblock.solar_sail_node_amount", SolarSailNodeAmount));
                        tl.add(Component.translatable("mbe.multiblock.solar_sail_damage_amount", TotalDamageAmount));
                        if (AutoRecycle == 0) {
                            tl.add(Component.translatable("mbe.multiblock.auto_recycle_on"));
                        } else if (AutoRecycle == 1) {
                            tl.add(Component.translatable("mbe.multiblock.auto_recycle_off"));
                        }
                    }
                });
    }

    public static ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof DysonSphereDeploymentBaseStation dysonSphereDeploymentBaseStation && dysonSphereDeploymentBaseStation.SolarSailAmount >= 100 && dysonSphereDeploymentBaseStation.getCoolant().matchRecipe(dysonSphereDeploymentBaseStation).isSuccess())) {
            return RecipeModifier.nullWrongType(LargeCombustionEngineMachine.class, machine);
        }
        long EUt = RecipeHelper.getOutputEUt(recipe);
        if (EUt > 0) {
            double eutMultiplier = dysonSphereDeploymentBaseStation.SolarSailAmount / 100;
            return ModifierFunction.builder().eutMultiplier(eutMultiplier).build();
        }
        return ModifierFunction.NULL;
    }

    static {
        MANAGED_FIELD_HOLDER = new ManagedFieldHolder(DysonSphereDeploymentBaseStation.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    }
}
