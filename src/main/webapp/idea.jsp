<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Publish Idea</title>
</head>
<body>

	<h4>Souhaitez vous publier :</h4>

	<form>
		<input type="radio" name="idea" value="idea">Idée <input
			type="radio" name="poll" value="poll">Sondage<br />
	</form>

	<h2>Publié une idée</h2>
	<form:form action="publishIdea" modelAttribute="evaluableIdea"
		method="post">
		<form:input type="text" placeholder="Titre" path="titleIdea"
			required="required" />
		<br />
		<br />
		<form:textarea type="text" placeholder="Description"
			path="descriptionIdea" required="required" />
		<br />
		<br />
		<form:select path="category">
			<form:options items="${categoryList}" />
		</form:select>
		<form:input type="file" accept="image/x-png, image/gif, image/jpeg" path="imageUp" />
		<form:input type="hidden" path="pictureIdea" />
		<br />
		<br />
		<input type="submit" value="Publier">
		<br />
	</form:form>

	<h2>Options de Sondage</h2>

	<form>
		<INPUT type="checkbox" name="choix1" value="1">Permettre des
		réponses personnalisés
	</form>


	<form action="publishOptionPoll" method="post">
		<input type="text" placeholder="Réponse 1" /><br />
		<br /> <input type="text" placeholder="Réponse 2" /><br />
		<br /> <input type="text" placeholder="Réponse 3" /><br />
		<br /> <input type="text" placeholder="Réponse 4" /><br />
		<br /> <input type="text" placeholder="Réponse 5" /><br />
		<br /> <input type="submit" value="Envoyer"><br />
	</form>

</body>
</html>