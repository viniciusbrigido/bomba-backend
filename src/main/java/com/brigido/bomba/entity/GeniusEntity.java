package com.brigido.bomba.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "genius")
public class GeniusEntity implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    private String colors;
    private String serial;
    private Integer countErrors;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
}
