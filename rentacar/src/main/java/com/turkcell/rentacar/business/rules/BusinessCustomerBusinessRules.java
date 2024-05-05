package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.BusinessCustomerRepository;
import com.turkcell.rentacar.entities.concretes.BusinessCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BusinessCustomerBusinessRules {
    private BusinessCustomerRepository businessCustomerRepository;

    public void businessCustomerMustExists(int customerId) {
        Optional<BusinessCustomer> businessCustomer = businessCustomerRepository.findById(customerId);
        if (businessCustomer.isEmpty()) {
            throw new BusinessException("Customer must exist.");
        }
    }
}
