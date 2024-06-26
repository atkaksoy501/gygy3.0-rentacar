package com.turkcell.rentacar.business.dtos.requests.Fuel;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateFuelRequest {
    @NotNull
    @Size(min = 2, max = 6)
    private String name;
}
