package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.CreateRentalExtrasRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedRentalExtraResponse;
import com.turkcell.rentacar.entities.concretes.RentalExtras;

import java.util.List;

public interface RentalExtraService {
    CreatedRentalExtraResponse add(CreateRentalExtrasRequest extrasRequest);

    void addAll(List<RentalExtras> extras);
}
