<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saisie d'une Voiture</title>
</head>
<body>
	<h1>Saisie Voiture</h1>
	<br />

	<form:form action="voiture.do" commandName="voiture" method="POST">
	
<%-- 	<form:errors path="*"></form:errors> --%>
		<table>
			<tr>
				<td>Marque:</td>
				<td><form:input path="marque"/><form:errors path="marque"/></td>
			</tr>
			<tr>
				<td>Modele:</td>
				<td><form:input path="modele"/><form:errors path="modele"/></td>
			</tr>
			<tr>
				<td>Date MEC:</td>
				<td><form:input path="dateMiseEnCirculation"/><form:errors path="dateMiseEnCirculation"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="valider"></td>
			</tr>
		</table>
	</form:form>
	
	<br />
	<table border=0>
		<tr>
			<td><a href="listervoiture.do">Retour à la liste des Voitures</a></td>
		</tr>
	</table>

</body>
</html>