package com.brigido.bomba.service;

import com.brigido.bomba.dto.button.*;
import com.brigido.bomba.entity.ButtonEntity;
import java.util.List;
import java.util.UUID;

public interface ButtonService {
    ButtonResponseDTO resolve(ButtonDTO dto);
    ButtonResponseDTO resolveSecondStep(ButtonSecondStepDTO dto);
    List<ButtonEntity> list();
    void delete(UUID id);
}
