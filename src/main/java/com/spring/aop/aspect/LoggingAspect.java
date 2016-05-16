package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	// executes LoggingAdvice() before execution of getName()
	@Before("execution(public String getName())")
	public void LoggingAdvice() {
		System.out.println("Advice run.Get method called");
	}
}
