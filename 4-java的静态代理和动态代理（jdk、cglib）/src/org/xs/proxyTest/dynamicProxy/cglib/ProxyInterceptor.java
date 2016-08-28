package org.xs.proxyTest.dynamicProxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyInterceptor implements MethodInterceptor {
	
	public Object intercept(Object proxy, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
		System.out.println("cglib动态代理开始");
		Object result = methodProxy.invokeSuper(proxy, params);
		System.out.println("cglib动态代理开始");
		
		return result;
	}
	
	public Object newProxy(Object target) 
	{
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
}
