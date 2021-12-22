package org.openlab.openlabcustomerservice.service;

import java.util.List;

import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;

public interface CustomerService {
	
	CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
	CustomerResponseDTO getCustomer(String id);
	CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO);
	List<CustomerResponseDTO> listCustomers();
}
