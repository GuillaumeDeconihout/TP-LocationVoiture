
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="container">
	<h1>Liste des réservations</h1>
	<br />
	<table>
		<tr>
			<td><a href="reservation.do">Nouvelle réservation</a></td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td><a href="recherche-vehicules-dispo.do">Véhicules -->
<!-- 					disponibles</a></td> -->
<!-- 		</tr> -->
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
			<security:authorize ifAllGranted="ROLE_ADMIN">
				<th colspan="2">Action</th>
			</security:authorize>
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
				<security:authorize ifAllGranted="ROLE_ADMIN">
					<td><a href="modifierreservation.do?id=${r.id}"><button
								type="button" class="btn btn-info">Modifier</button></a> <a
						href="supprimerreservation.do?id=${r.id}"><button
								type="button" class="btn btn-danger">Supprimer</button></a></td>
				</security:authorize>
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