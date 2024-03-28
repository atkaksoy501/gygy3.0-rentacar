package com.turkcell.rentacar.business.dtos.responses.Brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBrandResponse { //getAll ve getById dışında kullanılan alanlar için
    private int id;
    private String name;
}
