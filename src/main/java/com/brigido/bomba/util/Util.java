package com.brigido.bomba.util;

import static java.util.Objects.*;

public class Util {

    public static String onlyNumbers(String value) {
        if (isNull(value)) {
            return "";
        }
        return toRemoveCharacterNotIn(value, "0123456789");
    }

    public static String toRemoveCharacterNotIn(String s, String in) {
        if (isNull(s)) {
            return "";
        }
        return s.chars()
                .filter(c -> in.indexOf(c) >= 0)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
