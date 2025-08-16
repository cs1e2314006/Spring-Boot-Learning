package com.learning.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseBallCoach implements Coach {
	BaseBallCoach() {
		System.out.println("Constructor of :- " + this.getClass().getName());

	}

	@Override
	public String getDailyWorkout() {
		return "It is a japanese game not for indians you enjoy cricket only ";
	}

}
