<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title><spring:message code='registration.title' /></title>
</head>

<body>
	<div class="container">
		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<h2 class="form-signin-heading"><spring:message code='registration.create_your_account' /></h2>

			<spring:bind path="firstName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.first_name' var="first_name" />
					<form:input type="text" path="firstName" class="form-control" placeholder='${first_name}' autofocus="true"></form:input>
					<form:errors path="firstName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="secondName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.second_name' var="second_name" />
					<form:input type="text" path="secondName" class="form-control" placeholder='${second_name}' autofocus="true"></form:input>
					<form:errors path="secondName"></form:errors>
				</div>
			</spring:bind>
			
			<spring:bind path="age">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.age' var="age" />
					<form:input type="number" path="age" class="form-control" placeholder='${age}' autofocus="true"></form:input>
					<form:errors path="age"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.email' var="email" />
					<form:input type="text" path="email" class="form-control" placeholder='${email}' autofocus="true"></form:input>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.password' var="password" />
					<form:input type="password" path="password" class="form-control" placeholder='${password}'></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.password_confirm' var="password_confirm" />
					<form:input type="password" path="passwordConfirm"
						class="form-control" placeholder='${password_confirm}'></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code='registration.submit' /></button>
		</form:form>
	</div>
	
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>