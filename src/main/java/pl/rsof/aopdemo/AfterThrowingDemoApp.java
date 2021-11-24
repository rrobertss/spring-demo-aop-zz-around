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
public class AfterThrowingDemoApp {

	
	public static void main(String[] args) {

		// read Spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account>accounts = null;
		
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);	
		}catch (Exception e) {
			System.out.println("AfterThrowing, exception: "+e);
		}
		
		System.out.println("Start after findAccounts");
		System.out.println(accounts);
		
		
		context.close();
		
	}

}
