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
		
		
		Coach coach1 = applicationContext.getBean("tennisCoach", Coach.class);
		
		Coach coach2 = applicationContext.getBean("tennisCoach", Coach.class);
		
		boolean theSame = coach1 == coach2;
		
		System.out.println("the same: "+theSame);
		
		System.out.println("memory coach1: "+coach1);
		System.out.println("memory coach2: "+coach2);
		
//		System.out.println(coach1.getDailyWorkout());
//		System.out.println(coach.getDailyFortune());
		
		
		applicationContext.close();
	}

}
