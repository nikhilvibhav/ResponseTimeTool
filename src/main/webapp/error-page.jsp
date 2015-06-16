<%-- 
    Document   : error-page
    Created on : Jun 15, 2015, 2:20:14 PM
    Author     : nvibhav
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Oops..</title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/css/materialize.min.css">

</head>

<body class="center-align">
	<br>
	<br>
	<br>
	
	<h2>We're sorry, an error has occurred</h2>
	
	<br>
	<hr>
	<br>
	
	<div class="row" style="width:75%; margin-left:auto; margin-right:auto;">
		<div class="col s12 m12 l12">
			<p><b>Exception:</b> <%= exception.getMessage() %></p>
			<br>
			<br>
			<p>Please check logs for more details</p>
		</div>
	</div>
	
	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>	
</body>
</html>