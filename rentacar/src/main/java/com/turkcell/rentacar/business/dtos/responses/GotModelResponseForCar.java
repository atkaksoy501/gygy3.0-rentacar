package com.turkcell.rentacar.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GotModelResponseForCar {
    private int id;
    private String name;
    private GotBrandResponse brand;
    private GotFuelResponse fuel;
    private GotTransmissionResponse transmission;
    private int requiredFindexScore;

}
