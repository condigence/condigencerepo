package com.condigence.medicare.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String login() {
		return "index";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@RequestMapping("/user")
	public String user() {
		return "user";
	}

	@RequestMapping("/appointment")
	public String appointment() {
		return "appointment";
	}

	@RequestMapping("/doctor")
	public String doctor() {
		return "doctor";
	}

	@RequestMapping("/patient")
	public String patient() {
		return "patient";
	}

	@RequestMapping("/user-type")
	public String userType() {
		return "service";
	}

	@RequestMapping("/service-type")
	public String serviceType() {
		return "service";
	}

	@RequestMapping("/commission")
	public String commission() {
		return "commission";
	}

	@RequestMapping("/billing")
	public String billing() {
		return "billing";
	}

	@RequestMapping("/report")
	public String report() {
		return "report";
	}

}
