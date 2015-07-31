package com.estar.responsetimetool.helper;

import java.time.LocalDateTime;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.estar.responsetimetool.pojo.ResponseTime;

/**
 * Created by nvibhav on 30-Jul-15.
 */

public class ResponseTimeChrome {

	final static Logger LOGGER = LogManager.getLogger(ResponseTimeChrome.class.getName());

    private RemoteWebDriver driver = null;
    private StopWatch stopWatch = null;
    private WebElement element = null;
    private ResponseTime responseTime = null;
    private String websiteName = null; 
    private String browserName = null;
    private String browserVersion = null;

    public ResponseTimeChrome() {

        //Instantiate the selenium RC server
        System.setProperty("webdriver.chrome.driver", "D://Users//nvibhav//Documents//Code//chromedriver.exe");
        
        //Below driver location for sonar server
        //System.setProperty("webdriver.chrome.driver", "/tmp/chromedriver");
     	driver = new ChromeDriver();

        //Instantiate stopwatch
        stopWatch = new StopWatch();
        
        this.setWebsiteName(websiteName);
        
        LOGGER.info("Running test on Chrome");
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
       	responseTime.setResponseTime(stopWatch.getTime());
       	responseTime.setSessionID(driver.getSessionId());
       	responseTime.setDateAdded(LocalDateTime.now());
       	responseTime.setPageID("gateway");
       	responseTime.setBrowserName(getBrowserName());
       	responseTime.setBrowserVersion(getBrowserVersion());
       	responseTime.setDomainName(getWebsiteName());

       	return responseTime;
    }

    public ResponseTime homeJourney() throws InterruptedException {

        LOGGER.info("Home Journey");

        responseTime = new ResponseTime();

       	stopWatch.reset();
       	element.click();
       	stopWatch.start();

       	// Wait for the page to load, timeout after 30 seconds
       	(new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
       		@Override
       		public Boolean apply(WebDriver d) {
       			return d.getTitle().toLowerCase().startsWith("trains to paris");
       		}
       	});

       	stopWatch.stop();

       	LOGGER.info("Response time for Home Journey: " + stopWatch.getTime() + " ms");
       	
       	responseTime.setPageTitle(driver.getTitle());
       	responseTime.setResponseTime(stopWatch.getTime());
       	responseTime.setSessionID(driver.getSessionId());
       	responseTime.setDateAdded(LocalDateTime.now());
       	responseTime.setPageID("homepage");
       	responseTime.setBrowserName(getBrowserName());
       	responseTime.setBrowserVersion(getBrowserVersion());
       	responseTime.setDomainName(getWebsiteName());
       	
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
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("outbound train | eurostar");
        	}
        });

        stopWatch.stop();

        LOGGER.info("Response time for Outbound Journey: " + stopWatch.getTime() + " ms");

        responseTime.setPageTitle(driver.getTitle());
       	responseTime.setResponseTime(stopWatch.getTime());
       	responseTime.setSessionID(driver.getSessionId());
       	responseTime.setDateAdded(LocalDateTime.now());
       	responseTime.setPageID("outbound");
       	responseTime.setBrowserName(getBrowserName());
       	responseTime.setBrowserVersion(getBrowserVersion());
       	responseTime.setDomainName(getWebsiteName());

        return responseTime;
    }

    public ResponseTime inboundJourney() throws InterruptedException {

        LOGGER.info("Inbound Journey");

        responseTime = new ResponseTime();

        element = driver.findElement(By.xpath("//*[@id"
        		+ "='standard-booking-path-daily-view-form']/div/div[3]/table/tbody/tr[32]/td[7]/div"));
        stopWatch.reset();
        element.click();

        (new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
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
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("inbound train | eurostar");
        		}
        });

        stopWatch.stop();

        LOGGER.info("Response time for Inbound Journey: " + stopWatch.getTime() + " ms");

        responseTime.setPageTitle(driver.getTitle());
       	responseTime.setResponseTime(stopWatch.getTime());
       	responseTime.setSessionID(driver.getSessionId());
       	responseTime.setDateAdded(LocalDateTime.now());
       	responseTime.setPageID("inbound");
       	responseTime.setBrowserName(getBrowserName());
       	responseTime.setBrowserVersion(getBrowserVersion());
       	responseTime.setDomainName(getWebsiteName());

        return responseTime;
    }

    public ResponseTime insuranceJourney() throws InterruptedException {

        LOGGER.info("Insurance Journey");

        responseTime = new ResponseTime();

        element = driver.findElement(By.xpath("//*[@id"
        		+ "='standard-booking-path-daily-view-form']/div/div[3]/table/tbody/tr[38]/td[5]/div"));
        stopWatch.reset();
        element.click();

        (new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
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
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("travel extras | eurostar");
        	}
        });

        stopWatch.stop();

        LOGGER.info("Response time for Insurance Journey: " + stopWatch.getTime() + " ms");

        responseTime.setPageTitle(driver.getTitle());
       	responseTime.setResponseTime(stopWatch.getTime());
       	responseTime.setSessionID(driver.getSessionId());
       	responseTime.setDateAdded(LocalDateTime.now());
       	responseTime.setPageID("insurance");
       	responseTime.setBrowserName(getBrowserName());
       	responseTime.setBrowserVersion(getBrowserVersion());
       	responseTime.setDomainName(getWebsiteName());

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
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("login, create account");
        	}
        });

        stopWatch.stop();

        LOGGER.info("Response time for Login Journey: " + stopWatch.getTime() + " ms");

        responseTime.setPageTitle(driver.getTitle());
       	responseTime.setResponseTime(stopWatch.getTime());
       	responseTime.setSessionID(driver.getSessionId());
       	responseTime.setDateAdded(LocalDateTime.now());
       	responseTime.setPageID("login");
       	responseTime.setBrowserName(getBrowserName());
       	responseTime.setBrowserVersion(getBrowserVersion());
       	responseTime.setDomainName(getWebsiteName());

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
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("traveller details | eurostar");
        	}
        });

        stopWatch.stop();

        LOGGER.info("Response time for PaxDetails Journey: " + stopWatch.getTime() + " ms");

        responseTime.setPageTitle(driver.getTitle());
       	responseTime.setResponseTime(stopWatch.getTime());
       	responseTime.setSessionID(driver.getSessionId());
       	responseTime.setDateAdded(LocalDateTime.now());
       	responseTime.setPageID("traveller details");
       	responseTime.setBrowserName(getBrowserName());
       	responseTime.setBrowserVersion(getBrowserVersion());
       	responseTime.setDomainName(getWebsiteName());

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
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
        	@Override
        	public Boolean apply(WebDriver d) {
        		return d.getTitle().toLowerCase().startsWith("payment | eurostar");
        	}
        });

        stopWatch.stop();

       	LOGGER.info("Response time for Payment Journey: " + stopWatch.getTime() + " ms");

       	responseTime.setPageTitle(driver.getTitle());
       	responseTime.setResponseTime(stopWatch.getTime());
       	responseTime.setSessionID(driver.getSessionId());
       	responseTime.setDateAdded(LocalDateTime.now());
       	responseTime.setPageID("payment");
       	responseTime.setBrowserName(getBrowserName());
       	responseTime.setBrowserVersion(getBrowserVersion());
       	responseTime.setDomainName(getWebsiteName());

        driver.quit();

        return responseTime;
    }

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}
	
public void browserDetails() {
		
		String browserVersion = null;
		Capabilities cap = driver.getCapabilities();
		String browserName = cap.getBrowserName();
		
		// This block to find out IE Version number
		if ("internet explorer".equalsIgnoreCase(browserName)) {
			String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			
			//uAgent return as "MSIE 8.0 Windows" for IE8
			if (uAgent.contains("MSIE") && uAgent.contains("Windows")) {
				browserVersion = uAgent.substring(uAgent.indexOf("MSIE")+5, uAgent.indexOf("Windows")-2);
			} else if (uAgent.contains("Trident/7.0")) {
				browserVersion = "11.0";
			} else {
				browserVersion = "0.0";
			}
		} else
		{
			//Browser version for Firefox and Chrome
			browserVersion = cap.getVersion();// .split(".")[0];
		}
		
		browserVersion = browserVersion.substring(0, browserVersion.indexOf("."));
		
		this.setBrowserName(browserName);
		this.setBrowserVersion(browserVersion);
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
}
