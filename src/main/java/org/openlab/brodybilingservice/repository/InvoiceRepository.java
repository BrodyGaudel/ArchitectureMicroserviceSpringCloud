package org.openlab.brodybilingservice.repository;

import java.util.List;

import org.openlab.brodybilingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
	
	List<Invoice> findByCustomerId(String clientId);
}
