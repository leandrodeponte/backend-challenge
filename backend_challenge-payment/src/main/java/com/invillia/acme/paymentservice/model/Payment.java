package com.invillia.acme.orderservice.model;

import com.invillia.acme.orderservice.enums.PaymentStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter
    private Long creditaCardNumber;

    @Getter @Setter
    private PaymentStatusEnum paymentStatus;

}
