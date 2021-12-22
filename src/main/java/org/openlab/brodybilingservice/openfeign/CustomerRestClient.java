package org.openlab.brodybilingservice.openfeign;

import java.util.List;

import org.openlab.brodybilingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

	@GetMapping(path="/customers/get/{id}")
	Customer getCustomer(@PathVariable(name="id") String id);
	
	@GetMapping(path="/customers/getall")
	List<Customer> allCustomers();
	
	
}
