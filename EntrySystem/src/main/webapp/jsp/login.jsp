<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Log In with your account</title>
	
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
	
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	
	<style>
		.btn-primary {
			color: #fff;
			background-color: #009688;
			border-color: #00A088;
		}
		
		.btn-primary:hover {
			background-color: #00A688;
			border-color: #00A088;
		}
		
		.registration {
			color: #009688;
		}
		
		.registration:hover {
			color: #00A688;
		}
	</style>
</head>

<body>
	<div class="container card" style="margin-top: 10%; width: 25%;">
		<article class="card-body">
			<h4 class="card-title text-center mb-4 mt-1 form-heading">Sign in</h4>
			<hr>
			<p class="text-success text-center" ${error != null ? 'has-error' : ''}><span>${message}</span><span>${error}</span></p>
			
			<form method="POST" action="${contextPath}/login" class="form-signin">
				<div class="form-group" ${error != null ? 'has-error' : ''}>
					<div class="input-group">
						<div class="input-group-prepend"><span class="input-group-text"> <i class="fa fa-user"></i></span></div>
						<input name="email" class="form-control" placeholder="Email or login" type="text">
					</div>
				</div>
				
				<div class="form-group" ${error != null ? 'has-error' : ''}>
					<div class="input-group">
						<div class="input-group-prepend"><span class="input-group-text"> <i class="fa fa-lock"></i></span></div>
						<input name="password" class="form-control" placeholder="******" type="password">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</div>
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block btn-lg">Login</button>
				</div>

				<p class="text-center">
					<a href="${contextPath}/registration" class="btn registration">Create an account</a>
				</p>
			</form>
		</article>
	</div>
</body>
</html>