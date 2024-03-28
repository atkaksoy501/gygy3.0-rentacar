package com.turkcell.rentacar.business.dtos.responses.Customer.BusinessCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBusinessCustomerReponse {
    private int id;

    private String companyName;
}
