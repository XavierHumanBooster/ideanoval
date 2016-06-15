<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<H1>page index du site</H1>

	<br />
	<br />
	<a href="idea.jsp">Ajout d'une idée</a>

	<table style="margin: 0px auto;">



		<c:forEach items="${listeIdea}" var="idea">
			<tr>
				<td style="border: solid 1px #606060;"><img
					src="/ideanoval/resources/Images/${idea.pictureIdea}" /></td>
				<td style="border: solid 1px #606060;">

					<a href="affichageIdea?id=${idea.idIdea}"><h3>${idea.titleIdea}</h3></a>

					<p>${idea.descriptionIdea}</p>

					<p>${currentDate}</p> <c:if
						test="${sessionScope.idUser !=null && sessionScope.idUser != idea.userLambda.idUser && idea['class'].name == 'com.humanbooster.business.EvaluableIdea' && idea.endEvaluableIdea >= currentDate}">

						<c:forEach items="${listeMarkUser}" var="markUser">
						
							<c:if test="${idea.idIdea != markUser.evaluableIdea.idIdea }">
								<form action="addMarkTop" method="post">
									<input type="hidden" name="idIdea" value="${idea.idIdea}" /> <input
										type="hidden" name="idUser" value="${sessionScope.idUser}" />
									<input type="submit" value="Top" />
								</form>
								<p>${idea.endEvaluableIdea},${currentDate}</p>
								<form action="addMarkFlop" method="post">
									<input type="hidden" name="idIdea" value="${idea.idIdea}" /> <input
										type="hidden" name="idUser" value="${sessionScope.idUser}" />
									<input type="submit" value="Flop" />
								</form>
							</c:if>
						</c:forEach>
					</c:if>
				</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>