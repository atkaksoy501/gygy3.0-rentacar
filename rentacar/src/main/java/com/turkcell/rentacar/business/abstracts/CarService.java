package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Car.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.Car.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.Car.GetCarResponse;
import com.turkcell.rentacar.business.dtos.responses.Car.GetCarResponseById;
import com.turkcell.rentacar.entities.concretes.Car;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest car);
    GetCarResponseById getById(int id);

    Car updateCarStatus(Car car);
}
