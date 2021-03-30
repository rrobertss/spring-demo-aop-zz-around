/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 22 mar 2021  21:00:54
 *  Author:  RS 		
 */
package pl.rsof.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
	
	
	// init method
	@PostConstruct
	public void someInitMethod() {
		System.out.println("init method postConstruct");
	}
	
	
	// destroy method
	@PreDestroy
	public void someDestroyMethod() {
		System.out.println("destroy method: preDestroy");
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
