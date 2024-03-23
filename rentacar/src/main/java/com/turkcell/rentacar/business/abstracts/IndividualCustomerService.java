package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.IndividualCustomer;

public interface IndividualCustomerService {
    IndividualCustomer add(IndividualCustomer customer);
    IndividualCustomer getById(int id);
}
