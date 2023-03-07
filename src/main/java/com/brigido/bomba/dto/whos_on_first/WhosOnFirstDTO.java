package com.brigido.bomba.dto.whos_on_first;

import lombok.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WhosOnFirstDTO {
    private UUID id;
    private String display;
    private Integer step;
    private List<String> words;
}
