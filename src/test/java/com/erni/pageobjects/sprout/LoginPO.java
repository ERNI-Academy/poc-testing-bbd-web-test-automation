package com.erni.pageobjects.sprout;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.erni.actions.InputAction;
import com.erni.commons.PageBase;
import com.erni.stepdefinitions.LoginDefinition;


/**
 * Page Object class representing the login functionality of the Sprout application.
 * 
 * @author faju
 *
 */
public class LoginPO extends PageBase{

	@FindBy(how = How.ID, using = "txtUsername") 
	WebElement txtUserName;
	
	@FindBy(how = How.ID, using = "txtPassword") 
	WebElement txtPassword;
	
	@FindBy(how = How.ID, using = "btnLogIn") 
	WebElement btnLogin;
	
	/**
     * Constructs a new instance of LoginPO.
     *
     * @param driver The WebDriver instance to be used for interacting with the page elements.
     */
	public LoginPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
     * Verifies that the URL matches the expected URL.
     *
     * @param url The expected URL.
     * @return The LoginPO instance.
     */
	public LoginPO isUrlCorrect(String url){
		try {
			wait.implicitWait(driver, 30);
			verify.isURLCorrect(driver, url);
		} catch(Exception e) {
			logger.error("Error occurred in isUrlCorrect()", e);
		}
		
		return this;
	}
	
	/**
     * Enters the provided username into the username field.
     *
     * @param userName The username to be entered.
     * @return The LoginPO instance.
     */
	public LoginPO enterUsername(String userName) {
		try {
			input.sendKeys(txtUserName, userName);
		} catch(Exception e) {
			logger.error("Error occurred in enterUsername()", e);
		}
		
		return this;
	}
	
	/**
     * Enters the provided password into the password field.
     *
     * @param password The password to be entered.
     * @return The LoginPO instance.
     */
	public LoginPO enterPassword(String password) {
		try {
			input.sendKeys(txtPassword, password);
		}catch(Exception e) {
			logger.error("Error occurred in enterPassword()", e);
		}
		
		return this;
	}
	
	/**
     * Clicks the login button after waiting for it to be displayed.
     *
     * @return The LoginPO instance.
     */
	public LoginPO clickLoginBtn() {
		try {
			wait.untilElemIsDisplayed(driver, btnLogin, 10);
	        mouse.click(btnLogin);
			wait.implicitWait(driver, 10);
		}catch(Exception e) {
			logger.error("Error occurred in clickLoginBtn()", e);
		}
		
		return this;
	}
	
	/**
     * Verifies that the login was successful by checking the title of the resulting page.
     *
     * @return The LoginPO instance.
     */
	public LoginPO isLoginSuccessful() {
		try {
	        wait.untilTitleContains(driver, "Employee Dashboard | Sprout HR", 30);
	        verify.isTitleContains(driver, "Employee Dashboard | Sprout HR");
		}catch(Exception e) {
			logger.error("Error occurred in isLoginSuccessful()", e);
		}
		
		return this;
	}

}
