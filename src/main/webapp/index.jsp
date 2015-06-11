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

        <div> <%= loadTimeInit.getPageTitle()%> &nbsp;&nbsp;&nbsp;&nbsp; <%= loadTimeInit.getPageLoadTime()%> ms</div>
        <div> <%= loadTimeHome.getPageTitle()%> &nbsp;&nbsp;&nbsp;&nbsp; <%= loadTimeHome.getPageLoadTime()%> ms</div>
        <div> <%= loadTimeOutbound.getPageTitle()%> &nbsp;&nbsp;&nbsp;&nbsp; <%= loadTimeOutbound.getPageLoadTime()%> ms</div>
        <div> <%= loadTimeInbound.getPageTitle()%> &nbsp;&nbsp;&nbsp;&nbsp; <%= loadTimeInbound.getPageLoadTime()%> ms</div>
        <div> <%= loadTimeInsurance.getPageTitle()%> &nbsp;&nbsp;&nbsp;&nbsp; <%= loadTimeInsurance.getPageLoadTime()%> ms</div>
        <div> <%= loadTimeLogin.getPageTitle()%> &nbsp;&nbsp;&nbsp;&nbsp; <%= loadTimeLogin.getPageLoadTime()%> ms</div>
        <div> <%= loadTimePaxDetails.getPageTitle()%> &nbsp;&nbsp;&nbsp;&nbsp; <%= loadTimePaxDetails.getPageLoadTime()%> ms</div>
        <div> <%= loadTimePayment.getPageTitle()%> &nbsp;&nbsp;&nbsp;&nbsp; <%= loadTimePayment.getPageLoadTime()%> ms</div>

        <br>
        <hr>
        
        <div>Total Response Time for SBP: <%= (loadTimeInit.getPageLoadTime() + 
                loadTimeHome.getPageLoadTime() + loadTimeOutbound.getPageLoadTime() 
                + loadTimeInbound.getPageLoadTime() + loadTimeInsurance.getPageLoadTime() 
                + loadTimeLogin.getPageLoadTime() + loadTimePaxDetails.getPageLoadTime()
                + loadTimePayment.getPageLoadTime())/1000%> seconds</div>
    </body>
</html>
