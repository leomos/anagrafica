<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Errore Update Cliente</title>
</head>
<body>
<p> CF non valido </p>
<c:choose>
<c:when test = "${CfUpdateNull==true}">

	<form action="http://localhost:5679/modificaCliente">

		<input type="submit" value="HomeUpdateCliente" />
	</form>
	</c:when>
	
	<c:when test = "${CfDeleteNull==true}">

	<form action="http://localhost:5679/EliminaCliente">

		<input type="submit" value="HomeEliminaCliente" />
	</form>
	</c:when>
	</c:choose>
	
</body>
</html>