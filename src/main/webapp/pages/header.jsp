<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Gardane Auto</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Accueil</a></li>
				<li><a href="Voiture/index.do">Voitures</a></li>
				<li><a href="#Client/index.do">Clients</a></li>
				<li><a href="#Reservation/index.do">Reservations</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Bienvenue <security:authentication property="principal.username" /></a> </li>
				<li><a href="<c:url value="j_spring_security_logout" />" > Logout</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
