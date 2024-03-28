package com.turkcell.rentacar.business.dtos.responses.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardPaymentResponse {
    private boolean transactionResult;
}
