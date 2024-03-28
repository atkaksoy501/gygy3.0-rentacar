package com.turkcell.rentacar.adapters.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Payment.CreditCardPaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.Payment.CreditCardPaymentResponse;

public interface PosHttpAdapter {
    CreditCardPaymentResponse sendPostRequest(String url, CreditCardPaymentRequest requestBody);
}
