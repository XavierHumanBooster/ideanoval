<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login/Inscription</title>
</head>
<body>

<h2>Identification</h2>
<form action="login" method="post">
<input type="text" placeholder="E-mail" name="loginUser" required="required"/><br/><br/>
<input type="password" placeholder="Mot de passe" name="passwordUser" required="required"/><br/><br/>
<input type="submit" value="Intentification"><br/>
</form>

<br/><br/>

<h2>Inscription</h2>
<form:form action="register" modelAttribute="userLambda" method="post">
<form:input type="text" placeholder="Pseudo" path="pseudoUser" required="required"/><br/><br/>
<form:input type="text" placeholder="E-mail" path="loginUser" required="required"/><br/><br/>
<form:input type="password" placeholder="Mot de passe" path="passwordUser" required="required"/><br/><br/>
<input type="submit" value="Inscription"><br/>
</form:form>
</body>
</html>