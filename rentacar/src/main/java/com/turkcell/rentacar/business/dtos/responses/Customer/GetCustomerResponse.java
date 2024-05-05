package com.turkcell.rentacar.business.dtos.responses.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCustomerResponse {
    private int id;
    private String identityNo;
}
