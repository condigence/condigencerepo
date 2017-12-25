package com.condigence.medicare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condigence.medicare.model.ClientSite;
import com.condigence.medicare.repository.ClientSiteRepository;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
public class ClientSiteController {

	public static final Logger logger = LoggerFactory.getLogger(ClientSiteController.class);

	@Autowired
	ClientSiteRepository clientSiteRepository;

	/**
	 * @return
	 */
	@GetMapping(value = "/clientsites")
	public ResponseEntity<List<ClientSite>> listAllServiceTypes() {
		List<ClientSite> clientsites = (ArrayList<ClientSite>) clientSiteRepository.findAll();
//		if (clientsites.isEmpty()) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
		return new ResponseEntity<List<ClientSite>>(clientsites, HttpStatus.OK);
	}

}
