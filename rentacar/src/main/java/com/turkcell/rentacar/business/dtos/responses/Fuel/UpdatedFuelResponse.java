package com.turkcell.rentacar.business.dtos.responses.Fuel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedFuelResponse {
    private int id;
    private String name;
    private LocalDateTime updateDate;
}
