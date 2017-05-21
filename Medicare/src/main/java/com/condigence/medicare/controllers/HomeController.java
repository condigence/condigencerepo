package com.condigence.medicare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.condigence.medicare.model.Nir;
import com.condigence.medicare.repository.NirMongoRepository;
import com.condigence.medicare.repository.NirSearchRepository;

@Controller
public class HomeController {

	@Autowired
	NirMongoRepository carRepository;

	@Autowired
	NirSearchRepository carSearchRepository;

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("carList", carRepository.findAll());
		return "home";
	}

	@RequestMapping("/")
	public String home() {

		return "index";
	}
	
	@RequestMapping("/content")
	public String getContent() {

		return "main-content";
	}
	
	@RequestMapping("/order")
	public String getOrder() {

		return "order-content";
	}
	
	@RequestMapping("/checkout")
	public String getCheckout() {

		return "checkout-content";
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String addCar(@ModelAttribute Nir car) {
		carRepository.save(car);
		return "redirect:home";
	}

	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("carList", carSearchRepository.searchCars(search));
		model.addAttribute("search", search);
		return "home";
	}

}
