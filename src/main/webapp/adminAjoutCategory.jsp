<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel Admin - Gestion catégories</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Catégories disponible</h2>
	<c:choose>
		<c:when test="${categoriesNumber == 0}">
			<p>Aucune category disponible</p>
		</c:when>
		<c:otherwise>
			<table style="margin: 0px auto;">
				<tr>
					<td>Titre catégorie</td>
				</tr>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td style="border: solid 1px #606060;">${category.labelCategory}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<h2>Ajouter une catégorie</h2>
	<c:if test="${not empty errorMsg}">
		<p>${errorMsg}</p>
	</c:if>
	<form:form action="gestionCategory" modelAttribute="category" method="post">
		<form:input type="text" placeholder="Label Catégorie" path="labelCategory"
			required="required" />
		
		<input type="submit" value="Ajouter la catégorie">
	</form:form>
</body>
</html>