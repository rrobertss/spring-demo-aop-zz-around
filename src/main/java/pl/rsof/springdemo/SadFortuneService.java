/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 30 mar 2021  22:07:45
 *  Author:  RS 		
 */
package pl.rsof.springdemo;

/**
 * <p></p><p>30 mar 2021</p>
 * @author RS
 *
 */
public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {

		return "Today is very, very sad day. No drinking!!!";
	}

}
