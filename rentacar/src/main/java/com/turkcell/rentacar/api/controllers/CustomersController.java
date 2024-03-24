package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BusinessCustomerService;
import com.turkcell.rentacar.business.abstracts.IndividualCustomerService;
import com.turkcell.rentacar.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.CreateBusinessCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.CreatedBusinessCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.entities.concretes.BusinessCustomer;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomersController {
    private BusinessCustomerService businessCustomerService;
    private IndividualCustomerService individualCustomerService;
    @PostMapping("/business")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBusinessCustomerResponse add(@RequestBody CreateBusinessCustomerRequest businessCustomer) {
        return businessCustomerService.add(businessCustomer);
    }

    @PostMapping("/individual")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedIndividualCustomerResponse add(@RequestBody CreateIndividualCustomerRequest individualCustomer) {
        return individualCustomerService.add(individualCustomer);
    }
}
