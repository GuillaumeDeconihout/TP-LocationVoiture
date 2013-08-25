<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Réservations</title>
</head>
<body>
	<h1>Liste des Réservations</h1>
	<br />
	<table border=0>
		<tr>
			<td><a href="reservation.do">Nouvelle Réservation</a></td>
		</tr>
		<tr>
			<td><a href="recherche-vehicules-dispo.do">Véhicules disponibles</a></td>
		</tr>
	</table>
	<br />
	<table border=1>
		<tr>
			<td>ID</td>
			<td>Nom Client</td>
			<td>Prenom Client</td>
			<td>Marque Voiture</td>
			<td>Modele Voiture</td>
			<td>Date Réservation</td>
			<td>Date Prise du véhicule</td>
			<td>Date Retour du véhicule</td>
			<td colspan="2">Action</td>
		</tr>
		<c:forEach items="${reservations}" var="r">
			<tr>
				<td>${r.id}</td>
				<td>${r.client.nom}</td>
				<td>${r.client.prenom}</td>
				<td>${r.voiture.marque}</td>
				<td>${r.voiture.modele}</td>
				<td><fmt:formatDate pattern="dd-MM-yyyy"
						value="${r.dateReservation}" /></td>
				<td><fmt:formatDate pattern="dd-MM-yyyy"
						value="${r.datePriseVehicule}" /></td>
				<td><fmt:formatDate pattern="dd-MM-yyyy"
						value="${r.dateRetourVehicule}" /></td>
				<td><a href="modifierreservation.do?id=${r.id}">Modifier</a></td>
				<td><a href="supprimerreservation.do?id=${r.id}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<table border=0>
		<tr>
			<td><a href="../index.do">Accueil</a></td>
		</tr>
	</table>

	<br />

</body>
</html>