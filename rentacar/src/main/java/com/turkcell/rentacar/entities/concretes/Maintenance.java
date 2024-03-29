package com.turkcell.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "maintenances")
@SequenceGenerator(
        name = "base_sequence",
        sequenceName = "maintenance_sequence",
        allocationSize = 1
)
public class Maintenance extends BaseEntity {
    private LocalDateTime dateSent;

    private LocalDateTime dateReturned;

    @ManyToOne
    @JoinColumn(name="carId")
    private Car car;
}
