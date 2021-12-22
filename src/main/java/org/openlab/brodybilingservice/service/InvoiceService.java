package org.openlab.brodybilingservice.service;

import java.util.List;

import org.openlab.brodybilingservice.dto.InvoiceRequestDTO;
import org.openlab.brodybilingservice.dto.InvoiceResponceDTO;

public interface InvoiceService {
	
	InvoiceResponceDTO save(InvoiceRequestDTO invoiceRequestDTO);
	InvoiceResponceDTO getInvoice(String invoiceId);
	List<InvoiceResponceDTO> invoicesByCustomerId(String customerId);
	List<InvoiceResponceDTO> allInvoices();
}
