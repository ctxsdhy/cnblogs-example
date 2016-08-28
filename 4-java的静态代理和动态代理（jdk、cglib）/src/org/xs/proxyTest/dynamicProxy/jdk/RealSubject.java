package org.xs.proxyTest.dynamicProxy.jdk;

public class RealSubject implements Subject {
	
	public void Request() {
		System.out.println("执行具体的功能");
	}
}
