package com.condigence.medicare.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condigence.medicare.dto.ReportDTO;
import com.condigence.medicare.model.Appointment;
import com.condigence.medicare.model.Doctor;
import com.condigence.medicare.model.Invoice;
import com.condigence.medicare.model.Patient;
import com.condigence.medicare.model.ServiceType;
import com.condigence.medicare.repository.AppointmentRepository;
import com.condigence.medicare.repository.InvoiceRepository;

@Service
public class ReportServices {

	public static final Logger logger = LoggerFactory.getLogger(ReportServices.class);
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	
	public List<ReportDTO> getStats(Timestamp timestamp, Timestamp timestamp1) {

		 List<ReportDTO> listOfReport = new ArrayList<ReportDTO>();
		
		// Timestamp timestamp = new java.sql.Timestamp("2017-07-09 22:33:35.468");
		logger.info(" Search between two date: "+ timestamp +" yesterdayDate : "+timestamp1 );
		
		List<Appointment>  listOfAppointment =   appointmentRepository.findByModifiedDateTimeBetween(timestamp,timestamp1);
		
		for(Appointment appointment : listOfAppointment){
			ReportDTO report = new ReportDTO();
			
			report.setDateOfAppointment(appointment.getModifiedDateTime());
		
			Invoice  invoice =  invoiceRepository.findByAppointmentId(appointment.getId());
			report.setTotalAmountsPaidByPatients(invoice.getTotalBill());
			
			Patient patient = appointment.getPatient();
			report.setPatient(patient.getFirstName()+" "+patient.getLastName());
			
			Set<ServiceType> servicetype = appointment.getServices();
			report.setNoOfServices(servicetype.size());
			report.setTotalServicePrice(getServicePrice(servicetype));
			
			Doctor doctor = appointment.getReferredByDoctor();  
			report.setRefDoctor(doctor.getName());
			report.setRefDocCommission(doctor.getCommission());
			
			report.setProfitPerPatient(CalulateProfit(invoice.getTotalBill(),report.getTotalServicePrice(),doctor.getCommission()));
			listOfReport.add(report);
		}
		
		return listOfReport;
	}


	private long CalulateProfit(Integer totalBill, double totalPrice, long commission) {
		return (long) (totalBill-(totalPrice - commission));
	}


	private double getServicePrice(Set<ServiceType> servivetype) {
		
		double prices = 0;
		for (ServiceType service:servivetype){
			prices += service.getPrice();
		}
		return prices;
	}

	
	
	
	
	
}
