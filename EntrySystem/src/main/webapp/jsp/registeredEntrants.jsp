<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

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
	
	<title><spring:message code='registered_entrants.title' /></title>
</head>

<body>
	<!-- Sidebar -->
	<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
		<h3 class="w3-bar-item"><spring:message code='registered_entrants.menu' /></h3>
		<a href="/home" class="w3-bar-item w3-button"><spring:message code='registered_entrants.home' /></a>
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<a href="/create-faculty" class="w3-bar-item w3-button"><spring:message code='registered_entrants.create_faculty' /></a>
			<a href="/registeredEntrants" class="w3-bar-item w3-button"><spring:message code='registered_entrants.registered_entrants' /></a>
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
			<h2><spring:message code='registered_entrants.registered_entrants' /></h2>
		</div>
		
		<c:if test="${not empty registeredEntrants}">
			<table>
				<tr>
					<th><spring:message code='registered_entrants.photo' /></th>
					<th><spring:message code='registered_entrants.first_name' /></th>
					<th><spring:message code='registered_entrants.second_name' /></th>
					<th><spring:message code='registered_entrants.email' /></th>
					<th><spring:message code='registered_entrants.faculty_name' /></th>
					<th colspan="4"><spring:message code='registered_entrants.marks' /></th>
					<th><spring:message code='registered_entrants.actions' /></th>
				</tr>
				<c:forEach items="${registeredEntrants}" var="currentRegisteredEntrant">
					<tr>
						<td rowspan="2"><img src="data:image/png;base64,${currentRegisteredEntrant.encodedEntrantImage}" width="80" height="80" /></td>
						<td rowspan="2">${currentRegisteredEntrant.user.firstName}</td>
						<td rowspan="2">${currentRegisteredEntrant.user.secondName}</td>
						<td rowspan="2">${currentRegisteredEntrant.user.email}</td>
						<td rowspan="2">${currentRegisteredEntrant.faculty.name}</td>
						
						<c:forEach items="${currentRegisteredEntrant.faculty.subjects}" var="currentSubject">
							<td>${currentSubject.title}</td>
						</c:forEach>
						
						<td rowspan="2">
							<form:form method="POST" action="${contextPath}/entrantSubmiting">						
								<input type="hidden" name="facultyId" value="${currentRegisteredEntrant.faculty.id}" />
								<input type="hidden" name="userId" value="${currentRegisteredEntrant.user.id}" />
								<input type="hidden" name="entrantId" value="${currentRegisteredEntrant.id}" />
								<button type="submit"><spring:message code='registered_entrants.submit' /></button>
							</form:form>
						</td>
					</tr>
					
					<tr>
						<c:forEach items="${currentRegisteredEntrant.marks}" var="currentMark">
							<td>${currentMark}</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>

<style>
	table {
		font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
		border-collapse: collapse;
		width: 76%;
    	text-align-last: center;
    	margin-top: 1%;
    	margin-left: 12%;
    	
	}
	
	table td, #customers th {
		border: 1px solid #ddd;
		padding: 8px;
	}
	
	table tr:nth-child(even) {
		background-color: #f2f2f2;
	}
	
	table tr:hover {
		background-color: #ddd;
	}
	
	table th {
		padding-top: 12px;
		padding-bottom: 12px;
		text-align: left;
		background-color: #009688;
		color: white;
	}
</style>
</html>