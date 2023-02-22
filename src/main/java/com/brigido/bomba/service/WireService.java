package com.brigido.bomba.service;

import com.brigido.bomba.dto.wire.WireDTO;
import com.brigido.bomba.dto.wire.WireResponseDTO;
import com.brigido.bomba.entity.WireEntity;
import java.util.List;
import java.util.UUID;

public interface WireService {
    WireResponseDTO resolve(WireDTO dto);
    List<WireEntity> list();
    void delete(UUID id);
}
