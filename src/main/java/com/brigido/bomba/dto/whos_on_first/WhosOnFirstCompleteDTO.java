package com.brigido.bomba.dto.whos_on_first;

import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WhosOnFirstCompleteDTO {
    private UUID id;

    private String display1, display2, display3;

    private List<String> words1, words2, words3;

    private Date createdAt;
}
