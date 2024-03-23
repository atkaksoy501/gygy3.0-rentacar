package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "individualCustomers")
public class IndividualCustomer extends Customer {
    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    @Size(min = 11, max = 11)
    private String nationalId;

}
