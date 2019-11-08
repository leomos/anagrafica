<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registry - Index</title>
<style>
body {
	background-color: #fff;
	background-size: 100% 100%;
	background-attachment: fixed;
}

.menu {
    background-color: rgba(61, 118, 53, 0.37);
    width: min-content;
    padding: 15px;
    left: 30px;
    top: 30px;
    position: relative;
    border-radius: 5px;
}

</style>

<link rel="shortcut icon" href="https://upload.wikimedia.org/wikipedia/commons/0/03/Pay_index_favicon.png"/>

</head>
<body background="http://all4desktop.com/data_images/original/4236532-background-images.jpg">


<div class="menu">
<form method="get" action="/NewClient">
    <input type="submit" value="Registration" style="padding: 5px;border-radius: 5px;width: 100px;"/>
</form>

<form method="get" action="/ReadOneClient">
    <input type="submit" value="Read by CF" style="padding: 5px;border-radius: 5px;width: 100px;"/>
</form>

<form method="get" action="/ReadAllClient">
    <input type="submit" value="Read all" style="padding: 5px;border-radius: 5px;width: 100px;"/>
</form>

<form method="get" action="/UpdateClient">
    <input type="submit" value="Modify" style="padding: 5px;border-radius: 5px;width: 100px;"/>
</form>

<form method="get" action="/DeleteClient">
    <input type="submit" value="Delete" style="padding: 5px;border-radius: 5px;width: 100px;"/>
</form>
</div>
</body>
</html>