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
	<table border="1" cellpadding=5 cellspacing=0>
		<c:forEach var="member" items="${members}">
			<tr>
				<td><c:out value="${member.name}"/></td>
				<td><c:out value="${member.email}" escapeXml="false">
				<font color=red>email 없음</font>
				</c:out>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>