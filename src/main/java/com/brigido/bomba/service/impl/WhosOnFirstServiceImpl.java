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
        WhosOnFirstEntity whosOnFirst = whosOnFirstRepository.findById(dto.getId()).orElse(create(dto));

//        return buttonRule.getButtonResponse(buttonEntity.getId(), dto);
        return WhosOnFirstResponseDTO.builder()
                .id(whosOnFirst.getId())
                .build();
    }

    @Override
    public WhosOnFirstDTO resolveSecondStep(WhosOnFirstSecondStepDTO dto) {
        Optional<WhosOnFirstEntity> whosOnFirst = whosOnFirstRepository.findById(dto.getId());
//        if (button.isPresent()) {
//            ButtonEntity buttonEntity = button.get();
//            buttonEntity.setLedColor(dto.getLedColor());
//            buttonRepository.save(buttonEntity);
//        }
//
//        return ButtonResponseDTO.builder()
//                .message(mostraMsgTempo(dto.getLedColor()))
//                .nextStep(false)
//                .build();

        return null;
    }

    @Transactional
    public WhosOnFirstEntity create(WhosOnFirstDTO dto) {
        var button = WhosOnFirstEntity.builder()
                .build();

        return whosOnFirstRepository.save(button);
    }

    private WhosOnFirstDTO parseWhosOnFirst(WhosOnFirstEntity whosOnFirst) {
        WhosOnFirstDTO whosOnFirstDTO = modelMapper.map(whosOnFirst, WhosOnFirstDTO.class);
        Type listType = new TypeToken<List<String>>(){}.getType();
//        whosOnFirstDTO.setWords6(gson.fromJson(whosOnFirst.getWords6(), listType));

        return whosOnFirstDTO;
    }

    @Override
    public List<WhosOnFirstDTO> list() {
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
