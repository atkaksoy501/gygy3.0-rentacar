package com.turkcell.rentacar.business.dtos.requests.Maintenance;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateMaintenanceRequest {
    @NotNull
    private int carId;
}
