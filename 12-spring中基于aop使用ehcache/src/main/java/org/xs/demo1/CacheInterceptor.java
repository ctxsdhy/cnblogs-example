package org.xs.demo1;

import java.io.Serializable;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 缓存操作拦截器
 */
public class CacheInterceptor {
	
	/**
	 * 缓存实例
	 */
	private Cache cache;
	
	public Cache getCache() {  
        return cache;  
    }  
	
    public void setCache(Cache cache) {  
        this.cache = cache;  
    }  
    
	/**
	 * 增加缓存
	 */
	public Object addCache(ProceedingJoinPoint joinpoint) {
		Object result = null;
        try {
        	//组合缓存key（实例名，方法名，方法参数列表）
        	String cacheKey = getCacheKey(joinpoint.getTarget().getClass().getName(), joinpoint.getSignature().getName(), joinpoint.getArgs());
        	Element element = cache.get(cacheKey);
            //如果缓存里有就从缓存里取
        	if(element != null) {
            	result = element.getObjectValue();
            } else {
            	//执行方法，获得结果
            	result = joinpoint.proceed();
            	//将结果存入缓存
            	cache.put(new Element(cacheKey, (Serializable)result));
            }
        } catch (Throwable e) {
        	e.printStackTrace();
        }
        return result;
	}
	
	/**
	 * 移除缓存
	 */
	public void removeCache(JoinPoint point) {
		//获得实例名
		String className = point.getTarget().getClass().getName();
        List<?> list = cache.getKeys();
        for(int i = 0; i<list.size(); i++) {
            String cacheKey = String.valueOf(list.get(i));
            //移除以这个实例名开头的缓存
            if(cacheKey.startsWith(className)) {
                cache.remove(cacheKey);
            }  
        } 
	}
	
	/**
	 * 组合缓存key
	 */
	private String getCacheKey(String targetName, String methodName, Object[] arguments) {
		StringBuffer sb = new StringBuffer();
		//实例名+方法名
		sb.append(targetName).append(".").append(methodName);  
        if ((arguments != null) && (arguments.length != 0)) {
        	//组合方法参数
            for (int i = 0; i < arguments.length; i++) {  
                if(arguments[i] instanceof String[]){  
                    String[] strArray = (String[])arguments[i];  
                    sb.append(".");  
                    for(String str : strArray){  
                        sb.append(str);  
                    }  
                }else{  
                    sb.append(".").append(arguments[i]);  
                }  
            }  
        }  
		return sb.toString();
	}
}
