<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kimwoojoong_mvcdb.domain.*, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Service Programming Homework</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>
<body>
	<header>Member List</header>
	<hr>
	
	<div class="normal">
	<a href="http://localhost:8080/kimwoojoong_mvcdb/welcome.html" target="_self">메인 페이지 이동</a>
	</div>
	<table>
		<tr><td>계정</td><td>이름</td><td>학번</td><td>학과</td><td>핸드폰</td><td>메일주소</td><td>관리</td></tr>
	<%
		List<StudentVO> studentList = (List<StudentVO>)request.getAttribute("studentList");
		for(StudentVO vo : studentList){
	%>
		<tr>
			<td><%= vo.getId() %></td>
			<td><%= vo.getUsername() %></td>
			<td><%= vo.getSnum() %></td>
			<td><%= vo.getDepart() %></td>
			<td><%= vo.getMobile() %></td>
			<td><%= vo.getEmail() %></td>
			<td>
				<a href="http://localhost:8080/kimwoojoong_mvcdb/StudentServlet?cmd=update&id=<%=vo.getId() %>" target="_self" method="get">수정</a>
				<a href="http://localhost:8080/kimwoojoong_mvcdb/StudentServlet?cmd=delete&id=<%=vo.getId() %>" target="_self" method="get">삭제</a>
			</td>
		</tr>
	<% } %>
	</table>
</body>
</html>