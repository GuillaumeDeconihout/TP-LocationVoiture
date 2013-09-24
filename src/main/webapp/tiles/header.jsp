
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="navbar navbar-responsive navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/location-voiture/">AutoPremium</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/location-voiture/">Accueil</a></li>
				<li><a href="/location-voiture/voiture/index.do">Voitures</a></li>
				<li><a href="/location-voiture/client/index.do">Clients</a></li>
				<li><a href="/location-voiture/reservation/index.do">Réservations</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Bienvenue <security:authentication
							property="principal.username" /></a></li>
				<li><a href="<c:url value="j_spring_security_logout" />">
						Logout</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>

