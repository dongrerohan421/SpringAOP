package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	// executes LoggingAdvice() before execution of getName()
	// @Before("execution(public String getName())")
	// @Before("allGetters() && allCircleMetods()")
	@Before("allCircleMetods()") // means all setters and getters will run
	public void LoggingAdvice(JoinPoint joinPoint) {
		// System.out.println(joinPoint.toString());
	}

	/*
	 * @Before("allGetters()") public void secondAdvice() { System.out.println(
	 * "Second advice executed."); }
	 */

	// only if target method successfully run and returns
	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void stringArgumentMethods(String name, String returnString) {
		System.out.println("A method that takes String arguments has been called. The value is : " + name
				+ " \nand the output value is : " + returnString);
	}

	// executes after exception get thrown
	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void exceptionAdvice(String name, RuntimeException ex) {
		System.out.println("An exception has been thrown: " + ex);
	}

	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

		Object returnValue = null;

		try {
			System.out.println("Before advice.");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After Returning.");
		} catch (Throwable e) {
			System.out.println("After Throwing." + e.getMessage());
		}

		System.out.println("After Finally.");
		return returnValue;
	}

	// Pointcut – Indicate which method should be intercept, by method name or
	// regular expression pattern.
	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

	@Pointcut("within(com.spring.aop.model.Circle)")
	public void allCircleMetods() {
	}
}
