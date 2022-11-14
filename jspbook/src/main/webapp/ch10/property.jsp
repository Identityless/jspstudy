<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<H2>ch10:property.jsp</H2>
		<HR>
		ServletContext 설정값 출력<HR>
		name3 : <%= getServletContext().getInitParameter("name3") %><BR>
		workspace : <%= getServletContext().getInitParameter("workspace") %>
	</div>
</body>
</html>