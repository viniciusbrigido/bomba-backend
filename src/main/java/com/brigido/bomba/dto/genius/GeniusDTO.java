package com.brigido.bomba.dto.genius;

import com.brigido.bomba.enumeration.Color;
import lombok.*;
import java.util.*;
import static java.util.Optional.ofNullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeniusDTO {
    private UUID id;
    private String serial;
    private Integer countErrors;
    private List<Color> colors;
    private Date createdAt;

    public List<Color> getColors() {
        return ofNullable(colors).orElseGet(() -> colors = new ArrayList<>());
    }
}
