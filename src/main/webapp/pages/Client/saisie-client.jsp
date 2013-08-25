<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saisie d'un client</title>
</head>
<body>
	<h1>Saisie Client</h1>
	<br />

	<form:form action="client.do" commandName="client" method="POST">
	
<%-- 	<form:errors path="*"></form:errors> --%>
		<table>
			<tr>
				<td>Nom:</td>
				<td><form:input path="nom" maxlength="64"/><form:errors path="nom"/></td>
			</tr>
			<tr>
				<td>Prenom:</td>
				<td><form:input path="prenom" maxlength="64"/><form:errors path="prenom"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email"/><form:errors path="email"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="valider"></td>
			</tr>
		</table>
	</form:form>
	
	<br />
	<table border=0>
		<tr>
			<td><a href="listerclient.do">Retour à la liste des Clients</a></td>
		</tr>
	</table>

</body>
</html>