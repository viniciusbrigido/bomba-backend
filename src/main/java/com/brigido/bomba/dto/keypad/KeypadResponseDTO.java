package com.brigido.bomba.dto.keypad;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KeypadResponseDTO {
    private List<Integer> keypads;
    private String message;
}
