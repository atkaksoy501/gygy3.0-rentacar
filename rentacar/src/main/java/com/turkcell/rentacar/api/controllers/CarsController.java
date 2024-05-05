package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.dtos.requests.Car.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.Car.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.Car.GetCarResponse;
import com.turkcell.rentacar.business.dtos.responses.Car.GetCarResponseById;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cars")
public class CarsController {

    private CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest car) {
        return carService.add(car);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCarResponseById getById(@PathVariable int id) {
        return carService.getById(id);
    }

    //todo: update, delete, getAll methods will be added
}
