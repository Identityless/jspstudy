<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="kimwoojoong_free.domain.*, java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InTheRain Fitness | ${member.getUname() }</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css"
	type="text/css"></link>
<meta name="theme-color" content="#712cf9">

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

	<div class="container">
		<ul class="list-group list-group-horizontal">
			<li class="list-group-item col-md-4">id</li>
			<li class="list-group-item col-md-8">${member.getId() }</li>
		</ul>
		<ul class="list-group list-group-horizontal">
			<li class="list-group-item col-md-4">이름</li>
			<li class="list-group-item col-md-8">${member.getUname() }</li>
		</ul>
		<ul class="list-group list-group-horizontal">
			<li class="list-group-item col-md-4">성별</li>
			<li class="list-group-item col-md-8">${member.getSex() }</li>
		</ul>
		<ul class="list-group list-group-horizontal">
			<li class="list-group-item col-md-4">나이</li>
			<li class="list-group-item col-md-8">${member.getAge() }</li>
		</ul>
		<ul class="list-group list-group-horizontal">
			<li class="list-group-item col-md-4">주소</li>
			<li class="list-group-item col-md-8">${member.getAddress() }</li>
		</ul>
		<ul class="list-group list-group-horizontal">
			<li class="list-group-item col-md-4">전화번호</li>
			<li class="list-group-item col-md-8">${member.getTell() }</li>
		</ul>
		<ul class="list-group list-group-horizontal">
			<li class="list-group-item col-md-4">담당 트레이너</li>
			<li class="list-group-item col-md-8">${member.getTname() }</li>
		</ul>
	</div>
	
	<div class="container">
		<button type="button" class="btn btn-primary" onClick="location.href='http://localhost:8080/kimwoojoong_free/FitnessServlet?cmd=update'">정보 수정</button>
		<button type="button" class="btn btn-danger" onClick="location.href='http://localhost:8080/kimwoojoong_free/FitnessServlet?cmd=delete&id=${member.getId()}'">회원 탈퇴</button>
	</div>


	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>