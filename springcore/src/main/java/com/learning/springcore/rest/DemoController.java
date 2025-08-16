package com.learning.springcore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springcore.common.Coach;

@RestController
public class DemoController {
	// declaring reference of coach but not intializing it as we want spring to handle the making the object of this class
//	private Coach myCoach;
	/*
		// constructor injection type of dependency injection
		@Autowired
		public DemoController(Coach requiredcoach) {
			this.myCoach=requiredcoach;
		}
	*/
	/*	
	  //setter injection type of dependency injection
		@Autowired
		public void setMyCoach(Coach myCoach) {
			this.myCoach = myCoach;
		}
		*/
//	// field injection (not recommended)
//	@Autowired
//	private Coach secondCoach;
	
	@Autowired
	@Qualifier("tennisCoach")
	private Coach DesiredCoach;
	
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return DesiredCoach.getDailyWorkout();
	}
	
	
	
@GetMapping("/")
public String SayHello() {
	return "Spring core is saying hello";
}
}
