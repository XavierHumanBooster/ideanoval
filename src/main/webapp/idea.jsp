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
	<jsp:include page="header.jsp" />

	<h4>Souhaitez vous publier :</h4>

	<form action="publishChoice" method="post">
		<input type="radio" name="choice" value="idea">Idée </input> 
		<input type="radio" name="choice" value="poll">Sondage</input><br />
		<input type="submit" value="Valider">
	</form>



</body>
</html>