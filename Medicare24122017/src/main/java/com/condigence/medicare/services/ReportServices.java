package com.condigence.medicare.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condigence.medicare.dto.ReportDTO;
import com.condigence.medicare.model.Appointment;
import com.condigence.medicare.model.ServiceType;
import com.condigence.medicare.repository.AppointmentRepository;

@Service
public class ReportServices {

	public static final Logger logger = LoggerFactory.getLogger(ReportServices.class);

	@Autowired
	AppointmentRepository appointmentRepository;

	public List<ReportDTO> getStats(String timestamp, String timestamp1) {

		List<ReportDTO> listOfReport = new ArrayList<ReportDTO>();

		logger.info(" Search between two date: " + timestamp + " yesterdayDate : " + timestamp1);

		List<Appointment> listOfAppointment = appointmentRepository.findByDateTimeBetween(timestamp,
				timestamp1);

		Map<String, ReportDTO> abmap = getMapOfReport(listOfAppointment);

		for (String key : abmap.keySet()) {
			
			listOfReport.add(abmap.get(key));
		}
		return listOfReport;
	}

	private Map<String, ReportDTO> getMapOfReport(List<Appointment> listOfAppointment) {
		Map<String, ReportDTO> abmap = new HashMap<String, ReportDTO>();

		//Long appointmentId = 0L;

		for (Appointment appointment : listOfAppointment) {

			Set<ServiceType> servicetype = appointment.getServices();

			for (ServiceType service : servicetype) {
				ReportDTO report = new ReportDTO();
				if (abmap.containsKey(service.getName())) {
					report.setServiceName(service.getName());
					report.setPerServiceCost(service.getPrice());
					
					//System.out.println(service.getName() +  " no. of services...  "+abmap.get(service.getName()).getNoOfPatient());
					
					report.setNoOfPatient(abmap.get(service.getName()).getNoOfPatient() + 1);
					
					
					//System.out.println(service.getName()  +" no. of after  services...  "+report.getNoOfPatient());
					report.setDoctorCommission(abmap.get(service.getName()).getDoctorCommission() + appointment.getReferredByDoctor().getCommission());
					report.setTotalServiceCost(abmap.get(service.getName()).getTotalServiceCost() + service.getPrice());
					report.setNoOfRefDoctor(abmap.get(service.getName()).getNoOfRefDoctor() + 1);
					report.setTotalAmount(report.getTotalServiceCost() - report.getDoctorCommission());
					abmap.put(service.getName(), report);

				} else {
					report.setServiceName(service.getName());
					report.setTotalServiceCost(service.getPrice());
					report.setPerServiceCost(service.getPrice());
						report.setNoOfPatient(1);
						report.setDoctorCommission(appointment.getReferredByDoctor().getCommission());
						report.setNoOfRefDoctor(1);
						report.setTotalAmount(report.getTotalServiceCost() - report.getDoctorCommission());

					abmap.put(service.getName(), report);
				}
			}
		}
		return abmap;
	}

}
