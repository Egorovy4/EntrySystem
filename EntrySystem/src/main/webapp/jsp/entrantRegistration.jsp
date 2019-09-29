<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title><spring:message code='entrant_registration.title' /></title>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
.fl_upld {
	/* width: 300px; */
	margin-top: 10px;
	text-align: center;
}

#fl_inp {
	display: none;
}

.fl_upld label {
	cursor: pointer;
	background: #009688;
	border-radius: 3px;
	padding: 10px 25px;
	color: #fff;
	font-weight: bold;
	text-align: center;
}

.fl_upld label:hover {
	background: #00A688;
}

#fl_nm {
	margin-top: 8px;
	color: #009688;
}
</style>
</head>

<body>
	<!-- Sidebar -->
	<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
		<h3 class="w3-bar-item"><spring:message code='entrant_registration.menu' /></h3> 
		<a href="/home" class="w3-bar-item w3-button"><spring:message code='entrant_registration.home' /></a>
	</div>

	<!-- Page Content -->
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h1><spring:message code='entrant_registration.entrant_registration' /></h1>
		</div>

		<div class="w3-container">
			<form:form method="POST" action="${contextPath}/addMarks"
				enctype="multipart/form-data">
				<table>
					<tr>
						<th><spring:message code='entrant_registration.enter_marks' /></th>
					</tr>

					<c:forEach items="${registeredEntrant.faculty.subjects}" var="currentSubject" varStatus="status">
						<tr>
							<td>${currentSubject.title}</td>
							<td><input type="number" name="marks" /></td>
						</tr>
					</c:forEach>

					<tr>
						<td><input type="hidden" name="facultyId" value="${registeredEntrant.faculty.id}" /></td>
						<td><input type="hidden" name="userEmail" value="${registeredEntrant.user.email}" /></td>
					</tr>
					
					<tr>
						<td><spring:message code='entrant_registration.upload_photo' /></td>
						<!-- <td><input type="file" name="image" /></td> -->
						
						<td>
							<div class="fl_upld">
								<label><input id="fl_inp" type="file" name="image"><spring:message code='entrant_registration.choose_photo' /></label>
								<div id="fl_nm"><spring:message code='entrant_registration.file_is_not_choosed' /></div>
							</div>
						</td>
						
					</tr>

					<tr>
						<td><input type="submit" value="<spring:message code='entrant_registration.register' />" /></td>
					</tr>

				</table>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form:form>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	
	<script>
		$(document).ready(function() {
			$("#fl_inp").change(function() {
				var filename = $(this).val().replace(/.*\\/, "");
				$("#fl_nm").html(filename);
			});
		});
	</script>
</body>
</html>