package com.brigido.bomba.dto.button;

import com.brigido.bomba.enumeration.Color;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ButtonSecondStepDTO {
    private UUID id;
    private Color colorLed;
}
