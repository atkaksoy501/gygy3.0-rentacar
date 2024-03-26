package com.turkcell.rentacar.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalExtraWithRentalRequest {
    private String name;
    private double price;
}
