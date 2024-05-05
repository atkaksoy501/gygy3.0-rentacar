package com.turkcell.rentacar.business.dtos.requests.Rental;

import com.turkcell.rentacar.business.dtos.requests.RentalExtras.CreateRentalExtraWithRentalRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRentalWithExtraRequest {
    @NotNull
    private int rentalId;
    @NotNull
    private List<CreateRentalExtraWithRentalRequest> extras;
}
