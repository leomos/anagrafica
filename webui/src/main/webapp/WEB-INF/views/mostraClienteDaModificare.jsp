<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cliente da Modificare</title>
</head>
<body>
<c:when test = "${presente==true}">

			<form action="UpdateProdotto" method="POST" >
				<input type="hidden" name="cliente.id" value="${ cliente.id }"> 
				<input type="text" name="cliente.nome" value="${ cliente.nome }"> 
				<input type="text" name="cliente.cognome" value="${ cliente.cognome }">
				<input type="text" name="cliente.sesso" value="${ cliente.sesso }"> 
				<input type="text" name="cliente.cf" value="${ cliente.cf }">
				<!--<input type="date" name="cliente.dataDiNascita" value="${ dataDiNascita }">-->
				 
				 <input type="date" name="dataDiNascita" value=<fmt:formatDate value="${cliente.dataDiNascita}" pattern="yyyy-MM-dd" />> 
				 <input type="text" name="cliente.luogoDiNascita" value="${ cliente.luogoDiNascita }">
				  <input type="text" name="cliente.mail" value="${ cliente.mail }">
				  <input type="text" name="cliente.telefono" value="${ cliente.telefono }">
				<input type="submit" value="UPDATE">
			</form>
			
			<form action="http://localhost:5679/modificaCliente/indirizzi">
 		<input type="hidden" name="id" value="${ cliente.id }">
		<input type="submit" value="Mostra Indirizzi" />
	</form>
	
	<form action="http://localhost:5679">

		<input type="submit" value="Home" />
	</form>
			
		
	</c:when>
	


</body>
</html>