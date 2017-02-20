/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package org.xs.demo1;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 日志拦截器
 * @author ThinkGem
 */
public class LogInterceptor implements HandlerInterceptor {

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal StartTime");
	
	/* 
	 * 预处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		long beginTime = System.currentTimeMillis(); //开始时间  
        startTimeThreadLocal.set(beginTime); //线程绑定变量（该数据只有当前请求的线程可见）  
        log.info("开始计时: {}", new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime));
        
		return true;
	}

	/* 
	 * 返回处理
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (modelAndView != null){
			log.info("ViewName: " + modelAndView.getViewName());
		}
	}

	/* 
	 * 后处理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

		// 保存日志
		//LogUtils.saveLog(request, handler, ex, null);
		
		// 输出日志信息
		log.info("访问地址：" + request.getRequestURI() + "，执行方式：" + request.getMethod());
		
		long beginTime = startTimeThreadLocal.get(); //得到线程绑定的局部变量（开始时间）  
		long endTime = System.currentTimeMillis(); //结束时间  
		log.info("计时结束：{}", new SimpleDateFormat("hh:mm:ss.SSS").format(endTime)); 
	}
}
