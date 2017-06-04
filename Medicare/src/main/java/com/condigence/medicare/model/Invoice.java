package com.condigence.medicare.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer	id;
	
   @Column(name = "apointment_id")
   private Integer apointmentId;
   
   @Column(name = "total_bill")
   private Integer totalBill;
   
   @Column(name = "date_bill")
   private Date dateBill;
   
   @Column(name = "generated_by_user")
   private Integer generatedByUser;
   
   @Column(name = "status")
   private String status;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getApointmentId() {
	return apointmentId;
}

public void setApointmentId(Integer apointmentId) {
	this.apointmentId = apointmentId;
}

public Integer getTotalBill() {
	return totalBill;
}

public void setTotalBill(Integer totalBill) {
	this.totalBill = totalBill;
}

public Date getDateBill() {
	return dateBill;
}

public void setDateBill(Date dateBill) {
	this.dateBill = dateBill;
}

public Integer getGeneratedByUser() {
	return generatedByUser;
}

public void setGeneratedByUser(Integer generatedByUser) {
	this.generatedByUser = generatedByUser;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((apointmentId == null) ? 0 : apointmentId.hashCode());
	result = prime * result + ((dateBill == null) ? 0 : dateBill.hashCode());
	result = prime * result + ((generatedByUser == null) ? 0 : generatedByUser.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((totalBill == null) ? 0 : totalBill.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Invoice other = (Invoice) obj;
	if (apointmentId == null) {
		if (other.apointmentId != null)
			return false;
	} else if (!apointmentId.equals(other.apointmentId))
		return false;
	if (dateBill == null) {
		if (other.dateBill != null)
			return false;
	} else if (!dateBill.equals(other.dateBill))
		return false;
	if (generatedByUser == null) {
		if (other.generatedByUser != null)
			return false;
	} else if (!generatedByUser.equals(other.generatedByUser))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	if (totalBill == null) {
		if (other.totalBill != null)
			return false;
	} else if (!totalBill.equals(other.totalBill))
		return false;
	return true;
  }
}
