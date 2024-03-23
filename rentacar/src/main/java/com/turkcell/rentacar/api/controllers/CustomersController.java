package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BusinessCustomerService;
import com.turkcell.rentacar.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.turkcell.rentacar.entities.concretes.BusinessCustomer;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomersController {
    private BusinessCustomerService businessCustomerService;
    @PostMapping("/business")
    @ResponseStatus(HttpStatus.CREATED)
    public BusinessCustomer add(@RequestBody BusinessCustomer businessCustomer) {
        return businessCustomerService.add(businessCustomer);
    }
}
