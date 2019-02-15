package com.invillia.acme.orderservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @Transient
    @Getter @Setter
    private OrderM orderm;

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

    public OrderM getOrderm() {
        return orderm;
    }

    public void setOrderm(OrderM orderm) {
        this.orderm = orderm;
    }
}
