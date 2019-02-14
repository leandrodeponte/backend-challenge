package com.invillia.acme.orderservice.service;

import com.invillia.acme.orderservice.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    OrderItem findOneById(Long id);
    OrderItem save(OrderItem orderItem);

}
