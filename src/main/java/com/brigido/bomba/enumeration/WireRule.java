package com.brigido.bomba.enumeration;

import com.brigido.bomba.dto.wire.ThreadDTO;
import com.brigido.bomba.dto.wire.WireDTO;
import java.util.List;
import static com.brigido.bomba.enumeration.Color.*;
import static com.brigido.bomba.util.Const.*;
import static com.brigido.bomba.util.Const.CORTE_SEGUNDO_FIO;

public enum WireRule {

    WIRE_RULE_3 {
        @Override
        public String rule(WireDTO dto) {
            if (dto.getWiresPerColor(VERMELHO).isEmpty()) {
                return CORTE_SEGUNDO_FIO;
            } else if (BRANCO.equals(dto.getLastWire().getColor())) {
                return CORTE_ULTIMO_FIO;
            } else if (dto.getWiresPerColor(AZUL).size() > 1) {
                return CORTE_ULTIMO_FIO_AZUL;
            }
            return CORTE_ULTIMO_FIO;
        }
    },

    WIRE_RULE_4 {
        @Override
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
            }
            return CORTE_SEGUNDO_FIO;
        }
    },

    WIRE_RULE_5 {
        @Override
        public String rule(WireDTO dto) {
            if (PRETO.equals(dto.getLastWire().getColor()) && dto.isSerialLastNumberOdd()) {
                return CORTE_QUARTO_FIO;
            } else if (dto.getWiresPerColor(VERMELHO).size() == 1 && dto.getWiresPerColor(AMARELO).size() > 1) {
                return CORTE_PRIMEIRO_FIO;
            } else if (dto.getWiresPerColor(PRETO).isEmpty()) {
                return CORTE_SEGUNDO_FIO;
            }
            return CORTE_PRIMEIRO_FIO;
        }
    },
    WIRE_RULE_6 {
        @Override
        public String rule(WireDTO dto) {
            List<ThreadDTO> yellowWires = dto.getWiresPerColor(AMARELO);
            if (yellowWires.isEmpty() && dto.isSerialLastNumberOdd()) {
                return CORTE_TERCEIRO_FIO;
            } else if (yellowWires.size() == 1 && dto.getWiresPerColor(BRANCO).size() > 1) {
                return CORTE_QUARTO_FIO;
            } else if (dto.getWiresPerColor(VERMELHO).isEmpty()) {
                return CORTE_ULTIMO_FIO;
            }
            return CORTE_QUARTO_FIO;
        }
    };

    public abstract String rule(WireDTO dto);
}
