package com.invillia.acme.paymentservice.model;

import com.invillia.acme.paymentservice.enums.PaymentStatusEnum;
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

    @Getter @Setter
    private Long idOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreditaCardNumber() {
        return creditaCardNumber;
    }

    public void setCreditaCardNumber(Long creditaCardNumber) {
        this.creditaCardNumber = creditaCardNumber;
    }

    public PaymentStatusEnum getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }
}
