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
        name = "base_sequence",
        sequenceName = "rental_extra_sequence",
        allocationSize = 1
)
public class RentalExtras extends BaseEntity {
    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
