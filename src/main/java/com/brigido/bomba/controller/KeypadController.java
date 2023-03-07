package com.brigido.bomba.controller;

import com.brigido.bomba.dto.keypad.KeypadDTO;
import com.brigido.bomba.dto.keypad.KeypadResponseDTO;
import com.brigido.bomba.service.KeypadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/keypad")
public class KeypadController {

    @Autowired
    private KeypadService keypadService;

    @PostMapping("/resolve")
    public KeypadResponseDTO resolve(@RequestBody KeypadDTO dto) {
        return keypadService.resolve(dto);
    }

    @GetMapping
    public List<KeypadDTO> list() {
        return keypadService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        keypadService.delete(id);
    }
}
