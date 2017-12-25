package com.condigence.medicare.dto;

public class Dashboard {

	private long totalAppointments;
	private long cancelAppointments;
	private long totalUsers;
	private long totalDoctors;
	private long totalServices;
	private long totalPatients;
	private long totalRoles;

	public long getTotalRoles() {
		return totalRoles;
	}

	public void setTotalRoles(long totalRoles) {
		this.totalRoles = totalRoles;
	}

	public long getTotalAppointments() {
		return totalAppointments;
	}

	public void setTotalAppointments(long totalAppointments) {
		this.totalAppointments = totalAppointments;
	}

	public long getCancelAppointments() {
		return cancelAppointments;
	}

	public void setCancelAppointments(long cancelAppointments) {
		this.cancelAppointments = cancelAppointments;
	}

	public long getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}

	public long getTotalDoctors() {
		return totalDoctors;
	}

	public void setTotalDoctors(long totalDoctors) {
		this.totalDoctors = totalDoctors;
	}

	public long getTotalServices() {
		return totalServices;
	}

	public void setTotalServices(long totalServices) {
		this.totalServices = totalServices;
	}

	public long getTotalPatients() {
		return totalPatients;
	}

	public void setTotalPatients(long totalPatients) {
		this.totalPatients = totalPatients;
	}

}
