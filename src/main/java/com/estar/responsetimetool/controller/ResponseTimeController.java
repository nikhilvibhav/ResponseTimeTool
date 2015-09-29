package com.estar.responsetimetool.controller;

import com.estar.responsetimetool.helper.ResponseTimeHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Inject
    public ResponseTimeController(ResponseTimeHelper responseTimeHelper){
        this.responseTimeHelper = responseTimeHelper;
    }

    @RequestMapping(value="/get-response-times")
    public @ResponseBody HashMap getResponseTimes() throws InterruptedException {
        LOGGER.info("***********Within the getResponseTime method***********");
        HashMap responseMap = responseTimeHelper.startJourney();
        return responseMap;
    }
}
