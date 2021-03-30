/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 30 mar 2021  22:09:16
 *  Author:  RS 		
 */
package pl.rsof.springdemo;

/**
 * <p></p><p>30 mar 2021</p>
 * @author RS
 *
 */
public class SwimCoach implements Coach {

	
	private FortuneService fortuneService;
	
	
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

}
