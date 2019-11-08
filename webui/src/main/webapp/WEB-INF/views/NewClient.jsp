<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
body {
	background-color: #fff;
	background-size: 100% 100%;
	background-attachment: fixed;
}

.flex-container2 {
    display: -webkit-flex;
    display: flex;
    text-align: center;
}

.flex-item2 {
    background-color: rgba(0,0,0,0.2);
	width: 145px;
	margin: 21px;
	padding: 5px;
	border-radius: 5px;
}
</style>

		<link rel="shortcut icon" href="https://www.favicon.cc/logo3d/109709.png"/>
</head>
<body background="http://all4desktop.com/data_images/original/4236532-background-images.jpg">
	
	<h2 style=" text-align: center;">Registration</h2>
	


<form style=" text-align: center;" action="NewClient" method="POST">		
							
	<div class="flex-container2" style="flex-wrap:nowrap; width:560px;position:relative; left:470px; ">
	
	<!-- div sinistra "cliente" -->
	<div class="flex-item2">  

			<h3 ALIGN="CENTER">Dati del cliente</h3>
		<br>
			<h4>Nome:</h4>
			<input type="text" name="nome"/> 
		<br>
			<h4>Cognome:</h4>
			<input type="text" name="cognome"/> 
		<br>
			<h4>Sesso:</h4>
			<input type="text" name="sesso"/> 
		<br>
			<h4>Cf:</h4>
			<input type="text" name="cf"/> 
		<br>
			<h4>Data di nascita:</h4>
			<input type="text" name="data_di_nascita"/> 
		<br>
			<h4>Luogo di nascita:</h4>
			<input type="text" name="luogo_di_nascita"/> 
		<br>
			<h4>Mail:</h4>
			<input type="text" name="mail"/> 
		<br>
			<h4>Telefono:</h4>
			<input type="text" name="telefono"/> 
		<br>
		
	</div>

				<!-- div centro "residenza" -->
	
	<div class="flex-item2">  

			<h3 ALIGN="CENTER">Residenza</h3>
		<br>
			<h4>Luogo:</h4>
			<input type="text" name="luogo"/> 
		<br>
			<h4>Numero civico:</h4>
			<input type="text" name="numeroCivico"/> 
		<br>
			<h4>Citta':</h4>
			<input type="text" name="citta"/> 
		<br>
			<h4>Provincia:</h4>
			<input type="text" name="provincia"/> 
		<br>
			<h4>Regione:</h4>
			<input type="text" name="regione"/> 
		<br>
			<h4>Nazione:</h4>
			<input type="text" name="nazione"/> 
		<br>

	</div>

				<!-- div destra "domicilio" -->

		<div class="flex-item2">  

			<h3 ALIGN="CENTER">Domicilio</h3>
		<br>
			<h4>Luogo:</h4>
			<input type="text" name="luogo"/> 
		<br>
			<h4>Numero civico:</h4>
			<input type="text" name="numeroCivico"/> 
		<br>
			<h4>Citta':</h4>
			<input type="text" name="citta"/> 
		<br>
			<h4>Provincia:</h4>
			<input type="text" name="provincia"/> 
		<br>
			<h4>Regione:</h4>
			<input type="text" name="regione"/> 
		<br>
			<h4>Nazione:</h4>
			<input type="text" name="nazione"/> 
		<br>

		</div>
	</div>
	
	<input type="submit" value="Registra"  style="padding: 3px;border-radius: 3px;"/>
	
		
</form>
<form style="right: 10px;position: fixed;bottom: 10px; text-align: center;" method="post" action="index">
    		<input type="submit" value="Back to home ;)" style="padding: 3px;border-radius: 3px;"/>
		</form>

</body>
</html>