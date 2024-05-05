package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.Car.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.Car.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.Car.GetCarResponse;
import com.turkcell.rentacar.business.dtos.responses.Car.GetCarResponseById;
import com.turkcell.rentacar.business.rules.CarBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CarManager implements CarService{
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;
    private ModelService modelService;


    @Override
    public CreatedCarResponse add(CreateCarRequest car) {
        carBusinessRules.carPlateCannotBeDuplicate(car.getPlate());
        Model model = modelMapperService.forResponse().map(modelService.getById(car.getModelId()), Model.class);
        Car dbCar = modelMapperService.forRequest().map(car, Car.class);
        dbCar.setId(0); //because model mapper maps "modelId" field as Car's "id"
        dbCar.setModel(model);
        dbCar.setCreateDate(LocalDateTime.now());
        dbCar.setStatus(CarStatus.AVAILABLE);
        dbCar = carRepository.save(dbCar);
        return modelMapperService.forResponse().map(dbCar, CreatedCarResponse.class);
    }

    @Override
    public GetCarResponseById getById(int id) {
        carBusinessRules.carMustExists(id);
        Car dbCar = carRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(dbCar, GetCarResponseById.class);
    }

    @Override
    public Car updateCarStatus(Car car) {
        carBusinessRules.carMustExists(car.getId());
        car.setUpdateDate(LocalDateTime.now());
        return carRepository.save(car);
    }
}
