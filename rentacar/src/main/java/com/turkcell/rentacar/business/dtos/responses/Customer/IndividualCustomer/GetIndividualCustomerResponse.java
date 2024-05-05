package com.turkcell.rentacar.business.dtos.responses.Customer.IndividualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetIndividualCustomerResponse {
    private int id;

    private String firstName;

    private String lastName;
}
