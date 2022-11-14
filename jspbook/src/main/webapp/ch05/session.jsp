<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<h2>Session 예제</h2><hr>
	<%
		if(session.isNew()){
			out.println("<script>alert('세션이 해제되어 다시 설정합니다.'</script>)");
			session.setAttribute("login", "강호동");
		}
	%>
	#<%= session.getAttribute("login") %>님 환영합니다! <br>
	1. 세션 ID : <%= session.getId() %> <br>
	2. 세션 유지시간 : <%= session.getMaxInactiveInterval() %> <br>
</body>
</html>