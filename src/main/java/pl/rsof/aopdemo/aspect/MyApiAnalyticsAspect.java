/*
 *  Company: RS
 *  Project: spring-demo-aop-order
 *  Created: 16 lis 2021  21:33:38
 *  Author:  RS 		
 */
package pl.rsof.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p></p><p>16 lis 2021</p>
 * @author RS
 *
 */
@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

	
	@Before("pl.rsof.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("-----------> Before performApiAnalytics");
	}
	
}
