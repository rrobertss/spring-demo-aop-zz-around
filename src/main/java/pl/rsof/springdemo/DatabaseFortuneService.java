/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 22 mar 2021  21:12:16
 *  Author:  RS 		
 */
package pl.rsof.springdemo;

import org.springframework.stereotype.Component;

/**
 * <p></p><p>22 mar 2021</p>
 * @author RS
 *
 */
@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "DatabaseFortuneService";
	}

}
