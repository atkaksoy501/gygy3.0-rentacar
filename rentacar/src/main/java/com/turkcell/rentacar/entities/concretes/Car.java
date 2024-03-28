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
public class Car extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;

    private CarStatus status;

    private String name;

    private int modelYear;

    private String plate;

    private double dailyPrice; // todo: rental fiyatı bu fiyattan hesaplanacak

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;


}
