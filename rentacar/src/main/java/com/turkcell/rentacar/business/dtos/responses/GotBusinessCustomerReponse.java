package com.turkcell.rentacar.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GotBusinessCustomerReponse {
    private int id;

    private String companyName;
}
