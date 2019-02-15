package com.invillia.acme.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.invillia.acme.paymentservice"})
public class AcmePaymentApplication {

	public static void main(String[] args) {

		SpringApplication.run(AcmePaymentApplication.class, args);
	}
}
