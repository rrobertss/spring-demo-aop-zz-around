/*
 *  Company: RS
 *  Project: spring-demo-aop
 *  Created: 21 paź 2021  22:03:38
 *  Author:  RS 		
 */
package pl.rsof.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	@Around("execution(* pl.rsof.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		
		// we are advising here
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("Executing @Around on method: " + method);
		
		// begin timestamp
		long begin = System.currentTimeMillis(); 
		
		// execute the method
		Object methodResult = null;
		try {
			methodResult = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			logger.warning(e.getMessage());
			
			// give user a custom message, bez przekazywania wyjatku
//			methodResult = "Major Accident, but don't worry - glowna czesc aplikacji nawet nie wie o tym bledzie, exception nie jest przekazywany";
			
			// wybrac powyższą lub poniższą linię
			// przekazywanie wyjatku, 
			throw e;
		}
		
		
		// end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it 
		long duration = end - begin;
		logger.info("Duration is "+duration / 1000D + " seconds");
		
		return methodResult;
	}
	
	
	//podata @After - bedzie zawsze - niezaleznie od wyniku operacji (tak jak finally)
	@After("execution(* pl.rsof.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("----->>>>> After (finally), method is "+method);
	}
	
	
	// porada @AfterThrowing
	@AfterThrowing(pointcut = "execution(* pl.rsof.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "excep") 
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable excep) {
		
		// method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("----->>>>> AfterThrowing, method is "+method);
		
		// log the exception
		logger.info("----->>>>> AfterThrowing, exception is "+excep);
	
	}
	
	
	
	
	
	
	
	
	// ten poincut pasuje tylko do jednej metody w klasie accountDAO
	
	// porada (advise) @AfterReturning
	@AfterReturning(pointcut = "execution(* pl.rsof.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account>result) {
		
		// print method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("----> Executing AfterReturning: "+method);
		
		// print result of the method call
		logger.info("----> Result is " + result);
		
		
		
		// post-preocess the data - modify data
		
		// convert the account names to uppercase;
		convertAccountNamesToUpperCase(result); 
		
		logger.info("----> Result is (upperCase): " + result);
	}
		
		
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}



	//porada before
	@Before("pl.rsof.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("-----------> Before addAccountAdvice");
		
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		logger.info("Method signature (before): "+methodSignature);
		
		
		// display method arguments
		
		Object[] args = joinPoint.getArgs();
		for (Object o : args) {
			logger.info("Method argument: "+o);
			
			if (o instanceof Account) {
				Account account = (Account) o;
				logger.info("Account: "+account.getName()+", "+account.getLevel());
			}
			
		}
		
		
		
	}
	
}
