package com.brigido.bomba.strategy.wire;

import com.brigido.bomba.dto.wire.ThreadDTO;
import com.brigido.bomba.dto.wire.WireDTO;
import java.util.List;
import static com.brigido.bomba.enumeration.Color.*;

public class FourWiresRule implements WireRule {

    public String rule(WireDTO dto) {
        List<ThreadDTO> redWires = dto.getWiresPerColor(VERMELHO);
        if (redWires.size() > 1 && dto.isSerialLastNumberOdd()) {
            return CORTE_ULTIMO_FIO_VERMELHO;
        } else if (AMARELO.equals(dto.getLastWire().getColor()) && redWires.isEmpty()) {
            return CORTE_PRIMEIRO_FIO;
        } else if (dto.getWiresPerColor(AZUL).size() == 1) {
            return CORTE_PRIMEIRO_FIO;
        } else if (dto.getWiresPerColor(AMARELO).size() > 1) {
            return CORTE_ULTIMO_FIO;
        } else {
            return CORTE_SEGUNDO_FIO;
        }
    }
}
