
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<h1>Modifier un client</h1>
	<br />

	<form:form action="modifierclient.do" commandName="client" method="POST"
		class="form-horizontal" role="form">
		<form:hidden path="id" />
		<div class="form-group">
			<form:label path="nom" class="col-lg-2 control-label">Nom :</form:label>
			<div class="col-lg-10">
				<form:input path="nom" class="form-control" placeholder="Nom"
					maxlength="64" />
				<form:errors path="nom" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="prenom" class="col-lg-2 control-label">Prénom :</form:label>
			<div class="col-lg-10">
				<form:input path="prenom" class="form-control" placeholder="Prénom" />
				<form:errors path="prenom" />
			</div>
		</div>


		<div class="form-group">
			<form:label path="email" class="col-lg-2 control-label">Email :</form:label>
			<div class="col-lg-10">
				<form:input path="email" class="form-control" placeholder="Email" />
				<form:errors path="email" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<button type="submit" class="btn btn-success">Valider</button>
			</div>
		</div>

	</form:form>

	<a href="listerclient.do">Annuler</a>
</div>