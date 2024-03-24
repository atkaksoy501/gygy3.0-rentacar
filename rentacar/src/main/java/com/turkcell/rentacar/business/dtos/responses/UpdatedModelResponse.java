package com.turkcell.rentacar.business.dtos.responses;

import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedModelResponse {
    private int id;
    private String name;
    private LocalDateTime updateDate;
    private Brand brand;
    private Fuel fuel;
    private Transmission transmission;
    private List<Car> cars;
    private int requiredFindexScore;
}
