package com.invillia.acme.paymentservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private Long unitPrice;

    @Getter @Setter
    private int quantity;

    @Getter @Setter
    private Long idOrderm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getOrderm() {
        return idOrderm;
    }

    public void setOrderm(Long idOrderm) {
        this.idOrderm = idOrderm;
    }
}
