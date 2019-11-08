<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${existByCf==true}">
		<p>il CF è gia presente  </p>
	</c:if>
	
	<c:if test="${nullCf==true}">
		<p>il CF non può essere vuoto </p>
	</c:if>
	
	<c:if test="${nullCliente==true}">
		<p>il cliente non può essere nullo </p>
	</c:if>
	
	<c:if test="${ClienteCreato==true}">
		<p>Cliente inserito con successo </p>
	</c:if>
	
	<form action="http://localhost:5679">

		<input type="submit" value="Home" />
	</form>

</body>
</html>