package com.brigido.bomba.service;

import com.brigido.bomba.dto.wire.WireDTO;
import com.brigido.bomba.dto.wire.WireResponseDTO;
import java.util.List;
import java.util.UUID;

public interface WireService {
    WireResponseDTO resolve(WireDTO dto);
    List<WireDTO> list();
    void delete(UUID id);
}
