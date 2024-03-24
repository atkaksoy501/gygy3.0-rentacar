package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.GotCarResponse;
import com.turkcell.rentacar.entities.concretes.Car;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest car);
    GotCarResponse getById(int id);

    Car updateCarStatus(Car car);
}
