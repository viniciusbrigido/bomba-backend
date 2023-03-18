package com.brigido.bomba.dto.whos_on_first;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WhosOnFirstResponseDTO {
    private UUID id;
    private String message;
}
