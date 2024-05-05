package com.turkcell.rentacar.business.dtos.responses.Rental;

import com.turkcell.rentacar.business.dtos.responses.Customer.GetCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.RentalExtras.GetRentalExtrasResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedRentalResponse {
    private int id;

    private LocalDateTime dateRented;

    private LocalDateTime dateReturned;

    private GetCarResponseForRental car;

    private GetCustomerResponse customer;

    private LocalDateTime updateDate;

    private List<GetRentalExtrasResponse> extras;
}
