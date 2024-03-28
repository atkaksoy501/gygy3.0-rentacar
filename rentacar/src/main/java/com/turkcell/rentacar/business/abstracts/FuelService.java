package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Fuel.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.Fuel.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.Fuel.*;

import java.util.List;

public interface FuelService {
    CreatedFuelResponse add(CreateFuelRequest createFuelRequest);
    List<GetAllFuelResponse> getAll();
    GetFuelResponseById getById(int id);
    UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest);
    void delete(int id);
}
