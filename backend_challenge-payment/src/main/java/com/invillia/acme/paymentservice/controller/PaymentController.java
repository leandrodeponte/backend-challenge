package com.invillia.acme.paymentservice.controller;

import com.invillia.acme.paymentservice.model.Payment;
import com.invillia.acme.paymentservice.service.PaymentRepository;
import com.invillia.acme.paymentservice.validator.PaymentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> get(
            @PathVariable(value = "id") Long id
    ) {
        Payment payment = paymentRepository.findOneById(id);

        return new ResponseEntity<Payment>(payment, HttpStatus.OK);
    }

    @PostMapping("/payment/")
    public ResponseEntity<Payment> get(
            @RequestBody Payment payment
    ) {

        PaymentValidator paymentValidator = new PaymentValidator();
        paymentValidator.validate(payment);

        if(paymentValidator.hasErrors()){
            return new ResponseEntity(paymentValidator, HttpStatus.PRECONDITION_FAILED);
        }

        paymentRepository.save(payment);

        return new ResponseEntity<Payment>(payment, HttpStatus.OK);
    }

}
