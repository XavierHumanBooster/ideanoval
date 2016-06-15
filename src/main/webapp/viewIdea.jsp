<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Idea - TODO Nom de l'ideee</title>
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
		<div class="idea-mark">
			<a href="#"><img
				src="/ideanoval/resources/Images/private/ideaTopMark.png" alt="Top"></a>
			<a href="#"><img
				src="/ideanoval/resources/Images/private/ideaFlopMark.png"
				alt="Flop"></a>
		</div>
		<div class="idea-description">
			<p>${idea.descriptionIdea}</p>
		</div>
		<div class="idea-author">
			<h4>-- ${idea.userLambda.pseudoUser}</h4>
		</div>
	</div>

	<div class="idea-commentaries">
		<h3>Commentaires :</h3>
		<c:forEach items="${listeCommentary}" var="commentary">
			<div class="idea-commentary">
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