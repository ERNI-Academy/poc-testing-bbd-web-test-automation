# About

Proof-of-concept for web test automation framework starter kit using using Java, Cucumber, Selenium, and Page-Object model design pattern. This POC will be particularly advantageous for projects which are using the Java ecosystem.

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
<!-- ALL-CONTRIBUTORS-BADGE:END -->

## Built With

- [Java 17.+](https://www.oracle.com/java/technologies/downloads/)
- [Cucumber 7.+](https://cucumber.io/docs/installation/)
- [Selenium 4.+](https://www.selenium.dev/downloads/)
- [Selenium Grid 4.+](https://www.selenium.dev/downloads/)

## Features

- Browser test automation
- Behavior-driven approach
- Parallel test execution
- Reports generation after test execution 

## Getting Started

Installation instructions by running:

1. Clone the repository

2. Build and install using Maven command (clean and install)

3. Implement Page objects corresponding to the pages of the Application under Test.
   
   a. Create java package under src/test/java (e.g. com.erni.pageobjects.sprout)
   
   b. Create a Page Object java class, make sure to extend PageBase class to inherit the Core libraries instances.
    ```JS
    public class LoginPO extends PageBase{
    ```

    c. Add page web elements by using annotation @FindBy
      ```JS
      @FindBy(how = How.ID, using = "txtUsername") 
      WebElement txtUserName;
	
      @FindBy(how = How.ID, using = "txtPassword") 
      WebElement txtPassword;
	
      @FindBy(how = How.ID, using = "btnLogIn") 
      WebElement btnLogin;
      ```
   d. Call the Selenium’s PageFactory initElements to initiate the page web elements
      ```JS
      PageFactory.initElements(driver, this);
      ```
   e. Add the page actions as java functions. Use the built-in functions which are inherited from PageBase class.
      ```JS
      public LoginPO enterUsername(String userName) {
		   try {
			   input.sendKeys(txtUserName, userName);
		   } catch(Exception e) {
			   logger.error("Error occurred in enterUsername()", e);
		   }
		   return this;
	   }
      ```

4. Create Features which will serve as the test cases/scenarios for this test suite

   a. Create a file directory under src/test/resources. This will be the folder of all the AUT test scenarios
   
   b. Create a feature file. File extension should be .feature
   
   c. Create test scenarios. Observe the Gherkin template (Given-When-Then)
      ```JS
      Feature: Login verification
         Features include all the scenarios for login

      Scenario: Sprout login
          Given current url is "https://erni.hrhub.ph/Login.aspx"
          When user enters valid username and password
          And user clicks login button
          Then login successful
      ```
5. Create the Feature’s step definitions
   
   a. Create java package under src/test/java (e.g. com.erni.stepdefinitions)

   b. Create a Step Definition java class, make sure to extend StepDefinition parent class to inherit the common functions used for step definitions.
      ```JS
      public class LoginDefinition extends StepDefinition{
      ```
   c. Create instance variables to declare the path for the test data
      ```JS
      private static final String EXCEL_FILE_PATH = "test-data/test-data-sprout.xlsx";
      private static final String EXCEL_SHEET_NAME = "Login";
      ```
   d. Create step definitions
      ```JS
      @Given("current url is {string}")
	   public void isUrlCorrect(String url) {
        try {
            loginPO.isUrlCorrect(url);
        } catch (Exception e) {
            logger.error("Error occurred in isUrlCorrect()", e);
        }
    }

   @When("enter password {string}")
	public void enterPassword(String password) {
		try {
			loginPO.enterPassword(password);
		} catch (Exception e) {
            logger.error("Error occurred in enterPassword()", e);
		}
	}
	
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
   ```

6. Update Hooks class (Hooks.java). Implement setup and teardown. Use @Before annotation for setup and @After for teardown. Note that the method marked with @Before annotation will be invoked before executing the test scenario/feature, whereas the one annotated with @After will be invoked immediately after the execution of the test scenario/feature.

7. Define the test configuration by updating the src/test/resources/config.properties. Feel free to add specific configurations in that file.
   ```JS
   browser=googlechrome
   hubAddress=http://localhost:4444/wd/hub
   baseUrl=https://example.com/
   ```
   
8. Create a Cucumber test runner and add it in TestNG.xml which resides /test-suite folder. TestNG.xml is test configuration of TestNG engine.

9. Selenium Grid’s Hub and Node which are included in the cloned code base have default configuration to run in the localhost. Feel free to setup the Hub and Nodes configuration to run in your desired environment.

## Contributing

Please see our [Contribution Guide](CONTRIBUTING.md) to learn how to contribute.

## License

![MIT](https://img.shields.io/badge/License-MIT-blue.svg)

Copyright  © 2023 [ERNI - Swiss Software Engineering](https://www.betterask.erni)

## Code of conduct

Please see our [Code of Conduct](CODE_OF_CONDUCT.md)

## Stats

Check [https://repobeats.axiom.co/](https://repobeats.axiom.co/) for the right URL

## Follow us

[![Twitter Follow](https://img.shields.io/twitter/follow/ERNI?style=social)](https://www.twitter.com/ERNI)
[![Twitch Status](https://img.shields.io/twitch/status/erni_academy?label=Twitch%20Erni%20Academy&style=social)](https://www.twitch.tv/erni_academy)
[![YouTube Channel Views](https://img.shields.io/youtube/channel/views/UCkdDcxjml85-Ydn7Dc577WQ?label=Youtube%20Erni%20Academy&style=social)](https://www.youtube.com/channel/UCkdDcxjml85-Ydn7Dc577WQ)
[![Linkedin](https://img.shields.io/badge/linkedin-31k-green?style=social&logo=Linkedin)](https://www.linkedin.com/company/erni)

## Contact

📧 [esp-services@betterask.erni](mailto:esp-services@betterask.erni)

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- ALL-CONTRIBUTORS-LIST:END -->
This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!
