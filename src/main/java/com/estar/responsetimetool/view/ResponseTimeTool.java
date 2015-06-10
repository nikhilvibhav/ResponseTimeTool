package com.estar.responsetimetool.view;

import com.estar.responsetimetool.helper.ResponseTimeHelper;
import com.estar.responsetimetool.pojo.TimeToLoad;
import java.util.Map;

/**
 * Created by nvibhav on 09-Jun-15.
 */
public class ResponseTimeTool {

    public static void main(String args[]) throws InterruptedException {

        ResponseTimeHelper responseTimeHelper = new ResponseTimeHelper();
        Map map = responseTimeHelper.initJourney();

        printLoadTimes(map);

    }

    public static void printLoadTimes(Map map) {
        
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

        System.out.println("\n\n\n*********************FROM MAIN METHOD*********************\n\n\n");

        System.out.println(loadTimeInit.getPageTitle() + " " + loadTimeInit.getPageLoadTime());
        System.out.println(loadTimeHome.getPageTitle() + " " + loadTimeHome.getPageLoadTime());
        System.out.println(loadTimeOutbound.getPageTitle() + " " + loadTimeOutbound.getPageLoadTime());
        System.out.println(loadTimeInbound.getPageTitle() + " " + loadTimeInbound.getPageLoadTime());
        System.out.println(loadTimeInsurance.getPageTitle() + " " + loadTimeInsurance.getPageLoadTime());
        System.out.println(loadTimeLogin.getPageTitle() + " " + loadTimeLogin.getPageLoadTime());
        System.out.println(loadTimePaxDetails.getPageTitle() + " " + loadTimePaxDetails.getPageLoadTime());
        System.out.println(loadTimePayment.getPageTitle() + " " + loadTimePayment.getPageLoadTime());

    }
}
