package org.xs.proxyTest.dynamicProxy.cglib;

public class Client {
	
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		
		ProxyInterceptor proxyInterceptor = new ProxyInterceptor();
		RealSubject subject = (RealSubject)proxyInterceptor.newProxy(realSubject);
		
		subject.Request();
		subject.RequestFinal();
	}
}
