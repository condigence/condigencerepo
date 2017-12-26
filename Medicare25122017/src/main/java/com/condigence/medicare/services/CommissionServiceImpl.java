package com.condigence.medicare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condigence.medicare.dto.CommissionDTO;
import com.condigence.medicare.model.Appointment;
import com.condigence.medicare.model.Commission;
import com.condigence.medicare.repository.AppointmentRepository;
import com.condigence.medicare.repository.CommissionRepository;
import com.condigence.medicare.repository.DoctorRepository;

@Service("commissionService")
public class CommissionServiceImpl implements CommissionService {
	
	
	@Autowired
	CommissionRepository commissionRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public CommissionDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCommission(CommissionDTO commissionDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CommissionDTO> findAll() {		
		List<CommissionDTO> commissionDTOs = new ArrayList<>();
		List<Commission> commissionList = (List<Commission>) commissionRepository.findAll();
		for(Commission commission : commissionList) {
			CommissionDTO commissionDTO = new CommissionDTO();			
			Appointment appointment = appointmentRepository.findOne(commission.getAppointmentId());				
			commissionDTO.setAppointment(appointment);
			commissionDTO.setId(commission.getId());
			commissionDTO.setStatus("true");
			commissionDTO.setTotalCommission((int)commission.getTotalCommission());
			commissionDTOs.add(commissionDTO);
		}		
		return commissionDTOs;
	}

}
