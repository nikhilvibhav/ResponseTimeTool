package com.estar.responsetimetool.controller;

import com.estar.responsetimetool.helper.ResponseTimeHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

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

    public
}
