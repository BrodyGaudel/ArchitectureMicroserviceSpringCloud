package org.openlab.brodybilingservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequestDTO {

	private BigDecimal amount;
	private String clientId;
}
