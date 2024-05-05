package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Rental.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.requests.Rental.UpdateRentalWithExtraRequest;
import com.turkcell.rentacar.business.dtos.responses.Rental.CreatedRentalResponse;
import com.turkcell.rentacar.business.dtos.responses.Rental.GetRentalResponseById;
import com.turkcell.rentacar.business.dtos.responses.Rental.UpdatedRentalResponse;

public interface RentalService {
    CreatedRentalResponse addRentalForBusiness(CreateRentalRequest rental);
    CreatedRentalResponse addRentalForIndividual(CreateRentalRequest rental);
    GetRentalResponseById getById(int id);
    UpdatedRentalResponse updateRentalWithExtras(UpdateRentalWithExtraRequest extraRequest);

}
