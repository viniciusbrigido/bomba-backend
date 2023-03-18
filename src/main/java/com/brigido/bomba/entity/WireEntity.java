package com.brigido.bomba.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "wire")
public class WireEntity implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    private String serial;

    private String wiring;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
}
