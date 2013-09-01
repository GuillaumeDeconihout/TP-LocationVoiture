<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.no-icons.min.css"
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/bootswatch/3.0.0/cosmo/bootstrap.min.css"
	rel="stylesheet">

<link href="pages/index.css" rel="stylesheet">
<!-- Custom styles for this template -->
<title>Accueil Location Voiture</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-4">4 ceeeeeolonnes</div>
			<div class="col-md-8">8 colonnes</div>
		</div>
	


	<h1>Accueil</h1>
	<br />
	<table border=1>
		<tr>
			<td><a href="Client/index.do">Clients</a></td>
		</tr>
		<tr>
			<td><a href="Voiture/index.do">Voitures</a></td>
		</tr>
		<tr>
			<td><a href="Reservation/index.do">Reservations</a></td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</body>
</html>