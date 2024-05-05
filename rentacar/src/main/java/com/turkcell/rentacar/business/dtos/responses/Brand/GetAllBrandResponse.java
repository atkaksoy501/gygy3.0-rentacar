package com.turkcell.rentacar.business.dtos.responses.Brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllBrandResponse {
    private int id;
    private String name;
}
