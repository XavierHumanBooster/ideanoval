<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Classement</title>
<link href="/ideanoval/resources/CSS/ranking-css.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="header.jsp" />
<div class="wrapper">
	<div class="idea-wrapper1">
		<img class="idea-picture"
			src="/ideanoval/resources/Images/default.jpg"
			alt="Illutration de l'idée">
		<div class="idea-name">
			<h2>Tire de l'idee</h2>
		</div>
		<div class="idea-description">
			<p>Le Lorem Ipsum est simplement de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi dans des applications de mise en page de texte, comme Aldus PageMaker.</p>
		</div>
			<div class="classement">
			<p>Note : </p>
		</div>
	</div>

	<div class="idea-wrapper2">
		<img class="idea-picture"
			src="/ideanoval/resources/Images/default.jpg"
			alt="Illutration de l'idée">
		<div class="idea-name">
			<h2>Tire de l'idee</h2>
		</div>
		<div class="idea-description">
			<p>Description de l'idee</p>
		</div>
			<div class="classement">
			<p>Note : </p>
		</div>
	</div>

	<div class="idea-wrapper3">
		<img class="idea-picture"
			src="/ideanoval/resources/Images/default.jpg"
			alt="Illutration de l'idée">
		<div class="idea-name">
			<h2>Tire de l'idee</h2>
		</div>
		<div class="idea-description">
			<p>Description de l'idee</p>
		</div>
			<div class="classement">
			<p>Note : </p>
		</div>

	</div>
	
	<c:forEach var="i" begin="4" end="10">
	
		<div class="idea-wrapper">
		<img class="idea-picture"
			src="/ideanoval/resources/Images/default.jpg"
			alt="Illutration de l'idée">
		<div class="idea-name">
			<h2>Tire de l'idee</h2>
		</div>
		<div class="idea-description">
			<p>Description de l'idee</p>
		</div>
		<div class="classement">
			<p>Note : </p>
		</div>

	</div>
	</c:forEach>
	</div>	
</body>
</html>