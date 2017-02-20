<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>Insert title here</title>
	</head>
	<body>
		<p>${say}</p>
		<table border="1" width="100px">
			<tr>
				<th>列1</th>
				<th>列2</th>
			</tr>
			<tr>
				<td>${testList[0].id}</td>
				<td>${testList[0].name}</td>
			</tr>
			<tr>
				<td>${testList[1].id}</td>
				<td>${testList[1].name}</td>
			</tr>
		</table>
	</body>
</html>