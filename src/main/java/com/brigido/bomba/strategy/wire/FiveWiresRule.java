package com.brigido.bomba.strategy.wire;

import com.brigido.bomba.dto.wire.WireDTO;
import static com.brigido.bomba.enumeration.Color.*;

public class FiveWiresRule implements WireRule {

    public String rule(WireDTO dto) {
        if (PRETO.equals(dto.getLastWire().getColor()) && dto.isSerialLastNumberOdd()) {
            return CORTE_QUARTO_FIO;
        } else if (dto.getWiresPerColor(VERMELHO).size() == 1 && dto.getWiresPerColor(AMARELO).size() > 1) {
            return CORTE_PRIMEIRO_FIO;
        } else if (dto.getWiresPerColor(PRETO).isEmpty()) {
            return CORTE_SEGUNDO_FIO;
        } else {
            return CORTE_PRIMEIRO_FIO;
        }
    }
}
