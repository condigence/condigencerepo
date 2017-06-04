package com.condigence.medicare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;	
   
   @Column(name = "name")
   private String name;
   
   @Column(name = "contact_no")
   private long	contactNo;
   
   @Column(name = "email")
   private String email;
   
   @Column(name = "hospital_name")
   private String hospitalName;
   
   @Column(name = "qualification")
   private String qualification;
   
   @Column(name = "speciality")
   private String speciality;
   
   @Column(name = "address")
   private String address;
   
   @Column(name = "is_deleted")
   private boolean isDeleted;
   
   @Column(name = "commision")
   private long commision;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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

public String getHospitalName() {
	return hospitalName;
}

public void setHospitalName(String hospitalName) {
	this.hospitalName = hospitalName;
}

public String getQualification() {
	return qualification;
}

public void setQualification(String qualification) {
	this.qualification = qualification;
}

public String getSpeciality() {
	return speciality;
}

public void setSpeciality(String speciality) {
	this.speciality = speciality;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public boolean isDeleted() {
	return isDeleted;
}

public void setDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
}

public long getCommision() {
	return commision;
}

public void setCommision(long commision) {
	this.commision = commision;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + (int) (commision ^ (commision >>> 32));
	result = prime * result + (int) (contactNo ^ (contactNo >>> 32));
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((hospitalName == null) ? 0 : hospitalName.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + (isDeleted ? 1231 : 1237);
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
	result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
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
	Doctor other = (Doctor) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (commision != other.commision)
		return false;
	if (contactNo != other.contactNo)
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (hospitalName == null) {
		if (other.hospitalName != null)
			return false;
	} else if (!hospitalName.equals(other.hospitalName))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (isDeleted != other.isDeleted)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (qualification == null) {
		if (other.qualification != null)
			return false;
	} else if (!qualification.equals(other.qualification))
		return false;
	if (speciality == null) {
		if (other.speciality != null)
			return false;
	} else if (!speciality.equals(other.speciality))
		return false;
	return true;
}
	
	
}
