<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Classement brain</title>
<link href="/ideanoval/resources/CSS/ranking-css.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="wrapper">
		<!-- <div class="idea-wrapper1">
			<img class="idea-picture"
				src="/ideanoval/resources/Images/default.jpg"
				alt="Illutration de l'id�e">
			<div class="idea-name">
				<h2>Nom de L'utilisateur</h2>
			</div>
			<div class="idea-description">
				<p>email utilisateur</p>
			</div>
			<div class="classement">
				<p>Nombre id�e :</p>
			</div>
		</div>

		<div class="idea-wrapper2">
			<img class="idea-picture"
				src="/ideanoval/resources/Images/default.jpg"
				alt="Illutration de l'id�e">
			<div class="idea-name">
				<h2>Nom de L'utilisateur</h2>
			</div>
			<div class="idea-description">
				<p>email utilisateur</p>
			</div>
			<div class="classement">
				<p>Nombre id�e :</p>
			</div>
		</div>

		<div class="idea-wrapper3">
			<img class="idea-picture"
				src="/ideanoval/resources/Images/default.jpg"
				alt="Illutration de l'id�e">
			<div class="idea-name">
				<h2>Nom de L'utilisateur</h2>
			</div>
			<div class="idea-description">
				<p>email utilisateur</p>
			</div>
			<div class="classement">
				<p>Nombre id�e :</p>
			</div>

		</div> -->

		<c:forEach items="${ListUser}" var="user" varStatus="loop">

			<div
				<c:choose>
					<c:when test="${loop.index < 3}">
						<c:if test="${loop.index == 0}"> class="idea-wrapper1"</c:if>
						<c:if test="${loop.index == 1}"> class="idea-wrapper2"</c:if>
						<c:if test="${loop.index == 2}"> class="idea-wrapper3"</c:if>
					</c:when>
					<c:otherwise>
						class="idea-wrapper"
					</c:otherwise>
				</c:choose>
			>
				<img class="idea-picture"
					src="/ideanoval/resources/Images/default.jpg"
					alt="Illutration de l'id�e">
				<div class="idea-name">
					<h2>${user.pseudoUser}</h2>
				</div>
				<div class="idea-description">
					<p>${user.loginUser}</p>
				</div>
				<div class="classement">
					<p>Nombre d'id�e : ${map.get(user.idUser)}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>