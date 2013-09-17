<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification d'une voiture</title>
</head>
<body>
	<h1>Modifier Voiture</h1>
	<br />

	<form:form action="modifiervoiture.do" commandName="voiture"
		method="POST">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>Marque:</td>
				<td><form:input path="marque" />
					<form:errors path="marque" /></td>
			</tr>
			<tr>
				<td>Modele:</td>
				<td><form:input path="modele" />
					<form:errors path="modele" /></td>
			</tr>
			<tr>
				<td>Date MEC:</td>
				<td><form:input path="dateMiseEnCirculation" />
					<form:errors path="dateMiseEnCirculation" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="valider"></td>
			</tr>
		</table>
	</form:form>
	<table border=0>
		<tr>
			<td><a href="listervoiture.do">Annuler</a></td>
		</tr>
	</table>
</body>
</html>