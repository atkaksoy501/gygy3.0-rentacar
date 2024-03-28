package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.RentalExtraService;
import com.turkcell.rentacar.business.abstracts.RentalService;
import com.turkcell.rentacar.business.dtos.requests.CreateRentalExtrasRequest;
import com.turkcell.rentacar.business.dtos.requests.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateRentalWithExtraRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedRentalExtraResponse;
import com.turkcell.rentacar.business.dtos.responses.CreatedRentalResponse;
import com.turkcell.rentacar.business.dtos.responses.GotRentalResponse;
import com.turkcell.rentacar.business.dtos.responses.UpdatedRentalResponse;
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
    public GotRentalResponse getById(@PathVariable int id) { //todo: GetRentalResponseById dto olarak isimlendiirlecek
        return rentalService.getById(id);
    }

    //todo: update, delete, getAll methods will be added
}
