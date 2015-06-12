<%-- 
    Document   : index
    Created on : Jun 9, 2015, 7:30:35 PM
    Author     : nvibhav
--%>


<%@page import="com.estar.responsetimetool.pojo.TimeToLoad"%>
<%@page import="com.estar.responsetimetool.helper.ResponseTimeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Response Time Calculator</title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/css/materialize.min.css">

</head>

<body class="center-align">

	<br>
	<br>
	<br>
	<br>
	<br>

	<h4>
		<b>Response Time for Eurostar.com</b>
	</h4>

	<br>
	<br>

	<form action="responsetime.jsp">
		<button class="btn waves-effect waves-light" type="submit"
			name="action">Check Response Time</button>
	</form>

	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>
</body>
</html>
