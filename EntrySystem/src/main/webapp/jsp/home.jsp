<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	
	<style>
		.buttonHref:link, .buttonHref:visited {
			background-color: #009688;
			color: white;
			padding: 8px 12px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			border-radius: 10px;
			margin-bottom: 6px;
		}
		
		.buttonHref:hover, .buttonHref:active {
			background-color: #00A688;
		}
	</style>
	
	<title><spring:message code='home.title' /></title>
</head>

<body>
	<!-- Sidebar -->
	<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
		<h3 class="w3-bar-item"><spring:message code='home.menu' /></h3>
		<a href="/home" class="w3-bar-item w3-button"><spring:message code='home.home' /></a>
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<a href="/create-faculty" class="w3-bar-item w3-button"><spring:message code='home.create_faculty' /></a>
			<a href="/registeredEntrants" class="w3-bar-item w3-button"><spring:message code='home.registered_entrants' /></a>
		</security:authorize>
		
		<div class="container" style="margin-left: 1%">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
				
				<a class="w3-bar-item w3-button" onclick="document.forms['logoutForm'].submit()"><spring:message code='home.logout' /></a>
			</c:if>
		</div>
	</div>

	<!-- Page Content -->
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h2 style="float: right;"><spring:message code='home.welcome' /> ${pageContext.request.userPrincipal.name}</h2>
			<h2><spring:message code='home.faculties' /></h2>
		</div>

		<c:if test="${not empty faculties}">
			<c:forEach items="${faculties}" var="currentFaculty">
				<div class="w3-container" style="margin-bottom: 2%; margin-top: 2%; margin-left: 2%; margin-right: 0; padding: 0; width: 17%; float: left">
					<div class="w3-card-4" style="width: 100%;">
						<div class="w3-container w3-center" style="padding: 0; width: 100%;">
							<h2>${currentFaculty.name}</h2>
							<p style="font-weight: bold;"><spring:message code='home.quantity_of_student' /> ${currentFaculty.quantityOfStudents}</p>
							<p style="font-weight: bold;"><spring:message code='home.list_of_subjects' /><br></p>
							
							<c:forEach items="${currentFaculty.subjects}" var="currentSubject">
								<p style="font-style: italic;">${currentSubject.title}</p>
							</c:forEach>
							
							<a href="rating?currentFacultyId=${currentFaculty.id}" class="buttonHref"><spring:message code='home.show_rating' /></a>
							
							<br>
							
							<security:authorize access="hasRole('ROLE_USER')">
								<a href="entrantRegistration?currentFacultyId=${currentFaculty.id}&currentUserEmail=${pageContext.request.userPrincipal.name}" class="buttonHref"><spring:message code='home.choose_this_faculty' /></a>
							</security:authorize>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>

</html>