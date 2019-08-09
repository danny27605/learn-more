package com.cnipr.open.ms.gateway.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Bi Yunfei
 * @date 2019/8/8 14:16
 */
@Aspect
@Component
public class DoneTimeAspect {
	@Around("@annotation(doneTime)")
	public Object around(ProceedingJoinPoint joinPoint, DoneTime doneTime) throws Throwable {
		System.out.println("方法开始时间是:"+new Date());
		Object o = joinPoint.proceed();
		System.out.println("方法结束时间是:"+new Date()) ;
		return o;
	}
}
