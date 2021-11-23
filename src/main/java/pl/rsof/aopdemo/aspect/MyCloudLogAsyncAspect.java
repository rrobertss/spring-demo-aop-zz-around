/*
 *  Company: RS
 *  Project: spring-demo-aop-order
 *  Created: 16 lis 2021  21:34:32
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
@Order(3)
public class MyCloudLogAsyncAspect {

	
	
	@Before("pl.rsof.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("-----------> Before logging to cloud in async fashion");
	}
	
	
}
