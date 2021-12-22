package org.openlab.openlabcustomerservice.mappers;

import org.mapstruct.Mapper;
import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	
	//CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
	Customer CustomerRequestDTOCustomer(CustomerRequestDTO customerRequestDTO);
}
