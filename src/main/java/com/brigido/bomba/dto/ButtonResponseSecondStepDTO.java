package com.brigido.bomba.dto;

import com.brigido.bomba.enumeration.Cor;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ButtonResponseSecondStepDTO {
    private UUID id;
    private Cor corLed;
}
