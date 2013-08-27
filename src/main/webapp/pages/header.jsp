<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<div id="header">
	<p>Bienvenue : <security:authentication property="principal.username" /></p>
	<h1>Gardane Auto</h1>
	<p>
		<a href="<c:url value="j_spring_security_logout"/>"> Logout</a>
	</p>
</div>