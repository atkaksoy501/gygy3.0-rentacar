package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.abstracts.PaymentApiService;
import com.turkcell.rentacar.business.dtos.requests.Payment.CreditCardPaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.Payment.CreditCardPaymentResponse;
import com.turkcell.rentacar.business.messages.PaymentMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {
    private PaymentApiService paymentApiService;

    public void paymentMustConfirmed(CreditCardPaymentRequest creditCardPaymentRequest) {
        CreditCardPaymentResponse paymentResult = paymentApiService.transaction(creditCardPaymentRequest);
        if (!paymentResult.isTransactionResult()) {
            throw new BusinessException(PaymentMessages.PAYMENT_FAILED);
        }
    }
}
