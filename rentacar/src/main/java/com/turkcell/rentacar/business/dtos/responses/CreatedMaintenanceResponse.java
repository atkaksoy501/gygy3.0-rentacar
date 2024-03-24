package com.turkcell.rentacar.business.dtos.responses;

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
public class CreatedMaintenanceResponse {
    private int id;

    private LocalDateTime dateSent;

    private Car car;
    private LocalDateTime createDate;
}
