package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.IndividualCustomerService;
import com.turkcell.rentacar.business.dtos.requests.Customer.IndividualCustomer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.Customer.IndividualCustomer.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.Customer.IndividualCustomer.GetIndividualCustomerResponse;
import com.turkcell.rentacar.business.rules.IndividualCustomerBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService modelMapperService;
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest customer) {
        IndividualCustomer individualCustomer = modelMapperService.forRequest().map(customer, IndividualCustomer.class);
        individualCustomer.setCreateDate(LocalDateTime.now());
        IndividualCustomer dbCustomer =  individualCustomerRepository.save(individualCustomer);
        return modelMapperService.forResponse().map(dbCustomer, CreatedIndividualCustomerResponse.class);
    }

    @Override
    public GetIndividualCustomerResponse getById(int id) {
        individualCustomerBusinessRules.individualCustomerMustExists(id);
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(individualCustomer, GetIndividualCustomerResponse.class);
    }
}
