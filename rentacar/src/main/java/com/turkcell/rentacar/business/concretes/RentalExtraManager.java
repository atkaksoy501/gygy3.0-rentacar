package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.RentalExtraService;
import com.turkcell.rentacar.business.abstracts.RentalService;
import com.turkcell.rentacar.business.dtos.requests.RentalExtras.CreateRentalExtrasRequest;
import com.turkcell.rentacar.business.dtos.responses.RentalExtras.CreatedRentalExtraResponse;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.RentalExtrasRepository;
import com.turkcell.rentacar.entities.concretes.Rental;
import com.turkcell.rentacar.entities.concretes.RentalExtras;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class RentalExtraManager implements RentalExtraService {
    private RentalExtrasRepository rentalExtrasRepository;
    private ModelMapperService modelMapperService;
    private RentalService rentalService;
    @Override
    public CreatedRentalExtraResponse add(CreateRentalExtrasRequest extrasRequest) {
        Rental rental = modelMapperService.forRequest().map(rentalService.getById(extrasRequest.getRentalNo()), Rental.class);
        RentalExtras rentalExtras = modelMapperService.forRequest().map(extrasRequest, RentalExtras.class);
        rentalExtras.setRental(rental);
        rentalExtras.setCreateDate(LocalDateTime.now());
        rentalExtras = rentalExtrasRepository.save(rentalExtras);
        return modelMapperService.forResponse().map(rentalExtras, CreatedRentalExtraResponse.class);
    }

    @Override
    public void addAll(List<RentalExtras> extras) {
        rentalExtrasRepository.saveAll(extras);
    }
}
