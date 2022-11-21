<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/ch09/choose.jsp" var="target">
		<c:param name="sel">a</c:param>
	</c:url>
	<hr>
	단순 출력 : ${target}<br>
	링크 연동 : <a href="${target}">choose.jsp-a선택</a>
</body>
</html>