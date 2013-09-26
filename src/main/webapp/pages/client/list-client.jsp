
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="container">
	<h1>Liste des clients</h1>
	<br />
	<table>
		<tr>
			<td><a href="client.do">Nouveau Client</a></td>
		</tr>
	</table>

	<br />


	<table class="table table-striped table-hover">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Email</th>
			<security:authorize ifAllGranted="ROLE_ADMIN">
				<th colspan="2">Action</th>
			</security:authorize>
		</tr>
		<c:forEach items="${clients}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.nom}</td>
				<td>${c.prenom}</td>
				<td>${c.email}</td>
				<security:authorize ifAllGranted="ROLE_ADMIN">
					<td><a href="modifierclient.do?id=${c.id}"><button
								type="button" class="btn btn-info">Modifier</button></a> <a
						href="supprimerclient.do?id=${c.id}"><button type="button"
								class="btn btn-danger">Supprimer</button></a></td>
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