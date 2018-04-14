package com.ou.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HandleErrorController {

	@GetMapping(value = "/404")
	public String page404() {
		return "404";
	}

	@GetMapping(value = "/500")
	public String page500() {
		return "500";
	}

	@GetMapping(value = "/403")
	public String page403() {
		return "403";
	}
	
}
