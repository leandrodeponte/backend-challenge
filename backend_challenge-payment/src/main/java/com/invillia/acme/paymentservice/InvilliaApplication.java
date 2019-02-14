package com.invillia.acme.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.invillia.acme"})
public class InvilliaApplication {

	public static void main(String[] args) {

		SpringApplication.run(InvilliaApplication.class, args);
	}
}
