package com.brigido.bomba.wire_strategy;

import com.brigido.bomba.dto.wire.WireDTO;

public interface WireRule {
    String CORTE_PRIMEIRO_FIO = "Corte o 1° Fio";
    String CORTE_SEGUNDO_FIO = "Corte o 2° Fio";
    String CORTE_TERCEIRO_FIO = "Corte o 3° Fio";
    String CORTE_QUARTO_FIO = "Corte o 4° Fio";
    String CORTE_ULTIMO_FIO = "Corte o Último Fio";
    String CORTE_ULTIMO_FIO_AZUL = "Corte o Último Fio AZUL";
    String CORTE_ULTIMO_FIO_VERMELHO = "Corte o Último Fio VERMELHO";

    String rule(WireDTO dto);
}
