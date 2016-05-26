<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion administrateur</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Identification</h2>
	<c:if test="${not empty errorMsg}">
		<p>${errorMsg}</p>
	</c:if>
	<form:form action="admin" modelAttribute="administrator" method="post">
		<form:input type="text" placeholder="Login" path="loginUser"
			required="true" />
		<form:input type="password" placeholder="Mot de passe"
			path="passwordUser" required="true" />
		<input type="submit" value="Connect" />
	</form:form>
</body>
</html>