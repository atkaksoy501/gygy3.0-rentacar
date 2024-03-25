package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Payment;

import java.util.List;

public interface PaymentService {
    Payment add(Payment payment);
    Payment getById(int id);
    List<Payment> getAll();
    void delete(int id);
    Payment update(int id, Payment payment);
}
