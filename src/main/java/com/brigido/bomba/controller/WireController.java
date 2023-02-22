package com.brigido.bomba.controller;

import com.brigido.bomba.dto.wire.*;
import com.brigido.bomba.entity.WireEntity;
import com.brigido.bomba.service.WireService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/wire")
public class WireController {

    @Autowired
    private WireService wireService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Gson gson;

    @PostMapping("/resolve")
    public WireResponseDTO resolve(WireDTO dto) {
        return wireService.resolve(dto);
    }

    @GetMapping
    public List<WireDTO> list() {
        return wireService.list()
                .stream()
                .map(this::parseWire)
                .collect(Collectors.toList());
    }

    private WireDTO parseWire(WireEntity wire) {
        WireDTO wireDTO = modelMapper.map(wire, WireDTO.class);
        Type listType = new TypeToken<List<ThreadDTO>>(){}.getType();
        wireDTO.setWiring(gson.fromJson(wire.getWiring(), listType));
        return wireDTO;
    }

    @DeleteMapping
    public void delete(@PathVariable UUID id) {
        wireService.delete(id);
    }
}
