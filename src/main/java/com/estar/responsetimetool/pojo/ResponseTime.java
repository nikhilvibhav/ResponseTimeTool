package com.estar.responsetimetool.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nvibhav
 */

@Entity
@Table(name = "site_response_tool")
public class ResponseTime {
    
    //This class contains pojo methods for load times of each page in the standard
    //booking path
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    int id;
	@Column(name="domain_name")
	String domainName;
	@Column(name="page_id")
	String pageID;
	@Column(name="browser_name")
	String browserName;
	@Column(name="browser_version")
	String browserVersion;
	@Column(name="session_id")
	String sessionID;
	@Column(name="page_title")
    String pageTitle;
	@Column(name="added_on")
    String dateAdded; //added_on
	@Column(name="response_time")
    String responseTime;
    
    /**
	 * @return the domainName
	 */
	public String getDomainName() {
		return domainName;
	}
	/**
	 * @param domainName the domainName to set
	 */
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	/**
	 * @return the pageID
	 */
	public String getPageID() {
		return pageID;
	}
	/**
	 * @param pageID the pageID to set
	 */
	public void setPageID(String pageID) {
		this.pageID = pageID;
	}
	/**
	 * @return the browserName
	 */
	public String getBrowserName() {
		return browserName;
	}
	/**
	 * @param browserName the browserName to set
	 */
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	/**
	 * @return the browserVersion
	 */
	public String getBrowserVersion() {
		return browserVersion;
	}
	/**
	 * @param browserVersion the browserVersion to set
	 */
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	/**
	 * @return the sessionID
	 */
	public String getSessionID() {
		return sessionID;
	}
	/**
	 * @param sessionID the sessionID to set
	 */
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	/**
	 * @return the dateAdded
	 */
	public String getDateAdded() {
		return dateAdded;
	}
	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	/**
	 * @return the pageTitle
	 */
	public String getPageTitle() {
		return pageTitle;
	}
	/**
	 * @param pageTitle the pageTitle to set
	 */
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	/**
	 * @return the responseTime
	 */
	public String getResponseTime() {
		return responseTime;
	}
	/**
	 * @param responseTime the responseTime to set
	 */
	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
