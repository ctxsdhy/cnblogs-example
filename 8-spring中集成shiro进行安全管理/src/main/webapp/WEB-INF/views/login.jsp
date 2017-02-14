<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<%
			/* 当前基础url地址 */
			String path = request.getContextPath();
			request.setAttribute("path", path);
		%>
	</head>
	<body>
		<form action="${path}/hello/auth" method="post">
			登录名称：<input type="text"  name="loginName" value="${userInfo.loginName}" />
			登录密码：<input type="text"  name="loginPwd" value="${userInfo.loginPwd}" />
			<input type="submit"  class="btn btn-default btn-xs" value="登录" />
		</form>
	</body>
</html>