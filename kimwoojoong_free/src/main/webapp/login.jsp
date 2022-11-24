<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kimwoojoong_free.domain.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">

<title>InTheRain Fitness | Sign In</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css"
	type="text/css"></link>
<meta name="theme-color" content="#712cf9">

<!-- Custom styles for this template -->
</head>

<body class="text-center">
	
	<br><br><br>
	<nav class="navbar navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="http://localhost:8080/kimwoojoong_free/">INTHERAIN FITNESS</a>
		</div>
	</nav>
	

	<main class="form-signin w-100 m-auto">
		<form action="http://localhost:8080/kimwoojoong_free/FitnessServlet?cmd=login" method="post">
			<img class="mb-4"
				src="https://cdn2.vectorstock.com/i/1000x1000/39/31/deadlift-powerlifting-competition-athlete-vector-28853931.jpg"
				alt="쇠를 든 남자" width="72" height="72">
			<h1 class="h3 mb-3 fw-normal">로그인</h1>

			<div class="form-floating">
				<input type="text" class="form-control" id="id" required
					placeholder="ID"> <label for="floatingInput">ID</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="pw" required
					placeholder="Password"> <label for="floatingPassword">Password</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
				in</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
		</form>
	</main>
	<div class="container">
		<footer
			class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
			<div class="col-md-4 d-flex align-items-center">
				<a href="http://localhost:8080/kimwoojoong_free/"
					class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
					<svg class="bi" width="30" height="24">
						<use xlink:href="#bootstrap" /></svg>
				</a> <span class="mb-3 mb-md-0 text-muted">&copy; 2022 Company,
					Inc</span>
			</div>

			<ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
				<li class="ms-3"><a class="text-muted" href="#"><svg
							class="bi" width="24" height="24">
							<use xlink:href="#twitter" /></svg></a></li>
				<li class="ms-3"><a class="text-muted" href="#"><svg
							class="bi" width="24" height="24">
							<use xlink:href="#instagram" /></svg></a></li>
				<li class="ms-3"><a class="text-muted" href="#"><svg
							class="bi" width="24" height="24">
							<use xlink:href="#facebook" /></svg></a></li>
			</ul>
		</footer>
	</div>

	<div class="b-example-divider"></div>

</body>
</html>