package com.turkcell.rentacar.business.dtos.responses.Rental;

import com.turkcell.rentacar.business.dtos.responses.Car.GetModelResponseForCar;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCarResponseForRental {
    private GetModelResponseForCar model;

    private CarStatus status;

    private String name;

    private int modelYear;

    private String plate;

    private double dailyPrice;
}
