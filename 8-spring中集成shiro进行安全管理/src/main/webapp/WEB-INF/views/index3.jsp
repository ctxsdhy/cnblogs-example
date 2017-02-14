<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>Insert title here</title>
	</head>
	<body>
		<p>${say}</p>
		<c:if test="${!empty testList}">
			<table border="1" width="100px">
				<tr>
					<th>列1</th>
					<th>列2</th>
				</tr>
				<c:forEach items="${testList}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>