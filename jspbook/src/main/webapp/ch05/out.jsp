<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Out</title>
</head>
<body>
	<div align="center">
		<h2>out 참조 변수의 사용</h2>
		0. 남아있는 버퍼 크기 : <%= out.getRemaining() %><br>
		1. 설정된 버퍼 크기 : <%= out.getBufferSize() %><br>
		2. 남아있는 버퍼 크기 : <%= out.getRemaining() %><br>
		<% out.flush(); %>
		3. flush 후 남아있는 버퍼 크기 : <%= out.getRemaining() %>
	</div>
</body>	
</html>