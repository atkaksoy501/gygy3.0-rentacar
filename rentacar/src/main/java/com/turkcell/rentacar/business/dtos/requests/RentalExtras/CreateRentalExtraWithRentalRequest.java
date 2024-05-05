package com.turkcell.rentacar.business.dtos.requests.RentalExtras;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalExtraWithRentalRequest {
    @NotNull
    private String name;
    @NotNull
    private double price;
}
