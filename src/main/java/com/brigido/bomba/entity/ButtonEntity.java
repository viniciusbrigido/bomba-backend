package com.brigido.bomba.entity;

import com.brigido.bomba.enumeration.Cor;
import com.brigido.bomba.enumeration.TextoBotao;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "button")
public class ButtonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TextoBotao texto;

    @Enumerated(EnumType.STRING)
    private Cor corBotao;

    @Enumerated(EnumType.STRING)
    private Cor corLed;

    private String leds;

    private Integer pilhas;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
}
