package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BusinessCustomerService;
import com.turkcell.rentacar.business.dtos.requests.CreateBusinessCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBusinessCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.GotBusinessCustomerReponse;
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

    @Override
    public GotBusinessCustomerReponse getById(int id) {
        BusinessCustomer businessCustomer = businessCustomerRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(businessCustomer, GotBusinessCustomerReponse.class);
    }

    @Override
    public CreatedBusinessCustomerResponse add(CreateBusinessCustomerRequest customer) {
        BusinessCustomer dbCustomer = modelMapperService.forRequest().map(customer, BusinessCustomer.class);
        dbCustomer.setCreateDate(LocalDateTime.now());
        BusinessCustomer businessCustomer = businessCustomerRepository.save(dbCustomer);
        return modelMapperService.forResponse().map(businessCustomer, CreatedBusinessCustomerResponse.class);
    }
}
