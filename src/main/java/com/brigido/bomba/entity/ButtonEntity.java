package com.brigido.bomba.entity;

import com.brigido.bomba.enumeration.Color;
import com.brigido.bomba.enumeration.ButtonText;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "button")
public class ButtonEntity implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ButtonText text;

    @Enumerated(EnumType.STRING)
    private Color buttonColor;

    @Enumerated(EnumType.STRING)
    private Color ledColor;

    private String leds;

    private Integer batteries;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
}
