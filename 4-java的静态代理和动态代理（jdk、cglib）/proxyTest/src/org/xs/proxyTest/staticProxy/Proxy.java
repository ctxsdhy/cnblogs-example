package org.xs.proxyTest.staticProxy;

public class Proxy implements Subject {
	
	private Subject realSubject = null;

	public Proxy(Subject subject) {
		realSubject = subject;
	}

	public void Request() {
		System.out.println("静态代理开始");
		realSubject.Request();
		System.out.println("静态代理结束");
	}
}
