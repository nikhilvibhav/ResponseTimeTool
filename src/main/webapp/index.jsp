<%-- 
    Document   : index
    Created on : Jun 9, 2015, 7:30:35 PM
    Author     : nvibhav
--%>


<%@page import="com.estar.responsetimetool.pojo.ResponseTime"%>
<%@page import="com.estar.responsetimetool.helper.ResponseTimeFirefox"%>
<%@page import="com.estar.responsetimetool.helper.ResponseTimeChrome"%>
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

	<form action="response_time_firefox.jsp">
		<button class="btn waves-effect waves-light" type="submit">
			Check Response Time on Firefox
		</button>
	</form>
	
	<br>
	<br>
	<br>
	
	<form action="response_time_chrome.jsp">
		<button class="btn waves-effect waves-light" type="submit">
			Check Response Time on Chrome
		</button>
	</form>

	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>
</body>
</html>
