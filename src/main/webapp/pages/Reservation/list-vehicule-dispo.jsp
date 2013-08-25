<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des voitures disponibles</title>
</head>
<body>
	<h1>Liste des Voitures disponibles pour la période du demandée</h1>
	<br>

	<table border=1>
		<tr>
			<td>ID</td>
			<td>Marque</td>
			<td>Modele</td>
			<td>Date MEC</td>
			<td colspan="2">Reserver</td>
		</tr>
		<c:forEach items="${voitures}" var="v">
			<tr>
				<td>${v.id}</td>
				<td>${v.marque}</td>
				<td>${v.modele}</td>
				<td><fmt:formatDate pattern="dd-MM-yyyy" value="${v.dateMiseEnCirculation}"/></td>
				<td><a href="modifiervoiture.do?id=${v.id}">Réserver</a></td>
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