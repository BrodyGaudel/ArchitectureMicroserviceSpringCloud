package org.openlab.brodybilingservice;

import java.math.BigDecimal;

import org.openlab.brodybilingservice.dto.InvoiceRequestDTO;
import org.openlab.brodybilingservice.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class BrodyBilingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrodyBilingServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(InvoiceService invoiceService) {
		return args -> {
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(98000), "C01"));
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(76000), "C01"));
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(76000), "C02"));
		};
	}

}
