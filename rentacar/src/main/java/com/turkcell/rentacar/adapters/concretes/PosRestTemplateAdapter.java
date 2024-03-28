package com.turkcell.rentacar.adapters.concretes;

import com.turkcell.rentacar.adapters.abstracts.PosHttpAdapter;
import com.turkcell.rentacar.business.dtos.requests.Payment.CreditCardPaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.Payment.CreditCardPaymentResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@NoArgsConstructor
public class PosRestTemplateAdapter implements PosHttpAdapter {
    private RestTemplate restTemplate;

    @Override
    public CreditCardPaymentResponse sendPostRequest(String url, CreditCardPaymentRequest requestBody) {
        ResponseEntity<CreditCardPaymentResponse> response =
                restTemplate.postForEntity(url, requestBody, CreditCardPaymentResponse.class);
        return response.getBody();
    }
}
