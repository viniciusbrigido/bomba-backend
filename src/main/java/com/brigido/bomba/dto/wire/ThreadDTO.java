package com.brigido.bomba.dto.wire;

import com.brigido.bomba.enumeration.Color;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThreadDTO {
    private Integer position;
    private Color color;
}
