package com.nhom1.invoiceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InvoiceserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceserviceApplication.class, args);
	}

}
