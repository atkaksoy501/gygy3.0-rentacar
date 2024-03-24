package com.turkcell.rentacar.business.dtos.responses;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedIndividualCustomerResponse {
    private int id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String identityNo;
    private LocalDateTime createDate;
}
