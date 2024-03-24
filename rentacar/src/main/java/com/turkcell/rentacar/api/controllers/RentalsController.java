package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.RentalService;
import com.turkcell.rentacar.business.dtos.requests.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedRentalResponse;
import com.turkcell.rentacar.business.dtos.responses.GotRentalResponse;
import com.turkcell.rentacar.entities.concretes.Rental;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/rentals")
public class RentalsController {
    private RentalService rentalService;

    @PostMapping("/business")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedRentalResponse addBusiness(@Valid @RequestBody CreateRentalRequest rental) {
        return rentalService.addRentalForBusiness(rental);
    }

    @PostMapping("/individual")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedRentalResponse addIndividual(@Valid @RequestBody CreateRentalRequest rental) {
        return rentalService.addRentalForIndividual(rental);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GotRentalResponse getById(@PathVariable int id) {
        return rentalService.getById(id);
    }
}
