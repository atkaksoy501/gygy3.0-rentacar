package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.core.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByEmail(String email);
}
