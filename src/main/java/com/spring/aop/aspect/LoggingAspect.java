package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
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

	@Before("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("A method that takes String arguments has been called. The value is : " + name);
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
