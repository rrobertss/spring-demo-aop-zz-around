/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 22 mar 2021  21:00:54
 *  Author:  RS 		
 */
package pl.rsof.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <p></p><p>22 mar 2021</p>
 * @author RS
 *
 */
@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("constructor TennisCoach");
	}
	
	
	
	@Override
	public String getDailyWorkout() {
		
		return "daily workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
