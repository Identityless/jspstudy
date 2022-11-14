<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>foward action</title>
</head>
<body>
	<h2>forward_action.jsp 에서 forward한 메시지입니다.</h2>
	<jsp:forward page = "footer.jsp">
	<jsp:param name="email" value="test@kpu.net"/>
	<jsp:param name="tel" value="010-1234-5678"/>
	</jsp:forward>
</body>
</html>