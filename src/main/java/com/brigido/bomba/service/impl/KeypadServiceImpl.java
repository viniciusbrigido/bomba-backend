package com.brigido.bomba.service.impl;

import com.brigido.bomba.dto.keypad.KeypadDTO;
import com.brigido.bomba.dto.keypad.KeypadResponseDTO;
import com.brigido.bomba.entity.KeypadEntity;
import com.brigido.bomba.enumeration.Keypad;
import com.brigido.bomba.repository.KeypadRepository;
import com.brigido.bomba.service.KeypadService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.*;
import static com.brigido.bomba.enumeration.Keypad.*;
import static java.util.stream.Collectors.*;

@Service
public class KeypadServiceImpl implements KeypadService {

    @Autowired
    private KeypadRepository keypadRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Gson gson;

    @Override
    public KeypadResponseDTO resolve(KeypadDTO dto) {
        create(dto);
        List<Integer> keypads = resolveKeypad(dto).stream().map(Keypad::getArquivo).toList();
        String message = keypads.isEmpty()
                ? "As imagnes selecionadas não pertencem as colunas do manual. Revise as imagens e tente novamente."
                : "Selecione as teclas na ordem a seguir.";

        return KeypadResponseDTO.builder()
                .message(message)
                .keypads(keypads)
                .build();
    }

    private List<Keypad> resolveKeypad(KeypadDTO dto) {
        if (containAllKeypads(getColumnA(), dto)) {
            return resolveColumn(getColumnA(), dto);
        } else if (containAllKeypads(getColumnB(), dto)) {
            return resolveColumn(getColumnB(), dto);
        } else if (containAllKeypads(getColumnC(), dto)) {
            return resolveColumn(getColumnC(), dto);
        } else if (containAllKeypads(getColumnD(), dto)) {
            return resolveColumn(getColumnD(), dto);
        } else if (containAllKeypads(getColumnE(), dto)) {
            return resolveColumn(getColumnE(), dto);
        } else {
            return resolveColumn(getColumnF(), dto);
        }
    }

    private List<Keypad> resolveColumn(List<Keypad> column, KeypadDTO dto) {
        List<Keypad> columnLinkedList = new LinkedList<>(column);
        columnLinkedList.removeIf(keypad -> !dto.getKeypads().contains(keypad));
        return columnLinkedList;
    }

    private boolean containAllKeypads(List<Keypad> column, KeypadDTO dto) {
        return column.containsAll(dto.getKeypads());
    }

    @Transactional
    public void create(KeypadDTO dto) {
        var keypad = KeypadEntity.builder()
                .keypads(gson.toJson(dto.getKeypads()))
                .createdAt(new Date())
                .build();

        keypadRepository.save(keypad);
    }

    private KeypadDTO parseKeypad(KeypadEntity keypad) {
        KeypadDTO keypadDTO = modelMapper.map(keypad, KeypadDTO.class);
        Type listType = new TypeToken<List<Keypad>>(){}.getType();
        keypadDTO.setKeypads(gson.fromJson(keypad.getKeypads(), listType));
        return keypadDTO;
    }

    @Override
    public List<KeypadDTO> list() {
        return keypadRepository.findAll()
                .stream()
                .map(this::parseKeypad)
                .collect(toList());
    }

    @Override
    public void delete(UUID id) {
        keypadRepository.deleteById(id);
    }
}
