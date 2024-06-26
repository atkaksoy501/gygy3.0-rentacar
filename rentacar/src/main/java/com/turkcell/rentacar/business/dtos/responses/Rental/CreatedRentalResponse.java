package com.turkcell.rentacar.business.dtos.responses.Rental;

import com.turkcell.rentacar.business.dtos.responses.Car.GetCarResponse;
import com.turkcell.rentacar.business.dtos.responses.RentalExtras.GetRentalExtrasResponse;
import com.turkcell.rentacar.core.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedRentalResponse {
    private int id;

    private LocalDateTime dateRented;

    private LocalDate dateReturned;

    private GetCarResponse car;

    private Customer customer;

    private LocalDateTime createDate;

    private List<GetRentalExtrasResponse> extras;
}
