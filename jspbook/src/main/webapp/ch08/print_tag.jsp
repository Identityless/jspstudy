<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Print Tag Test</title>
</head>
<body>
	<div align="center">
		<H2>PrintTagTest</H2><HR>
		<I><mytag:print>
			<%= request.getParameter("name") %>
		</mytag:print></I>
		테스트
	</div>
</body>
</html>