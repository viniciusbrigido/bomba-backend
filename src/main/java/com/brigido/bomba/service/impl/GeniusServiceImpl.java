package com.brigido.bomba.service.impl;

import com.brigido.bomba.dto.genius.GeniusDTO;
import com.brigido.bomba.dto.genius.GeniusResponseDTO;
import com.brigido.bomba.entity.GeniusEntity;
import com.brigido.bomba.enumeration.Color;
import com.brigido.bomba.repository.GeniusRepository;
import com.brigido.bomba.service.GeniusService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.*;
import static com.brigido.bomba.enumeration.GeniusFlash.*;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

@Service
public class GeniusServiceImpl implements GeniusService {

    @Autowired
    private GeniusRepository geniusRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Gson gson;

    @Override
    public GeniusResponseDTO resolve(GeniusDTO dto) {
        create(dto);
        return GeniusResponseDTO.builder()
                .colors(resolveGenius(dto))
                .build();
    }

    private List<Color> resolveGenius(GeniusDTO dto) {
        return dto.getColors().stream()
                .map(color -> getEquivalentColor(dto.getCountErrors(), isSerialWithVowel(dto.getSerial()), color))
                .collect(toList());
    }

    private boolean isSerialWithVowel(String serial) {
        List<String> vowels = asList("a", "e", "i", "o", "u");
        return vowels.stream().anyMatch(vowel -> serial.toLowerCase().contains(vowel));
    }

    @Transactional
    public void create(GeniusDTO dto) {
        var genius = GeniusEntity.builder()
                .colors(gson.toJson(dto.getColors()))
                .serial(dto.getSerial())
                .countErrors(dto.getCountErrors())
                .createdAt(new Date())
                .build();

        geniusRepository.save(genius);
    }

    private GeniusDTO parseGenius(GeniusEntity genius) {
        GeniusDTO geniusDTO = modelMapper.map(genius, GeniusDTO.class);
        Type listType = new TypeToken<List<Color>>(){}.getType();
        geniusDTO.setColors(gson.fromJson(genius.getColors(), listType));
        return geniusDTO;
    }

    @Override
    public List<GeniusDTO> list() {
        return geniusRepository.findAll()
                .stream()
                .map(this::parseGenius)
                .collect(toList());
    }

    @Override
    public void delete(UUID id) {
        geniusRepository.deleteById(id);
    }
}
