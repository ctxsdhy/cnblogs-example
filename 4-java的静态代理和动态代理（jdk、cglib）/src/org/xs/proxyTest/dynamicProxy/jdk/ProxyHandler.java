package org.xs.proxyTest.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
	
	private Object target;
	
	public ProxyHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] param) throws Throwable {
		System.out.println("jdk动态代理开始");
		Object result = method.invoke(target, param);
    	System.out.println("jdk动态代理结束");
    	
    	return result;
	}
}
