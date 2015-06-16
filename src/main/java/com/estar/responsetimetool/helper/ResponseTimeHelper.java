package com.estar.responsetimetool.helper;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.estar.responsetimetool.pojo.TimeToLoad;

/**
 * Created by nvibhav on 09-Jun-15.
 */
@SuppressWarnings("unused")
public class ResponseTimeHelper {

	final static Logger LOGGER = LogManager.getLogger(ResponseTimeHelper.class.getName());
	
    private WebDriver driver = null;
    private StopWatch stopWatch = null;
    private WebElement element = null;
    private TimeToLoad timeToLoad = null;

    public ResponseTimeHelper() {

        //Instantiate the selenium RC server
        //FirefoxBinary binary = new FirefoxBinary(new File("/usr/local/firefox"));
        //binary.setEnvironmentProperty("DISPLAY",System.getProperty("lmportal.xvfb.id",":99"));
        //driver = new FirefoxDriver(binary , null);
    	driver = new FirefoxDriver();
    	
        //Instantiate stopwatch
        stopWatch = new StopWatch();

    }

    public TimeToLoad initJourney() throws InterruptedException {
        
        LOGGER.info("Init Journey");

        timeToLoad = new TimeToLoad();

        try {
        	//To visit Eurostar dot com
        	driver.navigate().to("http://www.eurostar.com");
        	stopWatch.start();

        	element = driver.findElement(By.linkText("United Kingdom"));

        	stopWatch.stop();
        
        	LOGGER.info("Response time for Init journey: " + stopWatch.getTime()+ " ms");
        
        	timeToLoad.setPageTitle(driver.getTitle());
        	timeToLoad.setPageLoadTime(stopWatch.getTime());

        	return timeToLoad;
        } catch (Exception ex){
        	LOGGER.error("An error occurred!! "+ ex);
        	driver.quit();
        	return null;
        }
    }

    public TimeToLoad homeJourney() throws InterruptedException {
        
        LOGGER.info("Home Journey");

        timeToLoad = new TimeToLoad();
        
        try {
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

        	timeToLoad.setPageLoadTime(stopWatch.getTime());
        	timeToLoad.setPageTitle(driver.getTitle());

        	return timeToLoad;
        } catch (Exception ex) {
        	LOGGER.error("An error has occurred!! " + ex);
        	driver.quit();
        	return null;
        }
    }

    public TimeToLoad outboundJourney() throws InterruptedException {

        LOGGER.info("Outbound Journey");

        timeToLoad = new TimeToLoad();
        
        try {
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

        	timeToLoad.setPageTitle(driver.getTitle());
        	timeToLoad.setPageLoadTime(stopWatch.getTime());

        	return timeToLoad;
        } catch (Exception ex) {
        	LOGGER.error("An error has occurred!! " + ex);
        	driver.quit();
        	return null;
        }
    }

    public TimeToLoad inboundJourney() throws InterruptedException {

        LOGGER.info("Inbound Journey");

        timeToLoad = new TimeToLoad();
        
        try {
        	element = driver.findElement(By.xpath("//*[@id='s"
        			+ "tandard-booking-path-daily-view-form']/div/div[3]/table/tbody/tr[2]/td[5]/div"));
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

        	timeToLoad.setPageTitle(driver.getTitle());
        	timeToLoad.setPageLoadTime(stopWatch.getTime());

        	return timeToLoad;
        } catch (Exception ex) {
        	LOGGER.error("An error has occurred!! " + ex);
        	driver.quit();
        	return null;
        }
    }

    public TimeToLoad insuranceJourney() throws InterruptedException {

        LOGGER.info("Insurance Journey");

        timeToLoad = new TimeToLoad();

        try {
        	element = driver.findElement(By.xpath("//*[@id='s"
        			+ "tandard-booking-path-daily-view-form']/div/div[3]/table/tbody/tr[2]/td[5]/div"));
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

        	timeToLoad.setPageTitle(driver.getTitle());
        	timeToLoad.setPageLoadTime(stopWatch.getTime());

        	return timeToLoad;
        } catch (Exception ex) {
        	LOGGER.error("An error has occurred!! " + ex);
        	driver.quit();
        	return null;
        }
    }

    public TimeToLoad userLoginJourney() throws InterruptedException {

        LOGGER.info("Login Journey");

        timeToLoad = new TimeToLoad();
        
        try {
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

        	timeToLoad.setPageTitle(driver.getTitle());
        	timeToLoad.setPageLoadTime(stopWatch.getTime());

        	return timeToLoad;
        } catch (Exception ex) {
        	LOGGER.error("An error has occurred!! " + ex);
        	driver.quit();
        	return null;
        }
    }

    public TimeToLoad paxDetailsJourney() throws InterruptedException {
        
        LOGGER.info("Passenger Details Journey");

        timeToLoad = new TimeToLoad();

        try {
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

        	timeToLoad.setPageTitle(driver.getTitle());
        	timeToLoad.setPageLoadTime(stopWatch.getTime());

        	return timeToLoad;
        } catch (Exception ex) {
        	LOGGER.error("An error has occurred!! " + ex);
        	driver.quit();
        	return null;
        }
    }

    public TimeToLoad paymentJourney() throws InterruptedException {
        
        LOGGER.info("Payment Journey");

        timeToLoad = new TimeToLoad();

        try {
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

        	timeToLoad.setPageTitle(driver.getTitle());
        	timeToLoad.setPageLoadTime(stopWatch.getTime());

        	driver.quit();

        	return timeToLoad;
        } catch (Exception ex) {
        	LOGGER.error("An error has occurred!! " + ex);
        	driver.quit();
        	return null;
        }
    }
}
