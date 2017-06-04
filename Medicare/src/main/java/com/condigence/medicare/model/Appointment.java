package com.condigence.medicare.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contact_no")
	private long contactNo;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "ref_doc")
	private String refdoc;
	
	@Column(name = "commision")
	private String commision;
	
	@Column(name = "service_type")
    private String serviceType;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@Column(name = "is_modified")
    private boolean isModified;
    
	@Column(name = "is_cancled")
	private boolean isCancled;
    
	@Column(name = "token")
    private int token;
	
	@Column(name = "booking_date_time")
    private Date bookingDateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRefdoc() {
		return refdoc;
	}

	public void setRefdoc(String refdoc) {
		this.refdoc = refdoc;
	}

	public String getCommision() {
		return commision;
	}

	public void setCommision(String commision) {
		this.commision = commision;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
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

	public void setModified(boolean isModified) {
		this.isModified = isModified;
	}

	public boolean isCancled() {
		return isCancled;
	}

	public void setCancled(boolean isCancled) {
		this.isCancled = isCancled;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public Date getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(Date bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((bookingDateTime == null) ? 0 : bookingDateTime.hashCode());
		result = prime * result + ((commision == null) ? 0 : commision.hashCode());
		result = prime * result + (int) (contactNo ^ (contactNo >>> 32));
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isCancled ? 1231 : 1237);
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + (isModified ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((refdoc == null) ? 0 : refdoc.hashCode());
		result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
		result = prime * result + token;
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
		Appointment other = (Appointment) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (bookingDateTime == null) {
			if (other.bookingDateTime != null)
				return false;
		} else if (!bookingDateTime.equals(other.bookingDateTime))
			return false;
		if (commision == null) {
			if (other.commision != null)
				return false;
		} else if (!commision.equals(other.commision))
			return false;
		if (contactNo != other.contactNo)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isCancled != other.isCancled)
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (isModified != other.isModified)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (refdoc == null) {
			if (other.refdoc != null)
				return false;
		} else if (!refdoc.equals(other.refdoc))
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		if (token != other.token)
			return false;
		return true;
	}

}
