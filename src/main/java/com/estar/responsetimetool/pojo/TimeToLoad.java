package com.estar.responsetimetool.pojo;

/**
 *
 * @author nvibhav
 */
public class TimeToLoad {
    
    //This class contains pojo methods for load times of each page in the standard
    //booking path
    
    String pageTitle;
    Long pageLoadTime;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public Long getPageLoadTime() {
        return pageLoadTime;
    }

    public void setPageLoadTime(Long pageLoadTime) {
        this.pageLoadTime = pageLoadTime;
    }
    
}
