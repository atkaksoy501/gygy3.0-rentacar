package com.turkcell.rentacar.business.dtos.responses.Maintenance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedMaintenanceResponse {
    private int id;

    private LocalDateTime dateSent;

    private GetCarResponseForMaintenance car;

    private LocalDateTime createDate;
}
