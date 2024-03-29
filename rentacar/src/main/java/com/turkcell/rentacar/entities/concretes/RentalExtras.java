package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "extras")
@SequenceGenerator(
        name = "base_sequence_generator",
        sequenceName = "rental_extra_sequence",
        allocationSize = 1
)
public class RentalExtras extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
