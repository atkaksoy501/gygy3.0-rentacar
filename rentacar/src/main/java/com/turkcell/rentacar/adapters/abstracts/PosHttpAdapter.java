package com.turkcell.rentacar.adapters.abstracts;

import com.turkcell.rentacar.business.dtos.requests.CreditCardPaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.CreditCardPaymentResponse;

public interface PosHttpAdapter {
    CreditCardPaymentResponse sendPostRequest(String url, CreditCardPaymentRequest requestBody);
}
