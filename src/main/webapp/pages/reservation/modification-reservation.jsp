
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="container">

	<h1>Modifier une réservation</h1>
	<br />
	
	<form:form action="modifierreservation.do" commandName="reservation"
		method="POST" class="form-horizontal" role="form">
		<form:hidden path="id" />
		<div class="form-group">
			<form:label path="client" class="col-lg-2 control-label">Client :</form:label>
			<div class="col-lg-10">
				<form:select path="client.id">
					<c:forEach var="client" items="${clients}">
						<form:option value="${client.id}">
							${client.nom} ${client.prenom}
							</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label path="voiture" class="col-lg-2 control-label">Voiture :</form:label>
			<div class="col-lg-10">
				<form:select path="voiture.id">
					<c:forEach var="voiture" items="${voitures}">
						<form:option value="${voiture.id}">
							${voiture.marque} ${voiture.modele}
							</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="dateReservation"
				class="col-lg-2 control-label">Date réservation :</form:label>
			<div class="col-lg-10">
				<form:input path="dateReservation" class="form-control"
					placeholder="Date de la réservation" />
				<form:errors path="dateReservation" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="datePriseVehicule"
				class="col-lg-2 control-label">Date départ :</form:label>
			<div class="col-lg-10">
				<form:input path="datePriseVehicule" class="form-control"
					placeholder="Date de prise de véhicule" />
				<form:errors path="datePriseVehicule" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="dateRetourVehicule"
				class="col-lg-2 control-label">Date retour  :</form:label>
			<div class="col-lg-10">
				<form:input path="dateRetourVehicule" class="form-control"
					placeholder="Date de retour du véhicule" />
				<form:errors path="dateRetourVehicule" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<button type="submit" class="btn btn-success">Valider</button>
			</div>
		</div>

	</form:form>

	<a href="listerreservation.do">Annuler</a>
</div>