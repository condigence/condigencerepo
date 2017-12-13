package com.condigence.medicare.services;

import com.condigence.medicare.dto.Billing;
import com.condigence.medicare.model.Appointment;

public interface BillingService {

	Billing getBill(Appointment appointment);

}
