package com.digitmarket.defaultstore.home.web;

import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digitmarket.defaultstore.common.util.AppProperties;
import com.digitmarket.defaultstore.common.util.ConfigProperties;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class StoreController {

	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

	private AppProperties app;
	private ConfigProperties config;

	@Autowired
	public void setApp(AppProperties app) {
		this.app = app;
	}

	@Autowired
	public void setConfig(ConfigProperties config) {
		this.config = config;
	}

	@RequestMapping("/home")
	public ModelAndView welcome(Map<String, Object> model) {
		ModelAndView modelAndView = new ModelAndView();
		String appProperties = app.toString();
		String globalProperties = config.toString();
		logger.debug("Welcome {}, {}", app, config);
		modelAndView.addObject("host", app.getHost());
		modelAndView.addObject("port", app.getPort());

		modelAndView.addObject("coreURL", app.getCoreURL());
		modelAndView.addObject("webURL", app.getWebURL());
		modelAndView.addObject("serviceURL", app.getServiceURL());

		modelAndView.addObject("storeID", config.getStoreID());

		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");

		model.put("message", appProperties + globalProperties);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/list-service/{id}")
	public ModelAndView getServiceList(@PathVariable("id") String subCatId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("selectedSubCatId", subCatId);
		modelAndView.setViewName("/service-list");
		return modelAndView;

	}

	@RequestMapping("/service-desc")
	public String getServiceDescription() {
		return "/service-desc";
	}

	@RequestMapping("/service-checkout")
	public String getServiceCheckout() {
		return "/service-checkout";
	}

	@RequestMapping("/image-upload")
	public String getImageUpload() {
		return "/image-upload";
	}

}