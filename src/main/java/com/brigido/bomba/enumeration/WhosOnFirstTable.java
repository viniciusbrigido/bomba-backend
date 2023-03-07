package com.brigido.bomba.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WhosOnFirstTable {

    SIM("SIM", 3),
    VOCE_E("VOCE É", 2),
    DISPLAY("DISPLAY", 6),
    OK("OK", 2),
    TA_FALANDO("TÁ FALANDO", 6),
    NADA("NADA", 3),
    VAZIO_LITERAL("", 5),
    VAZIO("VAZIO", 4),
    NAO("NÃO", 6),
    CELA("CELA", 3),
    SELA("SELA", 6),
    CEM("CEM", 4),
    SEXTA("SEXTA", 4),
    CESTA("CESTA", 5),
    SEM("SEM", 5),
    CALMA_AI("CALMA AÍ", 6),
    DE_NOVO("DE NOVO", 4),
    CAUDA("CAUDA", 6),
    CALDA("CALDA", 4),
    VC_E("VC É", 4),
    BOOM("BOOM", 1),
    ERROU("ERROU", 6),
    MAS("MAS", 5),
    MAIS("MAIS", 4),
    NUNCA("NUNCA", 3),
    SE("SE", 6),
    C("C", 2),
    SER("SER", 6);

    private final String name;
    private final Integer wordIndex;

    public static Integer findWordIndexByName(String name) {
        for (WhosOnFirstTable table : WhosOnFirstTable.values()) {
            if (table.name.equals(name)) {
                return table.wordIndex - 1;
            }
        }
        return null;
    }
}
