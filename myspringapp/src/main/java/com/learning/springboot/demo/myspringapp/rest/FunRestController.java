package com.learning.springboot.demo.myspringapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	// expose "/" that returns Hello World
	@GetMapping("/")
	public String SayHello() {
		return "again changed while running";
	}
//	@GetMapping("/")
//	public String Say() {
//		return "Saying something";
//	}
	
	@GetMapping("/hello")
	public String Saybye() {
		return "Bye Bye";
	}
}
