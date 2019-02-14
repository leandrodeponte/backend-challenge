package com.invillia.acme.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.invillia.acme.orderservice"})
public class AcmeOrderApplication {

	public static void main(String[] args) {

		SpringApplication.run(AcmeOrderApplication.class, args);
	}
}
