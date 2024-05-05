package com.turkcell.rentacar.business.dtos.requests.RentalExtras;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalExtrasRequest {
    private String name;
    private int rentalNo;
    private double price;
}
