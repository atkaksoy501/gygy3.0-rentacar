package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedRentalResponse;
import com.turkcell.rentacar.business.dtos.responses.GotRentalResponse;
import com.turkcell.rentacar.entities.concretes.Rental;

public interface RentalService {
    CreatedRentalResponse addRentalForBusiness(CreateRentalRequest rental);
    CreatedRentalResponse addRentalForIndividual(CreateRentalRequest rental);
    GotRentalResponse getById(int id);

}
