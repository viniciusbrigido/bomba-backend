package com.brigido.bomba.service.impl;

import com.brigido.bomba.dto.wire.*;
import com.brigido.bomba.entity.WireEntity;
import com.brigido.bomba.enumeration.WireRule;
import com.brigido.bomba.repository.WireRepository;
import com.brigido.bomba.service.WireService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.*;
import static java.lang.String.*;
import static java.util.stream.Collectors.toList;

@Service
public class WireServiceImpl implements WireService {

    @Autowired
    private WireRepository wireRepository;

    @Autowired
    private ModelMapper modelMapper;

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
        WireRule wireRule = WireRule.valueOf(format("WIRE_RULE_%s", wireCount));
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

    private WireDTO parseWire(WireEntity wire) {
        WireDTO wireDTO = modelMapper.map(wire, WireDTO.class);
        Type listType = new TypeToken<List<ThreadDTO>>(){}.getType();
        wireDTO.setWiring(gson.fromJson(wire.getWiring(), listType));
        return wireDTO;
    }

    @Override
    public List<WireDTO> list() {
        return wireRepository.findAll()
                .stream()
                .map(this::parseWire)
                .collect(toList());
    }

    @Override
    public void delete(UUID id) {
        wireRepository.deleteById(id);
    }
}
