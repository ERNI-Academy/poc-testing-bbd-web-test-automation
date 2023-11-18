package com.erni.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitAction {
	
	private static WaitAction instance = new WaitAction();
	
	private Logger logger = LoggerFactory.getLogger(WaitAction.class);
	
	/**
	 * Returns instance of the class
	 * 
	 * @return instance
	 */
	public static WaitAction getInstance(){
		return instance;
	}
	
	public WaitAction implicitWait(WebDriver driver, int secs) throws Exception{
		logger.info("Waiting for element");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return this;
	}
	
	public WaitAction untilElemIsDisplayed(WebDriver driver, WebElement elem, int timeout) throws Exception{
		logger.info("Waiting for element");
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(d -> elem.isDisplayed());
        Thread.sleep(2000);
		
		return this;
	}
	
	public WaitAction untilVisibilityOf(WebDriver driver, WebElement elem, int timeout) throws Exception{
		logger.info("Waiting for element");
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(elem));
        Thread.sleep(2000);
        
		return this;
	}
	
	public WaitAction untilTitleContains(WebDriver driver, String title, int timeout) throws Exception{
		logger.info("Waiting for element");
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));
		
		return this;
	}

}
