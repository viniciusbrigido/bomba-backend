package com.brigido.bomba.service;

import com.brigido.bomba.dto.*;
import com.brigido.bomba.entity.ButtonEntity;
import java.util.List;
import java.util.UUID;

public interface ButtonService {
    ButtonResponseDTO resolve(ButtonDTO dto);
    ButtonResponseDTO resolveSecondStep(ButtonResponseSecondStepDTO dto);
    List<ButtonEntity> list();
    void delete(UUID id);
}
