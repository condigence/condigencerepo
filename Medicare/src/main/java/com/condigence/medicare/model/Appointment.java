package com.condigence.medicare.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
@NamedQuery(name = "Appointment.findByCanceledAppointment", query = "SELECT count(*) FROM Appointment app WHERE app.isCancled = 1")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appointment_id")
	private Integer id;

	@Column(name = "patient_id")
	private Integer patientId;

	@Column(name = "referred_by_doctor_id")
	private Integer referredByDoctorId;

	@Column(name = "service_type_id")
	private Integer serviceTypeId;

	@Column(name = "created_by_user_id")
	private Integer createdByUserId;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "is_modified")
	private boolean isModified;

	@Column(name = "is_cancled")
	private boolean isCancled;

	@Column(name = "token")
	private int token;

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "modified_date_time")
	private Date modifiedDateTime;

	@Column(name = "status")
	private String status;

	@Column(name = "slot")
	private int slot;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getReferredByDoctorId() {
		return referredByDoctorId;
	}

	public void setReferredByDoctorId(Integer referredByDoctorId) {
		this.referredByDoctorId = referredByDoctorId;
	}

	public Integer getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public Integer getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(Integer createdByUserId) {
		this.createdByUserId = createdByUserId;
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
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
		result = prime * result + ((createdByUserId == null) ? 0 : createdByUserId.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isCancled ? 1231 : 1237);
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + (isModified ? 1231 : 1237);
		result = prime * result + ((modifiedDateTime == null) ? 0 : modifiedDateTime.hashCode());
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		result = prime * result + ((referredByDoctorId == null) ? 0 : referredByDoctorId.hashCode());
		result = prime * result + ((serviceTypeId == null) ? 0 : serviceTypeId.hashCode());
		result = prime * result + slot;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (createdByUserId == null) {
			if (other.createdByUserId != null)
				return false;
		} else if (!createdByUserId.equals(other.createdByUserId))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
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
		if (modifiedDateTime == null) {
			if (other.modifiedDateTime != null)
				return false;
		} else if (!modifiedDateTime.equals(other.modifiedDateTime))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		if (referredByDoctorId == null) {
			if (other.referredByDoctorId != null)
				return false;
		} else if (!referredByDoctorId.equals(other.referredByDoctorId))
			return false;
		if (serviceTypeId == null) {
			if (other.serviceTypeId != null)
				return false;
		} else if (!serviceTypeId.equals(other.serviceTypeId))
			return false;
		if (slot != other.slot)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (token != other.token)
			return false;
		return true;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

}