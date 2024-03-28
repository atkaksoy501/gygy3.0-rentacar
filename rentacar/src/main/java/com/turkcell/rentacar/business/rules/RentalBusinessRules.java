package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.RentalRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private RentalRepository rentalRepository;

    public void rentalMustExists(int rentalId) {
        Optional<Rental> rental = rentalRepository.findById(rentalId);
        if (rental.isEmpty()) {
            throw new BusinessException("Rental not found. Rental must exist.");
        }
    }

    public double calculateDailyPrice(Rental rental) {
        int days = (int) ChronoUnit.DAYS.between(rental.getDateRented(), rental.getDateReturned().atStartOfDay());
        Car car = rentalRepository.findById(rental.getId()).orElse(null).getCar();
        return car.getDailyPrice() * days;
    }
}
