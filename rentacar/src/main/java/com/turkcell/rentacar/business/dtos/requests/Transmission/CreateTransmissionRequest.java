package com.turkcell.rentacar.business.dtos.requests.Transmission;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTransmissionRequest {
    @NotNull
    @Size(min = 2, max = 10)
    private String name;
}
