<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kimwoojoong_mvcdb.domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Service Programming Homework</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>
<body>
	<header>TUKOREA 2022 <br> Web Service Programming Community </header>
	<p id="sect"><%=request.getAttribute("greetings")%><br>
	<div>
		<%
			StudentVO vo = (StudentVO)request.getAttribute("student");
		%>
		<table>
		<tr><td>계정</td><td>이름</td><td>학번</td><td>학과</td><td>핸드폰</td><td>메일주소</td></tr>
		<tr>
			<td><%= vo.getId() %></td>
			<td><%= vo.getUsername() %></td>
			<td><%= vo.getSnum() %></td>
			<td><%= vo.getDepart() %></td>
			<td><%= vo.getMobile() %></td>
			<td><%= vo.getEmail() %></td>
		</tr>
	</div>
	<div class="normal">
	<a href="http://localhost:8080/kimwoojoong_mvcdb/welcome.html" target="_self">메인 페이지 이동</a>
	</div>
</body>
</html>