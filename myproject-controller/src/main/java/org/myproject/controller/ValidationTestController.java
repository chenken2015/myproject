package org.myproject.controller;

import javax.validation.Valid;

import org.myproject.model.Person;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "validationTest")
@RestController("/validationTest")
public class ValidationTestController {
	
	@ApiOperation(value="the first validation test")
	@PostMapping("/first")
	public Person validation(@RequestBody @Valid Person person,BindingResult bindingResult) {
		return person;
	}
	
}
