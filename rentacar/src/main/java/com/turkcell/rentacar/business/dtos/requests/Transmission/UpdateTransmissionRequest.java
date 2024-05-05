package com.turkcell.rentacar.business.dtos.requests.Transmission;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateTransmissionRequest {
    @NotNull
    private int id;

    @NotNull
    private CreateTransmissionRequest updatedTransmission;
}
