package com.brigido.bomba.dto.wire;

import com.brigido.bomba.enumeration.Color;
import lombok.*;
import java.util.*;
import java.util.stream.Collectors;
import static com.brigido.bomba.util.Util.onlyNumbers;
import static java.lang.Integer.parseInt;
import static java.util.Optional.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WireDTO {
    private UUID id;
    private String serial;
    private List<ThreadDTO> wiring;
    private Date createdAt;

    public List<ThreadDTO> getWiring() {
        return ofNullable(wiring).orElseGet(() -> wiring = new ArrayList<>());
    }

    public ThreadDTO getLastWire() {
        return getWiring().get(getWiring().size() - 1);
    }

    public boolean isSerialLastNumberOdd() {
        return parseInt(onlyNumbers(serial)) % 2 != 0;
    }

    public List<ThreadDTO> getWiresPerColor(Color color) {
        return wiring.stream().filter(wire -> color.equals(wire.getColor())).collect(Collectors.toList());
    }
}
