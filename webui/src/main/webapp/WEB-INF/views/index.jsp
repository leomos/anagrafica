<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErroreAggiuntiCliente</title>
</head>
<body>

<form action="http://localhost:5679/ListaClienti">

		<input type="submit" value="ListaClienti" />
	</form>
	
	<form action="http://localhost:5679/ListaClientiFiltrata">

		<input type="submit" value="ListaClientiConFiltro" />
	</form>


<form action="http://localhost:5679/aggiungiCliente">

		<input type="submit" value="AggiungiCliente" />
	</form>
	
	<form action="http://localhost:5679/modificaCliente">

		<input type="submit" value="ModificaCliente" />
	</form>
	
		<form action="EliminaCliente" method="POST">

		<input type="submit" value="EliminaCliente" />
	</form>
	
</body>
</html>