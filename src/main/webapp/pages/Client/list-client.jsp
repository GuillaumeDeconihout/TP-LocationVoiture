<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Clients</title>
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


</body>
</html>