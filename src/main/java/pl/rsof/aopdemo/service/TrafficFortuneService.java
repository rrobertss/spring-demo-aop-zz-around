/*
 *  Company: RS
 *  Project: spring-demo-aop-zz-around
 *  Created: 30 lis 2021  18:31:43
 *  Author:  RS 		
 */
package pl.rsof.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

/**
 * <p>Do testowania porady (advice) - @Around</p><p>30 lis 2021</p>
 * @author RS
 *
 */
@Component
public class TrafficFortuneService {

	
	public String getFortune() {
		
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		
		// return a fortune
		return "Expect heavy traffic this morning";
		
	}

	
	// z obslugą wyjatkow
	public String getFortune(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("Exception, Major accident!!!!");
		}
		
		return getFortune();
	}
	
	
}
