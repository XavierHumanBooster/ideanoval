<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel Admin - Validation des inscriptions</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Utilisateur en attente d'approbation :</h2>
	<c:choose>
		<c:when test="${attempApprouvedNumber == 0}">
			<p>Aucun utilisateur en attente d'approbation</p>
		</c:when>
		<c:otherwise>
			<table style="margin: 0px auto;">
				<tr>
					<td>Pseudo</td>
					<td>Login</td>
					<td>Date d'inscription</td>
				</tr>
				<c:forEach items="${attempApprouved}" var="userNotApprouved">
					<tr>
						<td style="border: solid 1px #606060;">${userNotApprouved.pseudoUser}</td>
						<td style="border: solid 1px #606060;">${userNotApprouved.loginUser}</td>
						<td style="border: solid 1px #606060;">${userNotApprouved.registerDateUser}</td>
						<td style="border: solid 1px #606060;">
							<form action="validationInscription" method="post">
								<button type="submit" title="Valider l'inscription"
									name="id" value="${userNotApprouved.idUser}">Valider
									l'inscription</button>
							</form>
						</td>
						<td style="border: solid 1px #606060;">
							<form action="annulationInscription" method="post">
								<button type="submit" title="Annuler l'inscription"
									name="id" value="${userNotApprouved.idUser}">X</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>