package com.estar.responsetimetool.helper;

import com.estar.responsetimetool.pojo.TimeToLoad;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nvibhav on 09-Jun-15.
 */
public class ResponseTimeHelper {

    public void RTHelper() throws InterruptedException {

        //Instantiate the RC Server
        WebDriver driver = new FirefoxDriver();
        
        TimeToLoad timeToLoad = new TimeToLoad();
                
        StopWatch stopWatch = new StopWatch();

        //To visit Eurostar dot com
        driver.navigate().to("http://www.eurostar.com");
        stopWatch.start();

        WebElement element = driver.findElement(By.linkText("United Kingdom"));

        stopWatch.stop();
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms");

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
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms");

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
        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms");

        element = driver.findElement(By.xpath("//*[@id='s" +
                "tandard-booking-path-daily-view-form']/div/div[3]/table/tbody/tr[2]/td[5]/div"));
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

        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms");

        element = driver.findElement(By.xpath("//*[@id='s" +
                "tandard-booking-path-daily-view-form']/div/div[3]/table/tbody/tr[2]/td[5]/div"));
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

        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms");

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

        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms");

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

        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms");

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

        System.out.println("Response Time to Page " + driver.getTitle() + " : " + stopWatch.getTime() + " ms");

        stopWatch.reset();
        driver.quit();
    }
}