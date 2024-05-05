package com.turkcell.rentacar.business.dtos.responses.Car;

import com.turkcell.rentacar.entities.concretes.Maintenance;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCarResponse {
    private int id;

    private GetModelResponseForCar model;

    private CarStatus status;

    private String name;

    private int modelYear;

    private String plate;

    private double dailyPrice;

    private List<Maintenance> maintenances;

    private LocalDateTime createDate;
}
