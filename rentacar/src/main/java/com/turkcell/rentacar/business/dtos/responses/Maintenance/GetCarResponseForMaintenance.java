package com.turkcell.rentacar.business.dtos.responses.Maintenance;

import com.turkcell.rentacar.business.dtos.responses.Car.GetModelResponseForCar;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCarResponseForMaintenance {
    private int id;

    private GetModelResponseForCar model;

    private CarStatus status;

    private String name;

    private int modelYear;

    private String plate;

    private double dailyPrice;

    private LocalDateTime createDate;
}
