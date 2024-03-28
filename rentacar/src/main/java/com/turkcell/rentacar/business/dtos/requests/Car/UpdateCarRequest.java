package com.turkcell.rentacar.business.dtos.requests.Car;

import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCarRequest {
    @NotNull
    private int id;

    @NotNull
    private CarStatus status;

    @NotNull
    private String plate;

    @NotNull
    private double dailyPrice;
}
