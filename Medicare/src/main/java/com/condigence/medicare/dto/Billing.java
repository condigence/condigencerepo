package com.condigence.medicare.dto;

import java.util.Set;

import com.condigence.medicare.model.ServiceType;

public class Billing {

	private int billNo;
	
	private String name;
	
	private Set<ServiceType>  listofServices;
	
	private String  date;

	private double  TotalPrice;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}

	public Set<ServiceType> getListofServices() {
		return listofServices;
	}

	public void setListofServices(Set<ServiceType> listofServices) {
		this.listofServices = listofServices;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
}
