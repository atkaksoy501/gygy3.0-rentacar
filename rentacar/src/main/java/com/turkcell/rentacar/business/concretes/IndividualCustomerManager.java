package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.IndividualCustomerService;
import com.turkcell.rentacar.business.dtos.requests.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.GotIndividualCustomerResponse;
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
    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest customer) {
        IndividualCustomer individualCustomer = modelMapperService.forRequest().map(customer, IndividualCustomer.class);
        individualCustomer.setCreateDate(LocalDateTime.now());
        IndividualCustomer dbCustomer =  individualCustomerRepository.save(individualCustomer);
        return modelMapperService.forResponse().map(dbCustomer, CreatedIndividualCustomerResponse.class);
    }

    @Override
    public GotIndividualCustomerResponse getById(int id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(individualCustomer, GotIndividualCustomerResponse.class);
    }
}
