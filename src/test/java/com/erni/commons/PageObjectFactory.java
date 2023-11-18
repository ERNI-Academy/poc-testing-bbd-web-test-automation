package com.erni.commons;

import org.openqa.selenium.WebDriver;

import com.erni.pageobjects.sprout.ForgotPasswordPO;
import com.erni.pageobjects.sprout.LoginPO;


/**
 * Factory class to create Page Object instances for the Sprout application.
 * 
 * @author faju
 *
 */
public class PageObjectFactory {
    private WebDriver driver;

    /**
     * Constructor to initialize the WebDriver instance.
     *
     * @param driver The WebDriver instance to be used for creating Page Objects.
     */
    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Creates a new instance of the Login Page Object.
     *
     * @return An instance of the Login Page Object.
     */
    public LoginPO createLoginPO() {
        return new LoginPO(driver);
    }
    
    /**
     * Creates a new instance of the Forgot Password Page Object.
     *
     * @return An instance of the Forgot Password Page Object.
     */
    public ForgotPasswordPO createForgotPasswordPO() {
        return new ForgotPasswordPO(driver);
    }
}
