package com.brigido.bomba.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.*;
import static java.util.Arrays.*;

@Getter
@AllArgsConstructor
public enum Keypad {
    IMAGEM_1(1),
    IMAGEM_2(2),
    IMAGEM_3(3),
    IMAGEM_4(4),
    IMAGEM_5(5),
    IMAGEM_6(6),
    IMAGEM_7(7),
    IMAGEM_8(8),
    IMAGEM_9(9),
    IMAGEM_10(10),
    IMAGEM_11(11),
    IMAGEM_12(12),
    IMAGEM_13(13),
    IMAGEM_14(14),
    IMAGEM_15(15),
    IMAGEM_16(16),
    IMAGEM_17(17),
    IMAGEM_18(18),
    IMAGEM_19(19),
    IMAGEM_20(20),
    IMAGEM_21(21),
    IMAGEM_22(22),
    IMAGEM_23(23),
    IMAGEM_24(24),
    IMAGEM_25(25),
    IMAGEM_26(26),
    IMAGEM_27(27),
    IMAGEM_28(28);

    private final Integer arquivo;

    public static List<Keypad> getColumnA() {
        return asList(IMAGEM_1, IMAGEM_2, IMAGEM_3, IMAGEM_4, IMAGEM_5, IMAGEM_6, IMAGEM_7);
    }

    public static List<Keypad> getColumnB() {
        return asList(IMAGEM_8, IMAGEM_1, IMAGEM_7, IMAGEM_9, IMAGEM_10, IMAGEM_6, IMAGEM_11);
    }

    public static List<Keypad> getColumnC() {
        return asList(IMAGEM_12, IMAGEM_13, IMAGEM_9, IMAGEM_14, IMAGEM_15, IMAGEM_16, IMAGEM_10);
    }

    public static List<Keypad> getColumnD() {
        return asList(IMAGEM_17, IMAGEM_18, IMAGEM_19, IMAGEM_5, IMAGEM_14, IMAGEM_11, IMAGEM_20);
    }

    public static List<Keypad> getColumnE() {
        return asList(IMAGEM_21, IMAGEM_20, IMAGEM_19, IMAGEM_22, IMAGEM_18, IMAGEM_23, IMAGEM_24);
    }

    public static List<Keypad> getColumnF() {
        return asList(IMAGEM_17, IMAGEM_8, IMAGEM_25, IMAGEM_26, IMAGEM_21, IMAGEM_27, IMAGEM_28);
    }
}
