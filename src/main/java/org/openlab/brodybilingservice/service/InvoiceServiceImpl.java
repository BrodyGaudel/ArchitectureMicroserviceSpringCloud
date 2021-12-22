package org.openlab.brodybilingservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.openlab.brodybilingservice.dto.InvoiceRequestDTO;
import org.openlab.brodybilingservice.dto.InvoiceResponceDTO;
import org.openlab.brodybilingservice.entities.Customer;
import org.openlab.brodybilingservice.entities.Invoice;
import org.openlab.brodybilingservice.openfeign.CustomerRestClient;
import org.openlab.brodybilingservice.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{
	
	private InvoiceRepository invoiceRepository;
	private CustomerRestClient customerRestClient;
	
	

	public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CustomerRestClient customerRestClient) {
		this.invoiceRepository = invoiceRepository;
		this.customerRestClient = customerRestClient;
	}

	@Override
	public InvoiceResponceDTO save(InvoiceRequestDTO invoiceRequestDTO) {
		
		Invoice invoice = new Invoice();
		invoice.setId(UUID.randomUUID().toString());
		invoice.setAmount(invoiceRequestDTO.getAmount());
		invoice.setCustomerId(invoiceRequestDTO.getClientId());
		invoice.setDate(new Date());
		
		Invoice savedInvoice = invoiceRepository.save(invoice);
		
		InvoiceResponceDTO invoiceResponceDTO = new InvoiceResponceDTO();
		invoiceResponceDTO.setAmount(savedInvoice.getAmount());
		invoiceResponceDTO.setDate(savedInvoice.getDate());
		invoiceResponceDTO.setCustomer(savedInvoice.getCustomer());
		invoiceResponceDTO.setId(savedInvoice.getId());
		
		return invoiceResponceDTO;
	}

	@Override
	public InvoiceResponceDTO getInvoice(String invoiceId) {
		
		Invoice invoice = invoiceRepository.findById(invoiceId).get();
		Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
		invoice.setCustomer(customer);
		
		InvoiceResponceDTO invoiceResponceDTO = new InvoiceResponceDTO();
		invoiceResponceDTO.setId(invoice.getId());
		invoiceResponceDTO.setDate(invoice.getDate());
		invoiceResponceDTO.setAmount(invoice.getAmount());
		invoiceResponceDTO.setCustomer(invoice.getCustomer());
		return invoiceResponceDTO;
	}

	@Override
	public List<InvoiceResponceDTO> invoicesByCustomerId(String customerId) {
		List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);
		List<InvoiceResponceDTO> invoiceResponceDTOS = new ArrayList<>();
		InvoiceResponceDTO invoiceResponceDTO = new InvoiceResponceDTO();
		
		for(Invoice invoice: invoices) {
			invoiceResponceDTO.setAmount(invoice.getAmount());
			invoiceResponceDTO.setCustomer(invoice.getCustomer());
			invoiceResponceDTO.setDate(invoice.getDate());
			invoiceResponceDTO.setId(invoice.getId());
			invoiceResponceDTOS.add(invoiceResponceDTO);
		}
		return invoiceResponceDTOS;
	}

	@Override
	public List<InvoiceResponceDTO> allInvoices() {
		
		List<InvoiceResponceDTO> invoiceResponceDTOS = new ArrayList<>();
		InvoiceResponceDTO invoiceResponceDTO = new InvoiceResponceDTO();
		List<Invoice> invoices = invoiceRepository.findAll();
		
		for(Invoice invoice: invoices) {
			Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
			invoice.setCustomer(customer);
		}
		
		for(Invoice invoice: invoices) {
			invoiceResponceDTO.setAmount(invoice.getAmount());
			invoiceResponceDTO.setCustomer(invoice.getCustomer());
			invoiceResponceDTO.setDate(invoice.getDate());
			invoiceResponceDTO.setId(invoice.getId());
			invoiceResponceDTOS.add(invoiceResponceDTO);
		}
		return invoiceResponceDTOS;
	}

}
