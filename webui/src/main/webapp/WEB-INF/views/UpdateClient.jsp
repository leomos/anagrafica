<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify</title>
<style>
	body {
	
		background-color: #fff;
		background-size: 100% 100%;
		background-attachment: fixed;
	}
	
</style>

<script type="text/javascript">
	var lista_codice =[];
</script>

<link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9Zyc8UjN7GBwsXzXjOIfxvxq4_bZxEpS2CWNAqV5HDOKhlI8u&s"/>

</head>
<body background="http://all4desktop.com/data_images/original/4236532-background-images.jpg">

<h1 ALIGN="CENTER">Modify client</h1>

<!-- div modify hide/show (da sistemare) -->
<div  style = "background: #68b1ff;padding: 10px;border-radius: 15px;">

<!--	<h3>Who?</h3>
 <input type="text" id="cf">
	<button value="search"
		onclick='showAggiorna(document.getElementById("cf").value)'>
		search</button> 

<!-- 	<c:forEach var="p" items="${ clienti }"> -->

			<!-- show field to modify after search 
		<form id="${ p.cf}-form" style="display: none" method="post"
			action="/UpdateClient">
	-->
		    <div style="display: block ruby;width: min-content;height: min-content;position: relative;left: 340px;">
		    
				<h3>Nome:</h3>
				<input type="text" name="nome" value="${ p.nome }" /> 
		
				<h3>Cognome:</h3>
				<input type="text" name="cognome" value="${p.cognome }" />
		
				<h3>Sesso:</h3>
				<input type="text" name="sesso" value="${ p.sesso }" />
			
				<h3>Cf:</h3>
				<input type="text" name="cf" value="${p.cf }" /> 
			
			</div>
			
			<div style="display: block ruby;width: min-content;height: min-content;position: relative;left:195px">
				
				<h3>Data di nascita:</h3>
				<input type="text" name="data_di_nascita" value="${p.datadinascita }" /> 
				
				<h3>Luogo di nascita:</h3>
				<input type="text" name="luogo_di_nascita" value="${p.luogodinascita }" /> 
			
				<h3>Mail:</h3>
				<input type="text" name="mail" value="${p.mail }" /> 
			
				<h3>Telefono:</h3>
				<input type="text" name="telefono" value="${p.telefono }" /> 
			
				<br> <input type="hidden" name="id" value="${p.id }"> 
				
				<input type="submit" value="salva modifiche" style="padding: 3px;border-radius: 5px;">

			</div>
			
	<!-- 	</form> -->

<!-- 	</c:forEach>  -->
</div>

<!-- hide/show function -->
<script type="text/javascript">
	function hidedesc(id){
	
		document.getElementById(id+"-desc").style.display= "none";
	}

	function showdesc(id){
	
		document.getElementById(id+"-desc").style.display= "contents";
		for ( let i in lista_codice){
			if(lista_codice[i] !=id) show_riga(lista_codice[i]);
		}
	}


	function showAggiorna(id){
	
		for ( let i in lista_codice){
			if(lista_codice[i] !=id) hide(lista_codice[i]);
			if(lista_codice[i] ==id) show(lista_codice[i]);
		};
	};


	function hide(id){
		
		document.getElementById(id+"-form").style.display= "none";
	};

	function show(id){
		document.getElementById(id+"-form").style.display= "contents";
	
	};

</script>
<script>
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>

<!-- back to home function -->
<form style="right: 10px;position: fixed;bottom: 10px; text-align: center;" method="post" action="index">
    <input type="submit" value="Back to home ;)" style="padding: 3px;border-radius: 3px;"/>
</form>

</body>
</html>