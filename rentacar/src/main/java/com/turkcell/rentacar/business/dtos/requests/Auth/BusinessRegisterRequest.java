package com.turkcell.rentacar.business.dtos.requests.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusinessRegisterRequest {

    private String companyName;
    private String email;
    private String password;
    private String identityNo;

}
