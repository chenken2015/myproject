package org.myproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/home")
@Api("LoginController相关的api")
public class HomeController {

	@GetMapping
	public String home() {
		return "home";
	}
	
}
