package com.turkcell.rentacar.business.dtos.responses.Customer.BusinessCustomer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedBusinessCustomerResponse {
    private int id;

    private String companyName;

    private String identityNo;

    private LocalDateTime updateDate;
}
