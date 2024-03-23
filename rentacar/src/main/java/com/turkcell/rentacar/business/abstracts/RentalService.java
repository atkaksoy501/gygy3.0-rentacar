package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Rental;

public interface RentalService {
    Rental add(Rental rental);
    Rental getById(int id);

}
