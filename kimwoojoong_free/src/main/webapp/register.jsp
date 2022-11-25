<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="kimwoojoong_free.domain.*, java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InTheRain Fitness | Sign Up</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css"
	type="text/css"></link>
<meta name="theme-color" content="#712cf9">

</head>
<body class="text-center">

	<br>
	<br>
	<br>
	<nav class="navbar navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="http://localhost:8080/kimwoojoong_free/">INTHERAIN FITNESS</a>
		</div>
	</nav>


	<div class="form-signin w-100 m-auto">
		<form
			action="http://localhost:8080/kimwoojoong_free/FitnessServlet?cmd=join"
			method="post">
			<img class="mb-4"
				src="https://cdn2.vectorstock.com/i/1000x1000/39/31/deadlift-powerlifting-competition-athlete-vector-28853931.jpg"
				alt="쇠를 든 남자" width="72" height="72">
			<h1 class="h3 mb-3 fw-normal">회원가입</h1>
			<fildset>
			<div class="form-floating">
				<input type="text" class="form-control" name="id" required
					placeholder="ID"> <label for="floatingInput">ID</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" name="passwd" required
					placeholder="PASSWORD"> <label for="floatingInput">PASSWORD</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" name="uname" required
					placeholder="NAME"> <label for="floatingInput">NAME</label>
			</div>
			<div class="form-floating">
				<input type="number" class="form-control" name="age" required
					placeholder="AGE"> <label for="floatingInput">AGE</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" name="sex" required
					placeholder="SEX"> <label for="floatingInput">SEX</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" name="address" required
					placeholder="OO도 OO시 OO구 OO동"> <label for="floatingInput">ADDRESS</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" name="tell" required
					placeholder="TELL"> <label for="floatingPassword">TELL</label>
			</div>
			<select name="trainer">
				<c:forEach items="${trainers}" var="trainer">
					<option>${trainer.getTname() }</option>
				</c:forEach>

			</select> </fildset>
			<fildset> <input class="w-100 btn btn-lg btn-primary"
				type="submit" id="submit" value="Sign Up"> <input
				class="w-100 btn btn-lg btn-danger" type="reset" name="reset"
				value="Reset"> </fildset>
			<p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
		</form>
	</div>

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

	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>