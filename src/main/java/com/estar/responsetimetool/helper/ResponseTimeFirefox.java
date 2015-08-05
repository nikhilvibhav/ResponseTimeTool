package com.estar.responsetimetool.helper;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.swing.text.DateFormatter;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor.BROWN;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.estar.responsetimetool.pojo.ResponseTime;
import com.google.common.base.Objects;

/**
 * Created by nvibhav on 09-Jun-15.
 */
@SuppressWarnings("unused")
public class ResponseTimeFirefox {

	final static Logger LOGGER = LogManager.getLogger(ResponseTimeFirefox.class.getName());
	
    private RemoteWebDriver driver = null;
    private StopWatch stopWatch = null;
    private WebElement element = null;
    private String websiteName;
    private Capabilities cap;
    
    private ResponseTime responseTime = null;
    private DateTimeFormatter formatter = null;
    
	public ResponseTimeFirefox() {

        //Instantiate the selenium RC server
        //FirefoxBinary binary = new FirefoxBinary(new File("/usr/local/firefox"));
        //binary.setEnvironmentProperty("DISPLAY",System.getProperty("lmportal.xvfb.id",":99"));
        //driver = new FirefoxDriver(binary , null);
    	driver = new FirefoxDriver();
    	
        //Instantiate stopwatch
        stopWatch = new StopWatch();
        
        //set date time pattern
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
        
        //initialise driver capabilities
        cap = driver.getCapabilities();
    	    
        LOGGER.info("Running test on Firefox");
    }

    public ResponseTime initJourney() throws InterruptedException {
        
        LOGGER.info("Gateway Journey");

        responseTime = new ResponseTime();

        //To visit Eurostar dot com
       	driver.navigate().to(websiteName);
       	stopWatch.start();

       	element = driver.findElement(By.linkText("United Kingdom"));

       	stopWatch.stop();
        
       	LOGGER.info("Response time for Init journey: " + stopWatch.getTime()+ " ms");
        
       	responseTime.setPageTitle(driver.getTitle());
       	responseTime.setResponseTime(String.valueOf(stopWatch.getTime()));
       	responseTime.setSessionID(driver.getSessionId().toString());
       	responseTime.setDateAdded(LocalDateTime.now().format(formatter));
       	responseTime.setPageID("gateway");
       	responseTime.setBrowserName(cap.getBrowserName());
       	responseTime.setBrowserVersion(cap.getVersion());
       	responseTime.setDomainName(websiteName);
       	  	
       	HibernateHelper.insertIntoDB(responseTime);
       	
       	return responseTime;
    }

    public ResponseTime homeJourney() throws InterruptedException {
        
        LOGGER.info("Home Journey");

        responseTime = new ResponseTime();
        
       	stopWatch.reset();
       	element.click();
       	stopWatch.start();

       	// Wait for the page to load, timeout after 30 seconds
       	(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
       		@Override
       		public Boolean apply(WebDriver d) {
       			return d.getTitle().toLowerCase().startsWith("trains to paris");
       		}
       	});
       
       	stopWatch.stop();
       
       	LOGGER.info("Response time for Home Journey: " + stopWatch.getTime() + " ms");
       	
       	responseTime.setPageTitle(driver.getTitle());
       	responseTime.setResponseTime(String.valueOf(stopWatch.getTime()));
       	responseTime.setSessionID(driver.getSessionId().toString());
       	responseTime.setDateAdded(LocalDateTime.now().format(formatter));
       	responseTime.setPageID("homepage");
       	responseTime.setBrowserName(cap.getBrowserName());
    	responseTime.setBrowserVersion(cap.getVersion());
       	responseTime.setDomainName(websiteName);
       		
       	HibernateHelper.insertIntoDB(responseTime);
       	
       	return responseTime;
    }

    public ResponseTime outboundJourney() throws InterruptedException {

        LOGGER.info("Outbound Journey");

        responseTime = new ResponseTime();
        
        element = driver.findElement(By.xpath("//input[@value='Find trains' and @type='submit']"));
        stopWatch.reset();
        element.click();
        stopWatch.start();

        // Wait for the page to load, timeout after 30 seconds
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("outbound train | eurostar");
        	}
        });

        stopWatch.stop();

        LOGGER.info("Response time for Outbound Journey: " + stopWatch.getTime() + " ms");

        responseTime.setPageTitle(driver.getTitle());
        responseTime.setResponseTime(String.valueOf(stopWatch.getTime()));
       	responseTime.setSessionID(driver.getSessionId().toString());
       	responseTime.setDateAdded(LocalDateTime.now().format(formatter));
       	responseTime.setPageID("outbound");
       	responseTime.setBrowserName(cap.getBrowserName());
    	responseTime.setBrowserVersion(cap.getVersion());
       	responseTime.setDomainName(websiteName);

       	HibernateHelper.insertIntoDB(responseTime);
       	
        return responseTime;
    }

    public ResponseTime inboundJourney() throws InterruptedException {

        LOGGER.info("Inbound Journey");

        responseTime = new ResponseTime();
        
        element = driver.findElement(By.xpath("//*[@id='standard-booking-path-daily-view-form']/div/div[3]/table/tbody/tr[8]/td[7]"));
        stopWatch.reset();
        element.click();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver webDriver) {
        		final WebElement element = webDriver.findElement(By.xpath("//*[@id='dialog-element--2']"));
        		return element.isEnabled();
        	}
        });

        element = driver.findElement(By.xpath("//*[@id='dialog-element--2']"));
        element.click();
        stopWatch.start();

        // Wait for the page to load, timeout after 30 seconds
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("inbound train | eurostar");
        		}
        });

        stopWatch.stop();

        LOGGER.info("Response time for Inbound Journey: " + stopWatch.getTime() + " ms");

        responseTime.setPageTitle(driver.getTitle());
        responseTime.setResponseTime(String.valueOf(stopWatch.getTime()));
       	responseTime.setSessionID(driver.getSessionId().toString());
       	responseTime.setDateAdded(LocalDateTime.now().format(formatter));
       	responseTime.setPageID("inbound");
       	responseTime.setBrowserName(cap.getBrowserName());
       	responseTime.setBrowserVersion(cap.getVersion());
       	responseTime.setDomainName(websiteName);

       	//FOR TEST
       	LOGGER.info("Browser version: " + responseTime.getBrowserVersion());
       	
       	HibernateHelper.insertIntoDB(responseTime);
       	
        return responseTime;
    }

    public ResponseTime insuranceJourney() throws InterruptedException {

        LOGGER.info("Insurance Journey");

        responseTime = new ResponseTime();

        element = driver.findElement(By.xpath("//*[@id='standard-booking-path-daily-view-form']/div/div[3]/table/tbody/tr[8]/td[5]"));
        stopWatch.reset();
        element.click();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver webDriver) {
        		final WebElement element = webDriver.findElement(By.xpath("//*[@id='dialog-element']"));
        		return element.isEnabled();
        	}
        });

        element = driver.findElement(By.xpath("//*[@id='dialog-element']"));
        element.click();
        stopWatch.start();

        // Wait for the page to load, timeout after 30 seconds
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("travel extras | eurostar");
        	}
        });

        stopWatch.stop();

        LOGGER.info("Response time for Insurance Journey: " + stopWatch.getTime() + " ms");

        responseTime.setPageTitle(driver.getTitle());
        responseTime.setResponseTime(String.valueOf(stopWatch.getTime()));
       	responseTime.setSessionID(driver.getSessionId().toString());
       	responseTime.setDateAdded(LocalDateTime.now().format(formatter));
       	responseTime.setPageID("insurance");
       	responseTime.setBrowserName(cap.getBrowserName());
    	responseTime.setBrowserVersion(cap.getVersion());
       	responseTime.setDomainName(websiteName);
       	
       	HibernateHelper.insertIntoDB(responseTime);
       	
        return responseTime;
    }

    public ResponseTime userLoginJourney() throws InterruptedException {

        LOGGER.info("Login Journey");

        responseTime = new ResponseTime();
        
        stopWatch.reset();
        element = driver.findElement(By.xpath("//*[@id='dialog-element--2']"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id='dialog-dialog-element--2']/div[2]/ul/li[1]/a"));
        element.click();
        stopWatch.start();

        // Wait for the page to load, timeout after 30 seconds
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("login, create account");
        	}
        });

        stopWatch.stop();

        LOGGER.info("Response time for Login Journey: " + stopWatch.getTime() + " ms");

        responseTime.setPageTitle(driver.getTitle());
        responseTime.setResponseTime(String.valueOf(stopWatch.getTime()));
       	responseTime.setSessionID(driver.getSessionId().toString());
       	responseTime.setDateAdded(LocalDateTime.now().format(formatter));
       	responseTime.setPageID("login");
       	responseTime.setBrowserName(cap.getBrowserName());
    	responseTime.setBrowserVersion(cap.getVersion());
       	responseTime.setDomainName(websiteName);

       	HibernateHelper.insertIntoDB(responseTime);
       	
        return responseTime;
    }

    public ResponseTime paxDetailsJourney() throws InterruptedException {
        
        LOGGER.info("Passenger Details Journey");

        responseTime = new ResponseTime();

        stopWatch.reset();
        element = driver.findElement(By.xpath("//*[@id='dialog-element']"));
        element.click();
        stopWatch.start();

        // Wait for the page to load, timeout after 30 seconds
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("traveller details | eurostar");
        	}
        });

        stopWatch.stop();

        LOGGER.info("Response time for PaxDetails Journey: " + stopWatch.getTime() + " ms");

        responseTime.setPageTitle(driver.getTitle());
        responseTime.setResponseTime(String.valueOf(stopWatch.getTime()));
       	responseTime.setSessionID(driver.getSessionId().toString());
       	responseTime.setDateAdded(LocalDateTime.now().format(formatter));
       	responseTime.setPageID("traveller details");
       	responseTime.setBrowserName(cap.getBrowserName());
    	responseTime.setBrowserVersion(cap.getVersion());
       	responseTime.setDomainName(websiteName);

       	HibernateHelper.insertIntoDB(responseTime);
       	
        return responseTime;
    }

    public ResponseTime paymentJourney() throws InterruptedException {
        
        LOGGER.info("Payment Journey");

        responseTime = new ResponseTime();

        stopWatch.reset();
        
       	Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='edit-adult-1-title']")));
       	dropdown.selectByValue("Mr");
        
        element = driver.findElement(By.xpath("//*[@id='edit-adult-1-first-name']"));
        element.sendKeys("John");
        element = driver.findElement(By.xpath("//*[@id='edit-adult-1-last-name']"));
        element.sendKeys("Smith");

        element = driver.findElement(By.xpath("//*[@id='dialog-element']"));
        element.click();
        stopWatch.start();

        // Wait for the page to load, timeout after 30 seconds
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("payment | eurostar");
        	}
        });

        stopWatch.stop();
        
       	LOGGER.info("Response time for Payment Journey: " + stopWatch.getTime() + " ms");

       	responseTime.setPageTitle(driver.getTitle());
       	responseTime.setResponseTime(String.valueOf(stopWatch.getTime()));
       	responseTime.setSessionID(driver.getSessionId().toString());
       	responseTime.setDateAdded(LocalDateTime.now().format(formatter));
       	responseTime.setPageID("payment");
       	responseTime.setBrowserName(cap.getBrowserName());
    	responseTime.setBrowserVersion(cap.getVersion());
       	responseTime.setDomainName(websiteName);

       	HibernateHelper.insertIntoDB(responseTime);
       	
        driver.quit();

        return responseTime;
    }
    
    // Function for finding website name, browser name and browser version
   	/**
	 * @param websiteName the websiteName to set
	 */
	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}
}
