package org.xs.demo1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private testDao testDao;
	
	@RequestMapping("world")
	public String helloworld(HttpServletRequest request) {
		request.setAttribute("say", "Hello World!");
		return "index2";
	}
	
	@RequestMapping("mysql")
	public String mysql(HttpServletRequest request) {
		
		List<testInfo> list = testDao.getList();
		
		request.setAttribute("testList", list);
		request.setAttribute("say", "Hello Mysql!");
		
		return "index3";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		
		//先从缓存中获取list
		List<testInfo> list = (List<testInfo>)CacheUtils.get("test", "testList");
		if(list == null) {
			list = testDao.getList();
			//将list存入缓存
			CacheUtils.put("test", "testList", list);
		}
		
		//如果修改了test的数据后要马上体现，可以手动清空list缓存
		//CacheUtils.remove("test", "testList");
		
		request.setAttribute("testList", list);
		
		return "list";
	}
	
	@RequestMapping("list2")
	public String list2(HttpServletRequest request) {
		
		List<testInfo> list = testDao.getList();
		request.setAttribute("testList", list);
		
		//log.info("233");
		
		return "list";
	}
	
	@RequestMapping("view/{id}")
	public String view(@PathVariable("id") String id, HttpServletRequest request) {
		
		testInfo info = testDao.getInfo(id);
		request.setAttribute("testInfo", info);
		
		return "view";
	}
	
	@RequestMapping("update/{id}")
	public String update(@PathVariable("id") String id, HttpServletRequest request) {
		
		testInfo testInfo = new testInfo();
		testInfo.setId(id);
		testDao.update(testInfo);
		
		return "redirect:/hello/list2";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") String id, HttpServletRequest request) {
		
		testDao.delete(id);
		
		return "redirect:/hello/list2";
	}
}
