package com.digitmarket.defaultstore.vendor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/vendor")
public class HomeController {

	@RequestMapping("/vendor-dashboard")
	public String getDashboard() {
		return "/vendor/vendor-dashboard";
	}

	@RequestMapping("/add-product")
	public String addProduct() {
		return "/vendor/add-product";
	}

	@RequestMapping("/add-product-basic")
	public String addProductBasic() {
		return "/vendor/add-product-basic";
	}

	@RequestMapping("/add-product-architecture")
	public String addProductArchitecture() {
		return "/vendor/add-product-architecture";
	}

	@RequestMapping("/add-product-faq")
	public String addProductFaq() {
		return "/vendor/add-product-faq";
	}

	@RequestMapping("/add-product-feature")
	public String addProductFeature() {
		return "/vendor/add-product-feature";
	}

	@RequestMapping("/list-products")
	public String listProducts() {
		return "/vendor/list-products";
	}	

}
