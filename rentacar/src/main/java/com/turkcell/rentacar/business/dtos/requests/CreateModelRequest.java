package com.turkcell.rentacar.business.dtos.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateModelRequest {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    private int brandId;

    @NotNull
    private int fuelId;

    @NotNull
    private int transmissionId;

    @NotNull
    @Size(min = 4, max = 4)
    private int requiredFindexScore;
}
