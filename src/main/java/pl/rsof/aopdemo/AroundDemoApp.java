/*
 *  Company: RS
 *  Project: spring-demo-aop-z-after-returning
 *  Created: 23 lis 2021  22:30:11
 *  Author:  RS 		
 */
package pl.rsof.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.rsof.aopdemo.service.TrafficFortuneService;

/**
 * <p>Porada @Around</p><p>23 lis 2021</p>
 * @author RS
 *
 */
public class AroundDemoApp {

	
	public static void main(String[] args) {

		// read Spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("ArroundDemoApp is starting");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("My fortune is: "+ data);
		
		System.out.println("ArroundDemoApp is finished");
		
		context.close();
		
	}

}
