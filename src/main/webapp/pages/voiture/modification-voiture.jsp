
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<h1>Modifier une voiture</h1>
	<br />

	<form:form action="modifiervoiture.do" commandName="voiture"
		method="POST" class="form-horizontal" role="form">
		<form:hidden path="id" />
		<div class="form-group">
			<form:label path="marque" class="col-lg-2 control-label">Marque :</form:label>
			<div class="col-lg-10">
				<form:input path="marque" class="form-control" placeholder="Marque" />
				<form:errors path="marque" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="modele" class="col-lg-2 control-label">Modele :</form:label>
			<div class="col-lg-10">
				<form:input path="modele" class="form-control" placeholder="Modele" />
				<form:errors path="modele" />
			</div>
		</div>


		<div class="form-group">
			<form:label path="dateMiseEnCirculation"
				class="col-lg-2 control-label">Date de 1ère MEC :</form:label>
			<div class="col-lg-10">
				<form:input path="dateMiseEnCirculation" class="form-control"
					placeholder="Modele" />
				<form:errors path="dateMiseEnCirculation" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<button type="submit" class="btn btn-success">Valider</button>
			</div>
		</div>

	</form:form>
	<a href="listervoiture.do">Annuler</a>
</div>