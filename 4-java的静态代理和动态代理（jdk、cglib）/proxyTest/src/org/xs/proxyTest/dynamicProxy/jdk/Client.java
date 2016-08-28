package org.xs.proxyTest.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
	
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		
		InvocationHandler handler = new ProxyHandler(realSubject);
		Subject subject = (Subject)Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
		
		subject.Request();
	}
}
