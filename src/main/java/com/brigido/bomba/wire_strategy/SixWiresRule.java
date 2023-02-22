package com.brigido.bomba.wire_strategy;

import com.brigido.bomba.dto.wire.ThreadDTO;
import com.brigido.bomba.dto.wire.WireDTO;
import java.util.List;
import static com.brigido.bomba.enumeration.Color.*;

public class SixWiresRule implements WireRule {

    public String rule(WireDTO dto) {
        List<ThreadDTO> yellowWires = dto.getWiresPerColor(AMARELO);
        if (yellowWires.isEmpty() && dto.isSerialLastNumberOdd()) {
            return CORTE_TERCEIRO_FIO;
        } else if (yellowWires.size() == 1 && dto.getWiresPerColor(BRANCO).size() > 1) {
            return CORTE_QUARTO_FIO;
        } else if (dto.getWiresPerColor(VERMELHO).isEmpty()) {
            return CORTE_ULTIMO_FIO;
        } else {
            return CORTE_QUARTO_FIO;
        }
    }
}
