package com.brigido.bomba.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.stream.Stream;
import static com.brigido.bomba.enumeration.Color.*;

@Getter
@AllArgsConstructor
public enum GeniusFlash {
    RED_ZERO_ERRORS_VOWEL(0, true, VERMELHO, AZUL),
    BLUE_ZERO_ERRORS_VOWEL(0, true, AZUL, VERMELHO),
    GREEN_ZERO_ERRORS_VOWEL(0, true, VERDE, AMARELO),
    YELLOW_ZERO_ERRORS_VOWEL(0, true, AMARELO, VERDE),

    RED_ONE_ERROR_VOWEL(1, true, VERMELHO, AMARELO),
    BLUE_ONE_ERROR_VOWEL(1, true, AZUL, VERDE),
    GREEN_ONE_ERROR_VOWEL(1, true, VERDE, AZUL),
    YELLOW_ONE_ERROR_VOWEL(1, true, AMARELO, VERMELHO),

    RED_TWO_ERRORS_VOWEL(2, true, VERMELHO, VERDE),
    BLUE_TWO_ERRORS_VOWEL(2, true, AZUL, VERMELHO),
    GREEN_TWO_ERRORS_VOWEL(2, true, VERDE, AMARELO),
    YELLOW_TWO_ERRORS_VOWEL(2, true, AMARELO, AZUL),

    RED_ZERO_ERRORS(0, false, VERMELHO, AZUL),
    BLUE_ZERO_ERRORS(0, false, AZUL, AMARELO),
    GREEN_ZERO_ERRORS(0, false, VERDE, VERDE),
    YELLOW_ZERO_ERRORS(0, false, AMARELO, VERMELHO),

    RED_ONE_ERROR(1, false, VERMELHO, VERMELHO),
    BLUE_ONE_ERROR(1, false, AZUL, AZUL),
    GREEN_ONE_ERROR(1, false, VERDE, AMARELO),
    YELLOW_ONE_ERROR(1, false, AMARELO, VERDE),

    RED_TWO_ERRORS(2, false, VERMELHO, AMARELO),
    BLUE_TWO_ERRORS(2, false, AZUL, VERDE),
    GREEN_TWO_ERRORS(2, false, VERDE, AZUL),
    YELLOW_TWO_ERRORS(2, false, AMARELO, VERMELHO);

    private final Integer countErrors;
    private final boolean serialWithVowel;
    private final Color buttonColor;
    private final Color equivalentColor;

    public static Color getEquivalentColor(Integer countErrors, boolean serialWithVowel, Color buttonColor) {
        return Stream.of(GeniusFlash.values())
                .filter(g -> g.getCountErrors().equals(countErrors)
                        && g.isSerialWithVowel() == serialWithVowel
                        && g.getButtonColor().equals(buttonColor))
                .findFirst()
                .map(GeniusFlash::getEquivalentColor)
                .orElse(VERMELHO);
    }
}
