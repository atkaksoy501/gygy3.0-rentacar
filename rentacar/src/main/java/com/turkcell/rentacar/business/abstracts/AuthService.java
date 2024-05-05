package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Auth.BusinessRegisterRequest;
import com.turkcell.rentacar.business.dtos.requests.Auth.IndividualRegisterRequest;
import com.turkcell.rentacar.business.dtos.requests.Auth.LoginRequest;



public interface AuthService {
    String login(LoginRequest request);
    void individualRegister(IndividualRegisterRequest request);

    void businessRegister(BusinessRegisterRequest request);
}
