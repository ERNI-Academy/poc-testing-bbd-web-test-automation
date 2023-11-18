package com.erni.stepdefinitions;

import java.io.IOException;
import java.util.Map;

import com.erni.commons.StepDefinition;
import com.erni.pageobjects.sprout.LoginPO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


/**
 * Step definitions for the Login Feature.
 * 
 * @author faju
 *
 */
public class LoginDefinition extends StepDefinition{
	
	private static final String EXCEL_FILE_PATH = "test-data/test-data-sprout.xlsx";
    private static final String EXCEL_SHEET_NAME = "Login";
    
    /**
     * Verifies the current URL matches the expected URL.
     *
     * @param url The expected URL.
     */
	@Given("current url is {string}")
	public void isUrlCorrect(String url) {
        try {
            LoginPO loginPO = pageObjectFactory.createLoginPO(); //TODO: Check implementation to be thread-safe and to remove this for all methods
            loginPO.isUrlCorrect(url);
        } catch (Exception e) {
            logger.error("Error occurred in isUrlCorrect()", e);
        }
    }
	
	/**
     * Enters valid username and password based on scenario from Excel.
     *
     * @throws IOException if an I/O error occurs.
     */
	@When("user enters valid username and password")
    public void enterValidCredentials() throws IOException {
		
		LoginPO loginPO = pageObjectFactory.createLoginPO();
		
		String scenarioToTest = "valid credentials";
		try {
			for (Object[] row : getTestData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME)) {
	            Map<String, String> rowData = (Map<String, String>) row[0];
	            String scenario = rowData.get("scenario");

	            if (scenario != null && scenario.equalsIgnoreCase(scenarioToTest)) {
	                String username = rowData.get("username");
	                String password = rowData.get("password");

	                logger.info("Scenario: {}", scenario);
	                logger.info("username: {}", username);
	                logger.info("password: {}", password);

	                loginPO.enterUsername(username)
	                      .enterPassword(password);
	            }
			}
	    } catch (Exception e) {
	          logger.error("Error occurred in enterValidCredentials()", e);
	    }
	}

	/**
     * Enters invalid username and password based on scenario from Excel.
     *
     * @throws IOException if an I/O error occurs.
     */
	@When("user enters invalid username and password")
    public void enterInvalidCredentials() throws IOException {
		
		LoginPO loginPO = pageObjectFactory.createLoginPO();
		
		String scenarioToTest = "invalid credentials";
		try {
			for (Object[] row : getTestData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME)) {
	            Map<String, String> rowData = (Map<String, String>) row[0];
	            String scenario = rowData.get("scenario");

	            if (scenario != null && scenario.equalsIgnoreCase(scenarioToTest)) {
	                String username = rowData.get("username");
	                String password = rowData.get("password");

	                loginPO.enterUsername(username)
	                      .enterPassword(password);
	            }
	        }
		} catch (Exception e) {
            logger.error("Error occurred in enterInvalidCredentials()", e);
            throw e; 
        }
    }

	
	/**
	 * Enter username based on scenario from Excel.
	 *  
	 * @param userName
	 */
	@When("enter username {string}")
	public void enterUsername(String userName) {
		LoginPO loginPO = pageObjectFactory.createLoginPO();
		
		try {
			loginPO.enterUsername(userName);
		} catch (Exception e) {
            logger.error("Error occurred in enterUsername()", e);
		}
	}
	
	/**
	 * Enter password based on scenario from Excel.
	 *  
	 * @param password
	 */
	@When("enter password {string}")
	public void enterPassword(String password) {
		LoginPO loginPO = pageObjectFactory.createLoginPO();
		
		try {
			loginPO.enterPassword(password);
		} catch (Exception e) {
            logger.error("Error occurred in enterPassword()", e);
		}
	}
	
	
	/**
	 * Click the Login button
	 */
	@When("user clicks login button")
	public void clickLoginBtn() {
		LoginPO loginPO = pageObjectFactory.createLoginPO();
		
		try {
			loginPO.clickLoginBtn();
		} catch (Exception e) {
            logger.error("Error occurred in clickLoginBtn()", e);
		}
	}
	
	
	/**
	 * Verify if login is successful
	 */
	@Then("login successful")
	public void isLoginSuccessful() {
		LoginPO loginPO = pageObjectFactory.createLoginPO();
		
		try {
			loginPO.isLoginSuccessful();
		} catch (Exception e) {
            logger.error("Error occurred in clickLoginBtn()", e);
            throw e;
		}
	}
}
