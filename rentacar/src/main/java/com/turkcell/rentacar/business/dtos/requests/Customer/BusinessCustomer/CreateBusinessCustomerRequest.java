package com.turkcell.rentacar.business.dtos.requests.Customer.BusinessCustomer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBusinessCustomerRequest {
    @NotNull
    @Size(min = 2, max = 50)
    private String companyName;

    @NotNull
    @Size(min = 10, max = 10)
    private String identityNo;
}
