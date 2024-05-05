package com.turkcell.rentacar.business.dtos.responses.Transmission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllTransmissionResponse {
    private int id;
    private String name;
}