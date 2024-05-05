package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Customer.BusinessCustomer.CreateBusinessCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.Customer.BusinessCustomer.CreatedBusinessCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.Customer.BusinessCustomer.GetBusinessCustomerReponse;

public interface BusinessCustomerService {
    GetBusinessCustomerReponse getById(int id);
    CreatedBusinessCustomerResponse add(CreateBusinessCustomerRequest customer);
}
