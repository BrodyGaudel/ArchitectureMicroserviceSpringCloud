package org.openlab.brodybilingservice.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.openlab.brodybilingservice.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponceDTO {
	
	private String id;
	private Date date;
	private BigDecimal amount;
	private Customer customer;
}
