package org.openlab.openlabcustomerservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.entities.Customer;
import org.openlab.openlabcustomerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	//private CustomerMapper customerMapper;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
		//this.customerMapper = customerMapper;
	}
	

	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		
		/*Mapping Object Object*/
		Customer customer = new Customer();
		customer.setId(customerRequestDTO.getId());
		customer.setName(customerRequestDTO.getName());
		customer.setEmail(customerRequestDTO.getEmail());
		
		//Customer customer = customerMapper.CustomerRequestDTOCustomer(customerRequestDTO);
		//customer.setId(UUID.randomUUID().toString()); for generate an id automatically
		Customer saveCustomer = customerRepository.save(customer);
		
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		customerResponseDTO.setId(saveCustomer.getId());
		customerResponseDTO.setName(saveCustomer.getName());
		customerResponseDTO.setEmail(saveCustomer.getEmail());
		
		//CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(saveCustomer);
		
		return customerResponseDTO;
	}

	@Override
	public CustomerResponseDTO getCustomer(String id) {
		Customer customer = customerRepository.findById(id).get();
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		customerResponseDTO.setId(customer.getId());
		customerResponseDTO.setName(customer.getName());
		customerResponseDTO.setEmail(customer.getEmail());
		return customerResponseDTO;
		//return customerMapper.customerToCustomerResponseDTO(customer);
	}

	@Override
	public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO) {
		Customer customer = new Customer();
		customer.setId(customerRequestDTO.getId());
		customer.setName(customerRequestDTO.getName());
		customer.setEmail(customerRequestDTO.getEmail());
		Customer updatedCustomer = customerRepository.save(customer);
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		customerResponseDTO.setId(updatedCustomer.getId());
		customerResponseDTO.setName(updatedCustomer.getName());
		customerResponseDTO.setEmail(updatedCustomer.getEmail());
		return customerResponseDTO;
		
	}

	@Override
	public List<CustomerResponseDTO> listCustomers() { 
		List<CustomerResponseDTO> customerResponseDTOS = new ArrayList<>();
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		List<Customer> customers = customerRepository.findAll();
		
		for(Customer customer: customers) {
			customerResponseDTO.setId(customer.getId());
			customerResponseDTO.setName(customer.getName());
			customerResponseDTO.setEmail(customer.getEmail());
			customerResponseDTOS.add(customerResponseDTO);
		}
		
		return customerResponseDTOS;
	}
	
	
	/*@Override
	public List<CustomerResponseDTO> listCustomers() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTOS = 
				customers.stream()
				.map(cust->customerMapper.customerToCustomerResponseDTO(cust))
				.collect(Collectors.toList());
		return customerResponseDTOS;
	}*/

}
