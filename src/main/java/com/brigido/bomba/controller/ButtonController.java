package com.brigido.bomba.controller;

import com.brigido.bomba.dto.button.*;
import com.brigido.bomba.service.ButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/button")
public class ButtonController {

    @Autowired
    private ButtonService buttonService;

    @PostMapping("/resolve")
    public ButtonResponseDTO resolve(@RequestBody ButtonDTO dto) {
        return buttonService.resolve(dto);
    }

    @PostMapping("/resolve-second-step")
    public ButtonResponseDTO resolveSecondStep(@RequestBody ButtonSecondStepDTO dto) {
        return buttonService.resolveSecondStep(dto);
    }

    @GetMapping
    public List<ButtonDTO> list() {
        return buttonService.list();
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        buttonService.delete(id);
    }
}
