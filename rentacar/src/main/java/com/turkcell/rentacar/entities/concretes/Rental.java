package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import com.turkcell.rentacar.core.entities.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "rentals")
public class Rental extends BaseEntity {

    private LocalDateTime dateRented;

    private LocalDateTime dateReturned;

    @ManyToOne
    @JoinColumn(name="carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;
}
