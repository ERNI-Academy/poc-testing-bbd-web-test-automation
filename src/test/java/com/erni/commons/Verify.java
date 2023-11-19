package com.erni.commons;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.erni.stepdefinitions.LoginDefinition;

public class Verify {
	
	private Logger logger = LoggerFactory.getLogger(LoginDefinition.class);
	
	public void isTitleContains(WebDriver driver, String title) {
		try {
			logger.info("Verify: Is title contains? "+ title);
			Assert.assertTrue(title.equals(driver.getTitle()));
		}catch(Exception e) {
			logger.error("Verification failed", e);
		}
	}
	
	public void isURLCorrect(WebDriver driver, String url) {
		try {
			logger.info("Verify: Is URL correct? "+ url);
			Assert.assertTrue(url.equals(driver.getCurrentUrl()));
		}catch(Exception e) {
			logger.error("Verification failed", e);
		}
	}
	
	public void isElementPresent(WebDriver driver, WebElement elem) {
		try {
			logger.info("Verify: Is Element present? "+ elem);
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOf(elem));
	        Thread.sleep(2000);
			Assert.assertTrue(true);
		}catch(Exception e) {
			logger.error("Verification failed", e);
		}
	}

}
