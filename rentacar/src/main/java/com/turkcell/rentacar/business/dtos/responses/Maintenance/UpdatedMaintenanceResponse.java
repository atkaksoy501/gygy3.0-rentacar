package com.turkcell.rentacar.business.dtos.responses.Maintenance;

import com.turkcell.rentacar.entities.concretes.Car;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedMaintenanceResponse {
    private int id;

    private LocalDateTime dateSent;

    private LocalDateTime dateReturned;

    private Car car;

    private LocalDateTime updateDate;
}
