/*
 *  Company: RS
 *  Project: spring-demo-aop
 *  Created: 18 paź 2021  20:51:59
 *  Author:  RS 		
 */
package pl.rsof.aopdemo.dao;

import org.springframework.stereotype.Component;

/**
 * <p></p><p>18 paź 2021</p>
 * @author RS
 *
 */
@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ", adding a membership account");
	}
	
	
	
	public void addAccountAdministrator() {
		System.out.println(getClass() + ", adding a administrator account");
	}
	
	
	public boolean addOne() {
		System.out.println(getClass() + ", is One");
		return true;
	}
	
	
	
	public void goToSleep() {
		System.out.println(getClass() + ", go to sleep");
	}
	
}
