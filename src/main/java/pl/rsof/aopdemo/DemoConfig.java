/*
 *  Company: RS
 *  Project: spring-demo-aop
 *  Created: 13 paź 2021  21:26:04
 *  Author:  RS 		
 */
package pl.rsof.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p></p><p>13 paź 2021</p>
 * @author RS
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("pl.rsof.aopdemo")
public class DemoConfig {

}
