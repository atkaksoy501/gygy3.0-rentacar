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
@Table(name = "fuels")
@SequenceGenerator(
        name = "base_sequence_generator",
        sequenceName = "fuel_sequence",
        allocationSize = 1
)
public class Fuel extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "fuel")
    private List<Model> model;
}
