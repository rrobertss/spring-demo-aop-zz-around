/*
 *  Company: RS
 *  Project: spring-demo-aop-order
 *  Created: 16 lis 2021  21:36:17
 *  Author:  RS 		
 */
package pl.rsof.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * <p></p><p>16 lis 2021</p>
 * @author RS
 *
 */
@Aspect
public class AopExpressions {

	

	// deklaracja pointcut-a - punktu przecięcia
	@Pointcut("execution(* pl.rsof.aopdemo.dao.*.*(..))")
	public void dowolnaNazwa() {}
	
	// pointcut for getter methods
	@Pointcut("execution(* pl.rsof.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	
	// pointcut for setter methods
	@Pointcut("execution(* pl.rsof.aopdemo.dao.*.set*(..))")
	public void setter  () {}
	
	// pointcut: include package ... exclude getter / setter
	@Pointcut("dowolnaNazwa() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
	
}
