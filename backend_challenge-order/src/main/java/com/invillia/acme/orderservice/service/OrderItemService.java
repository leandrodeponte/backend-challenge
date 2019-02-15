package com.invillia.acme.orderservice.service;

import com.invillia.acme.orderservice.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemService extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAllByIdOrderm(Long idOrderm);
}
