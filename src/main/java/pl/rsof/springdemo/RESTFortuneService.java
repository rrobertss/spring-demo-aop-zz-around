/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 22 mar 2021  21:18:06
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
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {

		return "RESTFortuneService";
	}

}
