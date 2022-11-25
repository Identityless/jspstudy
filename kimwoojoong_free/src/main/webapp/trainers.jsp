<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="kimwoojoong_free.domain.*, java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InTheRain Fitness | Trainers</title>
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



	<main>

		<section class="py-5 text-center container">
			<div class="row py-lg-5">
				<div class="col-lg-6 col-md-8 mx-auto">
					<h1 class="fw-light">Trainers</h1>
					<p class="lead text-muted">InterRain Fitness의 트레이너들은 풍부한 경험과
					훌륭한 실력을 바탕으로 회원님들에게 맞춤 솔루션을 제공합니다.</p>
					
				</div>
			</div>
		</section>

		<div class="album py-5 bg-light">
			<div class="container">

				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
				<c:forEach items="${trainers}" var="trainer">
					<div class="col">
						<div class="card shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg" role="img"
								aria-label="Placeholder: Thumbnail"
								preserveAspectRatio="xMidYMid slice" focusable="false">
								<title>Placeholder</title><rect width="100%" height="100%"
									fill="#55595c" />
								<text x="50%" y="50%" fill="#eceeef" dy=".3em">IntheRain Fitness</text></svg>

							<div class="card-body">
								<p class="card-text">이름 : ${trainer.getTname() }</p>
								<p class="card-text">전문 분야 : ${trainer.getMajor() }</p>
								<c:set value="trainer" var="trainer" scope="session"/>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary" href="http://localhost:8080/kimwoojoong_free/">View</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					
					
				</div>
			</div>
		</div>

	</main>


	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>