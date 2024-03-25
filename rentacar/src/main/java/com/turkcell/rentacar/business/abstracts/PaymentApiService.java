package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.CreditCardPaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.CreditCardPaymentResponse;

public interface PaymentApiService {
    CreditCardPaymentResponse transaction(CreditCardPaymentRequest request);
}
