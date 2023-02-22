package com.brigido.bomba.controller;

import com.brigido.bomba.dto.*;
import com.brigido.bomba.entity.ButtonEntity;
import com.brigido.bomba.service.ButtonService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

@CrossOrigin
@RestController
@RequestMapping("/button")
public class ButtonController {

    @Autowired
    private ButtonService buttonService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Gson gson;

    @PostMapping("/resolve")
    public ButtonResponseDTO resolve(@RequestBody ButtonDTO dto) {
        return buttonService.resolve(dto);
    }

    @PostMapping("/resolve-second-step")
    public ButtonResponseDTO resolveSecondStep(@RequestBody ButtonResponseSecondStepDTO dto) {
        return buttonService.resolveSecondStep(dto);
    }

    @GetMapping
    public List<ButtonDTO> list() {
        return buttonService.list()
                .stream()
                .map(this::parseButton)
                .collect(Collectors.toList());
    }
    
    private ButtonDTO parseButton(ButtonEntity button) {
        ButtonDTO buttonDTO = modelMapper.map(button, ButtonDTO.class);
        Type listType = new TypeToken<List<LedDTO>>(){}.getType();
        buttonDTO.setLeds(gson.fromJson(button.getLeds(), listType));
        return buttonDTO;
    }

    @DeleteMapping
    public void delete(@PathVariable UUID id) {
        buttonService.delete(id);
    }
}
