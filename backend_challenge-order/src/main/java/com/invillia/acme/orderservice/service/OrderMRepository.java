package com.invillia.acme.orderservice.service;

import com.invillia.acme.orderservice.model.OrderM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMRepository extends JpaRepository<OrderM, Long> {

    OrderM findOneById(Long id);
    OrderM save(OrderM orderM);
    List<OrderM> findByAddressContaining(String adress);
}
