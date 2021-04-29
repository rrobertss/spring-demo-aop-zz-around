/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 30 mar 2021  22:09:16
 *  Author:  RS 		
 */
package pl.rsof.springdemo;

import org.springframework.beans.factory.annotation.Value;

/**
 * <p></p><p>30 mar 2021</p>
 * @author RS
 *
 */
public class SwimCoach implements Coach {

	
	private FortuneService fortuneService;
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team; 
	
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


	public String getEmail() {
		return email;
	}


	public String getTeam() {
		return team;
	}

}
