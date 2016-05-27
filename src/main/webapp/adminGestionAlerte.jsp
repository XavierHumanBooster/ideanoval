<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel Admin - Gestion des alertes</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Idée en alerte :</h2>
	<c:choose>
		<c:when test="${alertsIdeaNumber == 0}">
			<p>Aucune idée en alerte</p>
		</c:when>
		<c:otherwise>
			<table style="margin: 0px auto;">
				<tr>
					<td>Catégorie</td>
					<td>Titre</td>
					<td>Date de publication</td>
					<td>Auteur</td>
					<td>Date du signalement</td>
					<td>Auteur du signalement</td>
				</tr>
				<c:forEach items="${alertsIdea}" var="alertIdea">
					<tr>
						<td style="border: solid 1px #606060;">${alertIdea.evaluableIdea.category.labelCategory}</td>
						<td style="border: solid 1px #606060;">${alertIdea.evaluableIdea.titleIdea}</td>
						<td style="border: solid 1px #606060;">${alertIdea.evaluableIdea.publishDateIdea}</td>
						<td style="border: solid 1px #606060;">${alertIdea.evaluableIdea.userLambda.pseudoUser}</td>
						<td style="border: solid 1px #606060;">${alertIdea.dateIdeaAlert}</td>
						<td style="border: solid 1px #606060;">${alertIdea.userLambda.pseudoUser}</td>
						<td style="border: solid 1px #606060;">
							<form action="seeIdea" method="post">
								<button type="submit" title="Voir" name="id"
									value="${alertIdea.evaluableIdea.idIdea}" disabled="disabled">Voir l'idée</button>
							</form>
						</td>
						<td style="border: solid 1px #606060;">
							<form action="gestionAlerte" method="post">
								<button type="submit" title="Désactiver l'idée" name="actionAndId"
									value="0${alertIdea.evaluableIdea.idIdea}">Désactiver l'idée</button>
							</form>
						</td>
						<td style="border: solid 1px #606060;">
							<form action="gestionAlerte" method="post">
								<button type="submit" title="Désactiver l'idée" name="actionAndId"
									value="1${alertIdea.evaluableIdea.idIdea}">Ignorer</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	
	<h2>Commentaire en alerte :</h2>
	<c:choose>
		<c:when test="${alertsCommentaryNumber == 0}">
			<p>Aucun commentaire en alerte</p>
		</c:when>
		<c:otherwise>
			<table style="margin: 0px auto;">
				<tr>
					<td>Auteur du commentaire</td>
					<td>Commentaire</td>
					<td>Titre de l'idée du commentaire</td>
					
					<td>Date du signalement</td>
					<td>Auteur du signalement</td>
				</tr>
				<c:forEach items="${alertsCommentary}" var="alertCommentary">
					<tr>
						<td style="border: solid 1px #606060;">${alertCommentary.commentary.user.pseudoUser}</td>
						<td style="border: solid 1px #606060;">${alertCommentary.commentary.valueCommentary}</td>
						<td style="border: solid 1px #606060;">${alertCommentary.commentary.evaluableIdea.titleIdea}</td>
						
						<td style="border: solid 1px #606060;">${alertCommentray.dateCommentaryAlert}</td>
						<td style="border: solid 1px #606060;">${alertCommentary.userLambda.pseudoUser}</td>
						
						<td style="border: solid 1px #606060;">
							<form action="gestionAlerte" method="post">
								<button type="submit" title="Désactiver l'idée" name="actionAndId"
									value="0${alertCommentary.commentary.idCommentary}" disabled="disabled">Désactiver ce commentaire</button>
							</form>
						</td>
						<td style="border: solid 1px #606060;">
							<form action="gestionAlerte" method="post">
								<button type="submit" title="Désactiver l'idée" name="actionAndId"
									value="1${alertIdea.evaluableIdea.idIdea}" disabled="disabled">Ignorer</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>