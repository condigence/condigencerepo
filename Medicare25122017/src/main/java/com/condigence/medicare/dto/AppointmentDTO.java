package com.condigence.medicare.dto;

import java.util.List;

import com.condigence.medicare.model.Doctor;
import com.condigence.medicare.model.Patient;
import com.condigence.medicare.model.ServiceType;
import com.condigence.medicare.model.User;

public class AppointmentDTO {

	private Long appointmentId;

	private Patient patient;

	private Doctor referredByDoctor;

	private List<ServiceType> serviceType;
	
	private List<String> services;	

	private User createdByUserId;

	private boolean isDeleted;

	private boolean isModified;

	private boolean isCancled;

	private String dateTime;

	private String modifiedDateTime;

	private String status;

	private int slot;

	private int token;

	private String firstName;

	private String lastName;

	private int age;

	private String address;

	private long contactNo;

	private Character gender;

	private String email;

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isModified() {
		return isModified;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public void setModified(boolean isModified) {
		this.isModified = isModified;
	}

	public boolean isCancled() {
		return isCancled;
	}

	public void setCancled(boolean isCancled) {
		this.isCancled = isCancled;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getModifiedDateTime() {
		return modifiedDateTime;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	public void setModifiedDateTime(String modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getReferredByDoctor() {
		return referredByDoctor;
	}

	public void setReferredByDoctor(Doctor referredByDoctor) {
		this.referredByDoctor = referredByDoctor;
	}

	public User getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(User createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ServiceType> getServiceType() {
		return serviceType;
	}

	public void setServiceType(List<ServiceType> serviceType) {
		this.serviceType = serviceType;
	}

}