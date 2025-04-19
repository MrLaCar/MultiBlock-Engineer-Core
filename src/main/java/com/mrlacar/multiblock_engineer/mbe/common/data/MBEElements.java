package com.mrlacar.multiblock_engineer.mbe.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class MBEElements {
        public static final Element Tephilorium = createAndRegister(187, 109, -1, null, "Tephilorium", "Tp", false);
        public static final Element Plonurium = createAndRegister(211, 166, -1, null, "Plonurium", "Pl", false);
        public static final Element Olancadium = createAndRegister(218, 89, -1, null, "Olancadium", "Od", false);
        public static final Element Racontrimium = createAndRegister(290, 179, -1, null, "Racontrimium", "Rc", false);
        public static final Element B47 = createAndRegister(292, 292, -1, null, "B47", "*B*", false);
        public static final Element Universium = createAndRegister(8237, 8454, -1, null, "Universium", "○Um○", false);
        public static final Element Draconium = createAndRegister(448, 276, -1, null, "Draconium", "Dc", false);
        public static final Element Awakened_Draconium = createAndRegister(73265, 67778, -1, null, "Awakened Draconium", "Dc*", false);
        public static final Element Desh = createAndRegister(202, 146, -1, null, "Desh", "De", false);
        public static final Element Ostrum = createAndRegister(233, 170, -1, null, "Ostrum", "Ot", false);
        public static final Element Calorite = createAndRegister(286, 215, -1, null, "Calorite", "Ct", false);
        public static final Element Omterium = createAndRegister(904, 766, -1, null, "Omterium", "▣", false);
        public static final Element Hades_Steel = createAndRegister(515, 327, -1, null, "Hades Steel", "☪", false);
        public static final Element Vibranium = createAndRegister(780, 591, -1, null, "Vibranium", "Vb", false);
        public static final Element Astritanium = createAndRegister(944, 927, -1, null, "Astritanium", "*Tr*", false);
        public static final Element Quantonium = createAndRegister(1089, 1082, -1, null, "Quantonium", "⊙", false);
        public static final Element Fragmented_Dimension = createAndRegister(367843, 578492, -1, null, "Fragmented Dimension", "※", false);
        public static final Element Talli_M = createAndRegister(784, 767, -1, null, "Talli-M", "✴", false);
        public static final Element Infinity = createAndRegister(64580, 32484, -1, null, "Infinity", "If", false);
        public static final Element PrimitiveInfinity = createAndRegister(64534, 33784, -1, null, "PrimitiveInfinity", "If??", false);
        public static final Element Strangium = createAndRegister(892756, 933476, -1, null, "Strangium", "✧", false);
        public static final Element Primary_Substance = createAndRegister(239439477, 272830103, -1, null, "Primary_Substance", "∞", false);
        public static final Element Quasar_Matter = createAndRegister(878738473, 634538592, -1, null, "Quasar_Matter", "??✯??", false);
        public static final Element Calculasium = createAndRegister(2837872, 6736476, -1, null, "Calculasium", "§kCc", false);
        public static final Element Bedrockium = createAndRegister(10000, 10000, -1, null, "Bedrockium", "§k■", false);
        public static final Element Kobosium = createAndRegister(343456, 232341, -1, null, "Kobosium", "Ko*", false);
        public static final Element Starlight_Iridium = createAndRegister(8728738, 236763, -1, null, "Starlight_Iridium", "✦Ir✦", false);
        public static final Element Singularium = createAndRegister(456565223, 32656254, -1, null, "Singularium", "§kSrm", false);
        public static final Element Dustosmos = createAndRegister(9000131, 2323, -1, null, "dustosmos", "?", false);
        public static final Element Metastable_Oganesson = createAndRegister(118, 176, -1, null, "Metastable_Oganesson", "Og*", false);
        public static final Element Metastable_Hassium = createAndRegister(108, 169, -1, null, "Metastable_Hassium", "Hs*", false);
        public static final Element Titanium50 = createAndRegister(22, 28, -1, null, "Titanium50", "Ti-50", true);
        public static final Element CrystalMatrix = createAndRegister(3333, 4442, -1, null, "CrystalMatrix", "?", true);
        public static final Element AstralAlloy = createAndRegister(1233423423, 4545776, -1, null, "AstralAlloy", "§kAstral", true);
        public static final Element MultiverseHyperstableCompactMatter = createAndRegister(0, 0, -1, null, "MultiverseHyperstableCompactMatter", "?", true);

        public static Element createAndRegister(long protons, long neutrons, long halfLifeSeconds, String decayTo, String name, String symbol, boolean isIsotope) {
            Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
            GTRegistries.ELEMENTS.register(name, element);
            return element;
        }

        public static void init() {
        }
}
