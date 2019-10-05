<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
	<title><spring:message code='login.title' /></title>
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
	
	<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			var selItem = localStorage.getItem("locales");
			$('#locales').val(selItem ? selItem : 'en');
			$("#locales").change(function() {
				var selectedOption = $('#locales').val();
				if (selectedOption) {
					window.location.replace('?lang=' + selectedOption);
					localStorage.setItem("locales", selectedOption);
				}
			});
		});
	</script>

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
		
		fieldset {
			text-align: center;
			margin-top: 25px;
			color: #009688;
		}
	</style>
</head>

<body>
	<div class="container card" style="margin-top: 10%; width: 25%;">
		<article class="card-body">
			<h4 class="card-title text-center mb-4 mt-1 form-heading"><spring:message code='login.title' /></h4>
			<hr>
			<p class="text-success text-center" ${error != null ? 'has-error' : ''}>
				<c:if test="${error != null}">
					<spring:message code='error.message' var="error" />
					<span>${error}</span>	
				</c:if>
				
				<c:if test="${message != null}">
					<spring:message code='logout.message' var="message" />
					<span>${message}</span>	
				</c:if>
			</p>
			
			<form method="POST" action="${contextPath}/login" class="form-signin">
				<div class="form-group" ${error != null ? 'has-error' : ''}>
					<div class="input-group">
						<div class="input-group-prepend"><span class="input-group-text"> <i class="fa fa-user"></i></span></div>
						<input name="email" class="form-control" placeholder="<spring:message code='login.email' />" type="text">
					</div>
				</div>
				
				<div class="form-group" ${error != null ? 'has-error' : ''}>
					<div class="input-group">
						<div class="input-group-prepend"><span class="input-group-text"> <i class="fa fa-lock"></i></span></div>
						<input name="password" class="form-control" placeholder="<spring:message code='login.password' />" type="password">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</div>
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block btn-lg"><spring:message code='login.button' /></button>
				</div>

				<div>
					<fieldset>
						<label><spring:message code="login.choose_language" /></label>
						<select id="locales">
							<option value="en"><spring:message code='login.english' /></option>
							<option value="ua"><spring:message code='login.ukrainian' /></option>
							<option value="sk"><spring:message code='login.slovak' /></option>
						</select>
					</fieldset>
				</div>

				<p class="text-center">
					<a href="${contextPath}/registration" class="btn registration"><spring:message code='login.create_new_account' /></a>
				</p>
			</form>
		</article>
	</div>
</body>
</html>