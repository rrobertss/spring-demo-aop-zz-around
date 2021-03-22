/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 22 mar 2021  20:53:54
 *  Author:  RS 		
 */
package pl.rsof.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p></p><p>22 mar 2021</p>
 * @author RS
 *
 */
public class AnnotationBeanScopeDemoApp {

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Coach coach = applicationContext.getBean("tennisCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
	}

}
