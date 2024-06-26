package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "businessCustomers")
public class BusinessCustomer extends Customer {
    @Column(name = "company_name")
    private String companyName;
}
