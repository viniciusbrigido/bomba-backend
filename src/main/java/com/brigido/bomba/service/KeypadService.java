package com.brigido.bomba.service;

import com.brigido.bomba.dto.keypad.KeypadDTO;
import com.brigido.bomba.dto.keypad.KeypadResponseDTO;
import com.brigido.bomba.entity.KeypadEntity;
import java.util.List;
import java.util.UUID;

public interface KeypadService {
    KeypadResponseDTO resolve(KeypadDTO dto);
    List<KeypadEntity> list();
    void delete(UUID id);
}
