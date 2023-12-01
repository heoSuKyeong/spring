package com.project.jr.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*
@RequestMapping(value = "/layout")
public class TestController {

	@GetMapping(value = "/test.do")
	public String test(Model model) {

		return "test";
	}
	
}
*/
@RequestMapping(value = "/template")
public class TestController {
	
	@GetMapping(value = "/index.do")
	public String index(Model model) {
	
		return "index";
	}
	
	@GetMapping(value = "/about.do")
	public String about(Model model) {
		
		return "about";
	}
	
	@GetMapping(value = "/contact.do")
	public String contact(Model model) {
		
		return "contact";
	}
	
	@GetMapping(value = "/jobDetails.do")
	public String jobDetails(Model model) {
		
		return "jobDetails";
	}
	
	@GetMapping(value = "/jobListings.do")
	public String jobListings(Model model) {
		
		return "jobListings";
	}
}