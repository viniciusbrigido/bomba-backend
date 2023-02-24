package com.brigido.bomba.controller;

import com.brigido.bomba.dto.keypad.KeypadDTO;
import com.brigido.bomba.dto.keypad.KeypadResponseDTO;
import com.brigido.bomba.entity.KeypadEntity;
import com.brigido.bomba.enumeration.Keypad;
import com.brigido.bomba.service.KeypadService;
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
@RequestMapping("/keypad")
public class KeypadController {

    @Autowired
    private KeypadService keypadService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Gson gson;

    @PostMapping("/resolve")
    public KeypadResponseDTO resolve(@RequestBody KeypadDTO dto) {
        return keypadService.resolve(dto);
    }

    @GetMapping
    public List<KeypadDTO> list() {
        return keypadService.list()
                .stream()
                .map(this::parseKeypad)
                .collect(Collectors.toList());
    }

    private KeypadDTO parseKeypad(KeypadEntity keypad) {
        KeypadDTO keypadDTO = modelMapper.map(keypad, KeypadDTO.class);
        Type listType = new TypeToken<List<Keypad>>(){}.getType();
        keypadDTO.setKeypads(gson.fromJson(keypad.getKeypads(), listType));
        return keypadDTO;
    }

    @DeleteMapping
    public void delete(@PathVariable UUID id) {
        keypadService.delete(id);
    }
}
