package com.condigence.medicare.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.condigence.medicare.dto.ReportDTO;
import com.condigence.medicare.services.ReportServices;

@RestController
public class ReportController {

	public static final Logger logger = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	ReportServices reportServices;

	@GetMapping(value = "/reports")
	public ResponseEntity<List<ReportDTO>> listAllAppointments() {

		Date date = new Date();

		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		java.sql.Timestamp timestamp1 = new java.sql.Timestamp(lastYearSameDate().getTime());

		List<ReportDTO> listOfReportdto = reportServices.getStats(timestamp1.toString(), timestamp.toString());

		
		return new ResponseEntity<List<ReportDTO>>(listOfReportdto, HttpStatus.OK);
	}

	private Date yesterday() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	private Date lastYearSameDate() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -365);
		return cal.getTime();
	}
}
