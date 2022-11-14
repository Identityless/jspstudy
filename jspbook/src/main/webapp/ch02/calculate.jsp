<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
// 변수설정
int num1=0, num2=0, result = 0;
// 웹페이지 요청이 post 인 경우에만 수행 즉 form을 통해 전달된것만 수행
// 초기 로딩시 오류방지
if(request.getMethod().equals("POST")) {
// 연산자를 가지고 옴
String op = request.getParameter("operator");
// 문자열 형태로 전달된 인자들을 int 로 변환함.
num1 = Integer.parseInt(request.getParameter("num1"));
num2 = Integer.parseInt(request.getParameter("num2"));
// 각 연산자별 처리
if(op.equals("+")) { result = num1+num2; }
else if(op.equals("-")) { result = num1-num2; }
else if(op.equals("*")) { result = num1 * num2; }
else if(op.equals("/")) { result = num1 / num2; }
}
%>
<html>
<head>
<meta charset="UTF-8">
<title> 계산기 </title>
</head>
<body>
<div align="center">
<H3>계산기 : 스크립트릿 사용 </H3>
<HR>
<form name=form1 action='calculate.jsp' method=post>
<input type="text" NAME="num1" width=200 size="5">
<select NAME="operator">
<option selected>+</option>
<option>-</option>
<option>*</option>
<option>/</option>
</select>
<INPUT TYPE="text" NAME="num2" width=200 size="5"> 
<input type="submit" value="계산" name="B1"> 
<input type="reset" value="다시입력" name="B2">
</form>
<HR>
계산결과 : <%=result %>
</div>
</body>
</html>