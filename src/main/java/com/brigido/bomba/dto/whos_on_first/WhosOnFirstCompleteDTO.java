package com.brigido.bomba.dto.whos_on_first;

import lombok.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WhosOnFirstCompleteDTO {
    private UUID id;

    private String display1, display2, display3;

    private List<String> words1, words2, words3;
}
