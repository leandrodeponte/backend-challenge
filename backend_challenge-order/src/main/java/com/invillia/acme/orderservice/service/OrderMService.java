package com.invillia.acme.orderservice.service;

import com.invillia.acme.orderservice.model.OrderItem;
import com.invillia.acme.orderservice.model.OrderM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMService {

    @Autowired
    OrderMRepository orderMRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    public OrderM save(OrderM orderM){

        OrderM orderSaved = orderMRepository.save(orderM);

        for(OrderItem item : orderSaved.getOrderItemList()){
            item.setOrderm(orderSaved);
            orderItemRepository.save(item);
        }

        return orderSaved;
    }

}


