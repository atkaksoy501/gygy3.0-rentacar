package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transmissions")
@SequenceGenerator(
        name = "base_sequence_generator",
        sequenceName = "transmission_sequence",
        allocationSize = 1
)
public class Transmission extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "transmission")
    private List<Model> models;
}
