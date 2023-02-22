package com.brigido.bomba.dto;

import com.brigido.bomba.enumeration.Indicator;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LedDTO {
    private Indicator indicator;
    private boolean on;
}
