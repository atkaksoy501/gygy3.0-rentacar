package com.turkcell.rentacar.business.dtos.responses.Fuel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetFuelResponseById {
    private int id;
    private String name;
}