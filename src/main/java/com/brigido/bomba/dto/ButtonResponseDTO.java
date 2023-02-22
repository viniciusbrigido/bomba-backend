package com.brigido.bomba.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ButtonResponseDTO {
    private UUID id;
    private String message;
    private boolean nextStep;
}
