package com.turkcell.rentacar.business.dtos.responses;

import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GotModelResponse {
    private int id;
    private String name;
    private Brand brand;
    private Fuel fuel;
    private Transmission transmission;
    private List<Car> cars;
    private int requiredFindexScore;
}
