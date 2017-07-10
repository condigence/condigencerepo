package com.condigence.medicare.dto;

import java.util.Date;

public class ReportDTO {

	
	private int noOfServices;
	
	private double totalServicePrice;
	
	private String Patient;
	
	private int totalAmountsPaidByPatients;
	
	private long refDocCommission;
	
	private String  refDoctor;
	
	private long profitPerPatient;
	
	private Date dateOfAppointment;
	

	public int getNoOfServices() {
		return noOfServices;
	}

	public void setNoOfServices(int noOfServices) {
		this.noOfServices = noOfServices;
	}

	public double getTotalServicePrice() {
		return totalServicePrice;
	}

	public void setTotalServicePrice(double totalServicePrice) {
		this.totalServicePrice = totalServicePrice;
	}

	public int getTotalAmountsPaidByPatients() {
		return totalAmountsPaidByPatients;
	}

	public void setTotalAmountsPaidByPatients(int totalAmountsPaidByPatients) {
		this.totalAmountsPaidByPatients = totalAmountsPaidByPatients;
	}

	public String getPatient() {
		return Patient;
	}

	public void setPatient(String patient) {
		Patient = patient;
	}

	public long getRefDocCommission() {
		return refDocCommission;
	}

	public void setRefDocCommission(long refDocCommission) {
		this.refDocCommission = refDocCommission;
	}

	public String getRefDoctor() {
		return refDoctor;
	}

	public void setRefDoctor(String refDoctor) {
		this.refDoctor = refDoctor;
	}

	public long getProfitPerPatient() {
		return profitPerPatient;
	}

	public void setProfitPerPatient(long profitPerPatient) {
		this.profitPerPatient = profitPerPatient;
	}

	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	
}
