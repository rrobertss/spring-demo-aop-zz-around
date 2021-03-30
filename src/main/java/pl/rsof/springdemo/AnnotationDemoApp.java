/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 30 mar 2021  20:50:55
 *  Author:  RS 		
 */
package pl.rsof.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p></p><p>30 mar 2021</p>
 * @author RS
 *
 */
public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Coach coach = context.getBean("tennisCoach", Coach.class);
		
		
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}
	
	
}
