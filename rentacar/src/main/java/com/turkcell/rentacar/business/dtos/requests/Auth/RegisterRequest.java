package com.turkcell.rentacar.business.dtos.requests.Auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest
{
    private String email;
    private String password;
    private LocalDate birthDate;
}
