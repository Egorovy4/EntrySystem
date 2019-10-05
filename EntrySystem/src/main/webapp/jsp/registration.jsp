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

<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: white;
}

.container {
	text-align: center;
	padding: 16px;
	background-color: white;
	margin-top: 6%;
}

/* Full-width input fields */
input[type=text], input[type=number], input[type=password] {
	width: 25%;
	padding: 15px;
	margin: 5px 0 12px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	border-radius: 8px;
	font-size: medium;
}

input[type=text]:focus, input[type=number]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 15px;
	width: 25%;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #009688;
	color: white;
	padding: 16px 20px;
	margin: 2px;
	border: none;
	cursor: pointer;
	width: 8%;
	opacity: 0.9;
	border-radius: 8px;
	font-size: medium;
}

.registerbtn:hover {
	opacity: 1;
}
</style>

<title><spring:message code='registration.title' /></title>
</head>

<body>
	<div class="container">
		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<h2 class="form-signin-heading"><spring:message code='registration.create_your_account' /></h2>
			<hr>
			<spring:bind path="firstName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.first_name' var="first_name" />
					<form:input type="text" path="firstName" class="form-control" placeholder='${first_name}' autofocus="true" required="required" minlength="3" maxlength="30"></form:input>
					<form:errors path="firstName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="secondName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.second_name' var="second_name" />
					<form:input type="text" path="secondName" class="form-control" placeholder='${second_name}' autofocus="true" required="required" minlength="3" maxlength="30"></form:input>
					<form:errors path="secondName"></form:errors>
				</div>
			</spring:bind>
			
			<spring:bind path="age">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.age' var="age" />
					<form:input type="number" path="age" class="form-control" placeholder='${age}' autofocus="true" required="required" min="18" max="50" step="1"></form:input>
					<form:errors path="age"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.email' var="email" />
					<form:input type="text" path="email" class="form-control" placeholder='${email}' autofocus="true" required="required"></form:input>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>
			
			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.password' var="password" />
					<spring:message code='password.validation' var="pv" />
					<spring:message code='password.confirmation' var="pc" />
					<form:input type="password" path="password" id="password" class="form-control"
						placeholder='${password}' 
						required="required"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title='${pv}'></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code='registration.password_confirm' var="password_confirm" />
					<form:input type="password" path="passwordConfirm"
						id="confirm_password"
						class="form-control" placeholder='${password_confirm}'
						required="required"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title='${pv}'></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind>

			<hr>

			<button class="btn btn-lg btn-primary btn-block registerbtn" type="submit"><spring:message code='registration.submit' /></button>
		</form:form>
	</div>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	
	<script>
		var password = document.getElementById("password"), confirm_password = document
				.getElementById("confirm_password");
		
		var pc = '${pc}';
		
		function validatePassword() {
			if (password.value != confirm_password.value) {
				confirm_password.setCustomValidity(pc);
			} else {
				confirm_password.setCustomValidity('');
			}
		}

		password.onchange = validatePassword;
		confirm_password.onkeyup = validatePassword;
	</script>
</body>
</html>