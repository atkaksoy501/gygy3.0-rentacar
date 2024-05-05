package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BusinessCustomerService;
import com.turkcell.rentacar.business.dtos.requests.Customer.BusinessCustomer.CreateBusinessCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.Customer.BusinessCustomer.CreatedBusinessCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.Customer.BusinessCustomer.GetBusinessCustomerReponse;
import com.turkcell.rentacar.business.rules.BusinessCustomerBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BusinessCustomerRepository;
import com.turkcell.rentacar.entities.concretes.BusinessCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class BusinessCustomerManager implements BusinessCustomerService {

    private BusinessCustomerRepository businessCustomerRepository;
    private ModelMapperService modelMapperService;
    private BusinessCustomerBusinessRules businessCustomerBusinessRules;

    @Override
    public GetBusinessCustomerReponse getById(int id) {
        businessCustomerBusinessRules.businessCustomerMustExists(id);
        BusinessCustomer businessCustomer = businessCustomerRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(businessCustomer, GetBusinessCustomerReponse.class);
    }

    @Override
    public CreatedBusinessCustomerResponse add(CreateBusinessCustomerRequest customer) {
        BusinessCustomer dbCustomer = modelMapperService.forRequest().map(customer, BusinessCustomer.class);
        dbCustomer.setCreateDate(LocalDateTime.now());
        BusinessCustomer businessCustomer = businessCustomerRepository.save(dbCustomer);
        return modelMapperService.forResponse().map(businessCustomer, CreatedBusinessCustomerResponse.class);
    }
}
