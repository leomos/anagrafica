<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina 2</title>
</head>
<body>
	<c:choose>
		<c:when test="${cercato==false}">
			<div>Il Cliente cercato non esiste.</div>
			<form:form action="/MergeRobiSamu/" method="GET">
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
							<td><fmt:formatDate value="${c.dataDiNascita}" pattern="yyyy-MM-dd" /></td>
							<td>${c.luogoDiNascita}</td>
							<td>${c.mail}</td>
							<td>${c.telefono}</td>
							<td><form:form action="/MergeRobiSamu/clienti" method="GET">
							<input type="hidden" name="cf" value="${c.cf }" />
							<input type="submit" value="Dettaglio" />
						</form:form></td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${cliente.cf!=null}">
			<table border="3" id="tabellaCliente" style="display: block">
				<tr>
					<td>${cliente.nome}</td>
					<td>${cliente.cognome}</td>
					<td>${cliente.sesso}</td>
					<td>${cliente.cf}</td>
					<td><fmt:formatDate value="${cliente.dataDiNascita}" pattern="yyyy-MM-dd" /></td>
					<td>${cliente.luogoDiNascita}</td>
					<td>${cliente.mail}</td>
					<td>${cliente.telefono}</td>
					<td><form:form action="/MergeRobiSamu/clienti/delete" method="POST">
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
					<form:form action="/MergeRobiSamu/clienti/update" method="POST">
					<input type="hidden" name="id" value="${cliente.id }" />
					<input type="hidden" name="cf" value="${cliente.cf }" />					
		Nome:<br>
						<input type="text" name="nome" value="${cliente.nome }">
						<br>
Cognome:<br>
						<input type="text" name="cognome" value="${cliente.cognome }">
						<br>
Sesso:<br>
						<input type="text" name="sesso" value="${cliente.sesso }" >
						<br>
Data di Nascita:<br>
						<input type="date" name="dataDiNascita"
							value="<fmt:formatDate value="${cliente.dataDiNascita}" pattern="yyyy-MM-dd" />">
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
									<input type="submit" value="Update" onclick="javascript:nascondi()">
					</form:form>
					</td>
				</tr>
			</table>
				</c:when>
	</c:choose>
	<c:if test="${cancellato==true}">
		<div>Cliente cancellato con successo.</div>
		<form:form action="/MergeRobiSamu/" method="GET">
			<input type="submit" value="Torna all'elenco" />
		</form:form>
	</c:if>
	<c:if test="${aggiornato==true}">
		<div>Cliente aggiornato con successo.</div>
		<form:form action="/MergeRobiSamu/" method="GET">
			<input type="submit" value="Torna all'elenco" />
		</form:form>
	</c:if>
	<c:if test="${aggiornato==false}">
		<div>Cliente non aggiornato perchè non presente e per errori.</div> <br>
		<div> ${messaggioErroreUpdate}</div>
		<form:form action="/MergeRobiSamu/" method="GET">
			<input type="submit" value="Torna all'elenco" />
		</form:form>
	</c:if>
	<script>
	function mostra() {
document.getElementById("tabellaUpdate").style.display="block";
}
	function nascondi() {
		document.getElementById("tabellaCliente").style.display="none";
		}
	</script>
</body>
</html>