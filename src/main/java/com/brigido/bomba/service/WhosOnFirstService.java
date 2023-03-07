package com.brigido.bomba.service;

import com.brigido.bomba.dto.whos_on_first.*;
import java.util.List;
import java.util.UUID;

public interface WhosOnFirstService {

    WhosOnFirstResponseDTO resolve(WhosOnFirstDTO dto);
    List<WhosOnFirstCompleteDTO> list();
    void delete(UUID id);
}
