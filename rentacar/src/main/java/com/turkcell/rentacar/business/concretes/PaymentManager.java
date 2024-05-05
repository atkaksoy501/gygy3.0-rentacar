package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.PaymentService;
import com.turkcell.rentacar.dataAccess.abstracts.PaymentRepository;
import com.turkcell.rentacar.entities.concretes.Payment;
import com.turkcell.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;
    @Override
    public Payment add(Rental rental, double amount) {
        Payment payment = new Payment();
        payment.setRental(rental);
        payment.setAmount(amount);
        payment.setCreateDate(LocalDateTime.now());
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getById(int id) {
        return null;
    }

    @Override
    public List<Payment> getAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Payment update(int id, Payment payment) {
        return null;
    }
}
