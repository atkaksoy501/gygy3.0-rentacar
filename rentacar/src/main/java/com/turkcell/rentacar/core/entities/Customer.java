package com.turkcell.rentacar.core.entities;

import com.turkcell.rentacar.entities.concretes.Rental;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(
        name = "base_sequence",
        sequenceName = "customer_sequence",
        allocationSize = 1
)
public class Customer extends BaseEntity{

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;

    @Column(name = "identityNo")
    private String identityNo;
}
