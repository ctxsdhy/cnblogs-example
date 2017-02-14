package org.xs.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class aopAdvice2 {
	
	@Pointcut("execution(* org.xs.demo1.testDao.getList(..))")
	public void performance() { }
	
	@Before("performance()")
	public void doBefore() {
		System.out.println("aop——before");
	}
	
	@After("performance()")
	public void doAfter() {
		System.out.println("aop——after");
	}
	
	@AfterReturning("performance()")
	public void doAfterReturning() {
		System.out.println("aop——after-returning");
	}
	
	@AfterThrowing("performance()")
	public void doAfterThrowing() {
		System.out.println("aop——after-throwing");
	}
	
	//joinpoint参数是被通知的方法
	//如果被通知的方法有返回值，在环绕方法里面也需要返回
	@Around("performance()")
	public Object doAround(ProceedingJoinPoint joinpoint) {
		Object result = null;
		try {
			System.out.println("aop——around-before");
			
			//调用被通知的方法
			result = joinpoint.proceed();
			
			System.out.println("aop——around-after");
		} catch (Throwable e) {
			System.out.println("aop——gg");
		}
		return result;
	}
}