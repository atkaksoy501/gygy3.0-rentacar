package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BusinessCustomerService;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BusinessCustomerRepository;
import com.turkcell.rentacar.entities.concretes.BusinessCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BusinessCustomerManager implements BusinessCustomerService {

    private BusinessCustomerRepository businessCustomerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public BusinessCustomer getById(int id) {
        BusinessCustomer businessCustomer = businessCustomerRepository.findById(id).orElse(null);
        return businessCustomer;
    }

    @Override
    public BusinessCustomer add(BusinessCustomer customer) {
        BusinessCustomer businessCustomer = businessCustomerRepository.save(customer);
        return businessCustomer;
    }
}
