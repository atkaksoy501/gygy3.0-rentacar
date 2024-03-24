package com.turkcell.rentacar.business.dtos.responses;

import com.turkcell.rentacar.core.entities.Customer;
import com.turkcell.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedRentalResponse {
    private int id;

    private LocalDateTime dateRented;

    private LocalDateTime dateReturned;

    private Car car;

    private Customer customer;

    private LocalDateTime updateDate;
}
