package com.spring.rest.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

	@GetMapping("/hello")
	public String showHello() {
		return " Hello World! ";
	}

}
