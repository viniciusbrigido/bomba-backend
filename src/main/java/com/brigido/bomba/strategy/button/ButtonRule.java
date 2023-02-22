package com.brigido.bomba.strategy.button;

import com.brigido.bomba.dto.button.ButtonDTO;
import com.brigido.bomba.dto.button.ButtonResponseDTO;
import java.util.UUID;

public interface ButtonRule {

    String PRESSIONE_SOLTE_BOTAO = "Pressione e imediamente solte o botão.";
    String PRESSIONE_BOTAO_LED = "Pressione o botão e informe a luz no led que aparece à direita do botão.";

    ButtonResponseDTO getButtonResponse(UUID id, ButtonDTO dto);
}
