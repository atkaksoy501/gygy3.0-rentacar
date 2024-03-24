package com.turkcell.rentacar.business.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalRequest {
    @NotNull
    private int carId;

    @NotNull
    private int customerId;

    @NotNull
    private LocalDate returnDate;
}
