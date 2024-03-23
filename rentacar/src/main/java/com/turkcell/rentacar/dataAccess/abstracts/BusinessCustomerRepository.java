package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.BusinessCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessCustomerRepository extends JpaRepository<BusinessCustomer, Integer> {
}
