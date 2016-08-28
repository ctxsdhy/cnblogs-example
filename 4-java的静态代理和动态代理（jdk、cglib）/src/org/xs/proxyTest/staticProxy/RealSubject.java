package org.xs.proxyTest.staticProxy;

public class RealSubject implements Subject {
	
	public void Request() {
		System.out.println("执行具体的功能");
	}
}
