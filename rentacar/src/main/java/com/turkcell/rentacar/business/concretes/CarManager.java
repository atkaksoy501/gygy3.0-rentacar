package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.dtos.requests.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.GotCarResponse;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CarManager implements CarService{
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;


    @Override
    public CreatedCarResponse add(CreateCarRequest car) {
        Car dbCar = modelMapperService.forRequest().map(car, Car.class);
        dbCar.setCreateDate(LocalDateTime.now());
        dbCar.setStatus(CarStatus.AVAILABLE);
        dbCar = carRepository.save(dbCar);
        return modelMapperService.forResponse().map(dbCar, CreatedCarResponse.class);
    }

    @Override
    public GotCarResponse getById(int id) {
        Car dbCar = carRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(dbCar, GotCarResponse.class);
    }

    @Override
    public Car updateCarStatus(Car car) {
        return carRepository.save(car);
    }
}
