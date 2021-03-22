/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 22 mar 2021  21:14:01
 *  Author:  RS 		
 */
package pl.rsof.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * <p></p><p>22 mar 2021</p>
 * @author RS
 *
 */
@Component
public class RandomFortuneService implements FortuneService {
	
	
	private String[]data = {"1 - A", "2 - BB", "3 - CCC", "4 - DDDD"};
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		
		return data[index];
	}

}
