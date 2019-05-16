package com.sync.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class TestController {

	@GetMapping(value="/hello")
	public String hello() {
		return "Hello";
	}
}
