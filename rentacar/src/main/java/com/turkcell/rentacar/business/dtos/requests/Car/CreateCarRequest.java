package com.turkcell.rentacar.business.dtos.requests.Car;

import com.turkcell.rentacar.entities.concretes.Model;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCarRequest {
    @NotNull
    private int modelId;

    @NotNull
    @Size(min = 2, max = 10)
    private String name;

    @NotNull
    private int modelYear;

    @NotNull
    @Size(min = 4, max = 10)
    private String plate;

    @NotNull
    private double dailyPrice;
}
