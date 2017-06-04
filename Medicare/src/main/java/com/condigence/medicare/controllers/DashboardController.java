package com.condigence.medicare.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.condigence.medicare.dto.Dashboard;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	public static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "totalcount/{entity}", method = RequestMethod.GET)
	public ResponseEntity<Dashboard> listAllAppointments() {
		Dashboard dashboard = new Dashboard();
//		if (dashboard == null) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//			// You many decide to return HttpStatus.NOT_FOUND
//		}
		return new ResponseEntity<Dashboard>(dashboard, HttpStatus.OK);
	}

}
