<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saisie d'une Réservation</title>
</head>
<body>
	<h1>Saisie Reservation</h1>
	<br />

	<form:form action="reservation.do" commandName="reservation"
		method="POST">

		<table>
			<tr>
				<td>Client:</td>
				<td><form:select path="client.id">
						<c:forEach var="client" items="${clients}">
							<form:option value="${client.id}">
							${client.nom} ${client.prenom}
							</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td>Voiture:</td>
				<td><form:select path="voiture.id">
						<c:forEach var="voiture" items="${voitures}">
							<form:option value="${voiture.id}">
							${voiture.marque} ${voiture.modele}
							</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td>Date Réservation:</td>
				<td><form:input path="dateReservation" /> <form:errors
						path="dateReservation" /></td>
			</tr>
			<tr>
				<td>Date Prise de véhicule:</td>
				<td><form:input path="datePriseVehicule" /> <form:errors
						path="datePriseVehicule" /></td>
			</tr>
			<tr>
				<td>Date Retour de Véhicule:</td>
				<td><form:input path="dateRetourVehicule" /> <form:errors
						path="dateRetourVehicule" /></td>
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