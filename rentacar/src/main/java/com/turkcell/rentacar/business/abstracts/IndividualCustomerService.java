package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.GotIndividualCustomerResponse;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest customer);
    GotIndividualCustomerResponse getById(int id);
}
