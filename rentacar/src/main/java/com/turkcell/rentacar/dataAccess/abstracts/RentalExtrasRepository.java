package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.RentalExtras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentalExtrasRepository extends JpaRepository<RentalExtras, Integer> {
    Optional<RentalExtras> findByName(String name);
}
