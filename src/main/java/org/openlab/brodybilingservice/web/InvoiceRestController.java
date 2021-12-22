package org.openlab.brodybilingservice.web;

import java.util.List;

import org.openlab.brodybilingservice.dto.InvoiceRequestDTO;
import org.openlab.brodybilingservice.dto.InvoiceResponceDTO;
import org.openlab.brodybilingservice.service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InvoiceRestController {
	
	private InvoiceService invoiceService;

	public InvoiceRestController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@GetMapping(path="/invoices/get/{id}")
	public InvoiceResponceDTO getInvoice(@PathVariable(name = "id") String invoiceId) {
		
		return invoiceService.getInvoice(invoiceId);
	}
	
	@GetMapping(path="/invoices/getall/{customerId}")
	public List<InvoiceResponceDTO> getInvoicesByCustomer(@PathVariable String customerId) {
		
		return invoiceService.invoicesByCustomerId(customerId);
	}
	
	@PostMapping(path="/invoices/save")
	public InvoiceResponceDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) {
		
		return invoiceService.save(invoiceRequestDTO);
	}
	
	@GetMapping(path="/invoices/getall/all")
	public List<InvoiceResponceDTO> allInvoices() {
		return invoiceService.allInvoices();
	}
	
	

	
}
