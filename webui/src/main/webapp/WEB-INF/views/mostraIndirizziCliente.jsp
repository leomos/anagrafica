<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Indirizzi Cliente</title>
</head>
<body>

<c:forEach var="p" items="${ indirizziCliente }">
		<form action="modificaIndirizzi" method="POST" >
				<input type="hidden" name="indirizzo.id" value="${ p.id }"> 
				<input type="text" name="indirizzo.luogo" value="${ p.luogo }"> 
				<input type="int" name="indirizzo.numeroCivico" value="${ p.numeroCivico }">
				<input type="text" name="indirizzo.citta" value="${ p.citta }"> 
				<input type="text" name="indirizzo.provincia" value="${ p.provincia }">
				<input type="text" name="indirizzo.regione" value="${ p.regione }">
				<input type="text" name="indirizzo.provincia" value="${ p.provincia }">
				<input type="text" name="indirizzo.nazione" value="${ p.nazione }">
				<input type="submit" value="UPDATE">
			</form>
			
		</c:forEach>
		
		<form action="http://localhost:5679">

		<input type="submit" value="Home" />
	</form>
		
</body>
</html>