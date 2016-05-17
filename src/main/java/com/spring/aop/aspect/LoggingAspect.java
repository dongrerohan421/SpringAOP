package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	// executes LoggingAdvice() before execution of getName()
	// @Before("execution(public String getName())")
	@Before("allGetters()")
	public void LoggingAdvice() {
		System.out.println("Advice run.Get method called");
	}

	@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Second advice executed.");
	}

	// Pointcut – Indicate which method should be intercept, by method name or
	// regular expression pattern.
	@Pointcut("execution(* get*())")
	public void allGetters() {
	}
}
