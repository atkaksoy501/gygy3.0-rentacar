package com.turkcell.rentacar.business.dtos.requests.Customer.IndividualCustomer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIndividualCustomerRequest {
    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    @Size(min = 11, max = 11)
    private String identityNo;
}
