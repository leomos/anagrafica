<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ page import="java.text.SimpleDateFormat" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista clienti Filtrata</title>
</head>
<body>
<c:choose>
<c:when test = "${ListaFiltrataNulla==true}">
<p4> Nessun cliente con le specifiche richieste </p4>
</c:when>

<c:when test = "${ListaFiltrataNonNulla==true}">
<table>
		<tr>
		
			<th><p class="redtext">Nome</p></th>
			<th><p class="redtext">Cognome</p></th>
			<th><p class="redtext">Sesso</p></th>
			<th><p class="redtext">Cf</p></th>
			<th><p class="redtext">Data di Nascita</p></th>
			<th><p class="redtext">Luogo di Nascita</p></th>
			<th><p class="redtext">Email</p></th>
			<th><p class="redtext">Telefono</p></th>
		

<tr>
<c:forEach var="p" items="${ ListaFiltrata }">
	
				<tr>
				
					<td>${ p.nome }</td>
					<td>${ p.cognome }</td>
					<td>${ p.sesso }</td>
					<td>${ p.cf }</td>
					<td><fmt:formatDate value="${p.dataDiNascita}" pattern="yyyy-MM-dd" /></td>
					<td>${ p.luogoDiNascita }</td>
					<td>${ p.mail }</td>
					<td>${ p.telefono }</td>
					</tr>
					</c:forEach>
					
</table>
</c:when>
</c:choose>
<form action="http://localhost:5679">

		<input type="submit" value="Home" />
	</form>

</body>
</html>