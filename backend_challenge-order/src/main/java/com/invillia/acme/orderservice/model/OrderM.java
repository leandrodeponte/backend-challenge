package com.invillia.acme.orderservice.model;

import com.invillia.acme.orderservice.enums.OrderStatusEnum;
import com.invillia.acme.paymentservice.model.Payment;
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

    @Transient
    @Getter @Setter
    private List<OrderItem> orderItemList = new ArrayList<>();

    @Getter @Setter
    private Payment payment = new Payment();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
