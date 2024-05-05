package com.turkcell.rentacar.business.dtos.requests.Rental;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRentalRequest {
    @NotNull
    private int id;

    @NotNull
    private LocalDateTime dateReturned;
}
