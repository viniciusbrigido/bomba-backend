package com.brigido.bomba.wire_strategy;

import com.brigido.bomba.dto.wire.WireDTO;
import static com.brigido.bomba.enumeration.Color.*;

public class ThreeWiresRule implements WireRule {

    public String rule(WireDTO dto) {
        if (dto.getWiresPerColor(VERMELHO).isEmpty()) {
            return CORTE_SEGUNDO_FIO;
        } else if (BRANCO.equals(dto.getLastWire().getColor())) {
            return CORTE_ULTIMO_FIO;
        } else if (dto.getWiresPerColor(AZUL).size() > 1) {
            return CORTE_ULTIMO_FIO_AZUL;
        } else {
            return CORTE_ULTIMO_FIO;
        }
    }
}
