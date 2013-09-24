
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<h1>Liste des réservations</h1>
	<br />
	<table>
		<tr>
			<td><a href="reservation.do">Nouvelle réservation</a></td>
		</tr>
		<tr>
			<td><a href="recherche-vehicules-dispo.do">Véhicules disponibles</a></td>
		</tr>
	</table>
	<br />
	<table class="table table-striped table-hover">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Marque</th>
			<th>Modèle</th>
			<th>Date réservation</th>
			<th>Date départ</th>
			<th>Date retour</th>
			<th colspan="2">Action</th>
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
	<table>
		<tr>
			<td><a href="../index.do">Accueil</a></td>
		</tr>
	</table>

	<br />
</div>