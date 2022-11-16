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
		<H2>Properties 연계</H2>
		<HR>
		version : ${prop.get('version')} <BR> url : ${prop.get('url')} <BR>
		user : ${prop.get('user')} <BR> password : ${prop.get('passwd')}
		<HR>
		<H2>Admin Properties</H2>
		관리자 ID : ${prop.get("adminId")} <BR> 관리자 전화번호 : ${tel}
	</div>
</body>
</html>