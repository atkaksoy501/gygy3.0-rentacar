package com.turkcell.rentacar.business.dtos.responses.Car;

import com.turkcell.rentacar.business.dtos.responses.Brand.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Fuel.GetFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Transmission.GetTransmissionResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetModelResponseForCar {
    private int id;
    private String name;
    private GetBrandResponse brand;
    private GetFuelResponse fuel;
    private GetTransmissionResponse transmission;
    private int requiredFindexScore;

}
