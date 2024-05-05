package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FuelBusinessRules {
    private FuelRepository fuelRepository;

    public void fuelNameCannotBeDuplicated(String fuelName) {
        Optional<Fuel> fuel = fuelRepository.findByNameIgnoreCase(fuelName);
        if (fuel.isPresent()) {
            throw new BusinessException("FuelExists");
        }
    }

    public void fuelMustExists(int fuelId) {
        Optional<Fuel> fuel = fuelRepository.findById(fuelId);
        if (!fuel.isPresent()) {
            throw new BusinessException("FuelNotExists");
        }
    }
}
