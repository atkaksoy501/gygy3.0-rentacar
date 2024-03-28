package com.turkcell.rentacar.business.dtos.responses.Fuel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetFuelResponse { //getAll ve getById dışında kullanılan alanlar için
    private int id;
    private String name;
}
