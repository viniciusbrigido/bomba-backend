package com.brigido.bomba.service.impl;

import com.brigido.bomba.dto.wire.WireDTO;
import com.brigido.bomba.dto.wire.WireResponseDTO;
import com.brigido.bomba.entity.WireEntity;
import com.brigido.bomba.repository.WireRepository;
import com.brigido.bomba.service.WireService;
import com.brigido.bomba.strategy.wire.*;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class WireServiceImpl implements WireService {

    @Autowired
    private WireRepository wireRepository;

    @Autowired
    private Gson gson;

    @Override
    public WireResponseDTO resolve(WireDTO dto) {
        create(dto);
        return WireResponseDTO.builder()
                .message(wireRuleMessage(dto))
                .build();
    }

    private String wireRuleMessage(WireDTO dto) {
        int wireCount = dto.getWiring().size();
        WireRule wireRule = switch (wireCount) {
            case 3 -> new ThreeWiresRule();
            case 4 -> new FourWiresRule();
            case 5 -> new FiveWiresRule();
            default -> new SixWiresRule();
        };

        return wireRule.rule(dto);
    }

    @Transactional
    public void create(WireDTO dto) {
        var wire = WireEntity.builder()
                .serial(dto.getSerial())
                .wiring(gson.toJson(dto.getWiring()))
                .createdAt(new Date())
                .build();

        wireRepository.save(wire);
    }

    @Override
    public void delete(UUID id) {
        wireRepository.deleteById(id);
    }

    @Override
    public List<WireEntity> list() {
        return wireRepository.findAll();
    }
}
