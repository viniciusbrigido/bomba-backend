package com.brigido.bomba.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "whos_on_first")
public class WhosOnFirstEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String display1, display2, display3;

    private String words1, words2, words3;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
}
