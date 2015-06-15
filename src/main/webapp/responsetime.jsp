<%-- 
    Document   : responsetime
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
<%
	ResponseTimeHelper responseTimeHelper = new ResponseTimeHelper();
	
	TimeToLoad loadTimeInit = responseTimeHelper.initJourney();
	TimeToLoad loadTimeHome = responseTimeHelper.homeJourney();
	TimeToLoad loadTimeOutbound = responseTimeHelper.outboundJourney();
	TimeToLoad loadTimeInbound = responseTimeHelper.inboundJourney();
	TimeToLoad loadTimeInsurance = responseTimeHelper.insuranceJourney();
	TimeToLoad loadTimeLogin = responseTimeHelper.userLoginJourney();
	TimeToLoad loadTimePaxDetails = responseTimeHelper.paxDetailsJourney();
	TimeToLoad loadTimePayment = responseTimeHelper.paymentJourney();
	
%>
<body class="center-align">

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
						<td><%=loadTimeInit.getPageTitle()%></td>
						<td><%=loadTimeInit.getPageLoadTime()%></td>
					</tr>
					<tr>
						<td><%=loadTimeHome.getPageTitle()%></td>
						<td><%=loadTimeHome.getPageLoadTime()%></td>
					</tr>
					<tr>
						<td><%=loadTimeOutbound.getPageTitle()%></td>
						<td><%=loadTimeOutbound.getPageLoadTime()%></td>
					</tr>
					<tr>
						<td><%=loadTimeInbound.getPageTitle()%></td>
						<td><%=loadTimeInbound.getPageLoadTime()%></td>
					</tr>
					<tr>
						<td><%=loadTimeInsurance.getPageTitle()%></td>
						<td><%=loadTimeInsurance.getPageLoadTime()%></td>
					</tr>
					<tr>
						<td><%=loadTimeLogin.getPageTitle()%></td>
						<td><%=loadTimeLogin.getPageLoadTime()%></td>
					</tr>
					<tr>
						<td><%=loadTimePaxDetails.getPageTitle()%></td>
						<td><%=loadTimePaxDetails.getPageLoadTime()%></td>
					</tr>
					<tr>
						<td><%=loadTimePayment.getPageTitle()%></td>
						<td><%=loadTimePayment.getPageLoadTime()%></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<br>
	<br>
	<br>

	<h6>
		<b> Total Response Time for SBP: <%=(loadTimeInit.getPageLoadTime()
					+ loadTimeHome.getPageLoadTime()
					+ loadTimeOutbound.getPageLoadTime()
					+ loadTimeInbound.getPageLoadTime()
					+ loadTimeInsurance.getPageLoadTime()
					+ loadTimeLogin.getPageLoadTime()
					+ loadTimePaxDetails.getPageLoadTime() + loadTimePayment
					.getPageLoadTime()) / 1000%> seconds
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
