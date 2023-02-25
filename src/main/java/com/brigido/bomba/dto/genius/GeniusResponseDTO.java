package com.brigido.bomba.dto.genius;

import com.brigido.bomba.enumeration.Color;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeniusResponseDTO {
    private List<Color> colors;
}
