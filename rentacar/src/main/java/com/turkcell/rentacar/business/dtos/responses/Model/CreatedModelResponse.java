package com.turkcell.rentacar.business.dtos.responses.Model;

import com.turkcell.rentacar.business.dtos.responses.Brand.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Fuel.GetFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Transmission.GetTransmissionResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedModelResponse {
    private int id;
    private String name;
    private LocalDateTime createDate;
    private GetBrandResponse brand;
    private GetFuelResponse fuel;
    private GetTransmissionResponse transmission;
    private int requiredFindexScore;
}
