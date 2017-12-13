package com.condigence.medicare.services;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.condigence.medicare.dto.Billing;
import com.condigence.medicare.model.Appointment;
import com.condigence.medicare.model.ServiceType;

@Service("billingService")
public class BillingServiceImpl  implements BillingService {

	
	
	@Override
	public Billing getBill(Appointment appointment) {
		
		double totalPrice = 0;
		
		Billing  billing = new Billing();
		
		billing.setName(appointment.getPatient().getFirstName());
		billing.setListofServices(appointment.getServices());
		billing.setDate(new Date());
		billing.setBillNo(new Random().nextInt(10000));
		
		for(ServiceType s: appointment.getServices()) {
			totalPrice += s.getPrice(); 
		}
		
		billing.setTotalPrice(totalPrice);
		
		return billing;
	}

}
