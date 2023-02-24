package com.brigido.bomba.dto.keypad;

import com.brigido.bomba.enumeration.Keypad;
import lombok.*;
import java.util.*;
import static java.util.Optional.ofNullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KeypadDTO {
    private UUID id;
    private List<Keypad> keypads;
    private Date createdAt;

    public List<Keypad> getKeypads() {
        return ofNullable(keypads).orElseGet(() -> keypads = new ArrayList<>());
    }
}
