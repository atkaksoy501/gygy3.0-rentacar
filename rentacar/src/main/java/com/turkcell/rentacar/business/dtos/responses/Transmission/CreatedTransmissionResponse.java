package com.turkcell.rentacar.business.dtos.responses.Transmission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedTransmissionResponse {
    private int id;
    private String name;
    private LocalDateTime createDate;
}
