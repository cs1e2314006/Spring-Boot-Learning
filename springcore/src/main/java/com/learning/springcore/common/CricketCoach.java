package com.learning.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
// this component defines the spring that it can use it for dependency injection
@Component
@Primary
public class CricketCoach implements Coach{

	CricketCoach(){
		System.out.println("Constructor of :- " +this.getClass().getName());
	}
	@Override
	public String getDailyWorkout() {
		
		return "Fast Bowling for 2 hours daily with Red Leather Ball in the field";
	}
	
}
