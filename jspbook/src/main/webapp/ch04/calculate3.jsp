<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Property</title>
</head>
<body>
	<jsp:useBean id="calc" class="jspbook.ch03.CalcBean"/>
	<jsp:setProperty property="num1" name="calc" value="10"/>
	<jsp:setProperty property="num2" name="calc" value="5"/>
	<jsp:setProperty property="operator" name="calc" value="/"/>
	<% calc.calculate(); %>
	<p> 계산 결과 : <% out.println(calc.getResult()); %></p>
	<p> 계산 결과 : <jsp:getProperty name="calc" property="result"/></p>
</body>
</html>