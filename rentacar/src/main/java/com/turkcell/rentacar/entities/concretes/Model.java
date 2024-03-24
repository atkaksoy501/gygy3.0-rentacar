package com.turkcell.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "models")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Model.class)
public class Model extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brandId")
//    @JsonBackReference
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "fuelId")
//    @JsonBackReference
    private Fuel fuel;

    @ManyToOne
    @JoinColumn(name = "transmissionId")
//    @JsonBackReference
    private Transmission transmission;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;

    @Column(name = "requiredFindexScore")
    private int requiredFindexScore;


}
