package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import com.turkcell.rentacar.core.entities.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "rentals")
@SequenceGenerator(
        name = "base_sequence_generator",
        sequenceName = "rental_sequence",
        allocationSize = 1
)
public class Rental extends BaseEntity {
    @Column(name = "date_rented")
    private LocalDateTime dateRented;

    @Column(name = "date_returned")
    private LocalDate dateReturned;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<RentalExtras> extras;

}
