package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Payment.CreditCardPaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.Payment.CreditCardPaymentResponse;

public interface PaymentApiService {
    CreditCardPaymentResponse transaction(CreditCardPaymentRequest request);
}
