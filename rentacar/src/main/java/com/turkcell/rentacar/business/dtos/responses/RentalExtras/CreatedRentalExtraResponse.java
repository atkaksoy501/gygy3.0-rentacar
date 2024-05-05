package com.turkcell.rentacar.business.dtos.responses.RentalExtras;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedRentalExtraResponse {
    private String name;
    private double price;
    private int rentalId;
}
