<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.png">

<title>Liste des Clients</title>

<!-- Bootstrap core CSS -->
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.no-icons.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/bootswatch/3.0.0/cosmo/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="starter-template.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>



    
    
	<h1>Liste des Clients</h1>
	<br />
	<table border=0>
		<tr>
			<td><a href="client.do">Nouveau Client</a></td>
		</tr>
	</table>

	<br />


	<table border=1>
		<tr>
			<td>ID</td>
			<td>Nom</td>
			<td>Prenom</td>
			<td>Email</td>
			<security:authorize ifAllGranted="ROLE_ADMIN">
				<td colspan="2">Action</td>
			</security:authorize>
		</tr>
		<c:forEach items="${clients}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.nom}</td>
				<td>${c.prenom}</td>
				<td>${c.email}</td>
				<security:authorize ifAllGranted="ROLE_ADMIN">
					<td><a href="modifierclient.do?id=${c.id}">Modifier</a></td>
					<td><a href="supprimerclient.do?id=${c.id}">Supprimer</a></td>
				</security:authorize>
			</tr>
		</c:forEach>
	</table>

	<br />
	<table border=0>
		<tr>
			<td><a href="../index.do">Accueil</a></td>
		</tr>
	</table>

	<br />


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</body>
</html>
