<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rechercher un Véhicule disponible par periode</title>
</head>
<body>
	<h1>Rechercher un Véhicule disponible par période</h1>
	<br />
	<h2>Entrez votre période de réservation :</h2>
	<form:form action="recherche-vehicules-dispo.do" commandName="periode"
		method="POST">

		<table>
			<tr>
				<td>Date Prise de véhicule:</td>
				<td><form:input path="dateDebut" /> <form:errors
						path="dateDebut" /></td>
			</tr>
			<tr>
				<td>Date Retour de Véhicule:</td>
				<td><form:input path="dateFin" /> <form:errors
						path="dateFin" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="valider"></td>
			</tr>
		</table>
	</form:form>
	<br />
	<table border=0>
		<tr>
			<td><a href="listerreservation.do">Annuler</a></td>
		</tr>
	</table>
</body>
</html>