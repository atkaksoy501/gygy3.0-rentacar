package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.adapters.abstracts.PosHttpAdapter;
import com.turkcell.rentacar.business.abstracts.PaymentApiService;
import com.turkcell.rentacar.business.dtos.requests.CreditCardPaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.CreditCardPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentApiManager implements PaymentApiService {
    private PosHttpAdapter posHttpAdapter;
    @Override
    public CreditCardPaymentResponse transaction(CreditCardPaymentRequest request) {
        return posHttpAdapter.sendPostRequest("http://localhost:8083/api/v1/pos", request);
    }
}
