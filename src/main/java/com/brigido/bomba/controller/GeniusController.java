package com.brigido.bomba.controller;

import com.brigido.bomba.dto.genius.GeniusDTO;
import com.brigido.bomba.dto.genius.GeniusResponseDTO;
import com.brigido.bomba.service.GeniusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/genius")
public class GeniusController {

    @Autowired
    private GeniusService geniusService;

    @PostMapping("/resolve")
    public GeniusResponseDTO resolve(@RequestBody GeniusDTO dto) {
        return geniusService.resolve(dto);
    }

    @GetMapping
    public List<GeniusDTO> list() {
        return geniusService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        geniusService.delete(id);
    }
}
