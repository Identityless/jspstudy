<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=UTF-8">
<title>ELOperator</title>
</head>
<body>
	요청 URL: ${pageContext.request.requestURI} <BR> <HR>
	X = ${param.NUM1}, Y = ${param.NUM2} <BR><BR>
	X + Y = ${param.NUM1 + param.NUM2} <BR>
	X - Y = ${param.NUM1 - param.NUM2} <BR>
	X * Y = ${param.NUM1 * param.NUM2} <BR>
	X / Y = ${param.NUM1 / param.NUM2} <BR>
	X % Y = ${param.NUM1 % param.NUM2} <BR><BR>
	X가 더 큽니까? ${param.NUM1 - param.NUM2 > 0} <BR>
	Y가 더 큽니까? ${param.NUM1 - param.NUM2 < 0} <BR><BR>
	X와 Y가 모두 양수입니까? ${(param.NUM1 > 0) && (param.NUM2 > 0)} <BR><BR>
	X와 Y가 같습니까? ${param.NUM1 == param.NUM2? "예 " : "아니오 "} <BR><BR>
</body>
</html>