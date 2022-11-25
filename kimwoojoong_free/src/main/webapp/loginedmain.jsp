<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kimwoojoong_free.domain.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
			Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InTheRain Fitness | Main</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css"
	type="text/css"></link>
<style>
body {
	background-color: black;
}
</style>

</head>
<body>

	<br><br><br>
	<nav class="navbar navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="http://localhost:8080/kimwoojoong_free/FitnessServlet?cmd=main&login=true">INTHERAIN FITNESS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
				aria-controls="offcanvasDarkNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1"
				id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">안녕하세요, ${member.getUname()}님</h5>
					<button type="button" class="btn-close btn-close-white"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link" href="http://localhost:8080/kimwoojoong_free/FitnessServlet?cmd=main&cmd=main&login=true">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="http://localhost:8080/kimwoojoong_free/FitnessServlet?cmd=trainers">Trainers</a></li>
						<li class="nav-item"><a class="nav-link" href="http://localhost:8080/kimwoojoong_free/FitnessServlet?cmd=mypage">Mypage</a></li>
						<li class="nav-item"><a class="nav-link" href="http://localhost:8080/kimwoojoong_free/">Logout</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</nav>


	<div class="container-fluid">
		<img
			src="https://www.muscleandfitness.com/wp-content/uploads/2018/12/dec-in-book-124.jpg?quality=86&strip=all"
			class="rounded mx-auto d-block" alt="어깨에 아주 무거운 짐을 지고 있는 남성">
	</div>

	<p class="text-center fw-bold fs-1" style="color: rgb(255, 255, 255);">강함을
		추구하는 InTheRain Fitness에 오신것을 환영합니다</p>


	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>