package com.turkcell.rentacar.business.dtos.responses;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GotIndividualCustomerResponse {
    private int id;

    private String firstName;

    private String lastName;
}
