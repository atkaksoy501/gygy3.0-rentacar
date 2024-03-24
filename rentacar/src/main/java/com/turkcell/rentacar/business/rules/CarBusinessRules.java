package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private CarRepository carRepository;

    public void carMustExists(int carId) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.isEmpty()) {
            throw new BusinessException("Car not found. Car must exist.");
        }
    }
    public void carIsInMaintenance(int carId) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.get().getStatus() == CarStatus.MAINTENANCE) {
            throw new BusinessException("Car is in Maintenance.");
        }
    }

    public void carIsAlreadyRented(int carId) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.get().getStatus() == CarStatus.RENTAL) {
            throw new BusinessException("Car is already rented.");
        }
    }

    public void carPlateCannotBeDuplicate(String plate) {
        Optional<Car> car = carRepository.findByPlate(plate);
        if (car.isPresent()) {
            throw new BusinessException("Car plate cannot be duplicate.");
        }
    }


}
