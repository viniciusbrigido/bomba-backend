package com.brigido.bomba.service.impl;

import com.brigido.bomba.dto.keypad.KeypadDTO;
import com.brigido.bomba.dto.keypad.KeypadResponseDTO;
import com.brigido.bomba.entity.KeypadEntity;
import com.brigido.bomba.enumeration.Keypad;
import com.brigido.bomba.repository.KeypadRepository;
import com.brigido.bomba.service.KeypadService;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import static com.brigido.bomba.enumeration.Keypad.*;

@Service
public class KeypadServiceImpl implements KeypadService {

    @Autowired
    private KeypadRepository keypadRepository;

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

    @Override
    public List<KeypadEntity> list() {
        return keypadRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        keypadRepository.deleteById(id);
    }
}
