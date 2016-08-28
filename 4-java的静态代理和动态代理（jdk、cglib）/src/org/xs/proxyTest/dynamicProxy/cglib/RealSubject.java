package org.xs.proxyTest.dynamicProxy.cglib;

public class RealSubject {
	
	public void Request() {
		System.out.println("执行具体的功能");
	}
	
	public final void RequestFinal() {
		System.out.println("执行具体的功能（final）");
	}
}
