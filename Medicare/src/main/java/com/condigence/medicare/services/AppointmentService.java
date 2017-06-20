package com.condigence.medicare.services;

import java.util.List;

import com.condigence.medicare.dto.AppointmentDTO;

public interface AppointmentService {

	public List<AppointmentDTO> findAppointments();

	public void save(AppointmentDTO appointment);
}
