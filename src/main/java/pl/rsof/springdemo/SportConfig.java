/*
 *	Company: RS
 *  Project: spring-demo-annotations
 *  Created: 30 mar 2021  20:47:27
 *  Author:  RS 		
 */
package pl.rsof.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p><p>30 mar 2021</p>
 * @author RS
 *
 */
@Configuration
//@ComponentScan("pl.rsof.springdemo") /* do tennicCoach */
public class SportConfig {

	
	@Bean
	public SadFortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
	
}
