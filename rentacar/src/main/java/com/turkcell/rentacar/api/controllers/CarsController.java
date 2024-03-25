package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.dtos.requests.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.GotCarResponse;
import com.turkcell.rentacar.entities.concretes.Car;
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
    public GotCarResponse getById(@PathVariable int id) { //todo: GetCarResponseById dto olarak isimlendiirlecek
        return carService.getById(id);
    }

    //todo: update, delete, getAll methods will be added
}
