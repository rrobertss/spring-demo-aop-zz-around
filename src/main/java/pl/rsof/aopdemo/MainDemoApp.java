/*
  *  Company: RS
 *  Project: spring-demo-aop
 *  Created: 13 paź 2021  22:26:22
 *  Author:  RS 		
 */
package pl.rsof.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.rsof.aopdemo.dao.AccountDAO;
import pl.rsof.aopdemo.dao.MembershipDAO;

/**
 * <p></p><p>13 paź 2021</p>
 * @author RS
 *
 */
public class MainDemoApp {

	
	public static void main(String[] args) {

		// read Spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account account = new Account();
		account.setName("Tom");
		account.setLevel("Platinum");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		
//		membershipDAO.addAccount();
		
		
		// getter / setter accountDAO
		accountDAO.setName("John");
		accountDAO.setServiceCode("bravo");
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		
		membershipDAO.addAccountAdministrator();
		membershipDAO.goToSleep();  
//		membershipDAO.addOne();
		
		context.close();
		
	}

}
