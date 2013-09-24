
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="container">
	<h1>Liste des voitures</h1>
	<br />
	<table>
		<tr>
			<td><a href="voiture.do">Nouvelle voiture</a></td>
		</tr>
	</table>

	<br />

	<table class="table table-striped table-hover">
		<tr>
			<th>ID</th>
			<th>Marque</th>
			<th>Modele</th>
			<th>Date MEC</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach items="${voitures}" var="v">
			<tr>
				<td>${v.id}</td>
				<td>${v.marque}</td>
				<td>${v.modele}</td>
				<td><fmt:formatDate pattern="dd-MM-yyyy"
						value="${v.dateMiseEnCirculation}" /></td>
				<td><a href="modifiervoiture.do?id=${v.id}">Modifier</a></td>
				<td><a href="supprimervoiture.do?id=${v.id}">Supprimer</a></td>
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