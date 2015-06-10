<%-- 
    Document   : index
    Created on : Jun 9, 2015, 7:30:35 PM
    Author     : nvibhav
--%>


<%@page import="com.estar.responsetimetool.pojo.TimeToLoad"%>
<%@page import="java.util.Map"%>
<%@page import="com.estar.responsetimetool.helper.ResponseTimeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Response Time Calculator</title>
    </head>
    <%
        ResponseTimeHelper responseTimeHelper = new ResponseTimeHelper();
        Map map = responseTimeHelper.initJourney();

        TimeToLoad loadTimeInit;
        TimeToLoad loadTimeHome;
        TimeToLoad loadTimeOutbound;
        TimeToLoad loadTimeInbound;
        TimeToLoad loadTimeInsurance;
        TimeToLoad loadTimeLogin;
        TimeToLoad loadTimePaxDetails;
        TimeToLoad loadTimePayment;

        loadTimeInit = (TimeToLoad) map.get("Initial Journey");
        loadTimeHome = (TimeToLoad) map.get("Homepage Journey");
        loadTimeOutbound = (TimeToLoad) map.get("Outbound Journey");
        loadTimeInbound = (TimeToLoad) map.get("Inbound Journey");
        loadTimeInsurance = (TimeToLoad) map.get("Insurance Journey");
        loadTimeLogin = (TimeToLoad) map.get("User Login Journey");
        loadTimePaxDetails = (TimeToLoad) map.get("PAX Details Journey");
        loadTimePayment = (TimeToLoad) map.get("Payment Journey");

    %>
    <body>
        <h1>Response Times for Eurostar.com</h1>

        <div> <%= loadTimeInit.getPageTitle()%> </div><div> <%= loadTimeInit.getPageLoadTime()%> ms</div>
        <div> <%= loadTimeHome.getPageTitle()%> </div><div> <%= loadTimeHome.getPageLoadTime()%> ms</div>
        <div> <%= loadTimeOutbound.getPageTitle()%> </div><div> <%= loadTimeOutbound.getPageLoadTime()%> ms</div>
        <div> <%= loadTimeInbound.getPageTitle()%> </div><div> <%= loadTimeInbound.getPageLoadTime()%> ms</div>
        <div> <%= loadTimeInsurance.getPageTitle()%> </div><div> <%= loadTimeInsurance.getPageLoadTime()%> ms</div>
        <div> <%= loadTimeLogin.getPageTitle()%> </div><div> <%= loadTimeLogin.getPageLoadTime()%> ms</div>
        <div> <%= loadTimePaxDetails.getPageTitle()%> </div><div> <%= loadTimePaxDetails.getPageLoadTime()%> ms</div>
        <div> <%= loadTimePayment.getPageTitle()%> </div><div> <%= loadTimePayment.getPageLoadTime()%> ms</div>

    </body>
</html>
