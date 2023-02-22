package com.brigido.bomba.strategy.button;

import com.brigido.bomba.dto.button.ButtonDTO;
import com.brigido.bomba.dto.button.ButtonResponseDTO;
import java.util.UUID;

public class AzulAbortarButtonRule implements ButtonRule {

    @Override
    public ButtonResponseDTO getButtonResponse(UUID id, ButtonDTO dto) {
        return ButtonResponseDTO.builder()
                .id(id)
                .message(PRESSIONE_SOLTE_BOTAO)
                .nextStep(true)
                .build();
    }
}
