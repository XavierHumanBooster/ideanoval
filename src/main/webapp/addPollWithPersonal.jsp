<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Options de Sondage</h2>

	<form action="publishOptionPollWithPersonal" method="post">
		<input type="text" name="rep1" placeholder="R�ponse 1" /><br /> <br /> <input
			type="text" name="rep2" placeholder="R�ponse 2" /><br /> <br /> <input
			type="text" name="rep3" placeholder="R�ponse 3" /><br /> <br /> <input
			type="text" name="rep4" placeholder="R�ponse 4" /><br /> <br /> <input
			type="submit" value="Envoyer"><br />
	</form>


	

</body>
</html>