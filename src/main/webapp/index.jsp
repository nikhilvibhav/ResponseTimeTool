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

        TimeToLoad loadTimeInit = responseTimeHelper.initJourney();
        TimeToLoad loadTimeHome = responseTimeHelper.homeJourney();
        TimeToLoad loadTimeOutbound = responseTimeHelper.outboundJourney();
        TimeToLoad loadTimeInbound = responseTimeHelper.inboundJourney();
        TimeToLoad loadTimeInsurance = responseTimeHelper.insuranceJourney();
        TimeToLoad loadTimeLogin = responseTimeHelper.userLoginJourney();
        TimeToLoad loadTimePaxDetails = responseTimeHelper.paxDetailsJourney();
        TimeToLoad loadTimePayment = responseTimeHelper.paymentJourney();

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
