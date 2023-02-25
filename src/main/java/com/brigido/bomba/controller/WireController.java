package com.brigido.bomba.controller;

import com.brigido.bomba.dto.wire.*;
import com.brigido.bomba.service.WireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/wire")
public class WireController {

    @Autowired
    private WireService wireService;

    @PostMapping("/resolve")
    public WireResponseDTO resolve(@RequestBody WireDTO dto) {
        return wireService.resolve(dto);
    }

    @GetMapping
    public List<WireDTO> list() {
        return wireService.list();
    }

    @DeleteMapping
    public void delete(@PathVariable UUID id) {
        wireService.delete(id);
    }
}
