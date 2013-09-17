<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification d'un Client</title>
</head>
<body>
	<h1>Modifier Client</h1>
	<br />

	<form:form action="modifierclient.do" commandName="client" method="POST">
	<form:hidden path="id"/>
		<table>
			<tr>
				<td>Nom:</td>
				<td><form:input path="nom"/><form:errors path="nom"/></td>
			</tr>
			<tr>
				<td>Prenom</td>
				<td><form:input path="prenom"/><form:errors path="prenom"/></td>
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
			<td><a href="listerclient.do">Annuler</a></td>
		</tr>
	</table>

</body>
</html>