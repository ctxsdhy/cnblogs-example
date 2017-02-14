package org.xs.demo1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {

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
	
	/**
	 * 保存实体
	 * @param request
	 * @return
	 */
	@RequestMapping("save")
	public String save(HttpServletRequest request) {
		
		testInfo info = new testInfo();
		info.setId(request.getParameter("id"));
		info.setName(request.getParameter("name"));
		
		testDao.save(info);
		
		return "redirect:/hello/mysql";
	}
	
	/**
	 * 登录页
	 */
	@RequestMapping("login")
	public String login() throws Exception {
		return "login";
	}
	
	/**
	 * 登录验证
	 */
	@RequestMapping("auth")
	public String auth(String loginName, String loginPwd) throws Exception {
		
		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
		
		if(!"xs".equals(loginName) || !"123".equals(loginPwd)) {
			return "redirect:/hello/login";
		}
		
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, loginPwd);
		Subject subject = SecurityUtils.getSubject();  
		subject.login(token);
		
		return "redirect:/hello/mysql";
	}
}
