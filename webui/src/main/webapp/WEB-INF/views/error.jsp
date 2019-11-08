<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Errore Creazione Cliente</title>
</head>
<body>
<p> Errore durante la creazione del cliente</p>
<form action="http://localhost:5679/aggiungiCliente">

		<input type="submit" value="HomeCreateCliente" />
	</form>
	

</body>
</html>