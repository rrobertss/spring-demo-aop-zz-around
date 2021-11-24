/*
 *  Company: RS
 *  Project: spring-demo-aop
 *  Created: 21 paź 2021  22:03:38
 *  Author:  RS 		
 */
package pl.rsof.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import pl.rsof.aopdemo.Account;

/**
 * <p>Combining pointcuts - łączenie poincutow</p><p>21 paź 2021</p>
 * @author RS
 *
 */
@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	
	// porada @AfterThrowing
	@AfterThrowing(pointcut = "execution(* pl.rsof.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "excep") 
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable excep) {
		
		// method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("----->>>>> AfterThrowing, method is "+method);
		
		// log the exception
		System.out.println("----->>>>> AfterThrowing, exception is "+excep);
	
	}
	
	
	
	
	
	
	
	
	// ten poincut pasuje tylko do jednej metody w klasie accountDAO
	
	// porada (advise) @AfterReturning
	@AfterReturning(pointcut = "execution(* pl.rsof.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account>result) {
		
		// print method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("----> Executing AfterReturning: "+method);
		
		// print result of the method call
		System.out.println("----> Result is " + result);
		
		
		
		// post-preocess the data - modify data
		
		// convert the account names to uppercase;
		convertAccountNamesToUpperCase(result); 
		
		System.out.println("----> Result is (upperCase): " + result);
	}
		
		
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}



	//porada before
	@Before("pl.rsof.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("-----------> Before addAccountAdvice");
		
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method signature (before): "+methodSignature);
		
		
		// display method arguments
		
		Object[] args = joinPoint.getArgs();
		for (Object o : args) {
			System.out.println("Method argument: "+o);
			
			if (o instanceof Account) {
				Account account = (Account) o;
				System.out.println("Account: "+account.getName()+", "+account.getLevel());
			}
			
		}
		
		
		
	}
	
}
