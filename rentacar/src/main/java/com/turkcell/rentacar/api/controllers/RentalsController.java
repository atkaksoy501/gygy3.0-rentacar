package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.RentalService;
import com.turkcell.rentacar.business.dtos.requests.Rental.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.requests.Rental.UpdateRentalWithExtraRequest;
import com.turkcell.rentacar.business.dtos.responses.Rental.CreatedRentalResponse;
import com.turkcell.rentacar.business.dtos.responses.Rental.GetRentalResponseById;
import com.turkcell.rentacar.business.dtos.responses.Rental.UpdatedRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/add/extra")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedRentalResponse updateRentalWithExtra(@Valid @RequestBody UpdateRentalWithExtraRequest extrasRequest) {
        return rentalService.updateRentalWithExtras(extrasRequest);
    }

    @PostMapping("/individual")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedRentalResponse addIndividual(@Valid @RequestBody CreateRentalRequest rental) {
        return rentalService.addRentalForIndividual(rental);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetRentalResponseById getById(@PathVariable int id) {
        return rentalService.getById(id);
    }

    //todo: update, delete, getAll methods will be added
}
