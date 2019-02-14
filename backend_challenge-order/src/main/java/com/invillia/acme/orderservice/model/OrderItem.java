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

    @ManyToOne
    @JoinColumn(name = "orderm_id")
    @Getter @Setter
    private OrderM orderm;

    public void setOrderm(OrderM orderm) {
        this.orderm = orderm;
    }

}
