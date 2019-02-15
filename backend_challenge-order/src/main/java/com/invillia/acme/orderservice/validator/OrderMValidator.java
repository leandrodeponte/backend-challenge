package com.invillia.acme.orderservice.validator;

import com.invillia.acme.orderservice.enums.OrderStatusEnum;
import com.invillia.acme.orderservice.model.OrderM;
import com.invillia.acme.orderservice.service.OrderMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.*;

@Component
public class OrderMValidator {

    @Autowired
    OrderMRepository orderMRepository;

    List<String> erros = new ArrayList();

    public void  validate(Long id){

        erros = new ArrayList();

        if(Objects.isNull(id)){
            erros.add("O id é obrigatório.");
        }

        Optional<OrderM> opt = orderMRepository.findById(id);

        if(!opt.isPresent()){
            erros.add("Pedido "+ id +" não encontrado no sistema.");
            return;
        }

        OrderM order = opt.get();

        if(order.getOrderStatus().equals(OrderStatusEnum.REFUNDED)){
            erros.add("Pedido "+ id +" já foi estornado.");
            return;
        }

        LocalDate dataConfirmacao = order.getConfirmationDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        if(dataConfirmacao
                .isBefore(LocalDate.now().minus(Period.ofDays(10)))){
            erros.add("Pedido "+ id +" expirou data de estorno.");
        }

    }

    public boolean hasErrors(){
        return !erros.isEmpty();
    }

    public List<String> getErros(){
        return erros;
    }
}
