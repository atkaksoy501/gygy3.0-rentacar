package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.AuthService;
import com.turkcell.rentacar.business.dtos.requests.Auth.BusinessRegisterRequest;
import com.turkcell.rentacar.business.dtos.requests.Auth.IndividualRegisterRequest;
import com.turkcell.rentacar.business.dtos.requests.Auth.LoginRequest;
import com.turkcell.rentacar.business.dtos.requests.Auth.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request){
        return authService.login(request);
    }

    @PostMapping("/register/individual")
    public void register(@Valid @RequestBody IndividualRegisterRequest request) {
        authService.individualRegister(request);
    }
    @PostMapping("/register/business")
    public void register(@RequestBody BusinessRegisterRequest request) {
        authService.businessRegister(request);
    }

}
