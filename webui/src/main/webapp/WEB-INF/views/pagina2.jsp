<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${cercato==false}">
			<div>Il Cliente cercato non esiste.</div>
			<form:form action="/clienti" method="GET">
				<input type="submit" value="Torna all'elenco" />
			</form:form>
		</c:when>
		<c:when test="${cliente.cf==null}">
			<!--	<c:if test="${ cfVuoto}"> 
	<h2>Attenzione, cf inserito nullo!</h2>
	</c:if> -->
			<table border="3">
				<c:forEach var="c" items="${ clienti }">
					<c:if test="${c.isVisibile()}">
						<tr>
							<td>${ c.sesso }</td>
							<td>${ c.nome }</td>
							<td>${ c.cognome }</td>
							<td>${ c.cf }</td>
							<td>${c.dataDiNascita}</td>
							<td>${c.luogoDiNascita}</td>
							<td>${c.mail}</td>
							<td>${c.telefono}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${cliente.cf!=null}">
			<table border="3">
				<tr>
					<td>${cliente.nome}</td>
					<td>${cliente.cognome}</td>
					<td>${cliente.sesso}</td>
					<td>${cliente.cf}</td>
					<td>${cliente.dataDiNascita}</td>
					<td>${cliente.luogoDiNascita}</td>
					<td>${cliente.mail}</td>
					<td>${cliente.telefono}</td>
					<td><form:form action="/clienti/delete" method="POST">
							<input type="hidden" name="cf" value="${cliente.cf }" />
							<input type="submit" value="elimina" />
						</form:form></td>
					<td><input type="button" value="Update" onclick="javascript:mostra()" />
						</td>
				</tr>
			</table>
	
			<table id="tabellaUpdate" style="display: none">
				<tr>
				<td>
					<form:form action="/clienti/update" method="POST">
					<input type="hidden" name="id" value="${cliente.id }" />
												<input type="hidden" name="cf" value="${cliente.cf }" />
		Nome:<br>
						<input type="text" name="nome" value="${cliente.nome }">
						<br>
Cognome:<br>
						<input type="text" name="cognome" value="${cliente.cognome }">
						<br>
Sesso:<br>
						<input type="text" name="sesso" value="${cliente.sesso }">
						<br>
Data di Nascita:<br>
						<input type="date" name="dataDiNascita"
							value="${cliente.dataDiNascita }">
						<br>
Luogo di Nascita:<br>
						<input type="text" name="luogoDiNascita"
							value="${cliente.luogoDiNascita }">
						<br>
Mail:<br>
						<input type="text" name="mail" value="${cliente.mail }">
						<br>
Telefono:<br>
						<input type="text" name="telefono" value="${cliente.telefono }">
						<br>
									<input type="submit" value="Update">
					</form:form>
					</td>
				</tr>
			</table>
				</c:when>
	</c:choose>
	<c:if test="${cancellato==true}">
		<div>Cliente cancellato con successo.</div>
		<form:form action="/clienti" method="GET">
			<input type="submit" value="Torna all'elenco" />
		</form:form>
	</c:if>
	<c:if test="${aggiornato==true}">
		<div>Cliente aggiornato con successo.</div>
		<form:form action="/clienti" method="GET">
			<input type="submit" value="Torna all'elenco" />
		</form:form>
	</c:if>
	<script>
	function mostra() {
document.getElementById("tabellaUpdate").style.display="block";
}
	</script>
</body>
</html>