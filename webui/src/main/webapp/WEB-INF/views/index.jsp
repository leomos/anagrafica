
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List"%>
<%@page import="com.example.anagrafica.data.Cliente"%>
<%@page import="com.example.anagrafica.business.ClienteFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.frameTabella {
	width: 1600px;
	height: 900px;
}
</style>

<script type="text/javascript">
var listaClienti = [];
var a="";

function showDettaglio(id) {
	
	for ( let i in listaClienti){
		if(listaClienti[i] !=id) nascondiDettaglio(listaClienti[i]);
		if(listaClienti[i] ==id) mostraDettaglio(listaClienti[i]);	
		nascondiInsert(listaClienti[i]);
	}
}

function nascondiDettaglio(id){
let i=	document.getElementsByClassName("dettaglio-"+id);
Array.prototype.forEach.call(i, function(el){
el.style.display= "none"})
}

	function mostraDettaglio(id){
		let i=document.getElementsByClassName("dettaglio-"+id);
		Array.prototype.forEach.call(i, function(el){
		el.style.display= "";
	});}



function nascondiInsert(id){
let i =	document.getElementsByClassName("insert-"+id);
Array.prototype.forEach.call(i, function(el){
	

	el.style.display= "none";
})}

	function mostraInsert(id){
		
	let i=	document.getElementsByClassName("insert-"+id)
	Array.prototype.forEach.call(i, function(el){
	el.style.display= "";})}

function showInsert(id){
	
	for ( let i in listaClienti){
		if(listaClienti[i] !=id) nascondiInsert(listaClienti[i]);
		if(listaClienti[i] ==id) mostraInsert(listaClienti[i]);
		 nascondiDettaglio(listaClienti[i]);
		};
}


</script>
</head>
<body>
	<div>cerca tramite L'id</div>
	<input type="number" step="1" placeholder="id=?" id="id2">
	<script type="text/javascript">

function goToClientePage() {
	window.location = "/MergeRobiSamu/clienti/"+document.getElementById("id2").value;
}

</script>
	<button onclick="goToClientePage()">trova cliente con l'id
		selezionato</button>

	<br>

	<div>cerca tramite altri parametri</div>
	<form:form action="/MergeRobiSamu/clienti/filter" method="Get">
		<input type="text" placeholder="con nome:" name="nome" value="">
		<input type="text" placeholder="con cognome:" name="cognome" value="">
		<input type="text" placeholder="di sesso:" name="sesso" value="">
		<input type="text" placeholder="con cf:" name="cf" value="">
		<input type="date" placeholder="nati dopo il:" name="dataIniziale"
			value="01/01/0000">
		<input type="date" placeholder="nati prima del:" name="dataFinale"
			value="01/01/9999">
		<input type="text" placeholder="con residenza nella provicia di:"
			name="provinciaDiResidenza" value="">
		<input type="text" placeholder="con residenza nella regione:"
			name="regioneDiResidenza" value="">


		<input type="submit" value="cerca tramite i parametri inseriti ">



	</form:form>
	<br>
	<form:form action="/MergeRobiSamu/clienti/filter" method="Get">

		<input type="hidden" name="nome" value="">
		<input type="hidden" name="cognome" value="">
		<input type="hidden" name="sesso" value="">
		<input type="hidden" name="cf" value="">
		<input type="hidden" name="dataIniziale" value="01/01/0000">
		<input type="hidden" name="dataFinale" value="01/01/9999">
		<input type="hidden" name="provinciaDiResidenza" value="">
		<input type="hidden" name="regioneDiResidenza" value="">

		<input type="submit" value="visualizza tutti">
	</form:form>



	<div id="nonTrovati" style="display: none">
		cliente non trovato



		<div id="messaggioDiErrore">

			<c:forEach var="p" items="${ messaggioDiErrore }">
				<div>${p}</div>

			</c:forEach>
		</div>
	</div>



	<table id="tabellaClienti" style="">
		<tr>
			<th>nome</th>
			<th>cognome</th>
			<th>sesso</th>
			<th>cf</th>
			<th>dataDiNascita</th>
			<th>luogoDiNascita</th>
			<th>mail</th>
			<th>telefono</th>
		</tr>
		<c:forEach var="p" items="${ clienteCollection }">
			<script>
             listaClienti.push(${p.id});
</script>

			<tr>
				<td>${p.nome}</td>
				<td>${p.cognome }</td>
				<td>${p.sesso }</td>
				<td>${p.cf}</td>
				<td>${p.dataDiNascita }</td>
				<td>${p.luogoDiNascita }</td>
				<td>${p.mail }</td>
				<td>${p.telefono }</td>
				<td>
				<form:form href="http://localhost:5679/MergeRobiSamu/" method="GET">
				<input type="submit" value="Dettaglio" />
				<input type="hidden" name="cf" value="${p.cf }" />
			</form:form>
				</td>
				<td>
					
			</tr>
<!-- 	


<button onclick='showInsert("${p.id}")'>inserisci/modifica</button></td> 
			<button class="dettaglio-${p.id}"
				onclick='nascondiDettaglio("${p.id}")' style="display: none">
				nascondi</button>
			
			<button class="insert-${p.id}" onclick='nascondiInsert("${p.id}")'
				style="display: none">nascondiinsert</button>

<br>
		<div style="background-color: white">
				<iframe src="http://localhost:5679/clienti/1"
					class="dettaglio-${p.id} frameTabella" style="display: none">
					testo</iframe>
					
				
			</div>

			<div style="background-color: white">
				<iframe src="http://localhost:5679/clienti/${p.id }"
					class="insert-${p.id} frameTabella" style="display: none">
					testo</iframe>
			</div>
 -->
		</c:forEach>
	</table>

	<script type="text/javascript">
if (${trovato}==false){
	document.getElementById("tabellaClienti").style.display="none";
document.getElementById("nonTrovati").style.display="";
}


</script>

</body>
</html>