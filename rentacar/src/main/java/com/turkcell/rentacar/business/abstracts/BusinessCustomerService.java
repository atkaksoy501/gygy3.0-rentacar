package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.CreateBusinessCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBusinessCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.GotBusinessCustomerReponse;
import com.turkcell.rentacar.entities.concretes.BusinessCustomer;

import java.util.List;

public interface BusinessCustomerService {
    GotBusinessCustomerReponse getById(int id);
    CreatedBusinessCustomerResponse add(CreateBusinessCustomerRequest customer);
}
