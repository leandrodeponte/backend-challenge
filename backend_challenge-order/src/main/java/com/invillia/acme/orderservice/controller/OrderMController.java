package com.invillia.acme.orderservice.controller;

import com.invillia.acme.orderservice.model.OrderItem;
import com.invillia.acme.orderservice.model.OrderM;
import com.invillia.acme.orderservice.service.OrderItemService;
import com.invillia.acme.orderservice.service.OrderMRepository;
import com.invillia.acme.orderservice.service.OrderMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping(path="/api")
public class OrderMController {

    @Autowired
    OrderMRepository orderMRepository;

    @Autowired
    OrderMService orderMService;

    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/orderm/{id}")
    public ResponseEntity<OrderM> get(
            @PathVariable("id") Long idOrderM) {

        OrderM order = orderMService.findOneById(idOrderM);

        if(order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);

    }

    @GetMapping("/orderm/{id}/orderItemList/")
    public ResponseEntity<List<OrderItem>> getItemlList(
            @PathVariable("id") Long idOrderm) {

        OrderM order = orderMService.findOneById(idOrderm);

        if(Objects.isNull(order)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<OrderItem> orderItemList = orderItemService.findAllByIdOrderm(idOrderm);

        if(Objects.isNull(orderItemList.isEmpty())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orderItemList, HttpStatus.OK);

    }

    @GetMapping("/orderm/")
    public ResponseEntity<List<OrderM>> get(
            @RequestParam("address") String address) {

        List<OrderM> orderList = orderMRepository.findByAddress(address);

        if(orderList == null || orderList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<OrderM>>(orderList, HttpStatus.OK);

    }

    @PostMapping("/orderm/")
    public ResponseEntity<OrderM> post(
            @RequestBody OrderM orderM) {

        orderMService.save(orderM);

        return new ResponseEntity<OrderM>(HttpStatus.OK);

    }

}
