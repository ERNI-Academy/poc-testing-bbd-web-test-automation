package com.erni.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner for Cucumber tests
 * 
 * @author faju
 *
 */
@CucumberOptions(
		features="src/test/resources/features",
		glue = { "com.erni.stepdefinitions", "com.erni.commons", "com.erni.runners" },
		plugin = { "pretty", "json:target/cucumber-reports/cucumber.json",
					"html:target/cucumber-reports/cucumberreport.html", 
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class CucumberRunnerTest extends AbstractTestNGCucumberTests{
	
	/**
	 *Enable parallel execution of Cucumber tests
	 */
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
