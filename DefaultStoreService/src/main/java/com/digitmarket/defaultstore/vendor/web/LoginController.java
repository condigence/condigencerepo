package com.digitmarket.defaultstore.vendor.web;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digitmarket.defaultstore.common.util.AppProperties;
import com.digitmarket.defaultstore.common.util.GlobalProperties;
import com.digitmarket.defaultstore.vendor.model.Role;
import com.digitmarket.defaultstore.vendor.model.User;
import com.digitmarket.defaultstore.vendor.service.UserService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private AppProperties app;
	private GlobalProperties global;

	@Autowired
	public void setApp(AppProperties app) {
		this.app = app;
	}

	@Autowired
	public void setGlobal(GlobalProperties global) {
		this.global = global;
	}

	@Autowired
	private UserService userService;
//
//	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
//	public ModelAndView login() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("login");
//		return modelAndView;
//	}
	
	@RequestMapping(value = {"/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping("/forgotpassword")
	public ModelAndView resetPassword() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/vendor/vendor-forgot-password");
		return modelAndView;
	}

	// @RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	// public ModelAndView resetPassword(ForgotPasswordDTO forgotPasswordDTO) {
	// ModelAndView modelAndView = new ModelAndView();
	// SimpleMailMessage message = new SimpleMailMessage();
	// String to = "vishnu_tiwary@thbs.com";
	// String subject = "JavaMailSender";
	// String body = "Just-Testing!";
	//
	// // message.setFrom(from);
	// message.setTo(to);
	// message.setSubject(subject);
	// message.setText(body);
	// modelAndView.setViewName("vendor-login");
	// return modelAndView;
	// }

//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	 public ModelAndView home() {
//	 ModelAndView modelAndView = new ModelAndView();
//	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	 User user = userService.findUserByEmail(auth.getName());
//	 Set<Role> roles = user.getRoles();
//	 boolean isAdmin = false;
//	 String uRole = "";
//	 for (Role r : roles) {
//	 String role = r.getRole();
//	 isAdmin = role.equals("ADMIN") ? true : false;
//	 }
//	
//	 if (isAdmin) {
//	 uRole = "ADMIN";
//	 } else {
//	 uRole = "VENDOR";
//	 }
//	 logger.debug("Welcome {}, {}", app, global);
//	 modelAndView.addObject("host", app.getHost());
//	 modelAndView.addObject("port", app.getPort());
//	 modelAndView.addObject("isAdmin", isAdmin);
//	 modelAndView.addObject("userRole", uRole);
//	 modelAndView.addObject("userName", user.getName());
//	 modelAndView.addObject("loggedInUserId", user.getId());
//	 modelAndView.addObject("userEmail", user.getEmail());
//	 modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
//	 modelAndView.setViewName("index");
//	 return modelAndView;
//	 }

}
