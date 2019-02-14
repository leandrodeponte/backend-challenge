package com.invillia.acme.orderservice.model;

import com.invillia.acme.orderservice.enums.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class OrderM implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter
    private String address;

    @Getter @Setter
    private Date confirmationDate;

    @Getter @Setter
    private OrderStatusEnum orderStatus;

    @OneToMany(mappedBy="orderm")
    @Getter @Setter
    private List<OrderItem> orderItemList = new ArrayList<>();

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}
