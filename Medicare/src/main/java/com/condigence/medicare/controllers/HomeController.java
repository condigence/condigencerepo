package com.condigence.medicare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String login() {
		return "index";
	}

	@RequestMapping("/home")
	public String dashboard() {
		return "dashboard";
	}
}
