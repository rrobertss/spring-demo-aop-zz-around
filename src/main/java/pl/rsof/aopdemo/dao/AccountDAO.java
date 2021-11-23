/*
 *  Company: RS
 *  Project: spring-demo-aop
 *  Created: 13 paź 2021  21:24:26
 *  Author:  RS 		
 */
package pl.rsof.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.rsof.aopdemo.Account;

/**
 * <p>Test aspektow</p><p>13 paź 2021</p>
 * @author RS
 *
 */
@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	
	public List<Account>findAccounts(){
		
		List<Account>accounts = new ArrayList<>();
		
		Account a1 = new Account("Tom", "Silver");
		Account a2 = new Account("Greg", "Platinum");
		Account a3 = new Account("Mary", "Gold");
		
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		
		return accounts;
		
	}
	
	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass() + ": adding an account");
	}
	
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork");
		return false;
	}


	public String getName() {
		System.out.println(getClass() + ": getName");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass() + ": setName");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
}
