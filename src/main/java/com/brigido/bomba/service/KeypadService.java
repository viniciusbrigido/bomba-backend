package com.brigido.bomba.service;

import com.brigido.bomba.dto.keypad.KeypadDTO;
import com.brigido.bomba.dto.keypad.KeypadResponseDTO;
import java.util.List;
import java.util.UUID;

public interface KeypadService {
    KeypadResponseDTO resolve(KeypadDTO dto);
    List<KeypadDTO> list();
    void delete(UUID id);
}
