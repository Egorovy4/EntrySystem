<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><spring:message code='create_faculty.title' /></title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
	<div class="container">
		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item"><spring:message code='create_faculty.menu' /></h3>
			<a href="/home" class="w3-bar-item w3-button"><spring:message code='create_faculty.home' /></a>
			<a href="/registeredEntrants" class="w3-bar-item w3-button"><spring:message code='create_faculty.registered_entrants' /></a>

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
				<h2><spring:message code='create_faculty.create_new_faculty' /></h2>
			</div>

			<div class="w3-container" style="margin: 1.5%; padding: 0px;">	
				<form:form method="POST" action="${contextPath}/addFaculty"
					modelAttribute="faculty">
					<table>
						<tr>
							<td style="font-weight: bold; font-style: italic;"><form:label path="name"><spring:message code='create_faculty.new_faculty_name' /> </form:label></td>
							<td style="padding-left: 20px"><form:input type="text" path="name" required="required" minlength="3" maxlength="30" /></td>
						</tr>

						<tr>
							<td style="font-weight: bold; font-style: italic;"><form:label path="quantityOfStudents"><spring:message code='create_faculty.quantity_of_students' /> </form:label></td>
							<td style="padding-left: 20px"><form:input type="number" path="quantityOfStudents" required="required" min="5" max="40" step="1" /></td>
						</tr>

						<tr>
							<td style="font-weight: bold; font-style: italic;"><spring:message code='create_faculty.choose_subjects' /> <br>
								<div style="font-weight: normal; font-style: italic; margin-top: 7px;">
									<c:if test="${not empty subjects}">
										<c:forEach items="${subjects}" var="currentSubject">
											<form:checkbox path="subjects" value="${currentSubject}" />${currentSubject.title}<br>
										</c:forEach>
									</c:if>
								</div>
							</td>
						</tr>

						<tr>
							<td><input style="margin-top: 7px;" type="submit" value="<spring:message code='create_faculty.submit' />" /></td>
						</tr>
					</table>

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>
			</div>
		</div>
	</div>

	<!-- /container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>