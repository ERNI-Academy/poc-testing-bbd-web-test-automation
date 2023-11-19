package com.erni.commons;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erni.commons.utils.ExcelUtility;

public class StepDefinition {
	
	protected WebDriver driver = Hooks.getDriver();
	protected Logger logger = LoggerFactory.getLogger(StepDefinition.class);
	protected PageObjectFactory pageObjectFactory = new PageObjectFactory(driver);
	
	
    public Object[][] getTestData(String EXCEL_FILE_PATH, String EXCEL_SHEET_NAME) throws IOException {
        return ExcelUtility.readTestDataFromExcel(EXCEL_FILE_PATH, EXCEL_SHEET_NAME)
                         .stream()
                         .map(map -> new Object[]{ map })
                         .toArray(Object[][]::new);
    }

}
