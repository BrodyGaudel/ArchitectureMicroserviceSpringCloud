package org.openlab.openlabcustomerservice.web;

import java.util.List;
import java.util.UUID;

import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping
public class CustomerRestApi {
	
	private CustomerService customerService;

	public CustomerRestApi(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping(path="/customers/getall")
	public List<CustomerResponseDTO> allCustomers() {
		return customerService.listCustomers();
	}
	
	@PostMapping(path="/customers/save")
	public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRquestDTO) {
		customerRquestDTO.setId(UUID.randomUUID().toString());
		return customerService.save(customerRquestDTO);
	}
	
	@GetMapping(path="/customers/get/{id}")
	public CustomerResponseDTO getCustomer(@PathVariable String id) {
		return customerService.getCustomer(id);
	}

}
