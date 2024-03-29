package com.turkcell.rentacar.core.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "base_sequence_generator" //generator name
    )
    @Column(name = "id")
    private int id;

    @Column(name = "createDate")
    private LocalDateTime createDate;

    @Column(name = "updateDate")
    private LocalDateTime updateDate;

    @Column(name = "deleteDate")
    private LocalDateTime deleteDate;
}
