<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/ideanoval/resources/CSS/header-css.css" rel="stylesheet" />
</head>
<body>
	<div id="wrapper-header">
		<a href="/ideanoval/index.jsp">
			<img alt="logo Ideanoval" src="/ideanoval/resources/Images/private/logo.png">
		</a>
		<nav id="nav-menu-header">
		<ul>
			<li><a href="#">Id�es al�atoires</a></li>
			<li><a href="#">Cat�gories</a></li>
			<li><a href="#">Classements</a></li>
			<c:choose>
				<c:when test="${sessionScope.idUser !=null}">
					<li>
						<p>Connect� en tant que ${sessionScope.pseudoUser}</p>
						<button type="button" title="D�connexion">D�connexion</button>
						<a href="#">Mon compte</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="register">Inscription</a></li>
					<li><a href="register">Connexion</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		</nav>
	</div>

</body>
</html>