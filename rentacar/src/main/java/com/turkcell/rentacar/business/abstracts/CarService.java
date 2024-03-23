package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Car;

public interface CarService {
    Car add(Car car);
    Car getById(int id);
}
