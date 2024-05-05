package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cars")
@SequenceGenerator(
        name = "base_sequence_generator",
        sequenceName = "car_sequence",
        allocationSize = 1
)
public class Car extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name = "status")
    private CarStatus status;

    @Column(name = "name")
    private String name;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "plate")
    private String plate;

    @Column(name = "daily_price")
    private double dailyPrice;

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;


}
