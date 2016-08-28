package org.xs.proxyTest.staticProxy;

public class Client {
	
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		realSubject.Request();
		
		Subject subject = new Proxy(realSubject);
		subject.Request();
	}
}
