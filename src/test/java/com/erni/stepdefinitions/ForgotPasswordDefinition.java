package com.erni.stepdefinitions;

import java.io.IOException;
import java.util.Map;

import com.erni.commons.StepDefinition;
import com.erni.pageobjects.sprout.ForgotPasswordPO;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


/**
 * Step definitions for the Forgot Password Feature.
 * 
 * @author faju
 *
 */
public class ForgotPasswordDefinition extends StepDefinition{

	private static final String EXCEL_FILE_PATH = "test-data/test-data.xlsx";
    private static final String EXCEL_SHEET_NAME = "ForgotPassword";

	/**
	 * Click the Forgot Password? link 
	 */
	@When("user clicks Forgot Password link")
	public void clickForgotPasswordLnk() {
		try {
			ForgotPasswordPO forgotPasswordPO = pageObjectFactory.createForgotPasswordPO();
			forgotPasswordPO.clickForgotPasswordLnk();
		} catch (Exception e) {
            logger.error("Error occurred in clickLoginBtn()", e);
		}
	}
	
	/**
     * Enters valid username and email based on scenario from Excel.
     *
     * @throws IOException if an I/O error occurs.
     */
	@When("user enters valid username and email")
    public void enterValidCredentials() throws IOException {
		
		ForgotPasswordPO forgotPasswordPO = pageObjectFactory.createForgotPasswordPO();
		
		String scenarioToTest = "valid username and email";
		try {
			for (Object[] row : getTestData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME)) {
	            Map<String, String> rowData = (Map<String, String>) row[0];
	            String scenario = rowData.get("scenario");

	            if (scenario != null && scenario.equalsIgnoreCase(scenarioToTest)) {
	                String username = rowData.get("username");
	                String email = rowData.get("email");

	                logger.info("Scenario: {}", scenario);
	                logger.info("username: {}", username);
	                logger.info("email: {}", email);

	                forgotPasswordPO.enterUsername(username)
	                      .enterEmail(email);
	            }
			}
	    } catch (Exception e) {
	          logger.error("Error occurred in enterValidCredentials()", e);
	    }
	}

	/**
	 * Click the Submit button
	 */
	@When("user clicks Submit button")
	public void clickSubmitBtn() {
		ForgotPasswordPO forgotPasswordPO = pageObjectFactory.createForgotPasswordPO();
		
		try {
			forgotPasswordPO.clickSubmitBtn();
		} catch (Exception e) {
            logger.error("Error occurred in clickSubmitBtn()", e);
		}
	}
	
	
	/**
	 * Verify if login is successful
	 */
	@Then("link reset email has been sent")
	public void isResetEmailSent() {
		ForgotPasswordPO forgotPasswordPO = pageObjectFactory.createForgotPasswordPO();
		
		try {
			forgotPasswordPO.isToastMessagePresent();
		} catch (Exception e) {
            logger.error("Error occurred in isToastMessagePresent()", e);
            throw e;
		}
	}
}
