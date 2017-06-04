package com.condigence.medicare.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.condigence.medicare.model.User;
import com.condigence.medicare.repository.LoginRepository;
import com.condigence.medicare.repository.LoginSearchRepository;


@RestController
@RequestMapping("/login")
public class LoginController {

public static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	
	@Autowired
	LoginRepository loginRepository;
	
	
	@Autowired
	LoginSearchRepository  loginSearchRepository;
	
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		final ModelAndView mv = new ModelAndView();
		User user1 = new User();
		
		if(user.getEmail().contains("@")){
			user1 =loginSearchRepository.findUserByemail(user.getEmail());
		}else{
			user1 =loginSearchRepository.findUserByContactNo(user.getContactNo());
		}
		
		if(user.getPassword().equals(user1.getPassword())){
			mv.addObject("userId", user1.getId());
			mv.addObject("userName",user1.getUserName());
			mv.addObject("userEmail",user1.getEmail());
			mv.addObject("uNameNotValid", false);
			mv.setViewName("example");
		}else{
			mv.addObject("uNameNotValid", true);
			mv.setViewName("Login");
		}
		return mv;
	}
	
	
	
}
