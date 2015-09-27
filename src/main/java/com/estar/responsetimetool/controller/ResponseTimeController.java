package com.estar.responsetimetool.controller;

import com.estar.responsetimetool.helper.ResponseTimeHelper;
import com.estar.responsetimetool.pojo.ResponseTime;
import com.estar.responsetimetool.util.JSONResponseTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.HashMap;

/**
 * Created by Nikhil on 27-09-2015.
 */
@RestController
public class ResponseTimeController {
    private final static Logger LOGGER = LogManager.getLogger(ResponseTimeController.class.getName());
    private final ResponseTimeHelper responseTimeHelper;
    private final ResponseTime responseTime = null;

    @Inject
    public ResponseTimeController(ResponseTimeHelper responseTimeHelper){
        this.responseTimeHelper = responseTimeHelper;
    }

    @RequestMapping(value="/get-response-times")
    public @ResponseBody JSONResponseTime initJourney() throws InterruptedException {
        HashMap responseMap = responseTimeHelper.startJourney();
        return new JSONResponseTime(responseMap);
    }
}
