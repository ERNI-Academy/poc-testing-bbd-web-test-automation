package com.erni.actions;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputAction {
	
	private static InputAction instance = new InputAction();
	
	private Logger logger = LoggerFactory.getLogger(InputAction.class);
	
	/**
	 * Returns instance of the class
	 * 
	 * @return instance
	 */
	public static InputAction getInstance(){
		return instance;
	}
	
	public InputAction sendKeys(WebElement elem, String text) throws Exception{
		logger.info("Typing value: " +text);
		elem.sendKeys(text);
		
		return this;
	}

}
