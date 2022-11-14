<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>&lt;c:set&gt;</h3>
	
	<c:set value="Hello World" var="msg"/>
	msg:${msg}<br>
	msg:<%=pageContext.getAttribute("msg") %>
	
	<c:set target="${member}" property="email" value="change@tukorea.ac.kr" />
	Member name : ${member.name} <BR>
	Member email : ${member.email}
</body>
</html>