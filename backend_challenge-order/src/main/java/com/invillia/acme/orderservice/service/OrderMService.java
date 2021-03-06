package com.invillia.acme.orderservice.service;

import com.invillia.acme.orderservice.enums.OrderStatusEnum;
import com.invillia.acme.orderservice.model.OrderItem;
import com.invillia.acme.orderservice.model.OrderM;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderMService {

    @Autowired
    OrderMRepository orderMRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    public OrderM save(OrderM orderM){

        OrderM orderSaved = orderMRepository.save(orderM);

        orderSaved.getOrderItemList().forEach( i ->
        {
                i.setOrderm(orderSaved.getId());
                orderItemRepository.save(i);
            }
        );

        return orderSaved;
    }

    public OrderM findOneById(Long id){

        OrderM order = orderMRepository.findOneById(id);

        if(order != null){
           // Hibernate.initialize(order.getOrderItemList());
        }

        return order;

    }

    public OrderM refund(Long id){

        Optional<OrderM> orderMValidate = orderMRepository.findById(id);
        OrderM updated = new OrderM();

        if(!orderMValidate.isPresent()){
            return null;
        }

        updated = orderMValidate.get();
        updated.setOrderStatus(OrderStatusEnum.REFUNDED);

        orderMRepository.save(updated);

        return updated;

    }

}


