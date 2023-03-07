package com.brigido.bomba.service.impl;

import com.brigido.bomba.dto.whos_on_first.*;
import com.brigido.bomba.entity.WhosOnFirstEntity;
import com.brigido.bomba.repository.WhosOnFirstRepository;
import com.brigido.bomba.service.WhosOnFirstService;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import static com.brigido.bomba.enumeration.WhosOnFirstTable.*;
import static com.brigido.bomba.enumeration.WhosOnFirstWords.*;
import static java.util.Objects.*;
import static java.util.stream.Collectors.toList;

@Service
public class WhosOnFirstServiceImpl implements WhosOnFirstService {

    @Autowired
    private WhosOnFirstRepository whosOnFirstRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Gson gson;

    @Override
    public WhosOnFirstResponseDTO resolve(WhosOnFirstDTO dto) {
        WhosOnFirstEntity whosOnFirst = isNull(dto.getId()) ? create(dto) : findById(dto.getId());

        Integer wordIndex = findWordIndexByName(dto.getDisplay());
        return WhosOnFirstResponseDTO.builder()
                .id(whosOnFirst.getId())
                .response(getSelectedWord(dto.getWords(), wordIndex))
                .build();
    }

    @Transactional
    public WhosOnFirstEntity create(WhosOnFirstDTO dto) {
        WhosOnFirstEntity whosOnFirst = new WhosOnFirstEntity();
        setWhosOnFirstStep(whosOnFirst, dto);
        return whosOnFirstRepository.save(whosOnFirst);
    }

    private WhosOnFirstEntity findById(UUID id) {
        return whosOnFirstRepository.findById(id).orElseThrow(() -> new RuntimeException("Entidade não encontrada!"));
    }

    public void setWhosOnFirstStep(WhosOnFirstEntity whosOnFirst, WhosOnFirstDTO dto) {
        String display = dto.getDisplay();
        String words = gson.toJson(dto.getWords());
        switch (dto.getStep()) {
            case 1 -> {
                whosOnFirst.setDisplay1(display);
                whosOnFirst.setWords1(words);
            }
            case 2 -> {
                whosOnFirst.setDisplay2(display);
                whosOnFirst.setWords2(words);
            }
            case 3 -> {
                whosOnFirst.setDisplay3(display);
                whosOnFirst.setWords3(words);
            }
        }
    }

    private WhosOnFirstCompleteDTO parseWhosOnFirst(WhosOnFirstEntity whosOnFirst) {
        WhosOnFirstCompleteDTO whosOnFirstCompleteDTO = modelMapper.map(whosOnFirst, WhosOnFirstCompleteDTO.class);
        Type listType = new TypeToken<List<String>>(){}.getType();
        whosOnFirstCompleteDTO.setWords1(gson.fromJson(whosOnFirst.getWords1(), listType));
        whosOnFirstCompleteDTO.setWords2(gson.fromJson(whosOnFirst.getWords2(), listType));
        whosOnFirstCompleteDTO.setWords3(gson.fromJson(whosOnFirst.getWords3(), listType));

        return whosOnFirstCompleteDTO;
    }

    @Override
    public List<WhosOnFirstCompleteDTO> list() {
        return whosOnFirstRepository.findAll()
                .stream()
                .map(this::parseWhosOnFirst)
                .collect(toList());
    }

    @Override
    public void delete(UUID id) {
        whosOnFirstRepository.deleteById(id);
    }
}
