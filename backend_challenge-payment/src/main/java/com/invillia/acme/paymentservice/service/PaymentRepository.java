package com.invillia.acme.paymentservice.service;


import com.invillia.acme.paymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findOneById(Long id);
    Payment save(Payment payment);

}
