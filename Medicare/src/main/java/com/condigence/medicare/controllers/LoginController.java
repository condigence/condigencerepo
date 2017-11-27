package com.condigence.medicare.controllers;

import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.condigence.medicare.model.Role;
import com.condigence.medicare.model.User;
import com.condigence.medicare.services.UserService;
import com.condigence.medicare.util.AppProperties;
import com.condigence.medicare.util.GlobalProperties;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

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

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		Set<Role> roles = user.getRoles();
		boolean isAdmin = false;
		boolean isSuperAdmin = false;
		boolean isManager = false;
		boolean isUser = false;
		String uRole = "";
		for (Role r : roles) {
			String role = r.getRole();
			isAdmin = role.equals("ADMIN") ? true : false;
			isSuperAdmin = role.equals("SUPERADMIN") ? true : false;
			isManager = role.equals("MANAGER") ? true : false;
			isUser = role.equals("USER") ? true : false;
		}

		if (isAdmin) {
			uRole ="ADMIN";
		} else if (isSuperAdmin) {
			uRole ="SUPERADMIN";
		} else if (isManager) {
			uRole ="MANAGER";
		} else {
			uRole ="USER";
		}

		logger.debug("Welcome {}, {}", app, global);

		modelAndView.addObject("host", app.getHost());
		modelAndView.addObject("port", app.getPort());

		modelAndView.addObject("isSuperAdmin", isSuperAdmin);
		modelAndView.addObject("isAdmin", isAdmin);
		modelAndView.addObject("isManager", isManager);
		modelAndView.addObject("isUser", isUser);

		modelAndView.addObject("userRole", uRole);
		modelAndView.addObject("userName", user.getName());
		modelAndView.addObject("userEmail", user.getEmail());
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.addObject("superAdminMessage", "Content Available Only for Users with Super Admin Role");
		modelAndView.addObject("managerMessage", "Content Available Only for Users with Manager Role");
				
		modelAndView.setViewName("home");
		return modelAndView;
	}

}
