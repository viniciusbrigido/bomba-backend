package com.brigido.bomba.controller;

import com.brigido.bomba.dto.whos_on_first.*;
import com.brigido.bomba.service.WhosOnFirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/whos_on_first")
public class WhosOnFirstController {

    @Autowired
    private WhosOnFirstService whosOnFirstService;

    @PostMapping("/resolve")
    public WhosOnFirstResponseDTO resolve(@RequestBody WhosOnFirstDTO dto) {
        return whosOnFirstService.resolve(dto);
    }

    @PostMapping("/resolve-second-step")
    public WhosOnFirstDTO resolveSecondStep(@RequestBody WhosOnFirstSecondStepDTO dto) {
        return whosOnFirstService.resolveSecondStep(dto);
    }

    @GetMapping
    public List<WhosOnFirstDTO> list() {
        return whosOnFirstService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        whosOnFirstService.delete(id);
    }
}
