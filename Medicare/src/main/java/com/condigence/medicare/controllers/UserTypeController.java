package com.condigence.medicare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.condigence.medicare.model.UserType;
import com.condigence.medicare.repository.SearchRepository;
import com.condigence.medicare.repository.UserTypeRepository;

@Controller
public class UserTypeController {

	@Autowired
	UserTypeRepository userTypeRepository;

	@Autowired
	SearchRepository searchRepository;

	@RequestMapping(value = "/addUserType")
	public String addUserTypeGet() {
		return "example";
	}

	@RequestMapping(value = "/addUserType", method = RequestMethod.POST)
	public String addUserTypePost(@ModelAttribute UserType userType) {
		userTypeRepository.save(userType);
		return "example";
	}

	@RequestMapping(value = "/editUserType", method = RequestMethod.PUT)
	public void editUserType(@ModelAttribute UserType userType) {
		userTypeRepository.save(userType);
	}

	@RequestMapping(value = "/deleteUserType", method = RequestMethod.DELETE)
	public String deleteUserType(@ModelAttribute UserType userType) {
		userTypeRepository.delete(userType.getId());
		return "example";
	}

	@RequestMapping(value = "/allUserType")
	public ModelAndView allUserType() {
		ModelAndView mv = new ModelAndView();
		List<UserType> userTypes = (ArrayList<UserType>) userTypeRepository.findAll();
		mv.addObject("userTypes", userTypes);
		mv.setViewName("example");
		return mv;
	}

	@RequestMapping(value = "/search")
	public ModelAndView search(@RequestParam String search) {
		ModelAndView mv = new ModelAndView();
		UserType userType = searchRepository.findByType(search);
		mv.addObject("userType", userType);
		mv.setViewName("example");
		return mv;
	}

}
