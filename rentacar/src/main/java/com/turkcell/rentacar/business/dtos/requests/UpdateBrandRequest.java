package com.turkcell.rentacar.business.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBrandRequest {
    @NotNull
    private int id;

    @NotNull
    private CreateBrandRequest updatedBrand;
}
