/*
 *  Company: RS
 *  Project: spring-demo-aop-z-after-returning
 *  Created: 23 lis 2021  22:30:11
 *  Author:  RS 		
 */
package pl.rsof.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.rsof.aopdemo.service.TrafficFortuneService;

/**
 * <p>Porada @Around z loggerem (zamieniony System.out.println)</p><p>23 lis 2021</p>
 * @author RS
 *
 */
public class AroundWithLoggerDemoApp {

	
	private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	
	public static void main(String[] args) {

		// read Spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("ArroundWithLoggerDemoApp is starting");
		
		String data = trafficFortuneService.getFortune();
		
		logger.info("My fortune is: "+ data);
		
		logger.info("ArroundDemoApp is finished");
		
		context.close();
		
	}

}
