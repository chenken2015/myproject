package org.myproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/login")
@Api("LoginController相关的api")
public class LoginController {

	@GetMapping
	public String login() {
		return "login";
	}
	
}
