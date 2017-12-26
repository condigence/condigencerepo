package com.condigence.medicare.dto;

import java.io.Serializable;



import com.condigence.medicare.model.Appointment;

public class CommissionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private int totalCommission;

	private Appointment appointment;

	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotalCommission() {
		return totalCommission;
	}

	public void setTotalCommission(int totalCommission) {
		this.totalCommission = totalCommission;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
