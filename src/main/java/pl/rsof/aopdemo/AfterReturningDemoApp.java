/*
 *  Company: RS
 *  Project: spring-demo-aop-z-after-returning
 *  Created: 23 lis 2021  22:30:11
 *  Author:  RS 		
 */
package pl.rsof.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.rsof.aopdemo.dao.AccountDAO;

/**
 * <p></p><p>23 lis 2021</p>
 * @author RS
 *
 */
public class AfterReturningDemoApp {

	
	public static void main(String[] args) {

		// read Spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account>accounts = accountDAO.findAccounts();
		
		System.out.println("Start AfterReturning");
		System.out.println(accounts);
		
		
		
		context.close();
		
	}

}
