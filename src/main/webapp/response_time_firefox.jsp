<%-- 
    Document   : responsetime
    Created on : Jun 9, 2015, 7:30:35 PM
    Author     : nvibhav
--%>

<%@page import="com.estar.responsetimetool.pojo.ResponseTime"%>
<%@page import="com.estar.responsetimetool.helper.ResponseTimeFirefox"%>
<%@page import="com.estar.responsetimetool.helper.ResponseTimeChrome"%>
<%@page import="org.apache.logging.log4j.Logger"%>
<%@page import="org.apache.logging.log4j.LogManager"%>
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
	
	<%
	ResponseTimeFirefox responseTimeFirefox = new ResponseTimeFirefox("http://www.eurostar.com");
	final Logger logger = LogManager.getLogger(getClass());
	
	logger.info("Entering responseTimeFirefox class");
		
	ResponseTime gatewayPage = responseTimeFirefox.initJourney();
	ResponseTime homePage = responseTimeFirefox.homeJourney();
	ResponseTime outboundPage = responseTimeFirefox.outboundJourney();
	ResponseTime inboundPage = responseTimeFirefox.inboundJourney();
	ResponseTime loadTimeInsurance = responseTimeFirefox.insuranceJourney();
	ResponseTime loginPage = responseTimeFirefox.userLoginJourney();
	ResponseTime travelerDetailsPage = responseTimeFirefox.paxDetailsJourney();
	ResponseTime paymentPage = responseTimeFirefox.paymentJourney();
		
	logger.info("Exiting responseTimeFirefox class");
	%>
	<br>
	<br>
	<br>

	<h4>
		<b>Response Time for Eurostar.com</b>
	</h4>

	<br>
	<br>
	<br>

	<div class="row"
		style="width: 75%; margin-left: auto; margin-right: auto">
		<div class="col s12 m12 l12">
			<table class="bordered hoverable">
				<thead>
					<tr>
						<th>Page Title</th>
						<th>Response Time (in ms)</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=gatewayPage.getPageTitle()%></td>
						<td><%=gatewayPage.getResponseTime()%></td>
					</tr>
					<tr>
						<td><%=homePage.getPageTitle()%></td>
						<td><%=homePage.getResponseTime()%></td>
					</tr>
					<tr>
						<td><%=outboundPage.getPageTitle()%></td>
						<td><%=outboundPage.getResponseTime()%></td>
					</tr>
					<tr>
						<td><%=inboundPage.getPageTitle()%></td>
						<td><%=inboundPage.getResponseTime()%></td>
					</tr>
					<tr>
						<td><%=loadTimeInsurance.getPageTitle()%></td>
						<td><%=loadTimeInsurance.getResponseTime()%></td>
					</tr>
					<tr>
						<td><%=loginPage.getPageTitle()%></td>
						<td><%=loginPage.getResponseTime()%></td>
					</tr>
					<tr>
						<td><%=travelerDetailsPage.getPageTitle()%></td>
						<td><%=travelerDetailsPage.getResponseTime()%></td>
					</tr>
					<tr>
						<td><%=paymentPage.getPageTitle()%></td>
						<td><%=paymentPage.getResponseTime()%></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<br>
	<br>
	<br>

	<h6>
		<b> Total Response Time for SBP: <%=(gatewayPage.getResponseTime()
					+ homePage.getResponseTime()
					+ outboundPage.getResponseTime()
					+ inboundPage.getResponseTime()
					+ loadTimeInsurance.getResponseTime()
					+ loginPage.getResponseTime()
					+ travelerDetailsPage.getResponseTime() + paymentPage
					.getResponseTime()) / 1000%> seconds
		</b>
	</h6>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>
</body>
</html>
