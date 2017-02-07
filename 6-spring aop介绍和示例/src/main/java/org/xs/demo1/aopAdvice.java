package org.xs.demo1;

import org.aspectj.lang.ProceedingJoinPoint;

public class aopAdvice {
	
	public void doBefore() {
		System.out.println("aop——before");
	}
	
	public void doAfter() {
		System.out.println("aop——after");
	}
	
	public void doAfterReturning() {
		System.out.println("aop——after-returning");
	}
	
	public void doAfterThrowing() {
		System.out.println("aop——after-throwing");
	}
	
	//joinpoint参数是被通知的方法
	//如果被通知的方法有返回值，在环绕方法里面也需要返回
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