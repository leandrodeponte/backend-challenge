package com.invillia.acme.orderservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String address;
}
