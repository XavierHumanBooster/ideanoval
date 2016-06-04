<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Idea</title>
</head>
<body>
	<jsp:include page="header.jsp" />


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
		<select name="category.idCategory">
			<option value="0" label="Selectionnez une catégorie" />
			<c:forEach items="${listeCategory}" var="category">
				<option value="${category.idCategory}"
					label="${category.labelCategory}" />
			</c:forEach>
		</select>
		<form:input type="file" accept="image/x-png, image/gif, image/jpeg"
			path="imageUp" />
		<!--<form:input type="hidden" path="pictureIdea" />-->
		<br />
		<br />
		<input type="submit" value="Publier">
		<br />
	</form:form>

</body>
</html>