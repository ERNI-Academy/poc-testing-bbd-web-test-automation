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

import com.erni.commons.PageBase;
import com.erni.stepdefinitions.LoginDefinition;


/**
 * Page Object class representing the Forgot Password functionality of the Sprout application.
 * 
 * @author faju
 *
 */
public class ForgotPasswordPO extends PageBase{
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Forgot Password?") 
	WebElement lnkForgotPassword;
	
	@FindBy(how = How.ID, using = "txtUsername") 
	WebElement txtUserName;
	
	@FindBy(how = How.ID, using = "txtEmail") 
	WebElement txtEmail;
	
	@FindBy(how = How.ID, using = "btnSubmit") 
	WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "toast-container") 
	WebElement divSuccessMsg;
	
	/**
     * Constructs a new instance of ForgotPasswordPO.
     *
     * @param driver The WebDriver instance to be used for interacting with the page elements.
     */
	public ForgotPasswordPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
     * Clicks the Forgot Password Link after waiting for it to be displayed.
     *
     * @return The ForgotPasswordPO instance.
     */
	public ForgotPasswordPO clickForgotPasswordLnk() {
		try {
			wait.untilVisibilityOf(driver, lnkForgotPassword, 5);
	        mouse.click(lnkForgotPassword);
	        wait.implicitWait(driver, 30);
		}catch(Exception e) {
			logger.error("Error occurred in clickForgotPasswordLnk()", e);
		}
		
		return this;
	}
	
	
	/**
     * Enters the provided username into the username field.
     *
     * @param userName The username to be entered.
     * @return The ForgotPasswordPO instance.
     */
	public ForgotPasswordPO enterUsername(String userName) {
		try {
			input.sendKeys(txtUserName, userName);
		} catch(Exception e) {
			logger.error("Error occurred in enterUsername()", e);
		}
		
		return this;
	}
	
	/**
     * Enters the provided email into the email field.
     *
     * @param email The email to be entered.
     * @return The ForgotPasswordPO instance.
     */
	public ForgotPasswordPO enterEmail(String email) {
		try {
			input.sendKeys(txtEmail, email);
		}catch(Exception e) {
			logger.error("Error occurred in enterEmail()", e);
		}
		
		return this;
	}
	
	/**
     * Clicks the Submit button after waiting for it to be displayed.
     *
     * @return The ForgotPasswordPO instance.
     */
	public ForgotPasswordPO clickSubmitBtn() {
		try {
			wait.untilVisibilityOf(driver, btnSubmit, 10);
	        mouse.click(btnSubmit);
	        wait.implicitWait(driver, 10);
		}catch(Exception e) {
			logger.error("Error occurred in clickSubmitBtn()", e);
		}
		
		return this;
	}
	
	/**
     * Verifies that the Forgot Password was successful by checking the success message.
     *
     * @return The ForgotPasswordPO instance.
     */
	public ForgotPasswordPO isToastMessagePresent() {
		try {
	        wait.untilVisibilityOf(driver, divSuccessMsg, 5);
	        verify.isElementPresent(driver, divSuccessMsg);
		}catch(Exception e) {
			logger.error("Error occurred in isToastMessagePresent()", e);
		}
		
		return this;
	}

}
