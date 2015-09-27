package com.estar.responsetimetool.util;

import com.estar.responsetimetool.pojo.ResponseTime;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil on 27-09-2015.
 */
public class JSONResponseTime extends JSONObject {
    public JSONResponseTime(HashMap responseMap){
        put("gateway", responseMap.get("gateway"));
        put("homepage", responseMap.get("homepage"));
        put("outbound", responseMap.get("outbound"));
        put("inbound", responseMap.get("inbound"));
        put("insurance", responseMap.get("insurance"));
        put("login", responseMap.get("login"));
        put("traveller details", responseMap.get("traveller details"));
        put("payment", responseMap.get("payment"));
    }
}
