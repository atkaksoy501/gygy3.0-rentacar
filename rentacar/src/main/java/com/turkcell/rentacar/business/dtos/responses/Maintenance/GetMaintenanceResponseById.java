package com.turkcell.rentacar.business.dtos.responses.Maintenance;

import com.turkcell.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetMaintenanceResponseById {
    private int id;

    private LocalDateTime dateSent;

    private LocalDateTime dateReturned;

    private Car car;
}
