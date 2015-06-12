package com.estar.responsetimetool.helper;

import java.io.File;

import org.apache.commons.lang3.time.StopWatch;
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
public class ResponseTimeHelper {

    WebDriver driver = null;
    StopWatch stopWatch;
    WebElement element;
    TimeToLoad timeToLoad;

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
        System.out.println("******************Init Journey******************");

        timeToLoad = new TimeToLoad();

        //To visit Eurostar dot com
        driver.navigate().to("http://www.eurostar.com");
        stopWatch.start();

        element = driver.findElement(By.linkText("United Kingdom"));

        stopWatch.stop();
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms\n");

        timeToLoad.setPageTitle(driver.getTitle());
        timeToLoad.setPageLoadTime(stopWatch.getTime());

        return timeToLoad;
    }

    public TimeToLoad homeJourney() throws InterruptedException {
        System.out.println("******************Home Journey******************");

        timeToLoad = new TimeToLoad();

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
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms\n");

        timeToLoad.setPageLoadTime(stopWatch.getTime());
        timeToLoad.setPageTitle(driver.getTitle());

        return timeToLoad;
    }

    public TimeToLoad outboundJourney() throws InterruptedException {
        System.out.println("******************Outbound Journey******************");

        timeToLoad = new TimeToLoad();

        element = driver.findElement(By.xpath("//input[@value='Find trains' and @type='submit']"));
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

        // Wait for the page to load, timeout after 30 seconds
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("outbound train | eurostar");
            }
        });

        stopWatch.stop();
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms\n");

        timeToLoad.setPageTitle(driver.getTitle());
        timeToLoad.setPageLoadTime(stopWatch.getTime());

        return timeToLoad;
    }

    public TimeToLoad inboundJourney() throws InterruptedException {
        System.out.println("******************Inbound Journey******************");

        timeToLoad = new TimeToLoad();

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
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms\n");

        timeToLoad.setPageTitle(driver.getTitle());
        timeToLoad.setPageLoadTime(stopWatch.getTime());

        return timeToLoad;

    }

    public TimeToLoad insuranceJourney() throws InterruptedException {
        System.out.println("******************Insurance Journey******************");

        timeToLoad = new TimeToLoad();

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
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms\n");

        timeToLoad.setPageTitle(driver.getTitle());
        timeToLoad.setPageLoadTime(stopWatch.getTime());

        return timeToLoad;
    }

    public TimeToLoad userLoginJourney() throws InterruptedException {
        System.out.println("******************Login Journey******************");

        timeToLoad = new TimeToLoad();

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
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms\n");

        timeToLoad.setPageTitle(driver.getTitle());
        timeToLoad.setPageLoadTime(stopWatch.getTime());

        return timeToLoad;
    }

    public TimeToLoad paxDetailsJourney() throws InterruptedException {
        System.out.println("******************Passenger Details Journey******************");

        timeToLoad = new TimeToLoad();

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
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms\n");

        timeToLoad.setPageTitle(driver.getTitle());
        timeToLoad.setPageLoadTime(stopWatch.getTime());

        return timeToLoad;
    }

    public TimeToLoad paymentJourney() throws InterruptedException {
        System.out.println("******************Payment Journey******************");

        timeToLoad = new TimeToLoad();

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
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms\n");

        timeToLoad.setPageTitle(driver.getTitle());
        timeToLoad.setPageLoadTime(stopWatch.getTime());

        driver.quit();

        return timeToLoad;

    }
}
