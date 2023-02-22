package com.brigido.bomba.dto;

import com.brigido.bomba.enumeration.Cor;
import com.brigido.bomba.enumeration.TextoBotao;
import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ButtonDTO {
    private UUID id;
    private TextoBotao texto;
    private Cor corBotao;
    private Cor corLed;
    private List<LedDTO> leds;
    private Integer pilhas;
    private Date createdAt;
}
