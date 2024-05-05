package com.turkcell.rentacar.business.dtos.requests.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateModelRequest {
    @NotNull
    private int id;

    @NotNull
    private CreateModelRequest updatedModel;
}
