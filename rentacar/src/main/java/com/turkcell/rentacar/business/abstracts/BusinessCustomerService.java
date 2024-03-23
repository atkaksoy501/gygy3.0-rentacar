package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.BusinessCustomer;

import java.util.List;

public interface BusinessCustomerService {
    BusinessCustomer getById(int id);
    BusinessCustomer add(BusinessCustomer customer);
}
