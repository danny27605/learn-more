package com.cnipr.open.ms.gateway.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Bi Yunfei
 * @date 2019/8/8 14:11
 */
@Aspect
@Component
public class LogAspect {
	@Pointcut("execution(public * com.cnipr.open.ms.gateway.web.*.*(..))")
	public void LogAspect(){}

	@Before("LogAspect()")
	public void doBefore(JoinPoint joinPoint){
		System.out.println("doBefore");
	}

	@After("LogAspect()")
	public void doAfter(JoinPoint joinPoint){
		System.out.println("doAfter");
	}

	@AfterReturning("LogAspect()")
	public void doAfterReturning(JoinPoint joinPoint){
		System.out.println("doAfterReturning");
	}

	@AfterThrowing("LogAspect()")
	public void deAfterThrowing(JoinPoint joinPoint){
		System.out.println("deAfterThrowing");
	}

	@Around("LogAspect()")
	public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("deAround");
		return joinPoint.proceed();
	}

}
