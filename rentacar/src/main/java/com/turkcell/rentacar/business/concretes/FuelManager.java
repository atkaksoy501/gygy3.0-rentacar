package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.dtos.requests.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.*;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {

    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        Fuel fuel = this.modelMapperService.forRequest().map(createFuelRequest, Fuel.class);
        fuel.setCreateDate(LocalDateTime.now());

        Fuel savedFuel = fuelRepository.save(fuel);

        return this.modelMapperService.forResponse().map(savedFuel, CreatedFuelResponse.class);
    }

    @Override
    public List<GotFuelResponse> getAll() {
        List<Fuel> fuels = fuelRepository.findAll();
        List<GotFuelResponse> gotFuelResponseList = new ArrayList<>();
        for (Fuel fuel : fuels) {
            GotFuelResponse gotFuelResponse = this.modelMapperService.forResponse().map(fuel, GotFuelResponse.class);
            gotFuelResponseList.add(gotFuelResponse);
        }
        return gotFuelResponseList;
    }

    @Override
    public GotFuelResponse getById(int id) {
        Fuel fuel = fuelRepository.findById(id).orElse(null);
        if (fuel == null) return null;
        return this.modelMapperService.forResponse().map(fuel, GotFuelResponse.class);
    }

    @Override
    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest) {
        Fuel fuel = this.modelMapperService.forRequest().map(updateFuelRequest, Fuel.class);
        fuel.setUpdateDate(LocalDateTime.now());
        Fuel updatedFuel = fuelRepository.findById(fuel.getId()).orElse(null);
        if (updatedFuel == null) {
            return null;
        }

        updatedFuel = fuelRepository.save(fuel);
        UpdatedFuelResponse updatedFuelResponse = this.modelMapperService.forResponse().map(updatedFuel, UpdatedFuelResponse.class);
        updatedFuelResponse.setUpdatedDate(updatedFuel.getUpdateDate());
        return updatedFuelResponse;
    }

    @Override
    public void delete(int id) {
        fuelRepository.deleteById(id);
    }

}
