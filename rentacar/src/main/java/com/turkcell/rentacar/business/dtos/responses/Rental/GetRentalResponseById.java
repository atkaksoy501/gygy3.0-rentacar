package com.turkcell.rentacar.business.dtos.responses.Rental;

import com.turkcell.rentacar.business.dtos.responses.Customer.GetCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.Maintenance.GetCarResponseForMaintenance;
import com.turkcell.rentacar.business.dtos.responses.RentalExtras.GetRentalExtrasResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetRentalResponseById {
    private int id;

    private LocalDateTime dateRented;

    private LocalDateTime dateReturned;

    private GetCarResponseForMaintenance car;

    private GetCustomerResponse customer;

    private List<GetRentalExtrasResponse> extras;
}
