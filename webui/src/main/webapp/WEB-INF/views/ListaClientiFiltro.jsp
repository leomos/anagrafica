<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Clienti filtrata</title>
</head>
<body>
<p4> Inserire i parametri da usare per filtrare la lista di clienti </p4>


<form:form action="ListaClientiFiltrata/Filtro" method="POST">

		
			<p class="redtext">Nome</p>
			<input type="text" name="nome" /> 
			<p class="redtext">Cognome</p>
			<input type="text" name="cognome" />
			<p class="redtext">Sesso</p>
			<input type="text" name="sesso" />
			<p class="redtext">Cf</p>
			<input type="text" name="cf" />
			<p class="redtext">Data iniziale</p>
			 <input type="date" name="dataIniziale"/> 
			<p class="redtext">Data finale</p>
			 <input type="date" name="dataFinale"/> 
			<p class="redtext">Provincia di Residenza</p>
			<input type="text" name="provinciaDiResidenza" />
			<p class="redtext">Regione di Residenza</p>
			<input type="text" name="regioneDiResidenza" />
<input type="submit" value="ListaFiltrata">
</form:form>

</body>
</html>