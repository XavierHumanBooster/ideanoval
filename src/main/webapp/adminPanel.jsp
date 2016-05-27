<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel Admin</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div style="height: 50px; background-color: #AAA;">
		<a href="admin/validationInscription">
			Validation des inscriptions </a>
		<c:if test="${attempApprouvedNumber != 0}">
			<p>${attempApprouvedNumber} en attente</p>
		</c:if>
	</div>
	
	<div style="height: 50px; background-color: #AAA;">
		<a href="admin/gestionAlerte">
			Gestion des alertes </a>
		<c:if test="${alertsIdeaNumber != 0}">
			<p>${alertsIdeaNumber} idea alert</p>
		</c:if>
		<c:if test="${alertsCommentaryNumber != 0}">
			<p>${alertsCommentaryNumber} commentary alert</p>
		</c:if>
	</div>
	<div style="height: 50px; background-color: #AAA;">
		<a href="admin/gestionCategory">Gestion des catégories</a>
	</div>
</body>
</html>