package com.brigido.bomba.service;

import com.brigido.bomba.dto.genius.GeniusDTO;
import com.brigido.bomba.dto.genius.GeniusResponseDTO;
import java.util.List;
import java.util.UUID;

public interface GeniusService {
    GeniusResponseDTO resolve(GeniusDTO dto);
    List<GeniusDTO> list();
    void delete(UUID id);
}
