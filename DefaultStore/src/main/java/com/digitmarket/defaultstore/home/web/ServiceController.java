package com.digitmarket.defaultstore.home.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digitmarket.defaultstore.common.util.AppProperties;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class ServiceController {

	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

	private AppProperties app;

	@Autowired
	public void setApp(AppProperties app) {
		this.app = app;
	}

	// @RequestMapping("/home")
	// public ModelAndView welcome(Map<String, Object> model) {
	// ModelAndView modelAndView = new ModelAndView();
	// String appProperties = app.toString();
	// String globalProperties = global.toString();
	// logger.debug("Welcome {}, {}", app, global);
	// modelAndView.addObject("host", app.getHost());
	// modelAndView.addObject("port", app.getPort());
	//
	// modelAndView.addObject("adminMessage", "Content Available Only for Users with
	// Admin Role");
	//
	// model.put("message", appProperties + globalProperties);
	// modelAndView.setViewName("index");
	// return modelAndView;
	// }

	@RequestMapping("/get-service-page")
	public String getService() {
		return "service/service";
	}

	@RequestMapping("/get-service-add-page")
	public String getServiceAdd() {
		return "service/service-add";
	}

	@RequestMapping("/get-service-list-page")
	public String getServiceList() {
		return "service/service-list";
	}

	@RequestMapping("/get-appointment-info-page")
	public String getAppointmentList() {
		return "service/appointment-info";
	}

}