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
@Table(name = "payments")
public class Payment extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "rental_id", referencedColumnName = "id")
    private Rental rental;
    private double amount;
}
