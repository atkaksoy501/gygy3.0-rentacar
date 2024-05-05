package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Customer.IndividualCustomer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.Customer.IndividualCustomer.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.Customer.IndividualCustomer.GetIndividualCustomerResponse;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest customer);
    GetIndividualCustomerResponse getById(int id);
}
