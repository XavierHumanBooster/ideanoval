<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Idea - ${idea.titleIdea}</title>
<link href="/ideanoval/resources/CSS/ideaView-css.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="idea-wrapper">
		<img class="idea-picture"
			src="/ideanoval/resources/Images/default.jpg"
			alt="Illutration de l'idée">
		<div class="idea-name">
			<h2>${idea.titleIdea}</h2>
		</div>
		<div class="idea-description">
			<p>${idea.descriptionIdea}</p>
		</div>
		<div class="idea-author">
			<h4>
				<c:choose>
					<c:when test="${idea.userLambda.availableUser}">
						-- ${idea.userLambda.pseudoUser}
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${idea.userLambda.deletedUser}">
								-- Utilisateur supprimé
							</c:when>
							<c:otherwise>
								-- Utilisateur désactivé
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose></h4>
		</div>
	</div>
	<div class="reponse">

	</div>

	<div class="idea-commentaries">
		<h3>Commentaires :</h3>
		<c:forEach items="${listeCommentary}" var="commentary">
			
			<div class="idea-commentary <c:if test="${commentary.user.idUser == idea.userLambda.idUser}">commentary-author</c:if>">
				<p>${commentary.valueCommentary}</p>
				<h5>-- ${commentary.user.pseudoUser}</h5>
			</div>
		</c:forEach>
		
	</div>

	<div class="idea-commentaries">
		<h3>Ajouter un commentaire :</h3>

		<form:form action="" modelAttribute="newCommentary" method="post">
			<form:input type="textarea" placeholder="Commentaire : "
				path="valueCommentary" required="required" />
			<br />
			<br />
			<input type="submit" value="Commenter">
			<br />
		</form:form>
	</div>



</body>
</html>