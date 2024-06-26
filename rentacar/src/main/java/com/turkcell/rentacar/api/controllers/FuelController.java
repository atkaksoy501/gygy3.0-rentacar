package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.dtos.requests.Fuel.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.Fuel.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.Fuel.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/fuels")
public class FuelController {

    private FuelService fuelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedFuelResponse add(@Valid @RequestBody CreateFuelRequest fuel) {
        return fuelService.add(fuel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllFuelResponse> getAll() {
        return fuelService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetFuelResponseById getById(@PathVariable int id) {
        return fuelService.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedFuelResponse update(@Valid @RequestBody UpdateFuelRequest updateFuelRequest) {
        return fuelService.update(updateFuelRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        fuelService.delete(id);
    }


}
