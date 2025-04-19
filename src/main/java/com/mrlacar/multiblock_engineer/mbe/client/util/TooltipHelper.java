package com.mrlacar.multiblock_engineer.mbe.client.util;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.ChatFormatting;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.ChatFormatting.*;

public class TooltipHelper {
    private static final List<GTFormattingCode> CODES = new ArrayList<>();

    public static final GTFormattingCode BLINK_PURPLE = createNewCode(5, LIGHT_PURPLE, DARK_PURPLE);

    public static GTFormattingCode createNewCode(int rate, ChatFormatting... codes) {
        GTFormattingCode code = new GTFormattingCode(rate, codes);
        CODES.add(code);
        return code;
    }

    public static void onClientTick() {
        CODES.forEach(GTFormattingCode::updateIndex);
    }

    public static class GTFormattingCode {

        private final int rate;
        private final ChatFormatting[] codes;
        private int index = 0;

        private GTFormattingCode(int rate, ChatFormatting... codes) {
            this.rate = rate;
            this.codes = codes;
        }

        public void updateIndex() {
            if (GTValues.CLIENT_TIME % rate == 0) {
                if (index + 1 >= codes.length) index = 0;
                else index++;
            }
        }

        public ChatFormatting getCurrent() {
            return codes[index];
        }

        @Override
        public String toString() {
            return codes[index].toString();
        }
    }
}
