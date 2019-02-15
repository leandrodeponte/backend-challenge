package com.invillia.acme.storeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.invillia.acme.storeservice"})
public class AcmeStoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(AcmeStoreApplication.class, args);
	}
}
