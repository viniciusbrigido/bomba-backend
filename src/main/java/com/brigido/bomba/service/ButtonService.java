package com.brigido.bomba.service;

import com.brigido.bomba.dto.button.*;
import java.util.List;
import java.util.UUID;

public interface ButtonService {
    ButtonResponseDTO resolve(ButtonDTO dto);
    ButtonResponseDTO resolveSecondStep(ButtonSecondStepDTO dto);
    List<ButtonDTO> list();
    void delete(UUID id);
}
