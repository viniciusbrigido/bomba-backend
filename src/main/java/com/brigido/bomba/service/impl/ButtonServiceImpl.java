package com.brigido.bomba.service.impl;

import com.brigido.bomba.dto.*;
import com.brigido.bomba.dto.button.*;
import com.brigido.bomba.entity.ButtonEntity;
import com.brigido.bomba.enumeration.*;
import com.brigido.bomba.repository.ButtonRepository;
import com.brigido.bomba.service.ButtonService;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import static com.brigido.bomba.enumeration.Color.*;
import static com.brigido.bomba.enumeration.Indicator.*;
import static com.brigido.bomba.enumeration.ButtonText.*;
import static java.lang.String.*;

@Service
public class ButtonServiceImpl implements ButtonService {
    
    private static final String PRESSIONE_SOLTE_BOTAO = "Pressione e imediamente solte o botão.";
    private static final String PRESSIONE_BOTAO_LED = "Pressione o botão e informe a luz no led que aparece à direita do botão.";

    @Autowired
    private ButtonRepository buttonRepository;

    @Autowired
    private Gson gson;

    @Override
    public ButtonResponseDTO resolve(ButtonDTO dto) {
        ButtonEntity buttonEntity = create(dto);
        
        String message;
        boolean nextStep = false;

        if (isAzulAbortar(dto)) {
            message = PRESSIONE_BOTAO_LED;
            nextStep = true;
        } else if (isBatteriesDetonar(dto)) {
            message = PRESSIONE_SOLTE_BOTAO;
        } else if (isBrancoCar(dto)) {
            message = PRESSIONE_BOTAO_LED;
            nextStep = true;
        } else if (isBatteriesFrk(dto)) {
            message = PRESSIONE_SOLTE_BOTAO;
        } else if (isAmarelo(dto)) {
            message = PRESSIONE_BOTAO_LED;
            nextStep = true;
        } else if (isVermelhoSegure(dto)) {
            message = PRESSIONE_SOLTE_BOTAO;
        } else {
            message = PRESSIONE_BOTAO_LED;
            nextStep = true;
        }

        return ButtonResponseDTO.builder()
                .id(buttonEntity.getId())
                .message(message)
                .nextStep(nextStep)
                .build();
    }

    @Override
    public ButtonResponseDTO resolveSecondStep(ButtonSecondStepDTO dto) {
        Optional<ButtonEntity> button = buttonRepository.findById(dto.getId());
        if (button.isPresent()) {
            ButtonEntity buttonEntity = button.get();
            buttonEntity.setLedColor(dto.getColorLed());
            buttonRepository.save(buttonEntity);
        }

        return ButtonResponseDTO.builder()
                .message(mostraMsgTempo(dto.getColorLed()))
                .nextStep(false)
                .build();
    }

    private boolean isAzulAbortar(ButtonDTO dto) {
        return AZUL.equals(dto.getButtonColor()) && ABORTAR.equals(dto.getText());
    }

    private boolean isBatteriesDetonar(ButtonDTO dto) {
        return dto.getBatteries() > 1 && DETONAR.equals(dto.getText());
    }

    private boolean isBrancoCar(ButtonDTO dto) {
        return BRANCO.equals(dto.getButtonColor()) && contemIndicadorAceso(CAR, dto.getLeds());
    }

    private boolean isBatteriesFrk(ButtonDTO dto) {
        return dto.getBatteries() > 2 && contemIndicadorAceso(FRK, dto.getLeds());
    }

    private boolean isAmarelo(ButtonDTO dto) {
        return AMARELO.equals(dto.getButtonColor());
    }

    private boolean isVermelhoSegure(ButtonDTO dto) {
        return VERMELHO.equals(dto.getButtonColor()) && SEGURE.equals(dto.getText());
    }

    private String mostraMsgTempo(Color colorLed) {
        return format("Solte quando o marcador de tempo tiver um %s em qualquer posição.", getSegundoPorLed(colorLed));
    }

    private Integer getSegundoPorLed(Color colorLed) {
        return switch (colorLed) {
            case AZUL -> 4;
            case AMARELO -> 5;
            default -> 1;
        };
    }

    private boolean contemIndicadorAceso(Indicator indicator, List<LedDTO> leds) {
        return leds.stream().anyMatch(led -> indicator.equals(led.getIndicator()) && led.isOn());
    }

    @Transactional
    public ButtonEntity create(ButtonDTO dto) {
        var button = ButtonEntity.builder()
                .text(dto.getText())
                .buttonColor(dto.getButtonColor())
                .ledColor(dto.getLedColor())
                .batteries(dto.getBatteries())
                .leds(gson.toJson(dto.getLeds()))
                .createdAt(new Date())
                .build();

        return buttonRepository.save(button);
    }

    @Override
    public void delete(UUID id) {
        buttonRepository.deleteById(id);
    }

    @Override
    public List<ButtonEntity> list() {
        return buttonRepository.findAll();
    }
}
