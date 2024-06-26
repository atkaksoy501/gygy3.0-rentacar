package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BusinessCustomerService;
import com.turkcell.rentacar.business.abstracts.IndividualCustomerService;
import com.turkcell.rentacar.business.dtos.requests.Customer.BusinessCustomer.CreateBusinessCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.Customer.IndividualCustomer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.Customer.BusinessCustomer.CreatedBusinessCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.Customer.IndividualCustomer.CreatedIndividualCustomerResponse;
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
    public CreatedBusinessCustomerResponse add(@Valid @RequestBody CreateBusinessCustomerRequest businessCustomer) {
        return businessCustomerService.add(businessCustomer);
    }

    @PostMapping("/individual")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest individualCustomer) {
        return individualCustomerService.add(individualCustomer);
    }

    //todo: update, delete, getAll methods will be added
}
