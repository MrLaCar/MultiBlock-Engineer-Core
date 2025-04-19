package com.mrlacar.multiblock_engineer.mbe.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.gui.texture.GuiTextureGroup;
import com.lowdragmc.lowdraglib.gui.texture.ResourceBorderTexture;
import com.lowdragmc.lowdraglib.gui.texture.TextTexture;
import com.lowdragmc.lowdraglib.gui.widget.ButtonWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.Size;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.toolHeadDrill;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrlacar.multiblock_engineer.mbe.api.machine.MBEOverclockingLogic.NONE_OVERCLOCK;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.ElementMaterials.Draconium;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.GelidCryotheum;
import static com.mrlacar.multiblock_engineer.mbe.common.data.materials.MiscMaterials.SuperCoolant;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class StarVeinDigger extends WorkableElectricMultiblockMachine implements IMachineModifyDrops {

    private final List<Material> Overworld =
            List.of(Bentonite, Magnetite, Olivine, GlauconiteSand, Almandine, Pyrope, Sapphire, GreenSapphire, Goethite, YellowLimonite, Hematite, Malachite, 
                    Soapstone, Talc, Pentlandite, Grossular, Spessartine, Pyrolusite, Tantalite, Chalcopyrite, Zeolite, Realgar, Coal, Iron, Pyrite, Copper, VanadiumMagnetite, Gold, Lazurite, Sodalite, Lapis, 
                    Calcite, Galena, Silver, Lead, Kyanite, Mica, Bauxite, Pollucite, Tin, Cassiterite, GarnetRed, GarnetYellow, Amethyst, Opal, BasalticMineralSand, GraniticMineralSand, FullersEarth, Gypsum, 
                    RockSalt, Salt, Lepidolite, Spodumene, Redstone, Ruby, Cinnabar, Apatite, Pyrochlore, CassiteriteSand, GarnetSand, Asbestos, Diatomite, Oilsands, Graphite, Diamond, Garnierite, Nickel, Cobaltite);
    private final List<Material> Flat =
            List.of(Bentonite, Magnetite, Olivine, GlauconiteSand, Almandine, Pyrope, Sapphire, GreenSapphire, Goethite, YellowLimonite, Hematite, Malachite, 
                    Soapstone, Talc, Pentlandite, Grossular, Spessartine, Pyrolusite, Tantalite, Chalcopyrite, Zeolite, Realgar, Coal, Iron, Pyrite, Copper, VanadiumMagnetite, Gold, Lazurite, Sodalite, Lapis,
                    Calcite, Galena, Silver, Lead, Kyanite, Mica, Bauxite, Pollucite, Tin, Cassiterite, GarnetRed, GarnetYellow, Amethyst, Opal, BasalticMineralSand, GraniticMineralSand, FullersEarth, Gypsum,
                    RockSalt, Salt, Lepidolite, Spodumene, Redstone, Ruby, Cinnabar, Apatite, Pyrochlore, CassiteriteSand, GarnetSand, Asbestos, Diatomite, Oilsands, Graphite, Diamond, Garnierite, Nickel, Cobaltite);
    private final List<Material> Nether =
            List.of(Tetrahedrite, Copper, Stibnite, Bastnasite, Monazite, Neodymium, Redstone, Ruby, Cinnabar, Saltpeter, Diatomite, Electrotine, Alunite, Beryllium, 
                    Emerald, Grossular, Pyrolusite, Tantalite, Wulfenite, Molybdenite, Molybdenum, Powellite, Goethite, YellowLimonite, Hematite, Gold, Quartzite, CertusQuartz, Barite, BlueTopaz, Topaz, Chalcocite, 
                    Bornite, NetherQuartz, Sulfur, Pyrite, Sphalerite);
    private final List<Material> End =
            List.of(Naquadah, Plutonium239, Magnetite, VanadiumMagnetite, Chromite, Gold, Scheelite, Tungstate, Lithium, Bauxite, Ilmenite, Aluminium, Bornite, Cooperite, Platinum, Palladium, Pitchblende,
                   Uraninite, Iron, Redstone, Amethyst, Lead, Neodymium, Cassiterite, Magnesite, Stibnite, Sphalerite, Lepidolite, Spodumene, Molybdenum, Monazite, Olivine, Barite, EnderEye, Draconium);

    @Getter
    @Persisted
    private final NotifiableItemStackHandler StorageSlot;
    @Persisted
    private int ExcavationRange = 1;
    @Persisted
    private int DiggerTemperature = 0;
    @Persisted
    private int LimitingTemperature = 3500;

    private static final FluidStack DrillingLiquid = DrillingFluid.getFluid(1000);
    private static final FluidStack COOLANT0 = PCBCoolant.getFluid(200);
    private static final FluidStack COOLANT1 = SuperCoolant.getFluid(FluidStorageKeys.LIQUID, 200);
    private static final FluidStack COOLANT2 = GelidCryotheum.getFluid(200);

    public StarVeinDigger(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.StorageSlot = new NotifiableItemStackHandler(this, 1, IO.NONE, IO.BOTH);
        this.StorageSlot.setFilter(stack -> ChemicalHelper.getPrefix(stack.getItem()) == toolHeadDrill);

    }

    protected GTRecipe getDrillingLiquid() {return GTRecipeBuilder.ofRaw().inputFluids(DrillingLiquid).buildRawRecipe();}
    protected GTRecipe getCoolant0() {
        return GTRecipeBuilder.ofRaw().inputFluids(COOLANT0).buildRawRecipe();
    }
    protected GTRecipe getCoolant1() {
        return GTRecipeBuilder.ofRaw().inputFluids(COOLANT1).buildRawRecipe();
    }
    protected GTRecipe getCoolant2() {
        return GTRecipeBuilder.ofRaw().inputFluids(COOLANT2).buildRawRecipe();
    }

    @Override
    public Widget createUIWidget() {
        Widget widget = super.createUIWidget();
        if (widget instanceof WidgetGroup group) {
            Size size = group.getSize();
            group.addWidget(new SlotWidget(StorageSlot.storage, 0, size.width - 30, size.height - 30, true, true)
                    .setBackground(GuiTextures.SLOT));
            group.setBackground(GuiTextures.BACKGROUND_INVERSE);
            group.addWidget(new ButtonWidget(size.width - 80, size.height - 30, 18, 18, new GuiTextureGroup(ResourceBorderTexture.BUTTON_COMMON, new TextTexture("+")),
                    cd -> {
                        if (ExcavationRange < 3) {
                            ExcavationRange += 1;
                        }
                    }));
            group.addWidget(new ButtonWidget(size.width - 57, size.height - 30, 18, 18, new GuiTextureGroup(ResourceBorderTexture.BUTTON_COMMON, new TextTexture("-")),
                    cd -> {
                        if (ExcavationRange > 1) {
                            ExcavationRange -= 1;
                        }
                    }));
        }
        return widget;
    }

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER;

    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private int DiggerTemperature() {
        return this.DiggerTemperature;
    }

    public Material RandomOutput(List<Material> list) {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
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

    @Override
    public void onStructureInvalid() {
        ExcavationRange = 1;
        LimitingTemperature = 3500;
        super.onStructureInvalid();
    }

    public boolean onWorking() {
        boolean value = super.onWorking();
        if (getOffsetTimer() % 1 == 0) {
            if (DiggerTemperature() < LimitingTemperature && ExcavationRange == 1) {
                DiggerTemperature += 1;
            }
            if (DiggerTemperature() < LimitingTemperature && ExcavationRange == 2) {
                DiggerTemperature += 2;
            }
            if (DiggerTemperature() < LimitingTemperature && ExcavationRange == 3) {
                DiggerTemperature += 3;
            }
        }
        if (getOffsetTimer() % 5 == 0) {
            if (DiggerTemperature > 100) {
                if (getCoolant0().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                    DiggerTemperature -= 5;
                }
                if (getCoolant1().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                    DiggerTemperature -= 10;
                }
                if (getCoolant2().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
                    DiggerTemperature -= 15;
                }
            }
        }
        //DrillHead (putting different drill head to change the limiting temperature)
        if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:titanium_drill_head")) {
            LimitingTemperature = 3500 + 1550 - 155 * ExcavationRange/10;
        } else if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:stainless_steel_drill_head")) {
            LimitingTemperature = 3500 + 1600 - 160 * ExcavationRange/10;
        } else if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:tungsten_steel_drill_head")) {
            LimitingTemperature = 3500 + 2400 - 240 * ExcavationRange / 10;
        } else if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:hsse_drill_head")) {
            LimitingTemperature = 3500 + 4000 - 400 * ExcavationRange / 10;
        } else if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:naquadah_alloy_drill_head")) {
            LimitingTemperature = 3500 + 5760 - 576 * ExcavationRange / 10;
        } else if (Objects.equals(StorageSlot.getStackInSlot(0).kjs$getId(), "gtceu:neutronium_drill_head")) {
            LimitingTemperature = 3500 + 80000 - 8000 * ExcavationRange / 10;
        } else {
            LimitingTemperature = 3500;
        }
        //Use of dilling fluid and stop machine when it runs out
        if (!getDrillingLiquid().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
            recipeLogic.interruptRecipe();
            return false;
        }
        //Comparison logic of digger temperature and limiting temperature
        if (DiggerTemperature >= LimitingTemperature) {
            recipeLogic.interruptRecipe();
            return false;
        }
        //Main Output
        if (getLevel().dimension() == Level.OVERWORLD) {
            Output(this, ChemicalHelper.get(TagPrefix.rawOre, RandomOutput(Overworld), 512 * ExcavationRange));
        }
        if (getLevel().dimension() == Level.NETHER) {
            Output(this, ChemicalHelper.get(TagPrefix.rawOre, RandomOutput(Nether), 512 * ExcavationRange));
        }
        if (getLevel().dimension() == Level.END) {
            Output(this, ChemicalHelper.get(TagPrefix.rawOre, RandomOutput(End), 512 * ExcavationRange));
        }
        if (getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("mbe:flat"))) {
            Output(this, ChemicalHelper.get(TagPrefix.rawOre, RandomOutput(Flat), 512 * ExcavationRange));
        }
        //Chanced Output
        if (DiggerTemperature <= LimitingTemperature / 5 && DiggerTemperature >= LimitingTemperature / 7) {
            if (getLevel().dimension() == Level.OVERWORLD) {
                Output(this, ChemicalHelper.get(TagPrefix.rawOre, RandomOutput(Overworld), 64));
            }
            if (getLevel().dimension() == Level.NETHER) {
                Output(this, ChemicalHelper.get(TagPrefix.rawOre, RandomOutput(Nether), 64));
            }
            if (getLevel().dimension() == Level.END) {
                Output(this, ChemicalHelper.get(TagPrefix.rawOre, RandomOutput(End), 64));
            }
            if (getLevel().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("mbe:flat"))) {
                Output(this, ChemicalHelper.get(TagPrefix.rawOre, RandomOutput(Flat), 64));
            }
        }
        return value;
    }

    @Override
        public void addDisplayText (List <Component> textList) {
            super.addDisplayText(textList);
            if (this.isFormed()) {
                textList.add(Component.translatable("mbe.digger_temperature", Component.translatable(FormattingUtil.formatNumbers(DiggerTemperature) + "K").setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA))));
                textList.add(Component.translatable("mbe.limiting_temperature", Component.translatable(FormattingUtil.formatNumbers(LimitingTemperature) + "K").setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
                textList.add(Component.translatable("mbe.excavation_range", Component.translatable(FormattingUtil.formatNumbers(ExcavationRange)).setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW))));
            }
    }

    public static @NotNull ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (machine instanceof StarVeinDigger starVeinDigger && starVeinDigger.getDrillingLiquid().matchRecipe(starVeinDigger).isSuccess()) {
            if (RecipeHelper.getRecipeEUtTier(recipe) > starVeinDigger.getTier()) {
            }
            var oc = NONE_OVERCLOCK.getModifier(machine, recipe, starVeinDigger.getOverclockVoltage());
            return oc;
        }
        return ModifierFunction.NULL;
    }

        static {
            MANAGED_FIELD_HOLDER = new ManagedFieldHolder(StarVeinDigger.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
        }

    public void onDrops(List<ItemStack> drops) {
        this.clearInventory(StorageSlot.storage);
    }
}
