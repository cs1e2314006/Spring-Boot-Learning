package com.learning.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	public TennisCoach() {

		System.out.println("Constructor of :- " + this.getClass().getName());
	}

	@Override
	public String getDailyWorkout() {

		return "Grind Tennis Daily man thats the only way to success";
	}

}
