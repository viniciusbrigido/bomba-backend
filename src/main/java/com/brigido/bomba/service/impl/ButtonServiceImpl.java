package com.brigido.bomba.service.impl;

import com.brigido.bomba.dto.*;
import com.brigido.bomba.entity.ButtonEntity;
import com.brigido.bomba.enumeration.*;
import com.brigido.bomba.repository.ButtonRepository;
import com.brigido.bomba.service.ButtonService;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import static com.brigido.bomba.enumeration.Cor.*;
import static com.brigido.bomba.enumeration.Indicator.*;
import static com.brigido.bomba.enumeration.TextoBotao.*;
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
        } else if (isPilhasDetonar(dto)) {
            message = PRESSIONE_SOLTE_BOTAO;
        } else if (isBrancoCar(dto)) {
            message = PRESSIONE_BOTAO_LED;
            nextStep = true;
        } else if (isPilhasFrk(dto)) {
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
    public ButtonResponseDTO resolveSecondStep(ButtonResponseSecondStepDTO dto) {
        Optional<ButtonEntity> button = buttonRepository.findById(dto.getId());
        if (button.isPresent()) {
            ButtonEntity buttonEntity = button.get();
            buttonEntity.setCorLed(dto.getCorLed());
            buttonRepository.save(buttonEntity);
        }

        return ButtonResponseDTO.builder()
                .message(mostraMsgTempo(dto.getCorLed()))
                .nextStep(false)
                .build();
    }

    private boolean isAzulAbortar(ButtonDTO dto) {
        return AZUL.equals(dto.getCorBotao()) && ABORTAR.equals(dto.getTexto());
    }

    private boolean isPilhasDetonar(ButtonDTO dto) {
        return dto.getPilhas() > 1 && DETONAR.equals(dto.getTexto());
    }

    private boolean isBrancoCar(ButtonDTO dto) {
        return BRANCO.equals(dto.getCorBotao()) && contemIndicadorAceso(CAR, dto.getLeds());
    }

    private boolean isPilhasFrk(ButtonDTO dto) {
        return dto.getPilhas() > 2 && contemIndicadorAceso(FRK, dto.getLeds());
    }

    private boolean isAmarelo(ButtonDTO dto) {
        return AMARELO.equals(dto.getCorBotao());
    }

    private boolean isVermelhoSegure(ButtonDTO dto) {
        return VERMELHO.equals(dto.getCorBotao()) && SEGURE.equals(dto.getTexto());
    }

    private String mostraMsgTempo(Cor corLed) {
        return format("Solte quando o marcador de tempo tiver um %s em qualquer posição.", getSegundoPorLed(corLed));
    }

    private Integer getSegundoPorLed(Cor corLed) {
        return switch (corLed) {
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
        var user = ButtonEntity.builder()
                .texto(dto.getTexto())
                .corBotao(dto.getCorBotao())
                .corLed(dto.getCorLed())
                .pilhas(dto.getPilhas())
                .leds(gson.toJson(dto.getLeds()))
                .createdAt(new Date())
                .build();

        return buttonRepository.save(user);
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
