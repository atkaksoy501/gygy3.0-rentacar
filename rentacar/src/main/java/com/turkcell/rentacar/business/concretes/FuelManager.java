package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.dtos.requests.Fuel.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.Fuel.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.Fuel.*;
import com.turkcell.rentacar.business.rules.FuelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
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
    private FuelBusinessRules fuelBusinessRules;

    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        fuelBusinessRules.fuelNameCannotBeDuplicated(createFuelRequest.getName());
        Fuel fuel = this.modelMapperService.forRequest().map(createFuelRequest, Fuel.class);
        fuel.setCreateDate(LocalDateTime.now());

        Fuel savedFuel = fuelRepository.save(fuel);

        return this.modelMapperService.forResponse().map(savedFuel, CreatedFuelResponse.class);
    }

    @Override
    public List<GetAllFuelResponse> getAll() {
        List<Fuel> fuels = fuelRepository.findAll();
        List<GetAllFuelResponse> getFuelResponseList = new ArrayList<>();
        for (Fuel fuel : fuels) {
            GetAllFuelResponse getFuelResponse = this.modelMapperService.forResponse().map(fuel, GetAllFuelResponse.class);
            getFuelResponseList.add(getFuelResponse);
        }
        return getFuelResponseList;
    }

    @Override
    public GetFuelResponseById getById(int id) {
        fuelBusinessRules.fuelMustExists(id);
        Fuel fuel = fuelRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(fuel, GetFuelResponseById.class);
    }

    @Override
    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest) {
        fuelBusinessRules.fuelMustExists(updateFuelRequest.getId());
        Fuel fuel = this.modelMapperService.forRequest().map(updateFuelRequest, Fuel.class);
        fuel.setUpdateDate(LocalDateTime.now());
        Fuel updatedFuel = fuelRepository.save(fuel);
        UpdatedFuelResponse updatedFuelResponse = this.modelMapperService.forResponse().map(updatedFuel, UpdatedFuelResponse.class);
        updatedFuelResponse.setUpdateDate(updatedFuel.getUpdateDate());
        return updatedFuelResponse;
    }

    @Override
    public void delete(int id) {
        fuelBusinessRules.fuelMustExists(id);
        fuelRepository.deleteById(id);
    }

}
