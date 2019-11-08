<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreateCliente</title>
</head>
<body>

<form:form action="CreateCliente" method="POST">
<h3> Cliente da aggiungere</h3>
		<div class="redtext">Nome
		<input type="text" name="cliente.nome" /> </div>
		<div class="redtext">Cognome
		<input type="text" name="cliente.cognome" /> </div>
		<div class="redtext">Sesso
		<input type="text" name="cliente.sesso" /></div>
		<div class="redtext">CF
		<input type="text" name="cliente.cf" /></div>
		<div class="redtext">Data di Nascita
		<input type="date" name="dataDiNascita" /></div>
		<div class="redtext">Luogo di Nascita
		<input type="text" name="cliente.luogoDiNascita" /></div>
		<div class="redtext">Mail
		<input type="text" name="cliente.mail" /></div>
		<div class="redtext">Telefono
		<input type="text" name="cliente.telefono" /></div>
	<h3>Indirizzo di Residenza</h3>	
	<div class="redtext">Via
		<input type="text" name="indirizzoResidenza.luogo" /> </div>
		<div class="redtext">Numero civico
		<input type="int" name="indirizzoResidenza.numeroCivico" /> </div>
		<div class="redtext">Città
		<input type="text" name="indirizzoResidenza.citta" /></div>
		<div class="redtext">Provincia
		<input type="text" name="indirizzoResidenza.provincia" />  </div>
		<div class="redtext">Regione
		<input type="text" name="indirizzoResidenza.regione" /> </div>
		<div class="redtext">Nazione
		<input type="text" name="indirizzoResidenza.nazione" /> </div>
		<h3>Indirizzo di Domicilio</h3>	
		<div class="redtext">Via
		<input type="text" name="indirizzoDomicilio.luogo" /> </div>
		<div class="redtext">Numero civico
		<input type="int" name="indirizzoDomicilio.numeroCivico" /> </div>
		<div class="redtext">Città
		<input type="text" name="indirizzoDomicilio.citta" /></div>
		<div class="redtext">Provincia
		<input type="text" name="indirizzoDomicilio.provincia" />  </div>
		<div class="redtext">Regione
		<input type="text" name="indirizzoDomicilio.regione" /> </div>
		<div class="redtext">Nazione
		<input type="text" name="indirizzoDomicilio.nazione" /> </div>
		
		
		<input type="submit" value="AGGIUNGI CLIENTE" />
	</form:form>
	
	
	<form action="http://localhost:5679">

		<input type="submit" value="Home" />
	</form>
	

</body>
</html>