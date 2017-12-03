package com.condigence.medicare.repository;



import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

	Invoice findByAppointmentId(Long appointmentId);
	
	
	
	
}
