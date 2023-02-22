package com.brigido.bomba.dto.button;

import com.brigido.bomba.dto.LedDTO;
import com.brigido.bomba.enumeration.Color;
import com.brigido.bomba.enumeration.ButtonText;
import lombok.*;
import java.util.*;
import static java.util.Optional.ofNullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ButtonDTO {
    private UUID id;
    private ButtonText text;
    private Color buttonColor;
    private Color ledColor;
    private List<LedDTO> leds;
    private Integer batteries;
    private Date createdAt;

    public List<LedDTO> getLeds() {
        return ofNullable(leds).orElseGet(() -> leds = new ArrayList<>());
    }
}
