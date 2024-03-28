package com.turkcell.rentacar.business.dtos.responses.Model;

import com.turkcell.rentacar.business.dtos.responses.Brand.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Fuel.GetFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Transmission.GetTransmissionResponse;
import com.turkcell.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllModelResponse {
    private int id;
    private String name;
    private GetBrandResponse brand;
    private GetFuelResponse fuel;
    private GetTransmissionResponse transmission;
    private List<Car> cars;
    private int requiredFindexScore;
}
